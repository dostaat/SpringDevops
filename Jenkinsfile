pipeline{
    agent any
    stages{
        stage("Checkout"){
            steps{
                git url: "https://github.com/dostaat/SpringDevops.git"
            }
        }
        stage("Packaging"){
            steps {
                sh "./gradlew build"
            }
        }
        stage("Docker build"){
            steps {
                sh "docker build -t szidom/devops-pelda ."
            }
        }
        stage("Docker login"){
            steps {
                sh "docker login --username=szidom --password=$docker_password"
            }
        }
        stage("Docker push"){
            steps {
                sh "docker push szidom/devops-pelda"
            }
        }
        stage("Docker deploy"){
            steps {
                sh "docker run -d --rm -p 8765:8080 --name calculator szidom/devops-pelda"
            }
        }
        #stage("Acceptance Test"){
        #    steps {
        #        sh "sleep 60"
        #        sh "./acceptance_test.sh"
        #    }
        }
    }
    post {
        always {
            sh "docker stop calculator"
        }
    }
}

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
        
        stage("Deploy to Production"){
            steps {
                sh "ansible-playbook playbook.yml -i inventory/production"
            }
        }
        
    }
    post {
        always {
            sh "docker stop calculator"
        }
    }
}

pipeline{
    agent any
    parameters{
        booleanParam(name: 'TEST_PROJECT', defaultValue: true)
    }
    stages{
        stage("Checkout"){
            steps{
                git url: "https://github.com/dostaat/SpringDevops.git"
            }
        }
        stage("Compile"){
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Unit test"){
            when { expression { return.params.TEST_PROJECT }}
            steps{
                sh "./gradlew test"
            }
        }
    }

}
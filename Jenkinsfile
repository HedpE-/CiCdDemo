pipeline {
    agent any
    stages {
        stage('Unit tests') {
            steps {
                sh "mvn test"
            }
        }
        stage('Build') {
            steps {
                sh "mvn build"
            }
        }
    }
}
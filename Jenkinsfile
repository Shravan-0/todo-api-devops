pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        PATH = "/usr/lib/jvm/java-17-openjdk-amd64/bin:/usr/bin:/bin"
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Environment Check') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Automated Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar',
                             fingerprint: true
        }
    }
}

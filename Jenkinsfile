pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Grant permission to the wrapper script and run it
                sh 'chmod +x gradlew'
                sh './gradlew clean build test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // 'SonarQube' must match the server name configured in Jenkins
                withSonarQubeEnv('SonarQube') { 
                    sh './gradlew sonar'
                }
            }
        }
    }

    post {
        always {
            // Task 2: Archive the JAR file
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            
            // Optional: Publish Test Results
            junit 'build/test-results/test/*.xml'
        }
    }
}

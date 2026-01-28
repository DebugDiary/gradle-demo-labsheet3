pipeline {
    agent any
    
    tools {
        // Ensure this matches the Global Tool Configuration name in Jenkins
        gradle 'Gradle' 
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Task 2: Build and Test execution
                sh './gradlew clean build test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // Task 3: SonarQube integration
                withSonarQubeEnv('SonarQube') { 
                    sh './gradlew sonar'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            junit 'build/test-results/test/*.xml'
        }
    }
}

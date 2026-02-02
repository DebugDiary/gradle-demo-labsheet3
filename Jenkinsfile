pipeline {
    agent any

    tools {
        gradle 'gradle' 
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/DebugDiary/gradle-demo-labsheet3.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'gradle clean build jacocoTestReport'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') { 
                    sh 'gradle sonar'
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }
}

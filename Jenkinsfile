pipeline {
    agent any

    tools {
        gradle 'gradle' 
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls your code from the repo seen in your error message
                git branch: 'main', url: 'https://github.com/DebugDiary/gradle-demo-labsheet3.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Runs build, tests, and generates JaCoCo reports for Task 1 & 2 [cite: 72, 89]
                sh 'gradle clean build jacocoTestReport'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // Task 3: Executes SonarQube scan using the JaCoCo reports [cite: 103, 104]
                // Make sure "sonar" matches your Global Tool Configuration name for SonarScanner
                withSonarQubeEnv('SonarQube') { 
                    sh 'gradle sonar'
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                // Task 2: Archives the generated JAR file [cite: 91, 92]
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }
}

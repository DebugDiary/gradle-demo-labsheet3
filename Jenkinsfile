pipeline {
    agent any

    tools {
        // Ensure you have "Gradle" configured in Global Tool Configuration
        gradle 'gradle' 
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls code from your specific GitHub repository 
                git branch: 'main', url: 'https://github.com/DebugDiary/gradle-demo-labsheet3.git' [cite: 85]
            }
        }

        stage('Build & Test') {
            steps {
                // Runs the clean and test tasks while generating the JAR [cite: 89, 93]
                sh 'gradle clean build' [cite: 72]
            }
        }

        stage('Archive Artifact') {
            steps {
                // Archives the generated JAR file from the build directory [cite: 91, 92]
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true [cite: 93, 98]
            }
        }
    }
}

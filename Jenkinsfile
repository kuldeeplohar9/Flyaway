pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from your version control system
                git 'https://github.com/kuldeeplohar9/Flyaway.git'
            }
        }

        stage('Build') {
            steps {
                // Build your Java project (e.g., compile code, package JAR)
                sh 'mvn clean package' // Assuming you're using Maven
            }
        }

        stage('Test') {
            steps {
                // Run tests for your Java project
                sh 'mvn test' // Assuming you're using Maven
            }
        }

        stage('Deploy') {
            steps {
                // Deploy your Java project (if applicable)
                // You might copy the built artifacts to a server, deploy to a container, etc.
                // Example: sh 'scp target/your-project.jar user@server:/path/to/deployment/'
            }
        }
    }

    post {
        always {
            // Clean up any resources or perform cleanup tasks
            // Example: deleteDir()
        }

        success {
            // Actions to take if the pipeline succeeds
            // Example: echo 'Pipeline succeeded!'
        }

        failure {
            // Actions to take if the pipeline fails
            // Example: echo 'Pipeline failed!'
        }
    }
}

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

    
    }

    
    }


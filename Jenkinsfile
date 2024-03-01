pipeline {
    agent {
        docker {
            image 'maven:latest'
            args '-v $HOME/.m2:/root/.m2:z -u root -w /workspace'
        }
    }

    environment {
        VERSION = '0.5.2'
        REL_VER = 'RES.4'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo "This is Build with version as ${VERSION} and release as ${REL_VER}"
                    sh 'java -version'
                    sh 'mvn -version'
                    sh 'ls'
                    sh 'mvn clean test'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "This is TEST with version as ${VERSION} and release as ${REL_VER}"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}

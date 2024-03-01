pipeline {
    agent {
        docker {
			docker.image('maven:latest').inside("${WORKSPACE}/Capstone_FlyAway/")
            args '-v $HOME/.m2:/root/.m2:z -u root'
            reuseNode true
        }
    }

    environment {
        VERSION = '0.5.2'
        REL_VER = 'RES.4'
    }

    stages {
        stage('Build') {
            steps {
                sh ''' 
                    echo "This is Build with version as ${VERSION} and release as ${REL_VER}"
                    java -version
                    mvn -version
                    ls
                    mvn clean test
                '''
            }
        }

        stage('Test') {
            steps {
                sh ''' 
                    echo "This is TEST with version as ${VERSION} and release as ${REL_VER}"
                '''
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}

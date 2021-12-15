pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh or bat
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh or bat
                sh "docker build -t='alo453/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh or bat
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push alo453/selenium-docker:latest"
			    }                           
            }
        }
    }
}
pipeline {
	agent {
		docker {
			image 'node:14-alpine'
			args '-p 3000:3000'
		}
	}
	stages {
		stage('Build - Dev') {
			steps {
				sh """
					echo "build/dev/Artifact-${BUILD_NUMBER}" > artifact-${BUILD_NUMBER}.txt
				"""
				script {
					def helper = load './jenkins-helper.groovy'
					helper('dev', 'first')
				}
			}
		}
		stage('Build - Master') {
			steps {
				sh """
					echo "build/master/Artifact-${BUILD_NUMBER}" > artifact-${BUILD_NUMBER}.txt
				"""
				script {
					def helper = load './jenkins-helper.groovy'
					helper('master', 'second')
				}
			}
		}
	}
}

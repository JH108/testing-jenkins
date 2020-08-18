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
					mkdir -p build/dev
					echo "build/dev/Artifact-${BUILD_NUMBER}" > build/dev/artifact-${BUILD_NUMBER}.txt
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
					mkdir -p build/master
					echo "build/master/Artifact-${BUILD_NUMBER}" > build/master/artifact-${BUILD_NUMBER}.txt
				"""
				script {
					// def helper = load './jenkins-helper.groovy'
					helper('master', 'second')
				}
			}
		}
	}
}

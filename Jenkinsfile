pipeline {
	agent {
		docker {
			image 'node:14-alpine'
			args '-p 3000:3000'
		}
	}
	stages {
		stage('Build') {
			steps {
				script {
					sh """
						echo "Artifact1" > artifact1.txt
						echo "Artifact2" > artifact2.txt
						echo "Artifact-${BUILD_NUMBER}" > artifact-${BUILD_NUMBER}.txt
					"""
				}
				archiveArtifacts artifacts: '*.txt', fingerprint: true, onlyIfSuccessful: true
				script {
					def helper = load './jenkins-helper.groovy'
					helper()
				}
			}
		}
	}
}

def call(String branch, String anotherVariable) {
	echo "Called the helper with branch = ${branch} and ${anotherVariable}!"
	archiveArtifacts artifacts: "build/${branch}/*.txt", fingerprint: true, onlyIfSuccessful: true
	def job = Jenkins.instance.getItemByFullName(currentBuild.projectName)

	if (job != null) {
		echo "Found the job! ${currentBuild.projectName}"
		def builds = job.getBuilds()
		builds.each { build ->
			def buildName = build.getDisplayName()
			echo "Examining build: ${buildName}"
			def artifacts = build.getArtifacts()
			echo "Artifacts for build: ${buildName} -> ${artifacts}"
		}
	}
}
return this

def call() {
	echo "Called the helper!"
	def job = Jenkins.instance.getItemByFullName(currentBuild.projectName)
	if (job != null) {
		echo "Found the job! ${currentBuild.projectName}"
		def builds = job.getBuilds().byTimestamp(new Date(0).getTime(), new Date().minus(1).getTime())
		echo "Number of builds: ${builds}"
		builds.each { build ->
			def buildName = build.getDisplayName()
			echo "Examining build: ${buildName}"
			def artifacts = build.getArtifacts()
			echo "Artifacts for build: ${buildName} -> ${artifacts}"
			def actions = build.actions

			actions.each { action ->
				echo "The action: ${action}"
			}
		}
	}
}
return this

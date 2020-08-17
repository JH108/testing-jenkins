def call() {
	echo "Called the helper!"
	def job = Jenkins.instance.getItemByFullName(currentBuild.projectName)
	if (job != null) {
		echo "Found the job! ${currentBuild.projectName}"
		def builds = job.getBuilds()
		builds.each { build ->
			def buildName = build.getDisplayName()
			echo "Examining build: ${buildName}"
			def artifacts = build.getArtifacts()
			echo "Artifacts for build: ${buildName} -> ${artifacts}"
			def actions = build.actions

			actions.each { action ->
				echo "The action: ${action}"
				echo "The var: ${SOME_VAR}"
			}
		}
	}
}
return this

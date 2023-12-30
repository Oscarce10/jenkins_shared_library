def call(Map pipelineParams) {
    pipeline {
        agent {
            docker {
                image pipelineParams.image
            }
        }

        stages {
            stageClone.cloneRepo(pipelineParams.repoName, pipelineParams.branch)
            stageBuild()
            stagePackage()
            stage ('Stage publish') {
                stagePublish.pubProcess1()
                stagePublish.pubProcess2()
            }
        }
    }
    
}
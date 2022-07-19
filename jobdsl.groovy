def repoUrl = getBinding().getVariables()["GIT_URL"]

pipelineJob('aws-xenos-jenkins-build') {
    definition {
        cpsScm {
             scriptPath 'Jenkinsfile'
             scm {
               git {
                   remote {
                     url repoUrl
                     credentials 'github-credentials'
                   }
                   branch '*/main'
                   extensions {}
               }
             }
         }
    }
}

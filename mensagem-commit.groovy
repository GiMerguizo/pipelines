stage('get_commit_msg') 
{
    steps {
        script {
            env.GIT_COMMIT_MSG = sh (script: 'git log -1 --pretty=%B ${GIT_COMMIT}', returnStdout: true).trim()
        }
    }
}
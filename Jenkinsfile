pipeline {
    agent any
        options {
            skipDefaultCheckout true
            buildDiscarder logRotator(
                artifactDaysToKeepStr: '',
                artifactNumToKeepStr: '',
                daysToKeepStr: '',
                numToKeepStr: '5'
                )
            timeout(
                activity: true,
                time: 30
                )
            disableConcurrentBuilds()
        }

        stages {
            stage('PO/SM - Production Approve'){
                agent any

                steps {
                    timeout(time: 30, unit: "MINUTES") {
                        script {
                            def userInput = input(id: 'Proceed1', message: 'Promote build?', parameters: [[$class: 'BooleanParameterDefinition', defaultValue: true, description: '', name: 'Please confirm you agree with this']])
                            echo 'userInput: ' + userInput

                            if(userInput == true) {
                                // do action
                            } else {
                                // not do action
                                echo "Action was aborted."
                            }

                        }
                    }
                }
            }

            stage('Notificação Discord') {
                steps {
                    script {
                        def d = [:]
                        def props = readProperties(defaults: d, file: './Docs/discord-id.properties')
                        env.ID1 = props['id_Giovana']
                        env.TIME = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East")).getTime().format('dd/MM/YYYY - hh:mm:ss')
                    }
                    discordSend description: "Notificação",
                    notes: "Executado por: <@${env.ID1}>",
                    footer: "Execução: ${env.TIME}",
                    link: env.BUILD_URL,
                    result: currentBuild.currentResult,
                    title: JOB_NAME,
                    webhookURL: ""
                    enableArtifactsList: true
                }
            }

            stage('get_commit_msg') {
                agent any

                steps {
                    script {
                        env.GIT_COMMIT_MSG = sh (script: 'git log -1 --pretty=%B ${GIT_COMMIT}', returnStdout: true).trim()
                    }
                }
            }
        } 
}
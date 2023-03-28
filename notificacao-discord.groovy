stage('Notificação Discord') {
    steps {
        checkout scm
        script {
            def d = [:]
            def props = readProperties(defaults: d, file: './jenkins/discord-id.properties')
            env.ID = props['id_Giovana']
            env.TIME = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East")).getTime().format('dd/MM/YYYY - hh:mm:ss')
        }
        discordSend description: "Teste de Notificação",
        notes: "Criado por <@${env.ID}>",
        footer: "Execução: ${env.TIME}",
        link: env.BUILD_URL,
        result: currentBuild.currentResult,
        title: JOB_NAME,
        webhookURL: ""
    }
}
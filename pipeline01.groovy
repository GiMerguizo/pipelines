node {
    def mvnHome
        stage ('Checkout') {
            echo 'Iniciando pipeline...'
        }
		stage('Read files'){
            def d = [GiMerguizo: 'id1...', Gi_Tartuga: 'id2...', other: 'Default']
            def props = readProperties defaults: d, file: '/var/jenkins_home/teste.properties', text: 'other=Override'
            echo props['GiMerguizo']
			echo props['Gi_Tartuga']
			script {
				env.ID = props['GiMerguizo']
			}
        }
        stage('Notificação Jenkins') {
            script {
                env.TIME = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East")).getTime().format('dd/MM/YYYY - hh:mm:ss')
            }
            echo '${env.ID} - ${env.TIME}'
        }
        stage('FIM') {
            script {
                echo 'Finalizando...'
            }
        }
        
}
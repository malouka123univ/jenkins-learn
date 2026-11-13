def buildApp() {
    echo "Building version ${params.VERSION}"
    sh "mvn clean install ${params.executeTests ? '' : '-DskipTests'}"
}

def testApp() {
    echo 'Testing the application.'
}

def deployApp() {
    echo "Deploying version ${params.VERSION}"
    withCredentials([usernamePassword(
        credentialsId: 'server-credentials',
        usernameVariable: 'DEPLOY_USER',
        passwordVariable: 'DEPLOY_PASSWORD'
    )]) {
        sh '''
            echo "Connexion au serveur de dev..."
            # Ajoutez ici la commande de déploiement.
            # DEPLOY_USER et DEPLOY_PASSWORD sont disponibles dans cet environnement.
            # Ne jamais afficher le mot de passe.
        '''
    }
}

return this

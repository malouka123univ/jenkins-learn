pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    options {
        timestamps()
    }

    environment {
        VERSION = '1.2.e'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building version ${VERSION}"
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            when {
                expression { env.BRANCH_NAME == 'dev' }
            }
            steps {
                echo 'Add your project test command here.'
            }
        }

        stage('Deploy') {
            when {
                expression { env.BRANCH_NAME == 'dev' }
            }
            steps {
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
        }
    }

    post {
        always {
            echo 'Le pipeline est terminé (toujours exécuté).'
        }
        success {
            echo 'Le build a réussi.'
        }
        failure {
            echo 'Le build a échoué.'
        }
    }
}

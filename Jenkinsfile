pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    parameters {
        string(name: 'VERSION', defaultValue: '1.2.0', description: 'Version à déployer')
        choice(name: 'VERSIONS', choices: ['1.0.0', '1.1.0', '1.2.0'], description: 'Versions disponibles')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Exécuter les tests ?')
    }

    options {
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building version ${params.VERSION}"
                sh "mvn clean install ${params.executeTests ? '' : '-DskipTests'}"
            }
        }

        stage('Test') {
            when {
                expression { params.executeTests }
            }
            steps {
                echo 'Testing the application.'
            }
        }

        stage('Deploy') {
            when {
                expression { env.BRANCH_NAME == 'dev' }
            }
            steps {
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

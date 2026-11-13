pipeline {
    agent any

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

pipeline {
    agent any

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
                echo 'Add your project build command here.'
            }
        }

        stage('Test') {
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

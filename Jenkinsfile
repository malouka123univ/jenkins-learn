def gv

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

        stage('Init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage('Test') {
            when {
                expression { params.executeTests }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage('Deploy') {
            when {
                expression { env.BRANCH_NAME == 'dev' }
            }
            steps {
                script {
                    gv.deployApp()
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

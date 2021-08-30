#!groovy

pipeline {
    agent any
    tools {
        maven 'maven-4.0.0'
        jdk 'java16'
    }
    stages {
        stage('Initialize') {
            steps {
                checkout scm

                script {
                    echo "Building with Maven "
                    echo "PATH = ${env.PATH}"
                    echo "BRANCH = ${env.BRANCH_NAME}"
                    echo "REVISION = ${env.GIT_COMMIT}"
                    echo "WORKSPACE = ${env.WORKSPACE}"
                }
            }
        }

        stage('Clean') {
            steps {
                sh 'make clean'
            }
        }

        stage('Build') {
            steps {
                sh 'make build'
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'make test'
                    junit allowEmptyResults: true, keepLongStdio: true, testResults: 'target/surefire-reports/*/.xml'
                }
            }
        }

        stage('Upgrade Version') {
            when {
                branch 'master'
            }
            steps {
                script {
                    echo '-- Upgrading project version --'
                    upgradeVersion()
                }
            }
        }

        stage('Docker') {
            when {
                anyOf { branch 'master'; branch 'feature/*' }
            }
            steps {
                sh 'make docker_build'
                }
            }
        }

        stage('Docker run') {
            steps {
                script {
                 sh 'make docker_compose_run'
                }
            }
        }

    post {
        always {
            echo 'Post::always executing...'
            script {
                if (currentBuild.result == 'SUCCESS') {
                    sendMessage("processo concluido com SUCESSO. :parrot_fast:")
                } else {
                    sendMessage("processo concluido com algum ERRO. :thinking_face:")
                }
            }
        }
    }
}

def upgradeVersion() {
    sh "mvn --batch-mode release:update-versions"
    sh "git commit -am \"Nova versao\""

    withCredentials([usernamePassword(credentialsId: "svcaccgithub", usernameVariable: "GIT_USERNAME", passwordVariable: "GIT_PASSWORD")]) {
        sh "git pull https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/pagseguro-core/thanatos-be master"
        sh "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/pagseguro-core/thanatos-be master"
        sh 'mvn clean install -DskipTests'
    }
}

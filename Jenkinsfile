pipeline {
    agent any
    tools {
        maven "M3"
    }
    stages {
        stage('Project build') {
            steps {
                sh 'mvn clean install -DskipTests=true'
            }
        }
        stage('Run tests') {
            steps {
                sh 'mvn test -Dsuite=${SUITE} -Dconfig=${CONFIG}'
            }
        }
        stage('Copy logs') {
            steps {
               archiveArtifacts artifacts: 'target/logs/*', followSymlinks: false
            }
        }
    }
    post('Allure results') {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}

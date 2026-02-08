pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    environment {
        MODIFIED_TEST = ''
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/GitHubAbhi1406/DummyJSON_API_Automation.git'
            }
        }

        stage('Detect Modified Test') {
            steps {
                script {
                    def changedFiles = bat(
                        script: 'git diff --name-only HEAD~1 HEAD',
                        returnStdout: true
                    ).trim()

                    echo "Changed files: ${changedFiles}"

                    if (changedFiles.contains('src/test/java')) {
                        MODIFIED_TEST = changedFiles.tokenize('/').last().replace('.java', '')
                        echo "Detected modified test: ${MODIFIED_TEST}"
                    } else {
                        echo "No test files modified"
                    }
                }
            }
        }

        stage('Run Modified Test First') {
            when {
                expression { MODIFIED_TEST != '' }
            }
            steps {
                echo "Running modified test only: ${MODIFIED_TEST}"
                bat "mvn test -Dtest=${MODIFIED_TEST}"
            }
        }

        stage('Run Full Regression') {
            steps {
                echo "Running full API regression suite"
                bat "mvn clean test"
            }
        }
    }

    post {
        success {
            echo 'Regression completed successfully'
        }
        failure {
            echo 'Pipeline failed – modified test or regression failed'
        }
    }
}

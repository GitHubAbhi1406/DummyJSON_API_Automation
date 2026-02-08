pipeline {
    agent any
    tools{
		jdk 'JDK21'
		maven 'Maven3'
	}

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/GitHubAbhi1406/DummyJSON_API_Automation.git'
            }
        }

        stage('Build & Run All Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
        success {
            echo 'All API tests passed successfully'
        }
        failure {
            echo 'Some API tests failed'
        }
    }
}

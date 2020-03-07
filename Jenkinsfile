pipeline{
    agent any
    stages {
        stage ('Compile Stage') {
            steps {
                bat 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage ('Test Stage') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            cucumber buildStatus: "UNSTABLE", fileIncludePattern: "**/cucumber.json", jsonReportDirectory: 'target'
        }
    }
}
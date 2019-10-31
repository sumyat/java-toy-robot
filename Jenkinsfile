pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Good Morning, Su Myat!"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
    }
}

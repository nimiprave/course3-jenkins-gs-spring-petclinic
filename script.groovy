echo 'firstpipleline'

node {
        stage('check out') {
            powershell 'ls'
            git branch: 'main', url: 'https://github.com/nimiprave/course3-jenkins-gs-spring-petclinic.git'
            powershell 'ls'
        }

        stage('Build') {
            powershell 'mvn clean package'
        }

        stage('capture') {
                archiveArtifacts artifacts: '**/target/*.jar', followSymlinks: false
        }
        stage('test') {
            jacoco()
            junit stdioRetention: '', testResults: '**target/surefire-reports/*.xml'
        }
}

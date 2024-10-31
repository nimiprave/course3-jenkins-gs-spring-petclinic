//declartive pipeline

pipeline {
        agent any
        stages {
            stage('check out') {
                steps {
                    git branch: 'main', url: 'https://github.com/nimiprave/course3-jenkins-gs-spring-petclinic.git'
                }
            }

            stage('Build') {
                steps {
                    powershell 'mvn clean package'
                }
            }

            stage('capture') {
                    steps {
                        archiveArtifacts artifacts: '**/target/*.jar', followSymlinks: false
                    }
            }
            stage('test') {
                steps {
                jacoco()
                junit stdioRetention: '', testResults: '**target/surefire-reports/*.xml'
                }
            }
        }
}

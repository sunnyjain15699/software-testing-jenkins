pipeline {
    agent {
        docker {
            image 'maven:3.9.0-eclipse-temurin-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
                sh 'mvn test-compile org.pitest:pitest-maven:mutationCoverage'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    pitmutation killRatioMustImprove: false, mutationStatsFile: 'target/pit-reports/**/mutations.xml'
                }
                  success {
                            jacoco(
                                execPattern: '**/target/jacoco.exec',
                                classPattern: '**/target/classes',
                                sourcePattern: '**/src/main'
                            )
                        }
            }
        }
    }
}

pipeline {
    agent any
    environPATH {
        JAVA_HOME = 'C:\Program Files\Java\jdk-21'
        PATH = 'C:\Program Files\Java\jdk-21;C:\Program Files\Java\jdk-21\bin;D:\Program Files (x86)\apache-maven-3.9.9\bin;'
    }
    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dmaven.test.failure.ignore=true'
            }
        }
        stage('PMD') {
            steps {
                sh 'mvn pmd:pmd'
            }
        }
        stage('JaCoCo') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
        stage('Javadoc') {
            steps {
                sh 'mvn javadoc:javadoc'
            }
        }
        stage('Site') {
            steps {
                sh 'mvn site'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }
    post {
        always {
        archiveArtifacts artifacts: '**/target/site/**/*.*', fingerprint: true
        archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
        archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
        junit '**/target/surefire-reports/*.xml'
        }
    }
}
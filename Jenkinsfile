#!groovy​
pipeline {
  agent {
    docker {
      image 'maven:3.6.1-jdk-11-slim' 
      args '-v /root/.m2:/root/.m2' 
    }
  }
  stages { 
    stage('Build') {
      steps {
        sh 'mvn --batch-mode -V -U -e clean package -DskipTests' 
      }
    }       
    stage('Test') {
      steps {
        sh 'mvn --batch-mode -V -U -e test -Dsurefire.useFile=false'
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml, **/target/failsafe-reports/*.xml'
        }
      }
    }
  }
}

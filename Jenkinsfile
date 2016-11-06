node {
        def mvnHome
        stage('Preparation') {
                git 'git@github.com:BikeSyndikat/Despot.git'
                mvnHome = tool 'maven-3.3.9'
        }
        stage('Build') {
                if (isUnix()) {
                        sh "'${mvnHome}/bin/mvn' clean deploy site-deploy"
                }
        }
        stage('Results') {
                archive 'target/**.?ar'
                archive 'pom.xml'
        }
}

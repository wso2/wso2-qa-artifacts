This scenario will test VFS will read a file from the ftp location contains a soap message and pass on to the backend (endpoint) where simple stock quote service deployed. Then e-mail the response message to a pre-defined e-mail address. Here the action after processing is move. The successful processing result in original file will be move to Pass folder and any failure result in file being move to Failures folder.

1. Enable VFS transport and create a stockQuoteProxy (Synapse vfsftpStockQuoteProxy.xml)

2. Create a folder stucture like below
C:\PERSONAL\VFS
├───Failures
└───Pass

Also ftp server locatrion create a folder structre as /vfsTest/ori

3. Deploy SimpleStockQuote Service using AXIS2

4. Place the Test.XML & aaa.xml to Original folder

5. Results
Test.XML should move to Pass folder
aaa.xml should move to Failures folder
AXIS2 response should e-mail to testerwso2@gmail.com
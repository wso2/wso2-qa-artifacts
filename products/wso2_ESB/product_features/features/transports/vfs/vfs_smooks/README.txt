This scenario will test VFS will work with smooks mediator.It will read the xml file and transform using smooks mediator and send the place order message to backend.Here the action after processing is move. The successful processing result in original file will be move to Pass folder and any failure result in file being move to Failures folder.

1. Enable VFS transport and create a stockQuoteProxy (Synapse vfsFileStockQuoteProxy.xml)

2. Create a folder stucture like below
C:\PERSONAL\VFS
├───Failures
├───Original
└───Pass

3. Deploy SimpleStockQuote Service using AXIS2

4. Place the placeorder.xml to Original folder

5. Results
placeorder.xml should move to Pass folder
AXIS2 server should log a place order
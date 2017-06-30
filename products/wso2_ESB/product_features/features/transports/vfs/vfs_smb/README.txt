Description:
This sample proxy services are used to access a Windows shared location using VFS transport.
Compatible with ESB5.0.0 and we use smb protocol here.

1. Deploy the proxy services on the ESB server
2. Deploy SimpleStockQuoteService service which is in ESB samples, in axis2 server.
3. Change the outSequence send mediator endpoint url, 'transport.vfs.MoveAfterFailure' and 'transport.vfs.MoveAfterProcess' with valid entries.
4. The files with the request payload are in transport.vfs.FileURI location will be processed as using to call the endpoint with it.

A. StockQuoteProxy.xml
----------------------
Unencrypted credentials

B. SimpleStockQuoteEncrypted
----------------------------
Encrypted credentials with secureVault

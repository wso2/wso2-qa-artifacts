********************************************************************************

This content is for module archive files saved as .mar
--------------------------------------------------------------------------------

Test case in test link:- ESB-1258:Verify MAR file deployment in ESB while deploy a CAR file.


Description:- This test case for checking MAR deployment to ESB while deploying with carbon application.


Pre-conditions:- If there are any .jar dependancies, those dependent jars of .mar file has to be copied directly to [ESB_HOME]/repository/components/lib for normal jars and [ESB_HOME]/repository/components/dropins for OSGI jars.


Note:- You cannot have a dependency from class in .mar to jar packed in a .car file; .mar will deploy during the initial stages of the startup and .car will deploy later. So during .mar deployment, depending jars will not available.




-----------------------------------------------------------------------------------


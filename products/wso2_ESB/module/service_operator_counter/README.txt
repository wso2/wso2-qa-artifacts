############################ This content is for module archive (.mar) deployment to ESB ###################################################
 

Axis2 provides extended support for modules & it uses MAR (Module Archive) to deploy modules in Axis2.
A module is an archive file that bundles a set of classes, related libraries and third party library dependencies.


Description:- This test case for checking module deployment to ESB while deploying with carbon application.


Test case in test link:- ESB-1258:Verify MAR file deployment in ESB while deploy a CAR file


Pre-conditions:- 
1. A .mar file and a .car file has to be created
2. There should not be any dependancy for module (.mar file) from carbon application (.car file)
3. If there are any .jar dependancies, those dependent jars of .mar file has to be copied directly to [ESB_HOME]/repository/components/lib for normal jars and [ESB_HOME]/repository/components/dropins for OSGI jars.


Detailed description:-
To deploy a module
1. Create a module archive file (.mar), you can follow the doc : "https://docs.wso2.com/display/ESB490/Writing+an+Axis2+Module" 
	- OR download 'ServiceOperatorCounter-1.0.0.mar' which is a sample available in git location
2. In ESB management console, 
	- Go to module deployment -> Add module
	- upload this .mar or else can manually copy this .mar into <ESB_HOME>/repository/deployment/server/axis2modules
3. Activate the module, you can follow the doc here : https://docs.wso2.com/display/ESB490/Engaging+Modules
	- You can activate in two types as service or globally
	- If you need to globally engage mar, 
		before start the server add this entry <module ref=“module-name"/> to <PRODUCT_HOME>/..axis2.xml  
	- If need to engage in service level, 
		add this entry <parameter name="engagedModules">module-name</parameter> to proxy service 
4. Now module shold be engaged without error

Deploying a carbon app
1. Create a carbon app using eclipse IDE and export as .car, you can follow the doc : "https://docs.wso2.com/display/DVS380/Creating+ESB+Artifacts"
2. In ESB management console, 
	- Go to carbon application deployment -> Add
	- upload a .car 
3. Now carbon application should be deployed without faulty


Summary: Deploying a module and a carbon app into ESB without faulty and incase there is no any dependancy from MAR file classes.


Note:- You cannot have a dependency from class in .mar to jar packed in a .car file; .mar will deploy during the initial stages of the startup and .car will deploy later. So during .mar deployment, depending jars will not available.


#############################################################################################################################################



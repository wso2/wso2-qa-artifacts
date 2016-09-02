------------------------------------------------------------------------------

    Script Name:- crud-gadget.jmx
    Author: Danesh
    Supported Product: ES 2.1.0


Description:
- This script logs into publisher > creates a gadget > search the gadget > read the asset > update the asset > logout user from the system.

Pre-Condition:
- Logged in user should exists in the system with minimal permissions to perform actions. user credentials are taken from user-credentials.csv file.
- Minimal Permissions required for the user
	"/permission/admin/enterprisestore"
	"/permission/admin/login"
	"/permission/admin/manage"
- default gadgets asset type should exists in the system.
- thumbnail.png file should exists in scripts folder.

User Defined Variables:
- asset : asset type (e.g: gadgets)
- assetID : UUID of the created asset
- SCRIPT_PATH : absolute file path of the script file

CSV Data Set Config:
- user-credentials.csv - store credentials of logged in users
- gadget-data.csv - metadata information of the asset

------------------------------------------------------------------------------

    Script Name:- crud-gadget-with-lc.jmx
    Author: Danesh
    Supported Product: ES 2.1.0


Description:
- This script logs into publisher > creates a gadget > search the gadget > read the asset > update the asset > change LC state to in-review > change LC state to published > logout user from the system. So the created assets will appear in ES Store.

Pre-Condition:
- Logged in user should exists in the system with minimal permissions to perform actions. user credentials are taken from user-credentials.csv file.
- Minimal Permissions required for the user
	"/permission/admin/enterprisestore"
	"/permission/admin/login"
	"/permission/admin/manage"
- default gadgets asset type should exists in the system. 
- thumbnail.png file should exists in scripts folder.

User Defined Variables:
- asset : asset type (e.g: gadgets)
- assetID : UUID of the created asset
- SCRIPT_PATH : absolute file path of the script file

CSV Data Set Config:
- user-credentials.csv - store credentials of logged in users
- gadget-data.csv - metadata information of the asset

------------------------------------------------------------------------------

    Script Name:- store_search.jmx
    Author: Danesh
    Supported Product: ES 2.1.0


Description:
- This script goto ES Store(as anonymous user) > logs into Store > goto asset listing page > search the gadget > read the gadget > add user reviews > search assets by tags > delete reviews > logout user from the system.

Pre-Condition:
- Logged in user should exists in the system with minimal permissions to perform actions. user credentials are taken from user-credentials.csv file.
- Minimal Permissions required for the user
	"/permission/admin/enterprisestore"
	"/permission/admin/login"
	"/permission/admin/manage"
- pre-loaded gadgets (according to the asset_type.csv) should exists in the system.

User Defined Variables:
- assetID : UUID of the created asset
- reviewID : user review ID

CSV Data Set Config:
- user-credentials.csv - store credentials of logged in users
- asset_type.csv - asset search information and user review data

------------------------------------------------------------------------------

README
==========
Payament Gateway

Description
=================
This sample covers the 'Dynamic Router', 'Content-Based routing' concepts. Using the payamentGw service, the request dynamically routes to the
-correct payment module once checked the existing pool and do the payment successfully.If new payment method is introduced,
-no need to do any change in the service level and only need to updated the payment module pool*(currently this is an map with hard coded values due to pending RDBMS connector,
-but originally this should be retrieved from the database)

Possible paymodes at the moment:
sampath, hnb, ezcash, starpoint

Sample Request:
===================
POST: http://localhost:9090/paymentgw/pay
Content-Type: application/json
BODY:

{
	"paymode": "sampath",
	"account": "12334",
	"amount": "test"
}

Service Orchestration:
paymentgw>>modules>>paymentrouter

[1]http://localhost:9090/paymentgw/pay
[2]http://localhost:9090/modules/checkModule
[3]http://localhost:9090/paymentrouter/<paymode>
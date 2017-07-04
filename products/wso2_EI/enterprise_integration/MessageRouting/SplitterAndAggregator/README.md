###### **Product Version** - Tested on ballerina 0.89 version
###### **Scenario** - Aggregator EIP pattern
&nbsp;
#### **Description**
 This scenario demonstrate aggregating the reponses coming from different backend services and sending a aggregated response to the requestor.
 
#### **Use Case**
 Let’s assume a Salesperson wants to get the Customer's Personal Information, Contact Information and the Purchasing Behavior for a given customer ID through the Customer Relationship Management (CRM) system for the upcoming direct marketing campaign. In a real world scenario, the  CRM system needs to call multiple backend services to get the required information and aggregate the responses coming from the backend systems to provide the information requested by the salesperson. 
 
The system will send a request message with the customer ID to retrieve the required information from following systems.

* Send a request to "Customer Info Service" to get customer's personal information
* Send a request to "Contact Info Service" to get customer's contact Information
* Send a request to "Purchasing Behavior Service" to get the purchasing details of the customer

The following backend services will provide the requested information based on the customer ID provided.
* ContactInfo.bal
* CustomerInfo.bal
* PurchasingInfo.bal
 
Intermediate service (AggregatorService) will get the responses coming from the backend services and integrate the responses to provide the response to the Salesperson.


 
 #### **Invoking the Service**
 Execute following command to run the service.
 ```
 <Ballerina_HOME>/bin/ballerina run service aggregator.bsz
 ```
To invoke the service use following information. (Data is available for Customer ID 100, 101 and 102)
> _Request_ - http://localhost:9090/AggregatorService 

> _HTTP Method_ - POST

> _Payload_ - 
```
{
  "Customer": { "id": "101" }
}
```

Response of the aggregator Service
```
{
    "CustomerDetailsResponse": {
        "PersonalDetails": {
            "Name": "Anne Stepson",
            "Age": "50",
            "Gender": "Female"
        },
        "ContactDetails": {
            "email": "anne@yahoo.com",
            "Address": "France",
            "PhoneNo": "0766927481"
        },
        "PurchasingDetails": {
            "Product": [
                {
                    "Type": "Fashion Accessories",
                    "ProductName": "wrist watch",
                    "Brand": "Titan"
                },
                {
                    "Type": "Fashion Accessories",
                    "ProductName": "Necklace",
                    "Brand": "gold"
                }
            ]
        }
    }
}
```


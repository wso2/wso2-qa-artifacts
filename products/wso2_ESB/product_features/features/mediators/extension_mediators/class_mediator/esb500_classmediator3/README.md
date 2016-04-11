# README

This artifact is written to demonstrate the use of class mediator. This class mediator will set a property and later accesses it through property mediator

> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 and WSO2 AS 530


### Contents 
  - Maven project of class mediator: secondClassMediator
  - sequences: class_seq_3.xml
  - Proxy service: ClassProxy_1.xml
  - Axis2 Service: OrderPlacingSystem.aar
  
### Preconditions
- Maven project should be built  by issuing mvn clean install
- The secondClassMediator-0.0.1-SNAPSHOT.jar (inside target folder of the maven project) should be copied to <ESB_HOME>/repository/components/lib folder
- ESB server should be restarted
- Axis2 service should be deployed in WSO2 AS

### Steps
- Deploy the given sequence in WSO2 ESB
- Deploy the given proxy service in WSO2 ESB by changing endpoint to refer the deployed axis2 service.
- Invoke the proxy service


### Expected Outcome
The property set through the class mediator will be displayed in the console
E.g.
```sh
[2016-04-01 15:28:17,895]  INFO - LogMediator newProperty = set through class mediator
```

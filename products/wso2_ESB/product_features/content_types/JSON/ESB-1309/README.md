#Artifact for ESB-1309

1. Deploy TestApi and  mockservice into ESB.

2. Now Invoke the API with the following curl command.

```sh
curl -v -H "Content-Type:application/json" http://localhost:8280/test/testapi1
```

3. You should recieve the following response.

```sh

{"Vehicles":[{"businessobjectnum":2837613,"busobjsequence":123,"objectnum":4,"year":"2002","make":"MAZDA","model":"PROTEGE DX 4DR","vehicleId":1,"Endorsements":[],"Coverages":[],"Drivers":[]},{"businessobjectnum":2837613,"busobjsequence":123,"objectnum":287,"year":"2000","make":"DODGE/RAM TRUCK/VAN","model":"GRAND CARAVAN","vehicleId":2,"Endorsements":[],"Coverages":[],"Drivers":[]}],"businessobjectnum":2837613,"busobjsequence":123,"policyNumber":"M05664","termEffectiveDate":"2015-05-02T00:00:00","termEffectiveTime":60,"termExpiryDate":"2016-05-02T00:00:00","policyId":"2837613-123","policyHolderId":0,"Insureds":[],"Addresses":[],"Documents":[]}

```

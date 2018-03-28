This artifact contains an insequence and out sequence which can be used to used to fetch data depending on the header value set.
e.g X-Bypass-Cache to true will bypass the cache and if X-Bypass-Cache to false it will fetch the response from cache

This was tested in APIM 2.1.0 pack

### Steps

- Navigate to APIM publisher portal and start an api publisher wizard and fill in the 1st phase ( Design )
- In the second phase ( Implementation ) click on "Enable Message Mediation" and upload the two sequences as,
	--Upload "bypass_response_cache_in_sequence.xml" to "In Flow"
	-- Upload "bypass_response_cache_out_sequence.xml" to "Out Flow"
	   (Please note, Do not enable "Response Caching" in the 3rd phase. Complete the rest of wizard and publish the API.)
- Now subscribe to the API from an application via the API store and invoke the API you created. While invoking,
	-- To fetch the response bypassing the cache set the header X-Bypass-Cache to true and invoke the API
	-- To fetch the response from cache you can set the header X-Bypass-Cache to false and invoke the API
	-- If you do not specify the above header the response will be cached

**Please note -** For this sample I have set the cache time for 60 seconds in the bypass_response_cache_in_sequence.xml sequence 
```sh
<cache scope="per-host" collector="false" hashGenerator="org.wso2.carbon.mediator.cache.digest.DOMHASHGenerator" timeout="60">
```
you can modify it as per you requirement.

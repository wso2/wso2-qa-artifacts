1. Start Simple WebService with IDEA
2. Server.java contains which content-type to be verified
i.e:  output.writeBytes(construct_http_header(200, 14)); (this means requested content-type is text/csv)
Note: you have to change "14" according to correct content type number from switch case list and re-run the server for different content types
3. Run simpleWebService
4. Create pass through proxy and create endpoint for http://localhost:9003/index.html
5. curl -v <proxy service> 

Sample proxy configuration: 

<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="pt"
       transports="https,http"
       statistics="disable"
       trace="disable"
       startOnLoad="true">
   <target>
      <outSequence>
         <send/>
      </outSequence>
      <endpoint>
         <address uri="http://localhost:9003/index.html"/>
      </endpoint>
   </target>
   <description/>
</proxy>



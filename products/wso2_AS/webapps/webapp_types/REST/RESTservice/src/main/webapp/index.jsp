<html>
<body>
<h1>REST Service</h1>

<p>This is a simple service created to test a REST service</p>

<h3>Available Operations</h3>

<p>
    <b>User Management Service</b><br/>
    [POST] Create a user: "http://localhost:8080/RESTservice/rest/users/add"<br/>
    [GET] Search for user: "http://localhost:8080/RESTservice/rest/users/search/{user_id}"<br/>
    [PUT] Update a user: "http://localhost:8080/RESTservice/rest/users/update"<br/>
    [DELETE] Delete a user: "http://localhost:8080/RESTservice/rest/users/delete/{user_id}"
    <br/>
<hr/>
<b>HTTP Status Service</b><br/>
http://localhost:8080/RESTservice/rest/status/{status_code} <br/>
eg: <br/>
http://localhost:8080/RESTservice/rest/status/200 <br/>
http://localhost:8080/RESTservice/rest/status/201 <br/>
http://localhost:8080/RESTservice/rest/status/500 <br/>
<br/>
<hr/>
<b>Delayed Response Service</b><br/>
http://localhost:8080/RESTservice/rest/delay/{delay time in miliseconds} <br/>
eg: <br/>
http://localhost:8080/RESTservice/rest/delay/1000 <br/>
http://localhost:8080/RESTservice/rest/delay/2000 <br/>
http://localhost:8080/RESTservice/rest/delay/4522 <br/>
<br/>
<hr/>
<b>Random Password Generation Service</b><br/>
http://localhost:8080/RESTservice/rest/password/generate <br/>
</p>
</body>
</html>

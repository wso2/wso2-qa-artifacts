#!/bin/bash

echo "Create Users..."
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d @create1.json http://localhost:8080/RESTservice/rest/user/add
echo ""
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d @create2.json http://localhost:8080/RESTservice/rest/user/add
echo ""
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d @create3.json http://localhost:8080/RESTservice/rest/user/add
echo

echo "Search Users after create"
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/1
echo ""
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/2
echo ""
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/3
echo ""

echo "Update Users..."
curl -X PUT -H "Content-Type:application/json" -H "Accept:application/json" -d @update1.json http://localhost:8080/RESTservice/rest/user/update
echo ""
curl -X PUT -H "Content-Type:application/json" -H "Accept:application/json" -d @update2.json http://localhost:8080/RESTservice/rest/user/update
echo ""
curl -X PUT -H "Content-Type:application/json" -H "Accept:application/json" -d @update3.json http://localhost:8080/RESTservice/rest/user/update
echo ""

echo "Search Users after update"
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/1
echo ""
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/2
echo ""
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/3
echo ""

echo "Delete Users..."
curl -X DELETE -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/delete/1
echo ""
curl -X DELETE -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/delete/2
echo ""
curl -X DELETE -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/delete/3
echo ""

echo "Check if deleted..."
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/1
echo ""
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/2
echo ""
curl -X GET -H "Content-Type:application/json" -H "Accept:application/json" http://localhost:8080/RESTservice/rest/user/search/3
echo ""


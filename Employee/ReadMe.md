Web application 
===============================================================
Get request for employee list 
Request type : Method.Get
Rest URL : http://localhost:8080/employee

Result: [{
          "id": 1,
          "firstName": "Lokesh",
          "lastName": "Gupta",
          "email": "abc@gmail.com",
          "companies": {
            "id": 1,
            "companyName": "TISP",
            "emailDomain": "tsip.com"
          },
          "department": {
            "id": 1,
            "departmentName": "Hardware"
          }
        }, {
          "id": 2,
          "firstName": "Praveenkumar",
          "lastName": "Shethe",
          "email": "Praveen.shethe7@gmail.com",
          "companies": {
            "id": 1,
            "companyName": "TISP",
            "emailDomain": "tsip.com"
          },
          "department": null
        }]
        
Status code 200 for success
http.Status.ok
---------------------------------------------------------------
Create request for a employee with Company 
Rest URL : http://localhost:8080/employee
Request type : Method.Post

Result: {
                  "firstName": "Lokesh",
                  "lastName": "Gupta",
                  "email": "abc@gmail.com",
                  "companies": {
                    "id": 1
                  }
        }
Status code 201 for success
http.Status.ok
---------------------------------------------------------------
Get request for Department list  
Rest URL : http://localhost:8080/department
Request type : Method.Get

Result: [{
          "id": 1,
          "departmentName": "Hardware"
        }, {
          "id": 2,
          "departmentName": "it"
        }, {
          "id": 3,
          "departmentName": "support"
        }]
Status code 200 for success
http.Status.ok
---------------------------------------------------------------
Update request for adding employee to Department  
Rest URL : http://localhost:8080/department
Request type : Method.Put
Result: {
            "id":"1",
            "department":{
                    "id":"2"
            }
        }
Status code 204 for success
http.Status.ok
---------------------------------------------------------------


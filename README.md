# Library Management System Task using Spring-Boot + REST + hibernate
1.Rest API
2.Transaction Management
3.Hibernate
4.Logging

# Pre Requesting 
 
1.JDK 1.8
2.IDE (eclipse or Netbeans)
3.Maven
4.apache tomcat 8+
5.MySql server
6.REST client (eg. Postman )

# How  project works.

Step 1:open project form any Spring pluging enable IDE 
Step 2: change databse configurate at application context file
Step 3:run spring boot application via command line or form IDE, on command line run the following command
mvn spring-boot:run

If run from IDE then  run spring main file under packge com.librarymanagementsystem
Step4: change logging configuration according to local machine's file path.

# CRUP operations for Users Entity, can perform by postman

Api url: http://localhost:8080/api/v1.0/users
1. Opertaion: create-users/add-user
	- Http Metohd :POST
	- Endpoint: http://localhost:8080/api/v1.0/users
	- RequestBody i.e. {"name":"Noman Mughal","cnic":"123456789012345","mobile":"923490000012","address":"I-8/3 Islamabad, 44000, Pakistan"}
	- ResponseBody i.e. {"statusCode":201,"status":"Success","responseMessage":"Record created/update successfully!"}

2. Opertaion: retrieve-users/fetch-users-list
	- Http Metohd :GET
	- Endpoint: http://localhost:8080/api/v1.0/users
	- ResponseBody i.e. {"users":[{"id":1,"name":"Adil Javed","cnic":"123456789012345","mobile":"923490000012","address":"F-8/3 Islamabad, 44000, Pakistan"},{"id":2,"name":"Jahanzaib Ali","cnic":"123456789012345","mobile":"923490000012","address":"Gulberg Greens Islamabad 44000, Pakistan"}]}
	
3. Opertaion: update-users/modify-user
	- Http Metohd :PUT
	- Endpoint: http://localhost:8080/api/v1.0/users
	- RequestBody i.e. {"id":7,"name":"Hassan Noman Khan1","cnic":"123456789012345","mobile":"923490000012","address":"I-8/3 Islamabad, 44000, Pakistan"}
	- ResponseBody i.e. {"statusCode":201,"status":"Success","responseMessage":"Record created/update successfully!"}

4. Opertaion: delete-users/remove-user
	- Http Metohd :DELETE
	- Endpoint: http://localhost:8080/api/v1.0/users/{identifier}
	- Requesting Parameter of identifier as numerical number, i.e. http://localhost:8080/api/v1.0/users/2
	
# CRUP operations for Categories Entity, can perform by postman

Api url: http://localhost:8080/api/v1.0/categories
1. Opertaion: create-categories/add-categories
	- Http Metohd :POST
	- Endpoint: http://localhost:8080/api/v1.0/categories
	- RequestBody i.e. {"name":"Medical"}
	- ResponseBody i.e. {"statusCode":201,"status":"Success","responseMessage":"Record created/update successfully!"}

2. Opertaion: retrieve-categories/fetch-categories-list
	- Http Metohd :GET
	- Endpoint: http://localhost:8080/api/v1.0/categories
	- ResponseBody i.e. {"categories":[{"Id":2,"name":"Medical"},{"Id":3,"name":"Art"},{"Id":4,"name":"Commerce"},{"Id":5,"name":"Finance"},{"Id":6,"name":"Computer Science"},{"Id":7,"name":"Computer Science"},{"Id":8,"name":"Eelectronics Engineering"}]}
	
3. Opertaion: update-categories/modify-categories
	- Http Metohd :PUT
	- Endpoint: http://localhost:8080/api/v1.0/categories
	- RequestBody i.e. {"Id":7, "name":"Medical Science"}
	- ResponseBody i.e. {"statusCode":201,"status":"Success","responseMessage":"Record created/update successfully!"}

4. Opertaion: delete-categories/remove-categories
	- Http Metohd :DELETE
	- Endpoint: http://localhost:8080/api/v1.0/categories/{identifier}
	- Requesting Parameter of identifier as numerical number, i.e. http://localhost:8080/api/v1.0/categories/2
	
# CRUP operations for Books Entity, can perform by postman

Api url: http://localhost:8080/api/v1.0/books
1. Opertaion: create-books/add-books
	- Http Metohd :POST
	- Endpoint: http://localhost:8080/api/v1.0/books
	- RequestBody
	- ResponseBody

2. Opertaion: retrieve-books/fetch-books-list
	- Http Metohd :GET
	- Endpoint: http://localhost:8080/api/v1.0/books
	- ResponseBody
	
3. Opertaion: update-books/modify-books
	- Http Metohd :PUT
	- Endpoint: http://localhost:8080/api/v1.0/books
	- RequestBody
	- ResponseBody

4. Opertaion: delete-books/remove-books
	- Http Metohd :DELETE
	- Endpoint: http://localhost:8080/api/v1.0/books/{identifier}
	- Requesting Parameter of identifier as numerical number, i.e. http://localhost:8080/api/v1.0/books/2
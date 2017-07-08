# Numbers Microservice Application

#### Number services

Method	| Path	| Description	
------------- | ------------------------- | -------------
GET	| /api/numbers   | Get number list in ascending order
GET	| /api/numbers?sort=DESC | Get number list in descending order
GET	| /api/numbers/{id}  | Get specified number	 	
GET	| /api/numbers/max   | Get max number
GET	| /api/numbers/min   | Get min number
POST	| /api/numbers  | Insert number	
DELETE	| /api/numbers/{id}	| Delete specified number

#### Important endpoints
- http://localhost:8000 - Number Service
- http://localhost:8761 - Eureka Dashboard

#### Build
```bash
> mvn clean package
> docker-compose -f docker-compose.yml up
```


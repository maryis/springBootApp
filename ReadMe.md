this is an application with springboot(starterData,starterWeb,starterDataRest)
web: for mvc : example : PersonHandler that is @restController 

dataRest: @RepositoryRestResource:it gives a ready rest api(no need to write code for rest and request mapping)
 example: CarService  :

Data: PagingAndSortingRepository : gives repo with paging and sorting ability example: CarService
Data: CrudRepository : gives repo which by default has CRUD operations

notice: oracle-driver dependencies do not exist on mvn-repo or spring-initializr 
and we should add them separately
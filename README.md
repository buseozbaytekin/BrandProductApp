
# Brand-Product Application

This application records product and brand lists in an associated way with postgreSQL. It is a project developed with the MVC design pattern. 

* Model includes Product and Brand classes. 

* View includes productDTO and brandDTO packeges.

* Controller includes productAPI and brandAPI.

At the service layer; creation, update, display, delete, listing services were created. These services are created for both entities.
The table relation is designed to have more than one product of each brand with the many to one annotation.


Rest service controls were prepared with the classes of the API package and Response entities were arranged. Responses were created separately for services such as deletion, creation and update.

* Created base endpoint with @RequestMapping("/api/v1/brand").
* @PostMapping -> create
* @GetMapping("{id}") -> get
* @PutMapping -> update
* @DeleteMapping("{id}") -> delete
* @GetMapping("{slice}") -> slice

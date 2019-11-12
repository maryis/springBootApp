package com.example.demo.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path = "vehicle") //to use this, we need spring-data-rest dependency!!!!!
//it gives us list, (get,create,update,delete) by id  (a rest standard interface)
//for example : http://localhost:8081/vehicle/, http://localhost:8081/vehicle/2, http://localhost:8081/vehicle/+body+post
// all available methods: http://localhost:8081/vehicle/

public interface CarService extends PagingAndSortingRepository<Car, Integer> {
    //Pageable secondPageWithFiveElements = PageRequest.of(1, 5); page-number and limit(no of records in page)
//Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
//    By having it extend PagingAndSortingRepository, we get findAll(Pageable pageable) and findAll(Sort sort) methods for paging and sorting.
//    Page<Product> allProductsSortedByName = productRepository.findAll(Sort.by("name"));


    //we can reach to all url patterns by : http://localhost:8081/vehicle/search
    //methods like find are listed there
    // http://localhost:8081/vehicle/search/findCarsByModel?model=bmw
    List<Car> findCarsByModel(String model);

    //http://localhost:8081/vehicle/search/findTopById
    Car findFirstById(int id);

    //we have this by default, because we extended PagingAndSortingRepository
//http://localhost:8081/vehicle?page=0&size=1

}

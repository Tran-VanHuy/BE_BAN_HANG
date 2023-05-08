package banhang.example.banhang.controller;

import banhang.example.banhang.model.BrandsModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/brands")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @GetMapping
    ResponseEntity<Response> findAll(@RequestParam(defaultValue = "0", required = false) Integer pageNo,
                                     @RequestParam(defaultValue = "10", required = false) Integer pageSize){
        ResponseEntity<Response> brands = brandsService.findAll(pageNo, pageSize);
        return  brands;
    }

    @PostMapping
    ResponseEntity<Response> create(@RequestBody BrandsModel newBrandsModel){
        ResponseEntity<Response> brands = brandsService.create(newBrandsModel);
        return brands;
    }
}

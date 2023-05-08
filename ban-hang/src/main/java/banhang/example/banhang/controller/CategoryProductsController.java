package banhang.example.banhang.controller;

import banhang.example.banhang.model.CategoryProductsModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.CategoryProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/category-products")
public class CategoryProductsController {

    @Autowired
    private CategoryProductsService categoryProductsService;

    @GetMapping
    ResponseEntity<Response> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                     @RequestParam(defaultValue = "10") Integer pageSize){
        ResponseEntity<Response> categoryProducts = categoryProductsService.findAll(pageNo, pageSize);
        return  categoryProducts;
    }

    @PostMapping
    ResponseEntity<Response> create(@RequestBody CategoryProductsModel newCategoryProductsModel){
        ResponseEntity<Response> categoryProducts = categoryProductsService.create(newCategoryProductsModel);
        return  categoryProducts;
    }

    @DeleteMapping("{id}")
    ResponseEntity<Response> delete(@PathVariable Long id){
        ResponseEntity<Response> categoryProducts = categoryProductsService.delete(id);
        return  categoryProducts;
    }

    @PutMapping("{id}")
    ResponseEntity<Response> update(@PathVariable Long id, @RequestBody CategoryProductsModel newCategoryProductsModel){
        ResponseEntity<Response> categoryProducts = categoryProductsService.update(id, newCategoryProductsModel);
        return  categoryProducts;
    }
}

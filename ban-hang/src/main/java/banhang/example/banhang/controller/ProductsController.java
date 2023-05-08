package banhang.example.banhang.controller;

import banhang.example.banhang.model.ProductsModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.response.ResponsePaging;
import banhang.example.banhang.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;
    @GetMapping
    ResponseEntity<ResponsePaging> findAll(@RequestParam(required = false) String category,
                                           @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                                           @RequestParam(defaultValue = "10", required = false) Integer pageSize){
        ResponseEntity<ResponsePaging> products = productsService.findAll(category, pageNo, pageSize);
        return  products;
    }

    @GetMapping("/{slug}")
    ResponseEntity<Response> findBySlug(@PathVariable String slug){
        ResponseEntity<Response> products = productsService.findBySlug(slug);
        return  products;
    }

    @PostMapping
    ResponseEntity<Response> create(@RequestBody ProductsModel newProductsModel){
        ResponseEntity<Response> products = productsService.create(newProductsModel);
        return  products;
    }

    @GetMapping("/like/{id}")
    ResponseEntity<Response> likeProducts(@PathVariable Long id){

        ResponseEntity<Response> likeProducts = productsService.likeProducts(id);
        return likeProducts;
    }

    @DeleteMapping("{id}")
    ResponseEntity<Response> delete(@PathVariable Long id){

        ResponseEntity<Response> products = productsService.delete(id);
        return products;
    }

    @PutMapping("{id}")
    ResponseEntity<Response> updateProduct(@PathVariable Long id, @RequestBody ProductsModel NewProductsModel){

        ResponseEntity<Response> products = productsService.update(id, NewProductsModel);
        return products;
    }
}

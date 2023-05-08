package banhang.example.banhang.controller;

import banhang.example.banhang.model.ProductsSoldModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.ProductsSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/order")
public class ProductsSoldController {

    @Autowired
    private ProductsSoldService productsSoldService;

    @PostMapping
    ResponseEntity<Response> createOrder (@RequestBody ProductsSoldModel newProductsSoldModel){

        ResponseEntity<Response> productsSold = productsSoldService.createOrder(newProductsSoldModel);
        return  productsSold;
    }
}

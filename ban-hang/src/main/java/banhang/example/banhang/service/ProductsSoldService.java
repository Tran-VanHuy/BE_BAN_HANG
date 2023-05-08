package banhang.example.banhang.service;

import banhang.example.banhang.model.ProductsModel;
import banhang.example.banhang.model.ProductsSoldModel;
import banhang.example.banhang.repository.ProductsSoldRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductsSoldService {

    @Autowired
    private ProductsSoldRepository productsSoldRepository;

    public ResponseEntity<Response> createOrder (@RequestBody ProductsSoldModel newProductsSoldModel){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, productsSoldRepository.save(newProductsSoldModel))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e)
            );
        }
    }
}

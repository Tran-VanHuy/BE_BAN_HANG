package banhang.example.banhang.controller;

import banhang.example.banhang.model.AdvertisementModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    ResponseEntity<Response> findAll(){

        ResponseEntity<Response> ad = advertisementService.findAll();
        return ad;
    }
    @PostMapping
    ResponseEntity<Response> create(@RequestBody AdvertisementModel newAdvertisementModel){

        ResponseEntity<Response> ad = advertisementService.create(newAdvertisementModel);
        return ad;
    }
}

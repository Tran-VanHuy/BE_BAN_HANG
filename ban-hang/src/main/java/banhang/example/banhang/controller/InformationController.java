package banhang.example.banhang.controller;

import banhang.example.banhang.model.InformationModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping
    ResponseEntity<Response> findAll(){

        ResponseEntity<Response> information = informationService.findAll();
        return  information;
    }

    @PostMapping
    ResponseEntity<Response> create(@RequestBody InformationModel newInformationModel){

        ResponseEntity<Response> information = informationService.create(newInformationModel);
        return  information;
    }
}

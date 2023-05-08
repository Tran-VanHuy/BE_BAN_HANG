package banhang.example.banhang.service;

import banhang.example.banhang.model.AdvertisementModel;
import banhang.example.banhang.repository.AdvertisementRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public ResponseEntity<Response> findAll(){

        try {
            List<AdvertisementModel> advertisementModelList = advertisementRepository.findAll();
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Response("TRUE", true, advertisementModelList)
            );
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody AdvertisementModel newAdvertisementModel){

        try {

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("TRUE", true, advertisementRepository.save(newAdvertisementModel))
            );
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }
}

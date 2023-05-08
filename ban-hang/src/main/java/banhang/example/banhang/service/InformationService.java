package banhang.example.banhang.service;

import banhang.example.banhang.model.InformationModel;
import banhang.example.banhang.repository.InformationRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class InformationService {

    @Autowired
    private InformationRepository informationRepository;

   public ResponseEntity<Response> findAll(){

        try {
            List<InformationModel> informationModelList = informationRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, informationModelList)
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e)
            );
        }
    }

   public ResponseEntity<Response> create(@RequestBody InformationModel newInformationModel){

        try {

            List<InformationModel> informationModelList = informationRepository.findAll();
            if(informationModelList.size() >= 4){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new Response("FAIL", false, "Dữ liệu không được quá 4")
                );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Response("SUCCESS", true, informationRepository.save(newInformationModel))
                );
            }

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e)
            );
        }
    }
}

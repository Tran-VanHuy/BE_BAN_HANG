package banhang.example.banhang.service;

import banhang.example.banhang.model.BrandsModel;
import banhang.example.banhang.repository.BrandsRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public ResponseEntity<Response> findAll(Integer pageNo, Integer pageSize){

        try {
            Pageable page = PageRequest.of(pageNo, pageSize);
            Page<BrandsModel> brandsModelList = brandsRepository.findAll(page);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, brandsModelList.getContent())
            );
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody BrandsModel newBrandsModel){
        try {

            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, brandsRepository.save(newBrandsModel))
            );
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }
}

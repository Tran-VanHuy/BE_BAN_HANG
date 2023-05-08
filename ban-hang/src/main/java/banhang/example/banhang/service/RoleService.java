package banhang.example.banhang.service;

import banhang.example.banhang.model.RoleModel;
import banhang.example.banhang.repository.RoleRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public ResponseEntity<Response> findAll(){

        try {
            List<RoleModel> roleModelList = roleRepository.findAll();
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, roleModelList)
            );
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody RoleModel newRoleModel){

        try {
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, roleRepository.save(newRoleModel))
            );
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }
}

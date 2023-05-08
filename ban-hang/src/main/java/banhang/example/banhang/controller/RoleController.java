package banhang.example.banhang.controller;

import banhang.example.banhang.model.RoleModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    ResponseEntity<Response> findAll(){

        ResponseEntity<Response> role = roleService.findAll();
        return  role;
    }

    @PostMapping
    ResponseEntity<Response> create(@RequestBody RoleModel newRoleModel){

        ResponseEntity<Response> role = roleService.create(newRoleModel);
        return  role;
    }
}

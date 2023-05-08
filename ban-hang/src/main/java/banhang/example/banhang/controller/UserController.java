package banhang.example.banhang.controller;

import banhang.example.banhang.dto.LoginDto;
import banhang.example.banhang.model.UserModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    ResponseEntity<Response> findAll(){

        ResponseEntity<Response> user = userService.findAll();
        return user;
    }

    @PostMapping
    ResponseEntity<Response> create(@RequestBody UserModel newUserModel){

        ResponseEntity<Response> user = userService.create(newUserModel);
        return user;
    }

    @PostMapping("/login")
    ResponseEntity<Response> create(@RequestBody LoginDto newLoginDto){

        ResponseEntity<Response> user = userService.login(newLoginDto);
        return user;
    }
}

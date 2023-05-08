package banhang.example.banhang.service;

import banhang.example.banhang.Bean.PasswordHash;
import banhang.example.banhang.dto.LoginDto;
import banhang.example.banhang.model.UserModel;
import banhang.example.banhang.repository.UserRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordHash passwordHash;



    public ResponseEntity<Response> findAll(){

        try {
            List<UserModel> userModelList = userRepository.findAll();
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, userModelList)
            );
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody UserModel newUserModel){

        try {
            Boolean userModelOptional = userRepository.existsByGmail(newUserModel.getGmail());
            if(userModelOptional == true){
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new Response("FAIL", false, "Tài khoản đã tồn tại")
                );
            }
             newUserModel.setPassword(passwordHash.encoder().encode(newUserModel.getPassword()));
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, userRepository.save(newUserModel))
            );
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> login (@RequestBody LoginDto newLoginDto){

        try {
            Boolean user = userRepository.existsByGmail(newLoginDto.getGmail());

            if(user == false){
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new Response("FAIL", false, "Sai tài khoản hoặc mặt khẩu")
                );
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            Optional<UserModel> userModelOptional = userRepository.findOneByGmail(newLoginDto.getGmail());
            boolean password = encoder.matches(newLoginDto.getPassword(), userModelOptional.get().getPassword());

            if(userModelOptional != null && password == true){
                return  ResponseEntity.status(HttpStatus.OK).body(
                        new Response("SUCCESS", true, userModelOptional)
                );
            }else{
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new Response("FAIL", false, "Sai tài khoản hoặc mặt khẩu")
                );
            }
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }
}

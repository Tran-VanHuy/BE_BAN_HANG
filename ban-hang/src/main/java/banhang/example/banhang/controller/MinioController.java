package banhang.example.banhang.controller;

import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.MinioService;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/upload")
public class MinioController {

//    @Autowired
//    private MinioService minioService;
//
//    @GetMapping("/bucket-name/{nameBucket}")
//    ResponseEntity<Response> makeBucket(@PathVariable String nameBucket) throws Exception {
//
//        ResponseEntity<Response> minio = minioService.makeBucket(nameBucket);
//        return  minio;
//    }
}

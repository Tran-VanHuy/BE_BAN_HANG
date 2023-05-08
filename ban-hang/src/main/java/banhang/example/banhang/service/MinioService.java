package banhang.example.banhang.service;

import banhang.example.banhang.response.Response;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MinioService {

//    @Autowired
//    private MinioClient minioClient;
//    public ResponseEntity<Response> makeBucket(String nameBucket) throws Exception {
//
////    check exits bucket
////        Boolean checkExitBucket = minioClient.bucketExists(BucketExistsArgs.builder().bucket(nameBucket).build());
////        if(!checkExitBucket){
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
////                    new Response("FAIL", false, "Bucket exits: " + nameBucket)
////            );
////        }
//
//        MakeBucketArgs makeBucket = MakeBucketArgs.builder().bucket(nameBucket).build();
//
//        minioClient.makeBucket(makeBucket);
//
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new Response("SUCCESS", true, "Created Success: " + nameBucket)
//        );
//    }
}

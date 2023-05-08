package banhang.example.banhang.controller;

import banhang.example.banhang.model.BlogModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    ResponseEntity<Response> findAll(
            @RequestParam(defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize
    ){

        ResponseEntity<Response> blog = blogService.findAll(pageNo, pageSize);
        return  blog;
    }

    @PostMapping
    ResponseEntity<Response> create(@RequestBody BlogModel newBlogModel){

        ResponseEntity<Response> blog = blogService.create(newBlogModel);
        return  blog;
    }

    @GetMapping("/{slug}")
    ResponseEntity<Response> findBySlug(@PathVariable String slug){

        ResponseEntity<Response> blog = blogService.findBySlug(slug);
        return  blog;
    }
}

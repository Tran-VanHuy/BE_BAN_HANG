package banhang.example.banhang.controller;

import banhang.example.banhang.model.BannerModel;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("")
    ResponseEntity<Response> findAll(
            @RequestParam(defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize
    ){
        ResponseEntity<Response> banner = bannerService.findAll(pageNo, pageSize);
        return  banner;
    }

    @PostMapping("")
    ResponseEntity<Response> create(@RequestBody BannerModel newBannerModel){
        ResponseEntity<Response> banner = bannerService.create(newBannerModel);
        return  banner;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Response> delete(@PathVariable Long id){
        ResponseEntity<Response> banner = bannerService.delete(id);
        return  banner;
    }

    @PutMapping("/{id}")
    ResponseEntity<Response> update(@PathVariable Long id, @RequestBody BannerModel newBannerModel){
        ResponseEntity<Response> banner = bannerService.update(id, newBannerModel);
        return  banner;
    }
}

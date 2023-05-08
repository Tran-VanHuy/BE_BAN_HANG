package banhang.example.banhang.service;

import banhang.example.banhang.model.BannerModel;
import banhang.example.banhang.repository.BannerRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public ResponseEntity<Response> findAll(Integer pageNo, Integer pageSize) {

        try {
            Pageable paging = PageRequest.of(pageNo, pageSize);
            Page<BannerModel> listBanner = bannerRepository.findAll(paging);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("Success", true, listBanner.getContent())
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("Fail", false, e)
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody BannerModel newBannerModel) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("Success", true, bannerRepository.save(newBannerModel))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("Fail", false, e)
            );
        }
    }
    public ResponseEntity<Response> delete(Long id) {

        try {
            Optional<BannerModel> bannerModelOptional = bannerRepository.findById(id);
            bannerRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("Success", true, bannerModelOptional)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("Fail", false, e)
            );
        }
    }

    public ResponseEntity<Response> update(Long id, @RequestBody BannerModel newBannerModel) {

        try {
            Optional<BannerModel> bannerModelOptional = bannerRepository.findById(id).map(item -> {
                item.setLink(newBannerModel.getLink());
                item.setImage(newBannerModel.getImage());
                return  bannerRepository.save(item);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("Success", true, bannerModelOptional)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("Fail", false, e)
            );
        }
    }



}

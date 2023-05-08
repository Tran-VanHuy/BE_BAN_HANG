package banhang.example.banhang.service;

import banhang.example.banhang.model.BlogModel;
import banhang.example.banhang.repository.BlogRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;

@Service
public class BlogService {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    @Autowired
    private BlogRepository blogRepository;

    public  ResponseEntity<Response> findAll(Integer pageNo, Integer pageSize){
        try {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
//            Page<BlogModel> pageTuts =
                    Page<BlogModel> blogModelList = blogRepository.findAll(paging);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, blogModelList.getContent())
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public  ResponseEntity<Response> findBySlug(String slug){
        try {
            Optional<BlogModel> blogModelOptional = blogRepository.findBySlug(slug);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, blogModelOptional)
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody BlogModel newBlogModel){

        try {

            Random random = new Random();
            int randomWithNextInt = random.nextInt();

            String noWhiteSpace = WHITESPACE.matcher(newBlogModel.getTitle()).replaceAll("-");
            String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
            String slug = NONLATIN.matcher(normalized).replaceAll("");

            newBlogModel.setSlug(slug + "-" +randomWithNextInt);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, blogRepository.save(newBlogModel))
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }
}

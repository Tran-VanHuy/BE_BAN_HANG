package banhang.example.banhang.service;

import banhang.example.banhang.model.CategoryProductsModel;
import banhang.example.banhang.repository.CategoryProductsRepository;
import banhang.example.banhang.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductsService {
    @Autowired
    private CategoryProductsRepository categoryProductsRepository;

    public ResponseEntity<Response> findAll(Integer pageNo, Integer pageSize){

        try {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "id"));
            Page<CategoryProductsModel> categoryProductsModelList = categoryProductsRepository.findAll(paging);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, categoryProductsModelList.getContent())
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e)
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody CategoryProductsModel newProductsModel){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, categoryProductsRepository.save(newProductsModel))
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e)
            );
        }
    }

    public ResponseEntity<Response> delete(@PathVariable Long id){

        try {
            Optional<CategoryProductsModel> categoryProductsModelOptional = categoryProductsRepository.findById(id);
            categoryProductsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, categoryProductsModelOptional)
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e)
            );
        }
    }

    public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody CategoryProductsModel newCategoryProductsModel){

        try {
            Optional<CategoryProductsModel> categoryProductsModelOptional = categoryProductsRepository.findById(id).map(item -> {
                item.setName(newCategoryProductsModel.getName());
                return categoryProductsRepository.save(item);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, categoryProductsModelOptional)
            );
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e)
            );
        }
    }
}

package banhang.example.banhang.service;

import banhang.example.banhang.model.ProductsModel;
import banhang.example.banhang.repository.ProductsRepository;
import banhang.example.banhang.response.Response;
import banhang.example.banhang.response.ResponsePaging;
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
public class ProductsService {


    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    @Autowired
    private ProductsRepository productsRepository;

    public ResponseEntity<ResponsePaging> findAll(String category, Integer pageNo, Integer pageSize){

        try {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "id"));
            if(category != null){
                Page<ProductsModel> productsModelList = productsRepository.findByCategoryProductsIdNameContaining(category, paging);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponsePaging("SUCCESS", true, productsModelList.getContent(), pageNo, pageSize, productsModelList.getSize())
                );
            }

            Page<ProductsModel> productsModelList = productsRepository.findAll(paging);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponsePaging("SUCCESS", true, productsModelList.getContent(), pageNo, pageSize, productsRepository.findAll().size())
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponsePaging("FAIL", false, e.getMessage(), null, null, null)
            );
        }
    }

    public ResponseEntity<Response> findBySlug(String slug){

        try {

            Optional<ProductsModel>  productsModelOptional = productsRepository.findOneBySlug(slug);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, productsModelOptional)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> create(@RequestBody ProductsModel newProductsModel){

        try {
            Random random = new Random();
            int randomWithNextInt = random.nextInt();

            String noWhiteSpace = WHITESPACE.matcher(newProductsModel.getName()).replaceAll("-");
            String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
            String slug = NONLATIN.matcher(normalized).replaceAll("");

            newProductsModel.setSlug(slug + "-" +randomWithNextInt);
            newProductsModel.setPriceToPay(newProductsModel.getPrice() - (newProductsModel.getPrice() * (newProductsModel.getSales() / 100)));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, productsRepository.save(newProductsModel))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> likeProducts(Long id){
        try {

            Optional<ProductsModel> productsModelOptional = productsRepository.findById(id).map(item -> {
                item.setLike(item.getLike() + 1);
                return productsRepository.save(item);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, productsModelOptional)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> delete(Long id){
        try {
            Optional<ProductsModel> productsModelOptional = productsRepository.findById(id);
            productsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, productsModelOptional)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }

    public ResponseEntity<Response> update(Long id, @RequestBody ProductsModel newProductsModel){
        try {
            Optional<ProductsModel> productsModelOptional = productsRepository.findById(id).map(item -> {
                item.setName(newProductsModel.getName());
                item.setPrice(newProductsModel.getPrice());
                item.setSales(newProductsModel.getSales());
                item.setImage(newProductsModel.getImage());
                item.setItemImage(newProductsModel.getItemImage());
                item.setBrand(newProductsModel.getBrand());
                item.setCategoryProductsId(newProductsModel.getCategoryProductsId());
                item.setContent(newProductsModel.getContent());
                return productsRepository.save(item);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("SUCCESS", true, productsModelOptional)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("FAIL", false, e.getMessage())
            );
        }
    }
}

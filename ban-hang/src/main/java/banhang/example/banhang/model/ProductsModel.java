package banhang.example.banhang.model;

import afu.org.checkerframework.checker.units.qual.Length;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    private Integer sales;
    @Column(name = "price_to_pay")
    private Integer priceToPay;
    private String image;

    @OneToMany(targetEntity = ProductsImageModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_image", referencedColumnName = "id")
    private List<ProductsImageModel> itemImage;
    private String slug;
    @Value("${some.key:0}")
    private Integer like;
    private String brand;
    @Value("${some.key:0}")
    private Integer point;
    @Value("${some.key:0}")
    private Boolean sold;
    @OneToOne
    @JoinColumn(name = "category_products_id")
    private CategoryProductsModel categoryProductsId;

    @Column(length = 4000)
    private String content;
}

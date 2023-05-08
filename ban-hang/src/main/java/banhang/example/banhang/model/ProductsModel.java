package banhang.example.banhang.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

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
}

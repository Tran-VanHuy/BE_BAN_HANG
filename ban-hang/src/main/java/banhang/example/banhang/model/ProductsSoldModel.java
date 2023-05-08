package banhang.example.banhang.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS_SOLD")
public class ProductsSoldModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;
    private String phone;
    private String address;
    @OneToOne
    @JoinColumn(name = "products")
    private  ProductsModel products;
}

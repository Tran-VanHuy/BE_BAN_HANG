package banhang.example.banhang.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "USER")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_name")
    private String userName;

    @Column(unique = true)
    private String gmail;
    private  String password;
    private String number;
    private  String address;

    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleModel role;
}

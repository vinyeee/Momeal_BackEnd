package dev.likelion.momeal.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_name;
    private String user_id;
    private String user_pw;
    private String user_email;
    private Boolean user_role;

    @OneToMany(
            targetEntity = OrderEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "orderEntity"
    )
    private List<OrderEntity> orderEntityList = new ArrayList<>();

    @OneToMany(
            targetEntity = CartEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "cartEntity"
    )
    private List<CartEntity> cartEntityList = new ArrayList<>();
}

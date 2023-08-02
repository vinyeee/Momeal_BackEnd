package dev.likelion.momeal.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class OrderEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    private int amount;
    private Instant date;

    @OneToMany(
            targetEntity = TicketEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "orderEntity"
    )
    private List<TicketEntity> ticketEntityList = new ArrayList<>();

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY
    )
    @Column(name = "user_id")
    private UserEntity userEntity;


}

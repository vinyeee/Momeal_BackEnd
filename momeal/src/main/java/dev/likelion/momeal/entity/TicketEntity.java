package dev.likelion.momeal.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class TicketEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    private int price;

    @ManyToOne(
            targetEntity = OrderEntity.class,
            fetch = FetchType.LAZY
    )
    @Column(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne(
            targetEntity = CartEntity.class,
            fetch = FetchType.LAZY
    )
    @Column(name = "cart_id")
    private CartEntity cartEntity;

}

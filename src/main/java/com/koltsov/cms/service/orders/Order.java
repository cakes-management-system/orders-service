package com.koltsov.cms.service.orders;

import com.koltsov.cms.starter.data.IdAble;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "orders")
@Entity
public class Order implements IdAble<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order")
    @SequenceGenerator(name = "seq_order", allocationSize = 1)
    private Long id;

    private Long cakeId;

    private Long userId;

    private LocalDateTime deliveryDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order cake = (Order) o;
        return id != null && Objects.equals(id, cake.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

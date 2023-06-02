package com.zahran.bookstore.service.orders.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(
    name = "order",
    schema = "service_orders"
)
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_order_generator")
    @GenericGenerator(
        name = "sequence_order_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "service_orders.seq_order"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    private Long id;


    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal price;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
}

package com.zahran.bookstore.service.prices.entities;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Parameter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
    name = "price",
    schema = "service_prices"
)
public class Price {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_price_generator")
    @GenericGenerator(
        name = "sequence_price_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "service_prices.seq_price"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;


    @Column(name = "book_id", nullable = false)
    private long bookId;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal price;
}

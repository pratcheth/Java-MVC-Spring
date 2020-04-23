package org.rado.app.db.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private String id;
    private String name;
    private String image;
    private BigDecimal price;
}

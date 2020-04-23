package org.rado.app.db.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    private Product product;
    private Integer quantity;
}

package com.hubt.ecommerce.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 128)
    @Length(min = 5)
    private String name;
    protected Float price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "productSet")
    private Set<Order> orderSet;
}

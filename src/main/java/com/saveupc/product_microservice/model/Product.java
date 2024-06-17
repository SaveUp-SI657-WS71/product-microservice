package com.saveupc.product_microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description", length = 60, nullable = false)
    private String description;

    @Column(name = "price", length = 20, nullable = false)
    private Double price;

    @Column(name = "stock", length = 20, nullable = false)
    private int stock;

    @Column(name = "expiration_date", length = 20, nullable = false)
    private String expirationDate;

    @Column(name = "image", nullable = false, columnDefinition = "TEXT")
    private String image;

    @Column(name = "company_id", nullable = false)
    private int companyId;

}

package com.BrandProductApp.BrandProductApp.model;

import com.BrandProductApp.BrandProductApp.validator.UniqueName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false,length = 50,unique = true)
    private String name;

    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}

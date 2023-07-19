package com.ltech.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "Categorias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    @Column(nullable = false, unique = true)
    private String nombreCategoria;
}
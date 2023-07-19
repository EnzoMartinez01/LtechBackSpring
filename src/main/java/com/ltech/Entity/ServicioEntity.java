package com.ltech.Entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Servicios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;
    @Column(nullable = false, unique = true)
    private String nombreServicio;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaEntity categoria;
    private String descripcionServicio;
    private Double precioServicio;
    private Boolean estadoServicio;
}

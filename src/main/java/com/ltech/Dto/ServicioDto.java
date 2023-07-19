package com.ltech.Dto;

import com.ltech.Entity.CategoriaEntity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDto {
    private Integer idServicio;
    private String nombreServicio;
    private CategoriaEntity categoria;
    private String descripcionServicio;
    private Double precioServicio;
    private Boolean estadoServicio;    
}

package com.ltech.Dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
    private Integer idCategoria;
    private String nombreCategoria;
}

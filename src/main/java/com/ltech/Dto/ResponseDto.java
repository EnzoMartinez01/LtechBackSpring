package com.ltech.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String codigo;
	private String mensaje;
	private Object data;
}

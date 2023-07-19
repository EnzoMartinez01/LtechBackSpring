package com.ltech.Service;

import org.springframework.stereotype.Service;

import com.ltech.Dto.CategoriaDto;
import com.ltech.Dto.ResponseDto;

@Service
public interface CategoriaService {
        public ResponseDto getAllCategorias();
        public ResponseDto getCategoriaId(Integer idCategoria);
        public ResponseDto createCategoria(CategoriaDto categoria);
        public ResponseDto updateCategoria(CategoriaDto categoria);
        public ResponseDto deleteCategoria(Integer idCategoria);
}

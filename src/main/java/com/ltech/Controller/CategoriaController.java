package com.ltech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltech.Dto.CategoriaDto;
import com.ltech.Dto.ResponseDto;
import com.ltech.Service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService catServ;

    @GetMapping("/obtenerCategorias")
    public ResponseEntity<ResponseDto> readAllCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(catServ.getAllCategorias());
    }

    @GetMapping("/obtenercategoria/{id}")
    public ResponseEntity<ResponseDto> readCategoria(@PathVariable("id") Integer idCategoria){
        return ResponseEntity.status(HttpStatus.OK).body(catServ.getCategoriaId(idCategoria));
    }

    @PostMapping("/crearCategoria")
    public ResponseEntity<ResponseDto> createCategoria(@RequestBody CategoriaDto categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(catServ.createCategoria(categoria));
    }

    @PutMapping("/modificarCategoria")
    public ResponseEntity<ResponseDto> updateCategoria(@RequestBody CategoriaDto categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(catServ.updateCategoria(categoria));
    }

    @DeleteMapping("/eliminarCategoria/{id}")
    public ResponseEntity<ResponseDto> deleteCategoria(@PathVariable("id") Integer idCategoria){
        return ResponseEntity.status(HttpStatus.OK).body(catServ.deleteCategoria(idCategoria));
    }
}

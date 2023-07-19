package com.ltech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ltech.Dto.ResponseDto;
import com.ltech.Dto.ServicioDto;
import com.ltech.Service.ServicioService;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    
    @Autowired
    private ServicioService servSer;

    @GetMapping("/obtenerServicios")
    public ResponseEntity<ResponseDto> readAllServicios(){
        return ResponseEntity.status(HttpStatus.OK).body(servSer.getAllServicios());
    }

    @GetMapping("/obtenerServicio/{id}")
    public ResponseEntity<ResponseDto> readServicioId(@PathVariable("id") Integer idServicio){
        return ResponseEntity.status(HttpStatus.OK).body(servSer.getServicioId(idServicio));
    }

    @PostMapping("/crearServicio")
    public ResponseEntity<ResponseDto> createServicio(@RequestBody ServicioDto servicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(servSer.createServicio(servicio));
    }

    @PutMapping("/modificarServicio")
    public ResponseEntity<ResponseDto> updateServicio(@RequestBody ServicioDto servicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(servSer.updateServicio(servicio));
    }

    @DeleteMapping("/inhabilitarServicio/{id}")
    public ResponseEntity<ResponseDto> inhabilitarServico(@PathVariable("id") Integer idServicio){
        return ResponseEntity.status(HttpStatus.OK).body(servSer.inhabilitarServicio(idServicio));
    }

    @GetMapping("/servicios")
    public ResponseEntity<ResponseDto> serviciosActivos(){
        return ResponseEntity.status(HttpStatus.OK).body(servSer.getServiciosActivos());
    }
}

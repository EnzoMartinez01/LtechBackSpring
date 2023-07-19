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

import com.ltech.Dto.ClienteDto;
import com.ltech.Dto.ResponseDto;
import com.ltech.Service.ClienteService;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {
    @Autowired
    private ClienteService cliServ;

    @GetMapping("/obtenerClientes")
    public ResponseEntity<ResponseDto> readAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(cliServ.getClientesAll());
    }

    @GetMapping("/obtenerCliente/{id}")
    public ResponseEntity<ResponseDto> readClienteId(@PathVariable("id") Integer idCliente){
        return ResponseEntity.status(HttpStatus.OK).body(cliServ.getClienteId(idCliente));
    }

    @PostMapping("/createCliente")
    public ResponseEntity<ResponseDto> createCliente(@RequestBody ClienteDto cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(cliServ.createCliente(cliente));
    }

    @PutMapping("/updateCliente")
    public ResponseEntity<ResponseDto> updateCliente(@RequestBody ClienteDto cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(cliServ.updateCliente(cliente));
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public ResponseEntity<ResponseDto> deleteCliente(@PathVariable("id") Integer idCliente){
        return ResponseEntity.status(HttpStatus.OK).body(cliServ.deleteCliente(idCliente));
    }
}

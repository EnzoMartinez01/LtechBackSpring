package com.ltech.Service;

import org.springframework.stereotype.Service;

import com.ltech.Dto.ClienteDto;
import com.ltech.Dto.ResponseDto;

@Service
public interface ClienteService {
    public ResponseDto getClientesAll();
    public ResponseDto getClienteId(Integer idCliente);
    public ResponseDto createCliente(ClienteDto cliente);
    public ResponseDto updateCliente(ClienteDto cliente);
    public ResponseDto deleteCliente(Integer idCliente);
}

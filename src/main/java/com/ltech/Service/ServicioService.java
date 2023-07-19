package com.ltech.Service;

import org.springframework.stereotype.Service;

import com.ltech.Dto.ResponseDto;
import com.ltech.Dto.ServicioDto;

@Service
public interface ServicioService {
    public ResponseDto getAllServicios();
    public ResponseDto createServicio(ServicioDto servicio);
    public ResponseDto getServicioId(Integer idServicio);
    public ResponseDto updateServicio(ServicioDto servicio);
    public ResponseDto inhabilitarServicio(Integer idPServicio);
    public ResponseDto getServiciosActivos();
}

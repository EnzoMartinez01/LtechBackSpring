package com.ltech.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltech.Dto.CategoriaDto;
import com.ltech.Dto.ResponseDto;
import com.ltech.Dto.ServicioDto;
import com.ltech.Entity.CategoriaEntity;
import com.ltech.Entity.ServicioEntity;
import com.ltech.Repository.CategoriaRepository;
import com.ltech.Repository.ServicioRepository;
import com.ltech.Service.ServicioService;
import com.ltech.Util.Constante;
import com.ltech.Util.Util;

@Service
public class ServicioServiceImplement implements ServicioService{
    
    @Autowired
    private ServicioRepository servRep;
    @Autowired
    private CategoriaRepository catRep;

    @Override
    public ResponseDto getAllServicios(){
        try{
            List<ServicioEntity> listServ = servRep.findAll();
            List<CategoriaEntity> listCat = catRep.findAll();
            if(listServ.isEmpty() || listCat.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<ServicioDto> list = new ArrayList<ServicioDto>();
            List<CategoriaDto> listC = new ArrayList<CategoriaDto>();
            for(ServicioEntity s : listServ){
                list.add(ServicioDto.builder()
                    .idServicio(s.getIdServicio())
                    .nombreServicio(s.getNombreServicio())
                    .categoria(s.getCategoria())
                    .descripcionServicio(s.getDescripcionServicio())
                    .precioServicio(s.getPrecioServicio())
                    .estadoServicio(s.getEstadoServicio())
                    .build());
            }
            for(CategoriaEntity c : listCat){
                listC.add(CategoriaDto.builder()
                    .idCategoria(c.getIdCategoria())
                    .nombreCategoria(c.getNombreCategoria())
                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);   
        }    
    }

    @Override
    public ResponseDto getServicioId(Integer idServicio){
        try{
            ServicioEntity servEnt = servRep.findById(idServicio).orElse(null);
            if(null == servEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            ServicioDto servDto = ServicioDto.builder()
                .idServicio(servEnt.getIdServicio())
                .nombreServicio(servEnt.getNombreServicio())
                .categoria(servEnt.getCategoria())
                .descripcionServicio(servEnt.getDescripcionServicio())
                .precioServicio(servEnt.getPrecioServicio())
                .estadoServicio(servEnt.getEstadoServicio())
                .build();
                return Util.getResponse(true, Constante.OPERATION_SUCCESS, servDto);
        }catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createServicio(ServicioDto servicio){
        try{
            ServicioEntity servEnti = ServicioEntity.builder()
            .nombreServicio(servicio.getNombreServicio())
            .categoria(servicio.getCategoria())
            .descripcionServicio(servicio.getDescripcionServicio())
            .precioServicio(servicio.getPrecioServicio())
            .estadoServicio(servicio.getEstadoServicio())
            .build();
            servRep.save(servEnti);
            servicio.setIdServicio(servEnti.getIdServicio());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, servicio);
        }catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateServicio(ServicioDto servicio){
        try{
            ServicioEntity servEnt = servRep.findById(servicio.getIdServicio()).orElse(null);
            if(null == servEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            servEnt.setIdServicio(servicio.getIdServicio());
            servEnt.setNombreServicio(servicio.getNombreServicio());
            servEnt.setCategoria(servicio.getCategoria());
            servEnt.setDescripcionServicio(servicio.getDescripcionServicio());
            servEnt.setPrecioServicio(servicio.getPrecioServicio());
            servEnt.setEstadoServicio(servicio.getEstadoServicio());
            servRep.save(servEnt);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, servicio);
        } catch(Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto inhabilitarServicio(Integer idPServicio){
        try{
            ServicioEntity servEnt = servRep.findById(idPServicio).orElse(null);
            servEnt.setEstadoServicio(false);
            servRep.save(servEnt);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getServiciosActivos(){
        try{
            List<ServicioEntity> servEnt = servRep.findByEstadoServicio(true);
            if(servEnt.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<ServicioDto> listServ = new ArrayList<ServicioDto>();
            for (ServicioEntity s : servEnt){
                listServ.add(ServicioDto.builder()
                    .idServicio(s.getIdServicio())
                    .nombreServicio(s.getNombreServicio())
                    .categoria(s.getCategoria())
                    .descripcionServicio(s.getDescripcionServicio())
                    .precioServicio(s.getPrecioServicio())
                    .estadoServicio(s.getEstadoServicio())
                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, listServ);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }    }
}

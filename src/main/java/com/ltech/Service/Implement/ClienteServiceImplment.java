package com.ltech.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltech.Dto.ClienteDto;
import com.ltech.Dto.ResponseDto;
import com.ltech.Entity.ClientesEntity;
import com.ltech.Repository.ClienteRepository;
import com.ltech.Service.ClienteService;
import com.ltech.Util.Constante;
import com.ltech.Util.Util;

@Service
public class ClienteServiceImplment implements ClienteService{
    
    @Autowired
    private ClienteRepository cliRep;

    @Override
    public ResponseDto getClientesAll(){
        try{
            List<ClientesEntity> listClientes = cliRep.findAll();
            if(listClientes.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<ClienteDto> list = new ArrayList<ClienteDto>();
            for(ClientesEntity c : listClientes){
                list.add(ClienteDto.builder()
                    .idCliente(c.getIdCliente())
                    .nombreCliente(c.getNombreCliente())
                    .apellidoCliente(c.getApellidoCliente())
                    .emailCliente(c.getEmailCliente())
                    .telefonoCliente(c.getTelefonoCliente())
                    .descripcionCliente(c.getDescripcionCliente())
                    .atendido(c.getAtendido())
                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
        }catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);   
        }
    }

    @Override
    public ResponseDto getClienteId(Integer idCliente){
        try{
            ClientesEntity cliEnt = cliRep.findById(idCliente).orElse(null);
            if(null == cliEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            ClienteDto cliDto = ClienteDto.builder()
                .idCliente(cliEnt.getIdCliente())
                .nombreCliente(cliEnt.getNombreCliente())
                .apellidoCliente(cliEnt.getApellidoCliente())
                .emailCliente(cliEnt.getEmailCliente())
                .telefonoCliente(cliEnt.getTelefonoCliente())
                .descripcionCliente(cliEnt.getDescripcionCliente())
                .atendido(cliEnt.getAtendido())
                .build();
          return Util.getResponse(true, Constante.OPERATION_SUCCESS, cliDto);
        }catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);   
        }
    }

    @Override
    public ResponseDto createCliente(ClienteDto cliente){
        try{
            ClientesEntity cliEnt = ClientesEntity.builder()
            .nombreCliente(cliente.getNombreCliente())
            .apellidoCliente(cliente.getApellidoCliente())
            .emailCliente(cliente.getEmailCliente())
            .telefonoCliente(cliente.getTelefonoCliente())
            .descripcionCliente(cliente.getDescripcionCliente())
            .atendido(cliente.getAtendido())
            .build();
            cliRep.save(cliEnt);
            cliente.setIdCliente(cliEnt.getIdCliente());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, cliente);
        }catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateCliente(ClienteDto cliente){
        try{
            ClientesEntity cliEnt = cliRep.findById(cliente.getIdCliente()).orElse(null);
            if(null==cliEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            cliEnt.setIdCliente(cliente.getIdCliente());
            cliEnt.setNombreCliente(cliente.getNombreCliente());
            cliEnt.setApellidoCliente(cliente.getApellidoCliente());
            cliEnt.setEmailCliente(cliente.getEmailCliente());
            cliEnt.setTelefonoCliente(cliente.getTelefonoCliente());
            cliEnt.setDescripcionCliente(cliente.getDescripcionCliente());
            cliEnt.setAtendido(cliente.getAtendido());
            cliRep.save(cliEnt);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, cliente);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto deleteCliente(Integer idCliente){
        try{
            ClientesEntity cliEnt = cliRep.findById(idCliente).orElse(null);
            if(null==cliEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            cliRep.delete(cliEnt);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
}
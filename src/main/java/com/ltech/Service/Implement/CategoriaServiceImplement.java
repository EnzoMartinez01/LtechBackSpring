package com.ltech.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltech.Dto.CategoriaDto;
import com.ltech.Dto.ResponseDto;
import com.ltech.Entity.CategoriaEntity;
import com.ltech.Repository.CategoriaRepository;
import com.ltech.Service.CategoriaService;
import com.ltech.Util.Constante;
import com.ltech.Util.Util;

@Service
public class CategoriaServiceImplement implements CategoriaService{
    
    @Autowired
    private CategoriaRepository catRep;

    @Override
    public ResponseDto getAllCategorias(){
        try{
            List<CategoriaEntity> listCategoriasEntity = catRep.findAll();
            if(listCategoriasEntity.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<CategoriaDto> list = new ArrayList<CategoriaDto>();
            for(CategoriaEntity entity : listCategoriasEntity){
                list.add(CategoriaDto.builder()
                    .idCategoria(entity.getIdCategoria())
                    .nombreCategoria(entity.getNombreCategoria())
                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);   
        }
    }
    
    @Override
    public ResponseDto getCategoriaId(Integer idCategoria){
        try{
            CategoriaEntity catEnt = catRep.findById(idCategoria).orElse(null);
            if(null == catEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            CategoriaDto catDto = CategoriaDto.builder()
                .idCategoria(catEnt.getIdCategoria())
                .nombreCategoria(catEnt.getNombreCategoria())
                .build();
                return Util.getResponse(true, Constante.OPERATION_SUCCESS, catDto);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createCategoria(CategoriaDto categoria){
        try{
            CategoriaEntity catEnt = CategoriaEntity.builder()
            .nombreCategoria(categoria.getNombreCategoria())
            .build();
        catRep.save(catEnt);
        categoria.setIdCategoria(catEnt.getIdCategoria());
        return Util.getResponse(true, Constante.OPERATION_SUCCESS, categoria);
        }catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateCategoria(CategoriaDto categoria){
        try{
            CategoriaEntity catEnt = catRep.findById(categoria.getIdCategoria()).orElse(null);
            if(null == catEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            catEnt.setIdCategoria(categoria.getIdCategoria());
            catEnt.setNombreCategoria(categoria.getNombreCategoria());
            catRep.save(catEnt);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, categoria);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto deleteCategoria(Integer idCategoria){
        try{
            CategoriaEntity catEnt = catRep.findById(idCategoria).orElse(null);
            if(null == catEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            catRep.delete(catEnt);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
}

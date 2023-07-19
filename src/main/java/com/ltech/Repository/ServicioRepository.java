package com.ltech.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltech.Entity.ServicioEntity;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioEntity, Integer>{
    List<ServicioEntity> findByEstadoServicio(Boolean estadoServicio);
}

package com.ltech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltech.Entity.ClientesEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClientesEntity, Integer>{
    
}

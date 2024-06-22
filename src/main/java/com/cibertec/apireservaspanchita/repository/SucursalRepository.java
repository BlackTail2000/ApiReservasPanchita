package com.cibertec.apireservaspanchita.repository;

import com.cibertec.apireservaspanchita.model.bd.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}

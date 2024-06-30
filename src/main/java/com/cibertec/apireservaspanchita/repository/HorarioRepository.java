package com.cibertec.apireservaspanchita.repository;

import com.cibertec.apireservaspanchita.model.bd.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query("Select H From Horario H Where H.sucursal.idSucursal=:idSucursal")
    List<Horario> findAllBySucursalId(@Param("idSucursal") Integer sucursalId);
    Horario findTopByOrderByIdHorarioDesc();
}

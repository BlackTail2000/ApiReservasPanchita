package com.cibertec.apireservaspanchita.repository;

import com.cibertec.apireservaspanchita.model.bd.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    @Query("Select Count(M.idMesa) From Mesa M Where M.sucursal.idSucursal=:idS")
    Integer obtenerNroMesasPorSucursal(@Param("idS") Integer idS);

    @Query(value = "Call ObtenerNroMesasOcupadasPorFechaYSucursal(:fec, :idS)",
            nativeQuery = true)
    Integer obtenerNroMesasPorFechaYSucursal(@Param("fec") Date fec, @Param("idS") Integer idS);
}

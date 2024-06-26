package com.cibertec.apireservaspanchita.repository;

import com.cibertec.apireservaspanchita.model.bd.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    @Query("Select M From Mesa M Where M.sucursal.idSucursal=:idS")
    List<Mesa> obtenerMesasPorSucursal(@Param("idS") Integer idS);

    @Query(value = "Call ObtenerNroMesasOcupadasPorFechaYSucursal(:fec, :idS)",
            nativeQuery = true)
    Integer obtenerMesasOcupadasPorFechaYSucursal(@Param("fec") Date fec, @Param("idS") Integer idS);
}

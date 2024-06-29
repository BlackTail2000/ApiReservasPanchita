package com.cibertec.apireservaspanchita.repository;

import com.cibertec.apireservaspanchita.model.bd.Estado;
import com.cibertec.apireservaspanchita.model.bd.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findAllByUsuario_idUsuarioAndEstado(Integer idUsuario, Estado estado);
}

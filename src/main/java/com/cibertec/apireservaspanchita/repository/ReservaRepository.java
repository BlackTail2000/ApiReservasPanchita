package com.cibertec.apireservaspanchita.repository;

import com.cibertec.apireservaspanchita.model.bd.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}

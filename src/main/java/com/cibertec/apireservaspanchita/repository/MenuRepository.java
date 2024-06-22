package com.cibertec.apireservaspanchita.repository;

import com.cibertec.apireservaspanchita.model.bd.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}

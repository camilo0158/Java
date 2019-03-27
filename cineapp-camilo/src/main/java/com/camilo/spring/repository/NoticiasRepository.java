package com.camilo.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camilo.spring.model.Noticia;

@Repository
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}

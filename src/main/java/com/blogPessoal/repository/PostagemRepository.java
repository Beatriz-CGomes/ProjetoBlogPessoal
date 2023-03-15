package com.blogPessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogPessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {


	
}

package com.mycompany.megasenatualizador.repository;

import com.mycompany.megasenatualizador.model.ResultadoMegaSena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultadoRepository extends JpaRepository<ResultadoMegaSena, Integer> {

    @Query("SELECT COALESCE(MAX(r.concurso), 0) FROM ResultadoMegaSena r")
    int findMaxConcurso();
}
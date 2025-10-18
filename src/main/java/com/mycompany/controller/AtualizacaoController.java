package com.mycompany.megasenatualizador.controller;

import com.mycompany.megasenatualizador.model.ResultadoMegaSena;
import com.mycompany.megasenatualizador.repository.ResultadoRepository;
import com.mycompany.megasenatualizador.service.ScrapingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AtualizacaoController {

    private final ResultadoRepository repository;
    private final ScrapingService scraping;

    public AtualizacaoController(ResultadoRepository repository, ScrapingService scraping) {
        this.repository = repository;
        this.scraping = scraping;
    }

    @PostMapping("/atualizar")
    public ResponseEntity<?> atualizar() {
        try {
            Integer ultimoConcurso = repository.findMaxConcurso();
            int ultimo = (ultimoConcurso != null) ? ultimoConcurso : 0;

            int atual = scraping.buscarUltimoConcursoCaixa();

            List<ResultadoMegaSena> novos = new ArrayList<>();
            for (int i = ultimo + 1; i <= atual; i++) {
                ResultadoMegaSena r = scraping.buscarConcurso(i);
                repository.save(r);
                novos.add(r);
            }

            return ResponseEntity.ok("Importados: " + novos.size());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }
}
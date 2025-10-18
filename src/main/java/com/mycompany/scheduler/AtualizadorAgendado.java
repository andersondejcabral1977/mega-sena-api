package com.mycompany.megasenatualizador.scheduler;

import com.mycompany.megasenatualizador.controller.AtualizacaoController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AtualizadorAgendado {

    private final AtualizacaoController controller;

    public AtualizadorAgendado(AtualizacaoController controller) {
        this.controller = controller;
    }

    @Scheduled(cron = "0 0 10 * * *") // todo dia às 10h
    public void executar() {
        controller.atualizar();
    }
}
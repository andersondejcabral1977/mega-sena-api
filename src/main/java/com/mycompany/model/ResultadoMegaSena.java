package com.mycompany.megasenatualizador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
@Table(name = "mega_sena_resultados")
public class ResultadoMegaSena {

    @Id
    @Column(name = "concurso", nullable = false)
    private int concurso;

    @Column(name = "data_sorteio", nullable = false)
    private LocalDate dataSorteio;

    @Column(name = "bola_1", nullable = false)
    private int bola1;

    @Column(name = "bola_2", nullable = false)
    private int bola2;

    @Column(name = "bola_3", nullable = false)
    private int bola3;

    @Column(name = "bola_4", nullable = false)
    private int bola4;

    @Column(name = "bola_5", nullable = false)
    private int bola5;

    @Column(name = "bola_6", nullable = false)
    private int bola6;

    @Column(name = "sena", nullable = false)
    private int sena;

    @Column(name = "quina", nullable = false)
    private int quina;

    @Column(name = "quadra", nullable = false)
    private int quadra;

    @Column(name = "valor_arrecadado", nullable = false)
    private double receitaTotal;

    @Column(name = "valor_estimado_proximo_concurso", nullable = false)
    private double estimativaPremio;

    @Column(name = "acumulado", nullable = false)
    private double acumuladoProxConcurso;

    @Column(name = "acumulado_mega_virada", nullable = false)
    private double acumuladoMegaVirada;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    // Getters e Setters
    public int getConcurso() { return concurso; }
    public void setConcurso(int concurso) { this.concurso = concurso; }

    public LocalDate getDataSorteio() { return dataSorteio; }
    public void setDataSorteio(LocalDate dataSorteio) { this.dataSorteio = dataSorteio; }

    public int getBola1() { return bola1; }
    public void setBola1(int bola1) { this.bola1 = bola1; }

    public int getBola2() { return bola2; }
    public void setBola2(int bola2) { this.bola2 = bola2; }

    public int getBola3() { return bola3; }
    public void setBola3(int bola3) { this.bola3 = bola3; }

    public int getBola4() { return bola4; }
    public void setBola4(int bola4) { this.bola4 = bola4; }

    public int getBola5() { return bola5; }
    public void setBola5(int bola5) { this.bola5 = bola5; }

    public int getBola6() { return bola6; }
    public void setBola6(int bola6) { this.bola6 = bola6; }

    public int getSena() { return sena; }
    public void setSena(int sena) { this.sena = sena; }

    public int getQuina() { return quina; }
    public void setQuina(int quina) { this.quina = quina; }

    public int getQuadra() { return quadra; }
    public void setQuadra(int quadra) { this.quadra = quadra; }

    public double getReceitaTotal() { return receitaTotal; }
    public void setReceitaTotal(double receitaTotal) { this.receitaTotal = receitaTotal; }

    public double getEstimativaPremio() { return estimativaPremio; }
    public void setEstimativaPremio(double estimativaPremio) { this.estimativaPremio = estimativaPremio; }

    public double getAcumuladoProxConcurso() { return acumuladoProxConcurso; }
    public void setAcumuladoProxConcurso(double acumuladoProxConcurso) { this.acumuladoProxConcurso = acumuladoProxConcurso; }

    public double getAcumuladoMegaVirada() { return acumuladoMegaVirada; }
    public void setAcumuladoMegaVirada(double acumuladoMegaVirada) { this.acumuladoMegaVirada = acumuladoMegaVirada; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
}
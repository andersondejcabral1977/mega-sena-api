package com.mycompany.megasenatualizador.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.megasenatualizador.model.ResultadoMegaSena;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ScrapingService {

    private final ObjectMapper mapper = new ObjectMapper();

    // ✅ Busca o número do último concurso disponível
    public int buscarUltimoConcursoCaixa() throws IOException {
        JsonNode json = mapper.readTree(new URL("https://servicebus2.caixa.gov.br/portaldeloterias/api/megasena"));
        return json.get("numero").asInt();
    }

    // ✅ Busca os dados completos de um concurso específico
    public ResultadoMegaSena buscarConcurso(int numero) throws IOException {
    String url = "https://servicebus2.caixa.gov.br/portaldeloterias/api/megasena/" + numero;
    JsonNode json = mapper.readTree(new URL(url));

    // 🔍 Log completo da resposta da API
    System.out.println("🔎 JSON recebido da API para concurso " + numero + ":");
    System.out.println(json.toPrettyString());


        ResultadoMegaSena r = new ResultadoMegaSena();
        r.setConcurso(numero);

        // Data do sorteio
        String dataStr = json.get("dataApuracao").asText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        r.setDataSorteio(LocalDate.parse(dataStr, formatter));

        // Dezenas sorteadas
        r.setBola1(Integer.parseInt(json.get("listaDezenas").get(0).asText()));
        r.setBola2(Integer.parseInt(json.get("listaDezenas").get(1).asText()));
        r.setBola3(Integer.parseInt(json.get("listaDezenas").get(2).asText()));
        r.setBola4(Integer.parseInt(json.get("listaDezenas").get(3).asText()));
        r.setBola5(Integer.parseInt(json.get("listaDezenas").get(4).asText()));
        r.setBola6(Integer.parseInt(json.get("listaDezenas").get(5).asText()));

        // Premiação por faixa
        r.setSena(json.get("listaRateioPremio").get(0).get("numeroDeGanhadores").asInt());
        r.setQuina(json.get("listaRateioPremio").get(1).get("numeroDeGanhadores").asInt());
        r.setQuadra(json.get("listaRateioPremio").get(2).get("numeroDeGanhadores").asInt());

        // Valores financeiros
        r.setReceitaTotal(json.get("valorArrecadado").asDouble());
        r.setEstimativaPremio(json.get("valorEstimadoProximoConcurso").asDouble());
        r.setAcumuladoProxConcurso(json.get("valorAcumuladoProximoConcurso").asDouble());
        r.setAcumuladoMegaVirada(json.get("valorAcumuladoConcursoEspecial").asDouble());

        // Observação (local do sorteio)
        r.setObservacao(json.get("localSorteio").asText());

        return r;
    }
}
package com.fernandoschimidt.desafio.itau.trantacao;

import com.fernandoschimidt.desafio.itau.estatistica.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

@Repository
public class TransacaoRepository {

    private List<TransacaoReques> transacoes = new ArrayList<>();

    public void add(TransacaoReques transacaoReques) {
        transacoes.add(transacaoReques);
    }

    public void limpar() {
        transacoes.clear();
    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicical) {
        if (transacoes.isEmpty()) {
            return new EstatisticaDTO();
        } else {

            final BigDecimal[] valoresFiltrados = transacoes.stream()
                    .filter(t -> t.getDataHora().isAfter(horaInicical) || t.getDataHora().equals(horaInicical))
                    .map(t -> t.getValor()).toArray(BigDecimal[]::new);

            DoubleStream doubleStream = Arrays.stream(valoresFiltrados).mapToDouble(BigDecimal::doubleValue);

            return new EstatisticaDTO(doubleStream.summaryStatistics());


        }
    }
}

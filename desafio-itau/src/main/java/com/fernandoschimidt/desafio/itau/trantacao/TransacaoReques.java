package com.fernandoschimidt.desafio.itau.trantacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoReques {

    private BigDecimal valor;
    private OffsetDateTime dataHora;
}

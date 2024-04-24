package br.unipar.programacaointernet.servicecep.apivenda.model;

import jakarta.persistence.*;
import jakarta.ws.rs.GET;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Getter
@Setter

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String descricao;

    @Column(length = 50)
    private BigDecimal valor_unitario;
}

package br.unipar.programacaointernet.servicecep.apivenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class ItensVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private BigDecimal valor_unitario;

    @Column(length = 50)
    private BigDecimal valor_total;

    @Column(length = 50)
    private BigDecimal
            quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;

}

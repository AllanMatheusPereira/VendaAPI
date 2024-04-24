package br.unipar.programacaointernet.servicecep.apivenda.model;

import jakarta.persistence.*;
import jakarta.ws.rs.GET;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150)
    private String nome;

    @Column(length = 15)
    private String telefone;

}

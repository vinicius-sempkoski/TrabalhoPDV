package br.unipar.programacaointernet.pdv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String observacoes;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime data;

    private BigDecimal total;

    @ManyToOne
    private Cliente cliente;

}

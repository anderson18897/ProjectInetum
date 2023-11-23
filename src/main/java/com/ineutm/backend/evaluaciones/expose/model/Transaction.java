package com.ineutm.backend.evaluaciones.expose.model;

import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "MOVIMIENTO")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCUENTA")
    private Account account;

    @Column(name = "DESCRIPCION")
    private String description;

    @Column(name = "INTERESES")
    private Double interests;
}

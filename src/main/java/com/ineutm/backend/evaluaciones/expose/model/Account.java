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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Entity
@Table(name = "CUENTA")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ESTADO")
    private int state;

    @Column(name = "NUMERO", nullable = false)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDUSUARIO")
    private User user;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Transaction> transactions;
}

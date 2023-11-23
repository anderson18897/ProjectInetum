package com.ineutm.backend.evaluaciones.expose.model;

import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Entity
@Table(name = "USUARIO")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String name;

    @Column(name = "NUMERODOCUMENTO", nullable = false)
    private String numberDocument;

    @Column(name = "ESTADO")
    private int state;

    @Column(name = "TIPO", nullable = false)
    private String type;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Account> accounts;
}

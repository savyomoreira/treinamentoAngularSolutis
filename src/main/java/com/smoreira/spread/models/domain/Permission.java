package com.smoreira.spread.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PERMISSAO")
public class Permission {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERMISSAO")
    private Long id;

    @Column(name = "NOME_PERMISSAO")
    private String permissionName;

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }
}

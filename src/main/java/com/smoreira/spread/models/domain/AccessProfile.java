package com.smoreira.spread.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PERFIL")
public class AccessProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERFIL")
    private Long id;

    @Column(name = "NOME_PERFIL")
    private String nomePerfil;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PERMISSION_PERFIL",
            joinColumns = {@JoinColumn(
                    name = "ID_PERFIL", referencedColumnName = "ID_PERFIL"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_PERMISSAO", referencedColumnName = "ID_PERMISSAO")
            })
    private List<Permission> permissionList;

    public AccessProfile(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
}

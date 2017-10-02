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
@Table(name="SISTEMA")
public class System {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SISTEMA")
    private Long id;

    @Column(name = "NOME_SYSTEMA")
    private String name;

    @Column(name = "SIGLA")
    private String initials;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USUARIO_SISTEMA",
            joinColumns = {@JoinColumn(
                    name = "ID_SISTEMA", referencedColumnName = "ID_SISTEMA"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
            })
    private List<User> userList;

    public System(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }
}

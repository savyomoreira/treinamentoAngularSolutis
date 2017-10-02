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
@Table(name="USUARIO")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Integer id;
	
	@Column(name = "NOME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "SENHA")
	private String senha;

	@Column(name = "TELEFONE")
	private String telefone;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USUARIO_PERFIL",
			joinColumns = {@JoinColumn(
					name = "ID_USUARIO", referencedColumnName = "ID_USUARIO"
			)},
			inverseJoinColumns = {@JoinColumn(
					name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
	})
	private List<AccessProfile> perfilList;
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


}

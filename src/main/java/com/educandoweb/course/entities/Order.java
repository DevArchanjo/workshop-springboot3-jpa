package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant moment;
	
	//Agora precisamos implementar o relacionamento entre Pedido e Cliente para o JPA transformar isso em 	chaves estrangeiras la no banco de dado.
	//Como fazer isso no JPA? Entendendo o que está acontecendo e qual o relacionamento entre as classes
	//1 - Temos uma associação de muitos Pedidos para um cliente e um cliente tem muitos pedidos. O Pedido 	é o lado do muitos e o Usuário é o lado do um.
	//Estando na classe pedido temos a relação muitos para um com o usuário(que é o atributo client)
	
	@ManyToOne //annotation muitos para um
	@JoinColumn(name = "client_id")//entre parenteses vamos dar um nome para a chave estrangeira que liga Produtos à um cliente
	private User client;
	
	public Order() {
	}

	public Order(Integer id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}

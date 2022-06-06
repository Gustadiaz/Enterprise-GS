package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_portaria")
@SequenceGenerator(name = "portaria", sequenceName = "sq_t_gco_portaria", allocationSize = 1)
public class Portaria implements Serializable{

	private static final long serialVersionUID = -2662273906271580447L;

	public Portaria() {}
	
	
	public Portaria(int numero, String nome, LocalDate dataInicio, LocalDate dataTermino, Condominio condominio) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.condominio = condominio;
	}



	@Id
	@Column(name = "id_portaria")
	@GeneratedValue(generator = "portaria", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nr_portaria", nullable = false)
	private int numero;
	
	@Column(name = "nm_portaria", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "st_status")
	private Boolean status;
	
	@Column(name = "dt_inicio")
	private LocalDate dataInicio;
	
	@Column(name = "dt_termino")
	private LocalDate dataTermino;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "condominio_id")
	private Condominio condominio;
	
	@OneToMany(mappedBy = "portaria", cascade = CascadeType.MERGE)
	private Set<MovimentacaoPortaria> movimentacao;
	
	
	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	@Override
	public String toString() {
		return "\nNúmero Portaria: " + this.getNumero()
			+ "\nNome Portaria: " + this.getNome()
			+ "\nStatus: " + this.getStatus()
			+ "\nData Início: " + this.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			+ "\nData Término: " + this.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	

}

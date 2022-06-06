package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_condominio")
@SequenceGenerator(name = "condominio", sequenceName = "sq_t_gco_condominio", allocationSize = 1)
public class Condominio implements Serializable{

	private static final long serialVersionUID = -4836593184445666776L;

	public Condominio() {}
	
	public Condominio(int cnpj, String razaoSocial, String nome, LocalDate dataFundacao) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.dataFundacao = dataFundacao;
	}

	@Id
	@Column(name = "id_condominio")
	@GeneratedValue(generator = "condominio", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nr_cnpj", nullable = false)
	private int cnpj;
	
	@Column(name = "ds_razao_social", length = 80, nullable = false)
	private String razaoSocial;
	
	@Column(name = "nm_fantasia", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "dt_fundacao")
	private LocalDate dataFundacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "\nNúmero CNPJ: " + this.getCnpj()
			+ "\nRazão Social: " + this.getRazaoSocial()
			+ "\nNome Fantasia: " + this.getNome()
			+ "\nData Fundação: " + this.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}

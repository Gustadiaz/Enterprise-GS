package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_func_portaria")
@SequenceGenerator(name = "funcionario", sequenceName = "sq_t_gco_func_portaria", allocationSize = 1)
public class FuncPortaria implements Serializable{

	private static final long serialVersionUID = -6955981148994093725L;
	
	public FuncPortaria() {}
	
	public FuncPortaria(String nome, LocalDate dataNascimento, String cpf, String rg, LocalDate dataCadastro) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}

	@Id
	@Column(name = "id_func_portaria")
	@GeneratedValue(generator = "funcionario", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nm_funcionario", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "dt_nasc")
	private LocalDate dataNascimento;
	
	@Column(name = "nr_cpf", length = 14, nullable = false)
	private String cpf;
	
	@Column(name = "nr_rg", length = 12, nullable = false)
	private String rg;
	
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@OneToMany(mappedBy = "funcionario")
	private List<MovimentacaoPortaria> movimentacaoPortaria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.getNome()
			+ "\nNascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			+ "\nCPF: " + this.getCpf()
			+ "\nRG: " + this.getRg()
			+ "\nCadastro: " + this.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	

}

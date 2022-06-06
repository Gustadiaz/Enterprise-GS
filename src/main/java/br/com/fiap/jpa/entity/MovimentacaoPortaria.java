package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_movimentacao_entrada")
@SequenceGenerator(name = "movimentacao", sequenceName = "sq_t_gco_movimentacao_entrada", allocationSize = 1)
public class MovimentacaoPortaria implements Serializable{
	


	public MovimentacaoPortaria() {}
	
	public MovimentacaoPortaria(String tipoMovimentacao, LocalDateTime dataMovimentacao, Portaria portaria, FuncPortaria funcPortaria, Visitante visitante) {
		super();
		this.tipoMovimentacao = tipoMovimentacao;
		this.dataMovimentacao = dataMovimentacao;
		this.portaria = portaria;
		this.funcionario = funcPortaria;
		this.visitante = visitante;
	}
	

	private static final long serialVersionUID = 6721362650828257647L;
	@Id
	@Column(name = "id_movimentacao")
	@GeneratedValue(generator = "movimentacao", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "tp_movimentacao", nullable = false)
	private String tipoMovimentacao;
	
	@Column(name = "dt_movimentacao", nullable = false)
	private LocalDateTime dataMovimentacao;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "portaria_id")
	private Portaria portaria;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private FuncPortaria funcionario;
	
	@ManyToOne
	@JoinColumn(name = "visitante_id")
	private Visitante visitante;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "\nTipo Movimentacao: " + this.getTipoMovimentacao()
			+ "\nData Movimentação: " + this.getDataMovimentacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	
	

}

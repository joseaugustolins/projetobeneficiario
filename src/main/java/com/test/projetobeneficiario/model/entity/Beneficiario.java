package com.test.projetobeneficiario.model.entity;

import com.test.projetobeneficiario.model.dto.BeneficiarioDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "beneficiario")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    @Column(nullable = false)
    private Long cpf;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false)
    private Integer anos;

    public Beneficiario(){

    }

    public Beneficiario(Long cpf, String email, BigDecimal valor, Integer anos) {
        this.cpf = cpf;
        this.email = email;
        this.valor = valor;
        this.anos = anos;
    }

    public Beneficiario(Long id, Long cpf, String email, BigDecimal valor, Integer anos) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.valor = valor;
        this.anos = anos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getAnos() {
        return anos;
    }

    public void setAnos(Integer anos) {
        this.anos = anos;
    }

    public BeneficiarioDTO toDTO(){
        return new BeneficiarioDTO(this.id, this.cpf, this.email, this.valor, this.anos);
    }
}

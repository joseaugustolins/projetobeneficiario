package com.test.projetobeneficiario.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.projetobeneficiario.model.entity.Beneficiario;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BeneficiarioRequest {
    @ApiModelProperty(value = "CPF do beneficiário")
    private Long cpf;
    @ApiModelProperty(value = "E-mail do beneficiário")
    private String email;
    @ApiModelProperty(value = "Valor total do saldo de aposentadoria")
    private BigDecimal valor;
    @ApiModelProperty(value = "Quantidade de Anos que irá receber a aposentadoria")
    private Integer anos;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public BeneficiarioRequest(Long cpf, String email, BigDecimal valor, Integer anos) {
        this.cpf = cpf;
        this.email = email;
        this.valor = valor;
        this.anos = anos;
    }

    public Beneficiario toBeneficiario(){
        return new Beneficiario(this.getCpf(), this.getEmail(),this.getValor(), this.getAnos());
    }

}

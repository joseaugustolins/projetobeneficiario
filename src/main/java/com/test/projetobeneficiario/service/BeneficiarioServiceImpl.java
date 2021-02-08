package com.test.projetobeneficiario.service;

import com.test.projetobeneficiario.model.dto.BeneficiarioDTO;
import com.test.projetobeneficiario.model.dto.BeneficiarioRequest;
import com.test.projetobeneficiario.model.entity.Beneficiario;
import com.test.projetobeneficiario.repository.BeneficiarioRepository;
import com.test.projetobeneficiario.service.exception.ValorDeAnoErradoExcpetion;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService{

    @Autowired
    BeneficiarioRepository beneficiarioRepository;

    @Override
    public BeneficiarioDTO save(BeneficiarioRequest beneficiarioRequest) {
        validaDados(beneficiarioRequest);
        return beneficiarioRepository.save(beneficiarioRequest.toBeneficiario()).toDTO();
    }

    @Override
    public List<BeneficiarioDTO> findAll() {
        return (List<BeneficiarioDTO>) beneficiarioRepository.findAll().stream().map(
                beneficiario -> {
                    return beneficiario.toDTO();
                }
        ).collect(Collectors.toList());
    }

    @Override
    public BeneficiarioDTO findById(Long id) throws NotFoundException {

        if (beneficiarioRepository.findById(id).isPresent()){
            return beneficiarioRepository.findById(id).get().toDTO();
        }else{
            throw  new NotFoundException("");
        }

    }

    @Override
    public BeneficiarioDTO update(Long id, BeneficiarioRequest beneficiarioRequest) {
        validaDados(beneficiarioRequest);
        Beneficiario beneficiario = beneficiarioRepository.findById(id).get();
        beneficiario.setValor(beneficiarioRequest.getValor());
        beneficiario.setEmail(beneficiarioRequest.getEmail());
        beneficiario.setAnos(beneficiarioRequest.getAnos());
        return beneficiarioRepository.save(beneficiario).toDTO();
    }

    @Override
    public BeneficiarioDTO aportar(Long id, BigDecimal valor) throws NotFoundException {
        if(!beneficiarioRepository.findById(id).isPresent()){
            throw new NotFoundException("");
        }
        Beneficiario beneficiario = beneficiarioRepository.findById(id).get();
        beneficiario.setValor(beneficiario.getValor().add(valor));
        return beneficiarioRepository.save(beneficiario).toDTO();
    }

    private boolean validaDados(BeneficiarioRequest beneficiarioRequest){
        if(beneficiarioRequest.getAnos()<1){
            throw new ValorDeAnoErradoExcpetion("Valor Errado");
        }
        return true;
    }
}

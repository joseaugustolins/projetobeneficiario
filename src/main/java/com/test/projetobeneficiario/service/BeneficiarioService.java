package com.test.projetobeneficiario.service;

import com.test.projetobeneficiario.model.dto.BeneficiarioDTO;
import com.test.projetobeneficiario.model.dto.BeneficiarioRequest;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface BeneficiarioService {
    public BeneficiarioDTO save(BeneficiarioRequest beneficiarioRequest);
    public List<BeneficiarioDTO> findAll();
    public BeneficiarioDTO findById(Long id) throws NotFoundException;
    public BeneficiarioDTO update(Long id, BeneficiarioRequest beneficiarioRequest);
    public BeneficiarioDTO aportar(Long id, BigDecimal valor) throws NotFoundException;
}

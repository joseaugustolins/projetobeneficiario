package com.test.projetobeneficiario.repository;

import com.test.projetobeneficiario.model.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}

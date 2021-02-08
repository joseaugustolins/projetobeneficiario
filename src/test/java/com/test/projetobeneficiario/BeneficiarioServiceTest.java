package com.test.projetobeneficiario;

import com.test.projetobeneficiario.model.dto.BeneficiarioDTO;
import com.test.projetobeneficiario.model.dto.BeneficiarioRequest;
import com.test.projetobeneficiario.model.entity.Beneficiario;
import com.test.projetobeneficiario.repository.BeneficiarioRepository;
import com.test.projetobeneficiario.service.BeneficiarioService;
import com.test.projetobeneficiario.service.BeneficiarioServiceImpl;
import com.test.projetobeneficiario.service.exception.ValorDeAnoErradoExcpetion;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BeneficiarioServiceTest {

    @Mock
    private BeneficiarioRepository beneficiarioRepository;

    @InjectMocks
    private BeneficiarioServiceImpl beneficiarioService;



    @Test
    void shouldReturnAllBeneficiarios(){
        given(beneficiarioRepository.findAll()).willReturn(UtilTest.getBeneficiarioList());
        List<BeneficiarioDTO> beneficiarios = beneficiarioService.findAll();
        assertThat(beneficiarios).isNotEmpty();
    }



    @Test
    void shouldValorDeAnoErradoExceptionSavingBeneficiario(){
        BeneficiarioRequest beneficiarioRequestExcecao01 = new BeneficiarioRequest( 1234l, "123@1234.com", new BigDecimal(302001.2), 0);
        assertThatThrownBy(() -> {
            beneficiarioService.save(beneficiarioRequestExcecao01);
        }).isInstanceOf(ValorDeAnoErradoExcpetion.class);

    }

    @Test
    void shouldSuccessfulFindingById(){
        given(beneficiarioRepository.findById(100l)).willReturn(Optional.empty());
        assertThatThrownBy(() -> {
            beneficiarioService.findById(100l);
        }).isInstanceOf(NotFoundException.class);
    }

    @Test
    void shouldNotFoundExceptionFindingById() throws NotFoundException {
        Beneficiario beneficiario = new Beneficiario(100l, 11111l, "1233@123.com", new BigDecimal(100), 50);
        given(beneficiarioRepository.findById(100l)).willReturn(Optional.of(beneficiario));
        BeneficiarioDTO beneficiarioDTO = beneficiarioService.findById(100l);
        assertThat(beneficiarioDTO).isNotNull();
    }

}
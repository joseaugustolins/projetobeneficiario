package com.test.projetobeneficiario;

import com.test.projetobeneficiario.model.entity.Beneficiario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    public static List<Beneficiario> getBeneficiarioList(){
        Beneficiario b1 = new Beneficiario(1l, 11111l, "1233@123.com", new BigDecimal(100), 50);
        Beneficiario b2 = new Beneficiario(2l, 22222l, "22222@123.com", new BigDecimal(200), 40);
        Beneficiario b3 = new Beneficiario(3l, 33333l, "33333@123.com", new BigDecimal(200), 50);
        List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
        beneficiarios.add(b1);
        beneficiarios.add(b2);
        beneficiarios.add(b3);
        return beneficiarios;
    }


}

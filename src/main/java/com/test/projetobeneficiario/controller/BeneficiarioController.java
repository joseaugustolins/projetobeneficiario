package com.test.projetobeneficiario.controller;

import com.test.projetobeneficiario.model.dto.BeneficiarioDTO;
import com.test.projetobeneficiario.model.dto.BeneficiarioRequest;
import com.test.projetobeneficiario.service.BeneficiarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {

    @Autowired
    BeneficiarioService beneficiarioService;

    @GetMapping
    public ResponseEntity<List<BeneficiarioDTO>> findAll(){
        return ResponseEntity.ok(beneficiarioService.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<BeneficiarioDTO> findById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(beneficiarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BeneficiarioDTO> save(@RequestBody BeneficiarioRequest beneficiarioRequest){
        return ResponseEntity.ok(beneficiarioService.save(beneficiarioRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> update(@PathVariable("id") Long id, @RequestBody BeneficiarioRequest beneficiarioRequest){
        return ResponseEntity.ok(beneficiarioService.update(id, beneficiarioRequest));
    }

    @PutMapping("/aportar/{id}")
    public ResponseEntity<BeneficiarioDTO> aportar(@PathVariable("id") Long id, @RequestBody BigDecimal valor) throws NotFoundException {
        return ResponseEntity.ok(beneficiarioService.aportar(id, valor));
    }
}

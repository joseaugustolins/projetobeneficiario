package com.test.projetobeneficiario.queueconsumer;

import com.test.projetobeneficiario.service.BeneficiarioService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AporteConsumer {

    @Autowired
    BeneficiarioService beneficiarioService;

    @RabbitListener(queues = "AporteQueue")
    public void receive(@Payload String mensagem){
        System.out.println("Order: "+mensagem);
    }

}

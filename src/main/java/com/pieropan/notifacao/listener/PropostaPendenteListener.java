package com.pieropan.notifacao.listener;

import com.pieropan.notifacao.domain.Proposta;
import com.pieropan.notifacao.service.NotificarEmailService;
import jakarta.mail.MessagingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class PropostaPendenteListener {

    @Autowired
    private NotificarEmailService service;


    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void PropostaPendente(Proposta proposta) throws MessagingException, UnsupportedEncodingException {
        System.out.println("RECEBI PROPOSTA");
        System.out.println("************");
        System.out.println(proposta.getUsuario().getEmail());
        this.service.notificar(proposta);
    }

}

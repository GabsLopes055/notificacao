package com.pieropan.notifacao.service;

import com.pieropan.notifacao.config.EmailConfiguration;
import com.pieropan.notifacao.domain.Proposta;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@AllArgsConstructor
public class NotificarEmailService {

    @Autowired
    private final EmailConfiguration sendEmail;

    public void notificar(Proposta proposta) throws MessagingException, UnsupportedEncodingException {
        this.sendEmail.notificarUsuario(proposta.getUsuario().getEmail(), proposta.getUsuario().getNome());
    }

}

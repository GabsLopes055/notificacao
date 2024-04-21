package com.pieropan.notifacao.service;

import com.pieropan.notifacao.config.EmailConfiguration;
import com.pieropan.notifacao.domain.Proposta;
import com.pieropan.notifacao.domain.Usuario;
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

    public void notificar(Usuario usuario) throws MessagingException, UnsupportedEncodingException {
        this.sendEmail.notificarUsuario(usuario.getEmail(), usuario.getNome());
    }

}

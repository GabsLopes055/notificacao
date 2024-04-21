package com.pieropan.notifacao.config;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@AllArgsConstructor
public class EmailConfiguration {

    @Autowired
    private final JavaMailSender sender;

    public void notificarUsuario(String email, String nomeUsuario) throws MessagingException, UnsupportedEncodingException {

        String toAddres = email;
        String fromAddres = "lopesgabriel055@gmail.com";
        String senderName = "Propostas";
        String subject = "Novidades sobre sua solicitação !";


        String content = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <style type=\"text/css\">\n" +
                "    td > h1 {\n" +
                "      padding: 30px;\n" +
                "      background-color: #3f51b5;\n" +
                "      color: white;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <table>\n" +
                "    <tr>\n" +
                "      <td align=\"center\">\n" +
                "        <h1>Olá, [[NAME]]</h1>\n" +
                "        <br>\n" +
                "        <h3>Informamos que recebemos sua solicitação. Estamos analizando sua proposta. </h3>\n" +
                "        <br>\n" +
                "        <h3>Fique atento, logo entraremos em contato !</h3>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>".formatted();

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddres, senderName);
        helper.setTo(toAddres);
        helper.setSubject(subject);

        content = content.replace("[[NAME]]", nomeUsuario);

        helper.setText(content, true);

        sender.send(message);


    }

}

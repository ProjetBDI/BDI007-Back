package fr.uga.miage.m1.service;

import com.sendgrid.*;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;

@Service
public class EmailService {

    @Value("${sendgrid.api-key}")
    private String sendGridApiKey;

    @SneakyThrows
    public void envoyerEmail(String destinataire, String sujet, String contenu) {

        Email from = new Email("festicardbi@gmail.com"); // Remplacez par votre adresse email SendGrid vérifiée
        Email to = new Email(destinataire);

        Content content = new Content("text/plain", contenu);
        Mail mail = new Mail(from, sujet, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        try{
            Response response = sg.api(request);
        } catch (IOException ex) {
            throw new IOException("Erreur lors de l'envoi de l'email");
        }
    }

    public void envoyerEmail(List<String> destinataire, String sujet, String contenu) throws IOException {

        for (String email : destinataire) {
            envoyerEmail(email, sujet, contenu);
        }

    }
}
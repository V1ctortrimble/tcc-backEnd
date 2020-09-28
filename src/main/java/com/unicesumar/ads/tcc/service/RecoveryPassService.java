package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.UserEntity;
import com.unicesumar.ads.tcc.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

public class RecoveryPassService {
    @Autowired private JavaMailSender mailSender;
    @Autowired private UserRepository userRepository;

    public String recoveryPass(String mail){

        UserEntity user = userRepository.findByUsername(mail);
        String response = "";

        try {
            if(user != null){
                String code = createCode();
                //salvar no banco código e usuário e apagar depois de um tempo.
                String link = "https://localhost:8000/recuperasenha/" + code;

                response = sendMail(mail, link);
            }
            else{
                response = "Usuário não encontrado!!!";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }

        return response;
    }

    public String createCode(){

        Random random = new Random();
        String code = String.valueOf(random.nextInt(1000));

        return code;
    }

    public String sendMail(String mail, String link) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Você solicitou a recuperação de senha, clique no link para realizar o cadastro de uma nova senha: " + link);
        message.setTo("");
        message.setFrom(mail);

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            return "Erro ao enviar email.";
        }
    }
}

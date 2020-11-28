package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.*;

@Service
@RequiredArgsConstructor
public class RecoveryPassService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UsersRepository usersRepository;
    @Value("${api.key}")
    private String LINK;

    /**
     * validation method for email forwarding
     * @return response
     */
    public String recoveryPass(String mail){

        UsersEntity user = usersRepository.findByUsername(mail);
        String response = "";

        try {
            if(user != null){
                UUID code = createCode();
                String link = LINK + "/recoverpassword/" + code;
                user.setCode(code.toString());
                user.setDataCode(LocalDateTime.now());
                usersRepository.save(user);
                response = sendMail(mail, link);
            }
            else{
                throw new HttpBadRequestException(ERRO_AO_ENVIAR_EMAIL);
            }
        }
        catch (Exception e){
            throw new HttpBadRequestException(ERRO_AO_ENVIAR_EMAIL);
        }

        return response;
    }

    /**
     * Create a random code
     * @return uuid
     */
    public UUID createCode(){
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    /**
     * forward the email if everything is correct
     * Try @return "Email enviado com sucesso!"
     * Catch @return "Erro ao enviar email!"
     */
    public String sendMail(String mail, String link) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(TEXT + link);
        message.setTo(mail);
        message.setSubject(SUBJECT);
        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            throw new HttpNotFoundException(ERRO_AO_ENVIAR_EMAIL);
        }
    }

}

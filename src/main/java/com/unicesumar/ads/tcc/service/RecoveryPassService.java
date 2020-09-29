package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.RecoveryPassCodeEntity;
import com.unicesumar.ads.tcc.data.entity.UserEntity;
import com.unicesumar.ads.tcc.data.repository.RecoveryPassCodeRepository;
import com.unicesumar.ads.tcc.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RecoveryPassService {

    private final RecoveryPassCodeRepository repository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserRepository userRepository;

    private RecoveryPassCodeEntity recoveryPassCodeEntity;

    @Value("${spring.mail.username}")
    private String email;

    public String recoveryPass(String mail){

        UserEntity user = userRepository.findByUsername(mail);
        String response = "";

        try {
            if(user != null){
                UUID code = createCode();
                //salvar no banco código e usuário e apagar depois de um tempo.
                String link = "https://localhost:8000/recuperasenha/" + code;

                recoveryPassCodeEntity = RecoveryPassCodeEntity.builder()
                        .code(code.toString())
                        .userEntity(user)
                        .build();
                repository.save(recoveryPassCodeEntity);

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

    public UUID createCode(){
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    public String sendMail(String mail, String link) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Você solicitou a recuperação de senha, clique no link para realizar o cadastro de uma nova senha: " + link);
        message.setTo("memorygamelgpd@gmail.com");
        message.setSubject( "Teste email" );
        message.setFrom(mail);
        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            return "Erro ao enviar email.";
        }
    }
}

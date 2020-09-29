package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.UserEntityConverter;
import com.unicesumar.ads.tcc.data.entity.RecoveryPassEntity;
import com.unicesumar.ads.tcc.data.entity.UserEntity;
import com.unicesumar.ads.tcc.data.repository.RecoveryPassCodeRepository;
import com.unicesumar.ads.tcc.data.repository.UserRepository;
import com.unicesumar.ads.tcc.dto.UserDTO;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.RecoveryPassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"visualization tests of Recovery Pass"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class RecoveryPassController {

    private final RecoveryPassCodeRepository recoveryPassCodeRepository;
    private final UserRepository userRepository;
    private final RecoveryPassService recoveryPassService;
    private final UserEntityConverter converter;

    private UserDTO userDTO;


    @GetMapping("recuperasenha/{code}")
    public RecoveryPassEntity getCodeRecoveryPass(@PathVariable("code") String code) {
        RecoveryPassEntity recoveryPassEntity = recoveryPassCodeRepository.findByCode(code);
        return recoveryPassEntity;
    }

//    @PutMapping("alterarsenha/{username}")
//    public ResponseEntity<UserDTO> putPassword(@PathVariable("username") String username,
//                                               @Validated @RequestBody UserDTO userDTO) throws HttpNotFoundException {
//
//        UserEntity user = userRepository.findByUsername(username);
//
//        if (user != null){
//            this.userDTO = UserDTO.builder()
//                    .password(userDTO.getPassword())
//                    .build();
//            userRepository.save(converter.toEntity(this.userDTO));
//            return new ResponseEntity<>(userDTO, HttpStatus.OK);
//        }
//        throw new HttpNotFoundException("not found");
//    }


    @ApiOperation(value = "Test enviar email" )
    @PostMapping(path = "sendemail/{email}")
    public ResponseEntity<?> getHelloAdmin(@PathVariable("email") String email) {
       try {
           recoveryPassService.recoveryPass(email);
           return new ResponseEntity<>(email, HttpStatus.OK);
       }catch (RuntimeException ex){
           throw new RuntimeException(ex);
       }
    }


}

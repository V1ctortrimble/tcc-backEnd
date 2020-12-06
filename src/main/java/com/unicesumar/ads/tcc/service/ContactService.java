package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.ContactEntity;
import com.unicesumar.ads.tcc.data.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactEntity getContactByIndividualId(Integer id){
        return contactRepository.findByPersonIndividualIdIndividual(id);
    }
}

package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.AdressEntity;
import com.unicesumar.ads.tcc.data.entity.BankDetailsEntity;
import com.unicesumar.ads.tcc.data.entity.ContactEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.data.repository.PersonRepository;
import com.unicesumar.ads.tcc.dto.personDTO.PersonIndividualDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.CAMPOS_OBRIGATORIOS;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    /**
     * Find PersonEntity by cnpj
     */
    public PersonEntity getPersonByCnpj(String cnpj) {
        return personRepository.findByCompanyCnpj(cnpj);
    }

    /**
     * Find PersonEntity by cpf
     */
    public PersonEntity getPersonByCpf(String cpf) {
        return personRepository.findByIndividualCpf(cpf);
    }

    /**
     * Find PersonEntity by rg
     */
    public PersonEntity getPersonByRg(String rg) {
        return personRepository.findByIndividualRg(rg);
    }

    /**
     * Save or update a PersonEntity
     */
    public void postUsers(PersonEntity entity) {
       try {
           personRepository.save(entity);
       }catch (NullPointerException e) {
           throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
       }
    }

    /**
     * Find All Persons
     */
    public List<PersonEntity> getPerson() {
        return personRepository.findAll();
    }

    public PersonEntity putPerson(PersonEntity person, PersonIndividualDTO dto) {
        //PersonEntity person = this.personRepository.findByIndividualCpf(dto.getIndividual().getCpf());
        if (dto.getActive() != null) {
            person.setActive(dto.getActive());
        }

        if (dto.getIndividual() != null) {
            if (dto.getIndividual().getCpf() != null) {
                person.getIndividual().setCpf(dto.getIndividual().getCpf());
            }

            if (dto.getIndividual().getNameIndividual() != null) {
                person.getIndividual().setNameIndividual(dto.getIndividual().getNameIndividual());
            }

            if (dto.getIndividual().getRg() != null) {
                person.getIndividual().setRg(dto.getIndividual().getRg());
            }

            if (dto.getIndividual().getLastName() != null) {
                person.getIndividual().setLastName(dto.getIndividual().getLastName());
            }

            if (dto.getIndividual().getBirthDate() != null) {
                person.getIndividual().setBirthDate(dto.getIndividual().getBirthDate());
            }
        }

        int i;
        if (dto.getContacts() != null) {
            for(i = 0; i < dto.getContacts().size(); ++i) {
                if (dto.getContacts().get(i) != null) {
                    if ((dto.getContacts().get(i)).getCellPhone() != null) {
                        ((ContactEntity)person.getContacts().get(i)).setCellPhone((dto.getContacts().get(i)).getCellPhone());
                    }

                    if ((dto.getContacts().get(i)).getEmail() != null) {
                        ((ContactEntity)person.getContacts().get(i)).setEmail((dto.getContacts().get(i)).getEmail());
                    }

                    if ((dto.getContacts().get(i)).getPhone() != null) {
                        ((ContactEntity)person.getContacts().get(i)).setPhone((dto.getContacts().get(i)).getPhone());
                    }

                    if ((dto.getContacts().get(i)).getCellwhats() != null) {
                        ((ContactEntity)person.getContacts().get(i)).setCellwhats((dto.getContacts().get(i)).getCellwhats());
                    }
                }
            }
        }

        if (dto.getAdresses() != null) {
            for(i = 0; i < dto.getAdresses().size(); ++i) {
                if (dto.getAdresses().get(i) != null) {
                    if ((dto.getAdresses().get(i)).getAdditional() != null) {
                        ((AdressEntity)person.getAdresses().get(i)).setAdditional((dto.getAdresses().get(i)).getAdditional());
                    }

                    if ((dto.getAdresses().get(i)).getAdress() != null) {
                        ((AdressEntity)person.getAdresses().get(i)).setAdress((dto.getAdresses().get(i)).getAdress());
                    }

                    if ((dto.getAdresses().get(i)).getAdressNumber() != null) {
                        ((AdressEntity)person.getAdresses().get(i)).setAdressNumber((dto.getAdresses().get(i)).getAdressNumber());
                    }

                    if ((dto.getAdresses().get(i)).getCity() != null) {
                        ((AdressEntity)person.getAdresses().get(i)).setCity((dto.getAdresses().get(i)).getCity());
                    }

                    if ((dto.getAdresses().get(i)).getNeighborhood() != null) {
                        ((AdressEntity)person.getAdresses().get(i)).setNeighborhood((dto.getAdresses().get(i)).getNeighborhood());
                    }

                    if ((dto.getAdresses().get(i)).getState() != null) {
                        ((AdressEntity)person.getAdresses().get(i)).setState((dto.getAdresses().get(i)).getState());
                    }

                    if ((dto.getAdresses().get(i)).getZipCode() != null) {
                        ((AdressEntity)person.getAdresses().get(i)).setZipCode((dto.getAdresses().get(i)).getZipCode());
                    }
                }
            }
        }

        if (dto.getBanksDetails() != null) {
            for(i = 0; i < dto.getBanksDetails().size(); ++i) {
                if (dto.getBanksDetails().get(i) != null) {
                    if ((dto.getBanksDetails().get(i)).getAccount() != null) {
                        ((BankDetailsEntity)person.getBanksDetails().get(i)).setAccount((dto.getBanksDetails().get(i)).getAccount());
                    }

                    if ((dto.getBanksDetails().get(i)).getActive() != null) {
                        ((BankDetailsEntity)person.getBanksDetails().get(i)).setActive((dto.getBanksDetails().get(i)).getActive());
                    }

                    if ((dto.getBanksDetails().get(i)).getAgency() != null) {
                        ((BankDetailsEntity)person.getBanksDetails().get(i)).setAgency((dto.getBanksDetails().get(i)).getAgency());
                    }

                    if ((dto.getBanksDetails().get(i)).getBank() != null) {
                        ((BankDetailsEntity)person.getBanksDetails().get(i)).setBank((dto.getBanksDetails().get(i)).getBank());
                    }

                    if ((dto.getBanksDetails().get(i)).getDigit() != null) {
                        ((BankDetailsEntity)person.getBanksDetails().get(i)).setDigit((dto.getBanksDetails().get(i)).getDigit());
                    }

                    if ((dto.getBanksDetails().get(i)).getOperation() != null) {
                        ((BankDetailsEntity)person.getBanksDetails().get(i)).setOperation((dto.getBanksDetails().get(i)).getOperation());
                    }

                    if ((dto.getBanksDetails().get(i)).getOperation() != null) {
                        ((BankDetailsEntity)person.getBanksDetails().get(i)).setOperation((dto.getBanksDetails().get(i)).getOperation());
                    }
                }
            }
        }

        try {
            this.personRepository.save(person);
            return this.personRepository.findByIndividualCpf(dto.getIndividual().getCpf());
        } catch (Exception var4) {
            throw new HttpBadRequestException(var4.getMessage());
        }
    }

}

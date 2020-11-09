package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.data.repository.PersonRepository;
import com.unicesumar.ads.tcc.dto.*;
import com.unicesumar.ads.tcc.dto.personDTO.PersonCompanyDTO;
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

    /**
     * Update a Persons Individual
     */
    public void putPersonIndividual(PersonEntity person, PersonIndividualDTO dto) {
        validationIndividualToPut(person, dto.getIndividual());
        validationContactToPut(person, dto.getContacts());
        validationAdresessesToPut(person, dto.getAdresses());
        validationBankDetailsToPut(person, dto.getBanksDetails());
        try {
            this.personRepository.save(person);
            this.personRepository.findByIndividualCpf(dto.getIndividual().getCpf());
        } catch (Exception e) {
            throw new HttpBadRequestException(e.getMessage());
        }
    }

    /**
     * Update a Persons Company
     */
    public void putPersonCompany(PersonEntity person, PersonCompanyDTO dto) {
        validationCompanyToPut(person, dto.getCompany());
        validationContactToPut(person, dto.getContacts());
        validationAdresessesToPut(person, dto.getAdresses());
        validationBankDetailsToPut(person, dto.getBanksDetails());
        try {
            this.personRepository.save(person);
            this.personRepository.findByCompanyCnpj(dto.getCompany().getCnpj());
        } catch (Exception e) {
            throw new HttpBadRequestException(e.getMessage());
        }
    }

    /**
     * Method that validates if an Individual can be updated
     */
    private void validationIndividualToPut(PersonEntity person, IndividualDTO dto) {
        if (dto != null) {
            if (dto.getCpf() != null) {
                person.getIndividual().setCpf(dto.getCpf());
            }
            if (dto.getActive() != null) {
                person.getIndividual().setActive(dto.getActive());
            }
            if (dto.getNameIndividual() != null) {
                person.getIndividual().setNameIndividual(dto.getNameIndividual());
            }
            if (dto.getRg() != null) {
                person.getIndividual().setRg(dto.getRg());
            }
            if (dto.getLastName() != null) {
                person.getIndividual().setLastName(dto.getLastName());
            }
            if (dto.getBirthDate() != null) {
                person.getIndividual().setBirthDate(dto.getBirthDate());
            }
        }
    }

    /**
     * Method that validates if an Company can be updated
     */
    private void validationCompanyToPut(PersonEntity person, CompanyDTO dto) {
        if (dto != null) {
            if (dto.getCnpj() != null) {
                person.getCompany().setCnpj(dto.getCnpj());
            }
            if (dto.getActive() != null) {
                person.getCompany().setActive(dto.getActive());
            }
            if (dto.getOpenDate() != null) {
                person.getCompany().setOpenDate(dto.getOpenDate());
            }
            if (dto.getFantasyName() != null) {
                person.getCompany().setFantasyName(dto.getFantasyName());
            }
            if (dto.getSocialReason() != null) {
                person.getCompany().setSocialReason(dto.getSocialReason());
            }
            if (dto.getStateRegis() != null) {
                person.getCompany().setStateRegis(dto.getStateRegis());
            }
        }
    }

    /**
     * Method that validates if a Contact can be updated
     */
    private void validationContactToPut(PersonEntity person, List<ContactDTO> dtos) {
        int i;
        if (dtos != null) {
            for(i = 0; i < dtos.size(); ++i) {
                if (dtos.get(i) != null) {
                    if ((dtos.get(i)).getCellPhone() != null) {
                        (person.getContacts().get(i)).setCellPhone((dtos.get(i)).getCellPhone());
                    }
                    if ((dtos.get(i)).getEmail() != null) {
                        (person.getContacts().get(i)).setEmail((dtos.get(i)).getEmail());
                    }
                    if ((dtos.get(i)).getPhone() != null) {
                        (person.getContacts().get(i)).setPhone((dtos.get(i)).getPhone());
                    }
                    if ((dtos.get(i)).getCellwhats() != null) {
                        (person.getContacts().get(i)).setCellwhats((dtos.get(i))
                                .getCellwhats());
                    }
                }
            }
        }
    }

    /**
     * Method that validates if an Address can be updated
     */
    private void validationAdresessesToPut(PersonEntity person, List<AdressDTO> dtos) {
        int i;
        if (dtos != null) {
            for(i = 0; i < dtos.size(); ++i) {
                if (dtos.get(i) != null) {
                    if ((dtos.get(i)).getAdditional() != null) {
                        (person.getAdresses().get(i)).setAdditional((dtos.get(i))
                                .getAdditional());
                    }
                    if ((dtos.get(i)).getAdress() != null) {
                        (person.getAdresses().get(i)).setAdress((dtos.get(i))
                                .getAdress());
                    }
                    if ((dtos.get(i)).getAdressNumber() != null) {
                        (person.getAdresses().get(i)).setAdressNumber((dtos.get(i))
                                .getAdressNumber());
                    }
                    if ((dtos.get(i)).getCity() != null) {
                        (person.getAdresses().get(i)).setCity((dtos.get(i)).getCity());
                    }
                    if ((dtos.get(i)).getNeighborhood() != null) {
                        (person.getAdresses().get(i)).setNeighborhood((dtos.get(i))
                                .getNeighborhood());
                    }
                    if ((dtos.get(i)).getState() != null) {
                        (person.getAdresses().get(i)).setState((dtos.get(i)).getState());
                    }
                    if ((dtos.get(i)).getZipCode() != null) {
                        (person.getAdresses().get(i)).setZipCode((dtos.get(i)).getZipCode());
                    }
                }
            }
        }
    }

    /**
     * Method that validates whether a bank details can be updated
     */
    private void validationBankDetailsToPut(PersonEntity person, List<BankDetailsDTO> dtos) {
        int i;
        if (dtos != null) {
            for(i = 0; i < dtos.size(); ++i) {
                if (dtos.get(i) != null) {
                    if ((dtos.get(i)).getAccount() != null) {
                        (person.getBanksDetails().get(i)).setAccount((dtos.get(i))
                                .getAccount());
                    }
                    if ((dtos.get(i)).getActive() != null) {
                        (person.getBanksDetails().get(i)).setActive((dtos.get(i))
                                .getActive());
                    }
                    if ((dtos.get(i)).getAgency() != null) {
                        (person.getBanksDetails().get(i)).setAgency((dtos.get(i))
                                .getAgency());
                    }
                    if ((dtos.get(i)).getBank() != null) {
                        (person.getBanksDetails().get(i)).setBank((dtos.get(i))
                                .getBank());
                    }
                    if ((dtos.get(i)).getDigit() != null) {
                        (person.getBanksDetails().get(i)).setDigit((dtos.get(i))
                                .getDigit());
                    }
                    if ((dtos.get(i)).getOperation() != null) {
                        (person.getBanksDetails().get(i)).setOperation((dtos.get(i))
                                .getOperation());
                    }
                    if ((dtos.get(i)).getOperation() != null) {
                        (person.getBanksDetails().get(i)).setOperation((dtos.get(i))
                                .getOperation());
                    }
                }
            }
        }
    }
}

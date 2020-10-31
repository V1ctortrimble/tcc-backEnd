package com.unicesumar.ads.tcc.data.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class UsersEntity implements Serializable, UserDetails {

    @Getter
    @Setter
    @Id
    @Column(name = "ID_USERS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Getter
    @Setter
    @NotEmpty(message = "Nome de usuário não pode ser vazio")
    @Email(message = "Campo deve ser um e-mail válido")
    @Column(name = "LOGIN")
    private String username;

    @Getter
    @Setter
    @NotEmpty(message = "Senha não pode ser vazia")
    @Column(name = "PASSWORD")
    private String password;

    @Getter
    @Setter
    @Column(name = "ADMIN")
    private Boolean admin;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individual;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_COMPANY_SYSTEM")
    private CompanySystemEntity companySystem;

    @Getter
    @Setter
    @Column(name = "RESET_PASS_CODE")
    private String code;

    @Getter
    @Setter
    @Column(name = "RESET_PASS_DATE")
    private LocalDateTime dataCode;

    /**
     * Methods for implementing UserDetails
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}

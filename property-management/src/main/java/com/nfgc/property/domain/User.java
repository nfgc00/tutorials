package com.nfgc.property.domain;

import com.nfgc.property.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "seq_users", sequenceName = "SEQ_USERS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(UserDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.password = dto.getPassword();
    }
}

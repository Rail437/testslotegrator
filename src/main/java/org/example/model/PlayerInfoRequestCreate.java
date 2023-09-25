package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PlayerInfoRequestCreate extends Player {
    private String password_change;
    private String password_repeat;

    public PlayerInfoRequestCreate(String currency_code,
                                   String email,
                                   String name,
                                   String password_change,
                                   String password_repeat,
                                   String surname,
                                   String username) {
        this.currency_code = currency_code;
        this.email = email;
        this.name = name;
        this.password_change = password_change;
        this.password_repeat = password_repeat;
        this.surname = surname;
        this.username = username;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "currency_code='" + currency_code + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password_change='" + password_change + '\'' +
                ", password_repeat='" + password_repeat + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}

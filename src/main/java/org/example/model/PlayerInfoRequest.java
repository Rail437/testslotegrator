package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerInfoRequest extends Player {
    private String id;
    private String password_change;
    private String password_repeat;

    public PlayerInfoRequest() {
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

package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PlayerInfoResponse extends Player {
    private String _id;
    private String password_change;
    private String password_repeat;
    private String __v;

    public PlayerInfoResponse() {
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "_id='" + _id + '\'' +
                ", currency_code='" + currency_code + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password_change='" + password_change + '\'' +
                ", password_repeat='" + password_repeat + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", __v='" + __v + '\'' +
                '}';
    }

}

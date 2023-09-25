package org.example.steps;


import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Player;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CheckSteps {

    /**
     * Метод проверки полей игроков
     *
     * @param firstPlayer  - первый проверяемый игрок
     * @param secondPlayer - второй проверяемый игрок
     */
    @Step("Проверка полей игрока")
    public void checkPlayerFields(Player firstPlayer, Player secondPlayer) {
        assertAll("Проверка полей игрока.",
                () -> assertEquals(firstPlayer.getCurrency_code(), secondPlayer.getCurrency_code()),
                () -> assertEquals(firstPlayer.getEmail(), secondPlayer.getEmail()),
                () -> assertEquals(firstPlayer.getName(), secondPlayer.getName()),
                () -> assertEquals(firstPlayer.getSurname(), secondPlayer.getSurname()),
                () -> assertEquals(firstPlayer.getUsername(), secondPlayer.getUsername())
        );
    }
}

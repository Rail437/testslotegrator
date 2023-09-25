package org.example.utils;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.model.PlayerInfoRequestCreate;

@Slf4j
public class PlayerUtil {
    private final Faker faker = new Faker();
    private static final String GMAIL_DOMAIN = "@gmail.com";

    /**
     * Метод создания игрока с рандомными значениями
     *
     * @return - созданный игрок
     */
    @Step("Создаем игрока с рандомными данными")
    public PlayerInfoRequestCreate getRandomPlayer() {
        String password = RandomStringUtils.randomAlphanumeric(6);
        var player = new PlayerInfoRequestCreate(faker.superhero().power(),
                RandomStringUtils.randomAlphabetic(6) + GMAIL_DOMAIN,
                faker.name().firstName(),
                password,
                password,
                faker.name().lastName(),
                faker.superhero().name());
        log.info(player.toString());
        return player;
    }
}

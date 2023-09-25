package org.example.client;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.example.config.BaseConfig;
import org.example.model.*;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;

@Slf4j
public class RestClient {
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Получение токена авторизации
     *
     * @param statusCode - ожидаемый статус код
     * @return - Обьект с информацией и токеном
     */
    @Step("Получение токена авторизации")
    public AuthResponse getToken(int statusCode) {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(AuthRequest.builder()
                        .email(config.email())
                        .password(config.password())
                        .build())
                .post(config.mainUrl() + config.apiLogin())
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .as(AuthResponse.class);
    }

    /**
     * Метод создания игрока.
     *
     * @param playerInfoRequest - игрок которого мы хотим создать
     * @param token             - токен авторизации
     * @return - ответ с данными от сервера
     */
    @Step("Создание игрока")
    public PlayerInfoResponse createPlayer(PlayerInfoRequestCreate playerInfoRequest, String token) {
        return given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(playerInfoRequest)
                .post(config.mainUrl() + config.apiCreate())
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(SC_CREATED)
                .extract()
                .as(PlayerInfoResponse.class);
    }

    /**
     * Получение данных игрока
     *
     * @param email      - email по которому ведется поиск
     * @param token      - token авторизации
     * @param statusCode - ожидаемый код ответа
     * @return - данные игрока
     */
    @Step("Получение данных игрока с email: {email}")
    public PlayerInfoRequest getPlayer(String email, String token, int statusCode) {
        var body = new PlayerInfoResponse();
        body.setEmail(email);
        return given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(body)
                .post(config.mainUrl() + config.apiGetOne())
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .as(PlayerInfoRequest.class);
    }

    /**
     * Получение списка всех игроков
     *
     * @param token      - токен авторизации
     * @param statusCode - ожидаемый статус ответа
     * @return - список игроков
     */
    @Step("Получение всех созданных игроков")
    public List<PlayerInfoRequest> getAllPlayers(String token, int statusCode) {
        return Arrays.asList(given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get(config.mainUrl() + config.apiGetAll())
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .as(PlayerInfoRequest[].class));
    }

    /**
     * Удаление игрока по его id
     *
     * @param playerId   - id удаляемого игрока
     * @param token      - токен авторизации
     * @param statusCode - ожидаемый код ответа
     */
    @Step("Удаление игрока с id: {playerId}")
    public void deletePleyer(String playerId, String token, int statusCode) {
        given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .delete(config.mainUrl() + config.apiDelete() + playerId)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(statusCode);
    }
}

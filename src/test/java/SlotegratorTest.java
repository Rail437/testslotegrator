import lombok.extern.slf4j.Slf4j;
import org.example.client.RestClient;
import org.example.model.Player;
import org.example.steps.CheckSteps;
import org.example.utils.PlayerUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;


@Slf4j
public class SlotegratorTest {
    private final RestClient restClient = new RestClient();
    private final PlayerUtil playerUtil = new PlayerUtil();
    private final CheckSteps checkSteps = new CheckSteps();

    @Test
    @DisplayName("Api тест создания, получения и удаления игроков")
    public void test() {
        //делаем запрос, авторизуемся и получаем токен
        String token = restClient.getToken(SC_CREATED).getAccessToken();
        //создаем новых игроков в количестве 12
        int playersCount = 12;
        for (int i = 1; i <= playersCount; i++) {
            var fakePlayer = playerUtil.getRandomPlayer();
            fakePlayer.setCurrency_code("Player_#" + i);
            //регистрируем игроков
            var player = restClient.createPlayer(fakePlayer, token);
            checkSteps.checkPlayerFields(fakePlayer, player);
            //получаем данные одного игрока по его email
            var playerInfo = restClient.getPlayer(fakePlayer.getEmail(), token, SC_CREATED);
            //проверяем правильность сохраненных данных.
            checkSteps.checkPlayerFields(fakePlayer, playerInfo);
        }

        //получаем данные всех игроков и сортируем их по имени
        var players = restClient.getAllPlayers(token, SC_OK).stream()
                .sorted(Comparator.comparing(Player::getName))
                .toList();
        Assertions.assertEquals(players.size(), playersCount,
                "Ожидалось, что добавится " + playersCount + " игроков.");
        int size = players.size();
        players.forEach(v -> log.info(v.toString()));
        players.forEach(v -> restClient.deletePleyer(v.getId(), token, SC_OK));
        players = restClient.getAllPlayers(token, SC_OK);
        log.info("до удаления size: " + size);
        log.info("после удаления size: " + players.size());
        Assertions.assertTrue(players.isEmpty(), "Ожидалось, что после удаления будет пустой список.");
    }
}
Задание:
***
Автоматизировать REST API-тесты на Java используя любой соответствующий инструмент (например RestAssured, Feign,
Retrofit, Unirest и т.д. - мы в частности используем Feign и RestAssured):

1. Получить токен пользователя (/api/tester/login)
   Ожидаемый результат: HTTP response code 200, ответ содержит токен пользователя

2. Зарегистрировать игроков (12 штук) (/api/automationTask/create)
   Ожидаемый результат: HTTP response code 201, ответ соответствует документации

3. Запросить данные профиля созданного игрока (/api/automationTask/getOne)
   Ожидаемый результат: HTTP response code 200, ответ соответствует документации

4. Запросить данные всех пользователей и отсортировать их по имени (/api/automationTask/getAll)

5. Удалить всех ранее созданных пользователей (/api/automationTask/deleteOne/{id})

6. Запросить список всех пользователей и убедиться что он пустой (/api/automationTask/getAll)

***
Найденные ошибки:
ОР - ожидаемый результат.
ФР - фактический результат.

1. Ошибка статус кода при ответе на запрос получения токена.  
   При запросе на адрес /api/tester/login  
   ОР: HTTP response code 200  
   ФР: HTTP response code 201

2. Ошибка статус кода при ответе на запрос получения токена.  
   При запросе на адрес api/automationTask/getOne  
   ОР: HTTP response code 200  
   ФР: HTTP response code 201

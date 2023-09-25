package org.example.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.yml"})
public interface BaseConfig extends Config {
    String mainUrl();

    String email();

    String password();

    String apiLogin();

    String apiCreate();

    String apiGetOne();

    String apiGetAll();

    String apiDelete();
}

package com.nexora.nextblack.code.jsonconf;

import com.google.gson.Gson;
import com.nexora.nextblack.code.Main;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Files;

public class Jsonconfig {
    public int winGame;
    public String version;

    public void SJsonconfig() {
        Gson gson = new Gson();
        Path path = Path.of("info.json");

        if (Files.exists(path)) {
            try {
                String json = Files.readString(path);
                JsonconfigHelper winGamegson = gson.fromJson(json, JsonconfigHelper.class);
                winGame = winGamegson.winGameJ;

                JsonconfigHelper versiongson = gson.fromJson(json, JsonconfigHelper.class);
                version = versiongson.versionJ;
            } catch (Exception e) {
                System.out.println("произошла неизвестная ошибка,\n" + "решения:\n" + "обратитесь к разработчику\n" + "подождите микро релиза(2.x)\n" + "перескачайте игру\n");
            }
        } else System.out.println("извините, неизвестная ошибка с чтением файла json");
    }
}

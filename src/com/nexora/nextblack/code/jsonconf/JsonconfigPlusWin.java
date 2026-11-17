package com.nexora.nextblack.code.jsonconf;

import com.google.gson.Gson;

import java.nio.file.Path;
import java.nio.file.Files;

public class JsonconfigPlusWin {
    public static void SJsonconfigPlusWin() {
        Gson gson = new Gson();
        Jsonconfig jsonconfig = new Jsonconfig();
        jsonconfig.SJsonconfig();
        Path path = Path.of("info.json");
        if (Files.exists(path)) {
            try {
                JsonconfigHelper jsonconfigHelper = new JsonconfigHelper();
                jsonconfigHelper.winGameJ = jsonconfig.winGame + 1;
                jsonconfigHelper.versionJ = jsonconfig.version;
                String reload = gson.toJson(jsonconfigHelper);
                Files.writeString(path, reload);
            } catch (Exception e) {
                System.out.println("произошла неизвестная ошибка,\n" + "решения:\n" + "обратитесь к разработчику\n" + "подождите микро релиза(2.x)\n" + "перескачайте игру\n");
            }
        } else {
            System.out.println("извините, неизвестная ошибка с чтением файла json");
        }

    }
}

/*
 * 2017-11-26
 */
package ru.davist.webwatcher.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.davist.webwatcher.domain.Result;
import ru.davist.webwatcher.domain.WantedTarget;

import java.util.Optional;

/**
 * @author Starovoytov Danil
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SteamExtractor {

    private static final Logger log = LoggerFactory.getLogger(SteamExtractor.class);

    @Test
    public void test() {
        Extractor ex = new GenericExtractor();

        WantedTarget target = new WantedTarget();
        target.setName("Stick_Fight");
        target.setUrl("http://store.steampowered.com/app/674940/Stick_Fight_The_Game/");

        target.addSelector("div.game_area_purchase_game");
        target.addSelector("div.price");

        Optional<Result> result = ex.get(target);

        result.ifPresent(res -> {
            log.info("Name: {}", target.getName());
            log.info("Price: " + res.getValue());
            if (res.getAdditionalValues() != null && !res.getAdditionalValues().isEmpty()) {
                res.getAdditionalValues().forEach((s, s2) -> log.info("{}: {}", s, s2));
            }
        });

    }
}

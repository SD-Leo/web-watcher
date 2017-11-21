/*
 * 2017-11-21
 */
package ru.davist.webwatcher.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.davist.webwatcher.domain.Result;

import java.util.Optional;

/**
 * @author Starovoytov Danil
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class JbExtractorTest {

    private static final Logger log = LoggerFactory.getLogger(JbExtractorTest.class);

    @Test
    public void test() {
        Extractor ex = new JbExtractor();
        Optional<Result> result1 = ex.get("https://www.jetbrains.com/idea/buy/#edition=personal");

        result1.ifPresent(res -> {
            log.info("!!!!!!  Price: " + res.getValue());
            if (res.getOldValue() != null) {
                log.info("Old price: " + res.getOldValue());

            }
        });
    }
}

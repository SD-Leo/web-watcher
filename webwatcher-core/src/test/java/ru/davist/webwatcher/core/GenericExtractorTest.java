/*
 * 2017-11-22
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
public class GenericExtractorTest {

    private static final Logger log = LoggerFactory.getLogger(GenericExtractorTest.class);

    @Test
    public void test() {
        GenericExtractor ex = new GenericExtractor();
        ex.thenSelect("div.context-product-placement-data")
            .thenSelect("div.price-info")
            .thenSelect("div.price-text")
            .thenSelect("span[aria-label]");

        ex.thenSelectOld("div.context-product-placement-data")
            .thenSelectOld("div.price-info")
            .thenSelectOld("div.price-text")
            .thenSelectOld("s.srv_saleprice");


//        Optional<Result> result1 = ex.get("https://www.microsoft.com/ru-ru/store/p/n-nplusplus/bt33chssb89v"); // N++
        Optional<Result> result1 = ex.get("https://www.microsoft.com/ru-ru/store/p/wolfenstein-the-two-pack/bzj43gk4l0jc"); // Wolfenstein®: The Two-Pack

        result1.ifPresent(res -> {
            log.info("Price: " + res.getValue());
            if (res.getOldValue() != null) {
                log.info("Old price: " + res.getOldValue());

            }
        });
    }
}

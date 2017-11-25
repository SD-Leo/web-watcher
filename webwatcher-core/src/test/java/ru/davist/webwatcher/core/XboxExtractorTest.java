/*
 * 2017-11-22
 */
package ru.davist.webwatcher.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.davist.webwatcher.domain.Result;
import ru.davist.webwatcher.domain.WantedTarget;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Starovoytov Danil
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class XboxExtractorTest {

    private static final Logger log = LoggerFactory.getLogger(XboxExtractorTest.class);

    @Test
    public void test() {
        Extractor ex = new GenericExtractor();
        WantedTarget target = new WantedTarget();

        target.setUrl("https://www.microsoft.com/ru-ru/store/p/n-nplusplus/bt33chssb89v"); // N++
//        target.setUrl("https://www.microsoft.com/ru-ru/store/p/wolfenstein-the-two-pack/bzj43gk4l0jc"); // Wolfenstein®: The Two-Pack

        target.setSelectors(new ArrayList<>(4));
        target.addSelector("div.context-product-placement-data");
        target.addSelector("div.price-info");
        target.addSelector("div.price-text");
        target.addSelector("span[aria-label]");

        target.setPrevValueSelectors(new ArrayList<>(4));
        target.addPrevValueSelector("div.context-product-placement-data");
        target.addPrevValueSelector("div.price-info");
        target.addPrevValueSelector("div.price-text");
        target.addPrevValueSelector("s.srv_saleprice");

        Optional<Result> result = ex.get(target);

        result.ifPresent(res -> {
            log.info("Price: " + res.getValue());
            Assert.assertTrue(res.getValue().contains("599,00"));
            if (res.getPrevValue() != null) {
                log.info("Old price: " + res.getPrevValue());
            }
        });
    }
}

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
import ru.davist.webwatcher.domain.WantedTarget;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Starovoytov Danil
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class JbExtractorTest {

    private static final Logger log = LoggerFactory.getLogger(JbExtractorTest.class);

    @Test
    public void test() {
        Extractor ex = new GenericExtractor();
        WantedTarget target = new WantedTarget();
        target.setUrl("https://www.jetbrains.com/idea/buy/#edition=personal");
        target.setSelectors(new ArrayList<>(6));
        target.addSelector("div[data-id=personal]");
        target.addSelector("div._spacer");
        target.addSelector("div[data-id=yearly]");
        target.addSelector("div[data-user-license=new]");
        target.addSelector("span.price-list__first-year");
        target.addSelector("span.-current__price");

        Optional<Result> result = ex.get(target);

        result.ifPresent(res -> {
            log.info("Price: {}", res.getValue());
            if (res.getPrevValue() != null) {
                log.info("Old price: {}", res.getPrevValue());
            }
        });
    }
}

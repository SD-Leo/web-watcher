/*
 * 2017-11-25
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
public class DnsExtractorTest {

    private static final Logger log = LoggerFactory.getLogger(DnsExtractorTest.class);

    @Test
    public void test() {
        Extractor ex = new GenericExtractor();
        WantedTarget target = new WantedTarget();

        // current_path=79f9c14e9184656ea5505f8b640d5512b767e2b881bf8415bc2e2f954bb49e0ba%3A2%3A%7Bi%3A0%3Bs%3A12%3A%22current_path%22%3Bi%3A1%3Bs%3A36%3A%2249bc7ffa-ddec-11dc-8709-00151716f9f5%22%3B%7D;
        // current_path=1d5af89c6fd335884612b1c9b767e0c7e454926d5df09dbf0b000e5933ecf055a%3A2%3A%7Bi%3A0%3Bs%3A12%3A%22current_path%22%3Bi%3A1%3Bs%3A36%3A%2258b139d1-90ae-11dc-a1f0-00151716f9f5%22%3B%7D
        target.addCookie("current_path", "79f9c14e9184656ea5505f8b640d5512b767e2b881bf8415bc2e2f954bb49e0ba%3A2%3A%7Bi%3A0%3Bs%3A12%3A%22current_path%22%3Bi%3A1%3Bs%3A36%3A%2249bc7ffa-ddec-11dc-8709-00151716f9f5%22%3B%7D;");

        target.setUrl("https://www.dns-shop.ru/product/c3e78bbf16393361/101-planset-asus-transformer-book-t100-chi-64-gb--klaviatura--seryj/");

        target.addSelector("div.clearfix");
        target.addSelector("span[data-role=current-price-value]");

        target.addPrevValueSelector("div.clearfix");
        target.addPrevValueSelector("s.prev-price-total");

        Optional<Result> result1 = ex.get(target);

        result1.ifPresent(res -> {
            log.info("Name: {}", target.getName());
            log.info("Price: " + res.getValue());
            if (res.getPrevValue() != null) {
                log.info("Old price: " + res.getPrevValue());
            }
        });
    }
}

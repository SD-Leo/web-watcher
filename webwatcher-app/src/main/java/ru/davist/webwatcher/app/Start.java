package ru.davist.webwatcher.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.davist.webwatcher.core.DnsExtractor;
import ru.davist.webwatcher.core.Extractor;
import ru.davist.webwatcher.core.JbExtractor;
import ru.davist.webwatcher.domain.Result;

import java.io.IOException;
import java.util.Optional;

/**
 * on 18/11/2017.
 *
 * @author danil
 */
public class Start {

    private static final Logger log = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) throws IOException {

        Extractor ex = new DnsExtractor();

//        String url = "https://www.dns-shop.ru/product/c3e78bbf16393361/101-planset-asus-transformer-book-t100-chi-64-gb--klaviatura--seryj/";
//        Optional<Result> result = ex.get(url);
//
//        result.ifPresent(res -> {
//            log.info("Price: " + res.getValue());
//            if (res.getOldValue() != null) {
//                log.info("Old price: " + res.getOldValue());
//
//            }
//        });
//
//        log.debug("111");


        ex = new JbExtractor();
        Optional<Result> result1 = ex.get("https://www.jetbrains.com/idea/buy/#edition=personal");

        result1.ifPresent(res -> {
            log.info("Price: " + res.getValue());
            if (res.getOldValue() != null) {
                log.info("Old price: " + res.getOldValue());

            }
        });


//        result = ex.get("https://www.dns-shop.ru/product/cd363dc335473330/101-netbuk-irbis-nb26-fioletovyj/");
//
//        result.ifPresent(result1 -> {
//            log.info("Price: " + result1.getValue());
//            if (result1.getOldValue() != null) {
//                log.info("Old price: " + result1.getOldValue());
//
//            }
//        });


    }
}

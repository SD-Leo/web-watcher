package ru.davist.webwatcher.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.davist.webwatcher.core.DnsExtractor;
import ru.davist.webwatcher.core.Extractor;

import java.io.IOException;

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
//            if (res.getPrevValue() != null) {
//                log.info("Old price: " + res.getPrevValue());
//
//            }
//        });
//
//        log.debug("111");


//        ex = new JbExtractor();
//        WantedTarget target = new WantedTarget();
//        target.setUrl("https://www.jetbrains.com/idea/buy/#edition=personal");
//        Optional<Result> result1 = ex.get(target);
//
//        result1.ifPresent(res -> {
//            log.info("Price: " + res.getValue());
//            if (res.getPrevValue() != null) {
//                log.info("Old price: " + res.getPrevValue());
//
//            }
//        });


//        result = ex.get("https://www.dns-shop.ru/product/cd363dc335473330/101-netbuk-irbis-nb26-fioletovyj/");
//
//        result.ifPresent(result1 -> {
//            log.info("Price: " + result1.getValue());
//            if (result1.getPrevValue() != null) {
//                log.info("Old price: " + result1.getPrevValue());
//
//            }
//        });


    }
}

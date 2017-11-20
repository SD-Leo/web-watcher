package ru.davist.webwatcher.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.davist.webwatcher.domain.Result;

import java.io.IOException;
import java.util.Optional;

/**
 * on 19/11/2017.
 *
 * @author danil
 */
public class DnsExtractor implements Extractor {

    private static final Logger log = LoggerFactory.getLogger(DnsExtractor.class);

    @Override
    public Optional<Result> get(String url) {

        try {
            Element body = Jsoup.connect(url).get().body();

            log.info("Город: {}", body.getElementsByClass("city-select w-choose-city-widget").first().text());

            Elements elems = body.getElementsByAttributeValue("data-role", "current-price-value");
            if (elems == null) {
                log.info("Elements are not found");
                return Optional.empty();
            }
            log.info("elemets found: {}", elems.size());
            if (elems.size() > 1) {
                elems.forEach(element -> log.info("{}", element));
            }
            String value = elems.first().attr("data-price-value");


            String oldValue = null;
            elems = body.getElementsByAttributeValue("data-role", "previous-price-value");
            if (elems == null || elems.size() == 0) {
                log.info("Elements 'previous-price-value' are not found");
//                return Optional.empty();
            } else {
                oldValue = elems.first().attr("data-price-value");
            }

            return Optional.of(new Result(value, oldValue));
        } catch (IOException e) {
            return Optional.empty();
        }

    }
}

/*
 * 2017-11-21
 */
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
 * @author Starovoytov Danil
 */
public class JbExtractor implements Extractor {

    private static final Logger log = LoggerFactory.getLogger(JbExtractor.class);

    @Override
    public Optional<Result> get(String url) {

        try {
            Element body = Jsoup.connect(url).get().body();

//            log.info("Город: {}", body.getElementsByClass("city-select w-choose-city-widget").first().text());

            Elements elems = body.select("div[data-id=personal]")
                .select("div._spacer")
                .select("div[data-id=yearly]")
                .select("div[data-user-license=new]")
                .select("span.price-list__first-year")
                .select("span.-current__price");
//            Elements elems = body.getElementsByAttributeValue("data-role", "current-price-value");
            if (elems == null || elems.size() == 0) {
                log.info("Elements are not found");
                return Optional.empty();
            }
            log.info("elemets found: {}", elems.size());
            if (elems.size() > 1) {
                elems.forEach(element -> log.info("{}", element));
            }
//            log.debug("First: {}", elems.first());
            String value = elems.first().text();

            return Optional.of(new Result(value));
        } catch (IOException e) {
            return Optional.empty();
        }

    }
}

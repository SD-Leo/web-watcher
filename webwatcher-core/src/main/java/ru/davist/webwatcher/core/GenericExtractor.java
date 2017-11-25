/*
 * 2017-11-22
 */
package ru.davist.webwatcher.core;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.davist.webwatcher.domain.Result;
import ru.davist.webwatcher.domain.WantedTarget;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Starovoytov Danil
 */
public class GenericExtractor implements Extractor {

    private static final Logger log = LoggerFactory.getLogger(GenericExtractor.class);

    @Override
    public Optional<Result> get(WantedTarget target) {
        try {
            Connection conn = Jsoup.connect(target.getUrl());
            if (target.getCookies() != null && !target.getCookies().isEmpty()) {
                conn.cookies(target.getCookies());
            }
            Element body = conn.get().body();

            Elements elems = null;

            if (target.getSelectors().isEmpty()) {
                log.debug("No selectors are found!");
                return Optional.empty();
            }

            boolean isFirst = true;
            for (String selectorQuery : target.getSelectors()) {
                if (isFirst) {
                    elems = body.select(selectorQuery);
                    isFirst = false;
                } else {
                    elems = elems.select(selectorQuery);
                }
            }
            if (elems != null && elems.size() != 0) {
                if (elems.size() > 1) {
                    log.info("Elemets found: {}", elems.size());
                    elems.forEach(element -> log.info("{}", element));
                }
                String value = elems.first().text();
                Result result = new Result(value);
                result = findOldPrice(target.getPrevValueSelectors(), body, result);
                return Optional.of(result);
            }
            log.info("Elements are not found");
            return Optional.empty();

        } catch (IOException e) {
            log.error("", e);
            return Optional.empty();
        }
    }

    private Result findOldPrice(List<String> selectors, Element body, Result result) {
        if (selectors != null && !selectors.isEmpty()) {
            Elements elems = null;
            boolean isFirst = true;
            for (String selectorQuery : selectors) {
                if (isFirst) {
                    elems = body.select(selectorQuery);
                    isFirst = false;
                } else {
                    elems = elems.select(selectorQuery);
                }
            }
            if (elems != null && elems.size() != 0) {
                if (elems.size() > 1) {
                    log.info("elemets found: {}", elems.size());
                    elems.forEach(element -> log.info("{}", element));
                }
                String value = elems.first().text();
                result.setPrevValue(value);
            }
        }
        return result;
    }
}

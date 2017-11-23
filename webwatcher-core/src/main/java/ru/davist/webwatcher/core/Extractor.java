package ru.davist.webwatcher.core;

import ru.davist.webwatcher.domain.Result;
import ru.davist.webwatcher.domain.WantedTarget;

import java.util.Optional;

/**
 * on 19/11/2017.
 *
 * @author danil
 */
public interface Extractor {

    Optional<Result> get(WantedTarget target);
}

/**
 * 10.02.2016
 */
package ru.davist.webwatcher.core.phantom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author StarovoytovD
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PhantomjsTest {

    private static final Logger log = LoggerFactory.getLogger(PhantomjsTest.class);

    @Test
    public void test() {

        File file = new File("/Users/danil/devel/bin/phantomjs-2.1.1-macosx/bin/phantomjs");

        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

        PhantomJSDriver driver = new PhantomJSDriver();
        driver.get("http://www.dns-shop.ru/product/014cb074033a3361/45-plenka-zasitnaa-dla-smartfona-red-line-ut000006696/");
        WebElement element = driver.findElement(By.className("price_g"));

//        driver.getScreenshotAs();

        log.info("Value: " + element.getText());

        driver.close();
    }
}

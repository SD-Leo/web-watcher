/**
 * 10.02.2016
 */
package ru.davist.webwatcher.core.phantom;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author StarovoytovD
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PhantomjsTest {

    private static final Logger log = LoggerFactory.getLogger(PhantomjsTest.class);

    @Test
    public void test() throws IOException {

        File file = new File("/Users/danil/devel/bin/phantomjs-2.1.1-macosx/bin/phantomjs");

        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

        PhantomJSDriver driver = new PhantomJSDriver();
//        driver.get("http://www.dns-shop.ru/product/014cb074033a3361/45-plenka-zasitnaa-dla-smartfona-red-line-ut000006696/");
        driver.get("http://store.steampowered.com/app/578080/PLAYERUNKNOWNS_BATTLEGROUNDS/");
//        WebElement element = driver.findElement(By.className("price_g"));
        driver.manage().window().setSize(new Dimension(1366, 768));


        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("target/1.jpg"));


//        log.info("Value: " + element.getText());

        driver.close();
    }
}

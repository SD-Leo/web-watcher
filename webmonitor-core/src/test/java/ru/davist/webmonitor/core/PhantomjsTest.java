/**
 * 10.02.2016
 */
package ru.davist.webmonitor.core;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

/**
 * @author StarovoytovD
 */
public class PhantomjsTest {

    @Test
    public void test() {

        File file = new File("/home/sdv/Downloads/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");

        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.dns-shop.ru/product/014cb074033a3361/45-plenka-zasitnaa-dla-smartfona-red-line-ut000006696/");
        WebElement element = driver.findElement(By.className("price_g"));

        System.out.println("111: " + element.getText());

        driver.close();
    }
}

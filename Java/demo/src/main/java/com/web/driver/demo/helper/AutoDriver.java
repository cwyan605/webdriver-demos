package com.web.driver.demo.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @ClassName AutoDriver
 * @Description
 * @Author cwyan
 * @Date 2019/5/7 下午4:15
 **/
public class AutoDriver {

    public static void run() {
        // chromedriver本地位置, 下载地址：http://chromedriver.chromium.org/downloads
        String driverAddress = "/Users/samen/downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverAddress);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        //输入关键词webdriver
        driver.findElement(By.id("kw")).sendKeys("webdriver");

        //点击搜索
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("su"))).click();

        try {
            //等待3s后关闭driver
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}

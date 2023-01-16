package org.example.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverManager {

    private AppiumDriver driver;

    public AppiumDriver getDriver() {
        return driver;
    }

    public AppiumDriver setDriver(String platformName) {
        if (platformName == null) {
            driver = initAndroidDriver();
            return driver;
        }
        switch (platformName) {
            case "android":
                driver = initAndroidDriver();
                break;
            case "iOS":
                driver = initIOSDriver();
                break;
        }
        return driver;
    }

    @SneakyThrows
    private AppiumDriver initAndroidDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "RFCR90SPG4J");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "/Users/gabrielmustata/IdeaProjects/student-appium-framework/apps/WhatsApp.apk");
        capabilities.setCapability("appPackage", "com.whatsapp");
        capabilities.setCapability("appActivity", "com.whatsapp.HomeActivity");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    @SneakyThrows
    private AppiumDriver initIOSDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "");
        capabilities.setCapability("platformName", "");
        capabilities.setCapability("platformVersion", "");
        capabilities.setCapability("app", "");
        capabilities.setCapability("udid", "");
        capabilities.setCapability("automationName", "");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.quit();

    }
}

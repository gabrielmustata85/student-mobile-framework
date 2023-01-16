package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.example.config.AppiumDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class OnBoardingScreen {

    AppiumDriverManager driverManager;
    /**
     * Initialize Page factory with Appium Field Decorator
     *
     * @param driver
     */
    public OnBoardingScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Înainte\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "")
    private By nextButton;

    public OnBoardingScreen clickNext(){
//        actionHelper.clickOn(nextButton);
//        mouseAction.clickOn(nextButton);
        return this;
    }
}

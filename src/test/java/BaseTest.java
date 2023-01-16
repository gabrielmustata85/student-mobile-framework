
import org.example.config.AppiumDriverManager;
import org.example.screens.OnBoardingScreen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

    AppiumDriverManager driver;
    protected OnBoardingScreen onBoardingScreen;


    @Parameters("platformName")
    @BeforeClass
    public void startDriver(@Optional String platformName) {
        driver = new AppiumDriverManager();
        driver.setDriver(platformName);
        onBoardingScreen = new OnBoardingScreen(driver.getDriver());
    }



    @AfterTest
    public void stopDriver(){
        driver.closeDriver();
    }
}

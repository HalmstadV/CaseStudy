package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.factories.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static AndroidDriver<MobileElement> driver;

    public BaseTest() {
        setUp();
    }

    @BeforeClass
    public static void setUp() {
        driver = DriverFactory.createDriver();
        driver.stopRecordingScreen();
    }

    @AfterClass
    public static void tearDown() {
        driver.stopRecordingScreen();
        driver.quit();
    }
}

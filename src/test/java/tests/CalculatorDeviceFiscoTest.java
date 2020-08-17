package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class CalculatorDeviceFiscoTest {
    @Test
    public void somarValores() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "qualquer");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.miui.calculator");
        desiredCapabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub")
                , desiredCapabilities);

        MobileElement el0 = (MobileElement) driver.findElementById("android:id/button1");
        el0.click();
        MobileElement el1 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_5_s");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("multiplicação");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_5_s");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual a");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.miui.calculator:id/result");


        assertEquals("= 25", el5.getText());

        driver.quit();

    }
}

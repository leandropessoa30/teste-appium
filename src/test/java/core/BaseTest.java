package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.*;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizaClasse(){
        killDriver();
    }

    @After
    public void tearDown() {
        gerarScreenshot();
        resetApp();
    }

    public void gerarScreenshot(){
        try {
            File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/"+ testName.getMethodName() +".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

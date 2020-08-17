package core;

import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class BasePage {

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto){
        getDriver().findElement(By.xpath("//*[@text='"+ texto +"']")).click();
    }

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + valor + "']")).click();
    }

    public boolean isMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public void marca(By by) {
        if (!isMarcado(by)) {
            clicar(by);
        }
    }

    public void desmarca(By by) {
        if (isMarcado(by)) {
            clicar(by);
        }
    }

}

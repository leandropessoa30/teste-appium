package pages;

import core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FormularioPage extends BasePage {

    private AndroidDriver<MobileElement> driver;

    private By campoNome = MobileBy.AccessibilityId("nome");
    private By comboConsole = MobileBy.AccessibilityId("console");
    private By valorConsole = By.xpath("//android.widget.Spinner/android.widget.TextView");
    private By checkbox = By.className("android.widget.CheckBox");
    private By switc = MobileBy.AccessibilityId("switch");
    private By nomeSalvo = By.xpath("//android.widget.TextView[starts-with(@text, 'Nome: ')]");
    private By consoleSalvo = By.xpath("//android.widget.TextView[starts-with(@text, 'Console: ')]");
    private By switchSalvo = By.xpath("//android.widget.TextView[starts-with(@text, 'Switch: ')]");
    private By checkboxSalvo = By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox: ')]");

    public void escreverNome(String nome) {
        escrever(campoNome, nome);
    }

    public String obterNome() {
        return obterTexto(campoNome);
    }

    public void selecionaConsole(String console) {
        selecionarCombo(comboConsole, console);
    }

    public String obterConsole() {
        return obterTexto(valorConsole);
    }

    public boolean isSelecionadoCheck() {
        return isMarcado(checkbox);
    }

    public boolean isSelecionadoSwitch() {
        return isMarcado(switc);
    }

    public void marcarCheckbox() {
        if (!isSelecionadoCheck()) {
            clicar(checkbox);
        }
    }

    public void marcarSwitch() {
        if (!isSelecionadoSwitch()) {
            clicar(switc);
        }
    }

    public void desmarcarCheckbox() {
        if (isSelecionadoCheck()) {
            clicar(checkbox);
        }
    }

    public void desmarcarSwitch() {
        if (isSelecionadoSwitch()) {
            clicar(switc);
        }
    }

    public void salver(){
        clicarPorTexto("SALVAR");
    }

    public String obterNomeSalvo(){
        return obterTexto(nomeSalvo);
    }

    public String obterConsoleSelecionado(){
        return obterTexto(consoleSalvo);
    }

    public String opacaoConsoleInformada(String opcao){
        String validaConsole = "";
        if ("Nintendo Switch".equals(opcao)) {
            validaConsole = "switch";
        } else if ("XBox One".equals(opcao)) {
            validaConsole = "one";
        } else if ("PS4".equals(opcao)) {
            validaConsole = "ps4";
        }
        return validaConsole;
    }

    public String obterValorSwitchSalvo(){
        return obterTexto(switchSalvo);
    }

    public String obterValorCheckboxSalvo(){
        return obterTexto(checkboxSalvo);
    }


}

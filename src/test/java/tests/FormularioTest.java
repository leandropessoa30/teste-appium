package tests;

import core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.FormularioPage;
import pages.MenuPage;

import static org.junit.Assert.*;

public class FormularioTest extends BaseTest {

    private static final String NOME = "Testando";
    private static final String OPCAO_CONSOLE = "Nintendo Switch";
    private static final String CHECKBOX = "Marcado";
    private static final String SWITC = "On";
    private MenuPage menu = new MenuPage();
    private FormularioPage form = new FormularioPage();

    @Before
    public void setup() {
        menu.acessarFormulario();
    }

    @Test
    public void devePreencherNome() {
        form.escreverNome(NOME);
        assertEquals(NOME, form.obterNome());
    }

    @Test
    public void deveInteragirComCombo() {
        form.selecionaConsole(OPCAO_CONSOLE);
        assertEquals(OPCAO_CONSOLE, form.obterConsole());
    }

    @Test
    public void deveInteragirSwitchCheckbox() {
        //verificar estado
        assertFalse(form.isSelecionadoCheck());
        assertTrue(form.isSelecionadoSwitch());

        //interagir
        form.marcarCheckbox();
        form.desmarcarSwitch();

        //verificar estado alterado
        assertTrue(form.isSelecionadoCheck());
        assertFalse(form.isSelecionadoSwitch());
    }

    @Test
    public void devePreencherValidarFormulario() {

        form.escreverNome(NOME);
        form.selecionaConsole(OPCAO_CONSOLE);

        form.marcarSwitch();
        //Seleciona Checkbox e switch
        if (CHECKBOX.equalsIgnoreCase("Marcado")) {
            form.marcarCheckbox();
        } else {
            form.desmarcarCheckbox();
        }

        if (SWITC.equalsIgnoreCase("On")) {
            form.marcarSwitch();
        } else {
            form.desmarcarSwitch();
        }

        //Salvar
        form.salver();

        //Validar dados salvos
        //- Nome
        assertEquals("Nome: " + NOME, form.obterNomeSalvo());
        assertEquals("Console: " + form.opacaoConsoleInformada(OPCAO_CONSOLE), form.obterConsoleSelecionado());
        //Valida Switch
        assertEquals("Switch: " + SWITC, form.obterValorSwitchSalvo());
        //Valida CheckBox
        assertEquals("Checkbox: " + CHECKBOX, form.obterValorCheckboxSalvo());

    }

}

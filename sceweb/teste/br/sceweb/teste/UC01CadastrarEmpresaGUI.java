package br.sceweb.teste;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresaGUI {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private EmpresaDAO empresaDAO;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"C://Users/esadv6/git/repositorio7/sceweb/WebContent/WEB-INF/lib/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void testUC01CadastrarEmpresaGUI() throws Exception {
		driver.get(baseUrl + "/sceweb/visao/FormEmpresa.jsp");
		driver.findElement(By.id("campo")).clear();
		driver.findElement(By.id("campo")).sendKeys("Open Informatica Ltda");
		driver.findElement(By.name("txtCNPJ")).clear();
		driver.findElement(By.name("txtCNPJ")).sendKeys("50658639000137");
		driver.findElement(By.name("txtNomeFantasia")).clear();
		driver.findElement(By.name("txtNomeFantasia")).sendKeys("Open Informatica");
		driver.findElement(By.name("txtEndereco")).clear();
		driver.findElement(By.name("txtEndereco")).sendKeys("Rua Aguia de Haia, 2432");
		driver.findElement(By.name("txtTelefone")).clear();
		driver.findElement(By.name("txtTelefone")).sendKeys("121212");
		driver.findElement(By.name("txtResponsavel")).clear();
		driver.findElement(By.name("txtResponsavel")).sendKeys("jose carlos");
		driver.findElement(By.name("txtTelefoneResponsavel")).clear();
		driver.findElement(By.name("txtTelefoneResponsavel")).sendKeys("111221");
		driver.findElement(By.name("txtSetor")).clear();
		driver.findElement(By.name("txtSetor")).sendKeys("contabilidade");
		driver.findElement(By.name("txtEmail")).clear();
		driver.findElement(By.name("txtEmail")).sendKeys("jose@gmail.com");
		driver.findElement(By.id("botao")).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mensagem")));
			assertEquals("cadastro realizado com sucesso", driver.findElement(By.id("mensagem")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.exclui("50658639000137");
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}

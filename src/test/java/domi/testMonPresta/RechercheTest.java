package domi.testMonPresta;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.time.Duration;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.openqa.selenium.support.PageFactory;


public class RechercheTest {
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private pageAccueil accueil;




	@BeforeEach
	public void setUp() throws Exception {

		// creation du driver
		driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-search-engine-choice-screen"));
		baseUrl = "http://www.qualifiez.fr/monPrestashop2/prestashop/index.php";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get(baseUrl);
		accueil =  PageFactory.initElements(driver, pageAccueil.class);


	};

	// faire une recherche sur des MUGs
	@Test
	public void testRecherche() throws Exception {
	}
	// faire une recherche qui n'aboutit pas 
	@Test
	public void testRechercheInfructueuse() throws Exception {
	}
	// faire une recherche vide
	@Test
	public void testRechercheInfructueuseVide() throws Exception {
	}
	@AfterEach
	public  void tearDown() throws Exception {
		driver.quit();
	}




}




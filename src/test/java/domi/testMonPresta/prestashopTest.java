package domi.testMonPresta;
import java.util.regex.Pattern;
import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.*;

import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class prestashopTest {
	private WebDriver driver;  
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private HashMap<String, Object> vars;
	//  private Util monUtil;
	final static Logger logger = Logger.getLogger(domi.testMonPresta.prestashopTest.class);
	private String PrestaShopURL="http://www.qualifiez.fr/monPrestashop2/prestashop/index.php?";



	@BeforeEach
	public void setUp() throws Exception {
		driver = new ChromeDriver(); 
		driver.get(PrestaShopURL);

        // commandes pour lancer un profile firefox spécifique
//		FirefoxOptions options = new FirefoxOptions();
//		FirefoxProfile monProfil = new FirefoxProfile(new File("/Users/dominiquemereaux/Library/Application Support/Firefox/Profiles/rfqfjl41.monProfil"));
//		options.setProfile(monProfil);
		//	driver = new FirefoxDriver(options);
//		DesiredCapabilities capabilities = new DesiredCapabilities().edge();
//		driver = new RemoteWebDriver(new URL("http://192.168.1.34:4444/wd/hu//b"),capabilities);
		

	}
	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "donnees.csv", numLinesToSkip = 1)
	public void testPrestashopParam(String input, String expected) throws Exception {
	} 
	// Utilisation des fonctions de base + attente explicite
	@Test 
	public void chercherLeMugAttenteCliquable() throws InterruptedException, MalformedURLException {
	}


	@Test 
	public void chercherLeMugHeadless() throws InterruptedException, MalformedURLException {
		driver.quit();
		ChromeOptions option = new ChromeOptions();
		// commandes pour lancer un chrome particulier
		//	 	option.addArguments("--profile-directory='Guest Profile'");
		//	 	option.addArguments("user-data-dir=/Users/dominiquemereaux/Library/Application Support/Google/Chrome"); 


	}
	// checker la Box et vérifier qu'elle est checkée
	@Test 
	public void checkerLaBOX() throws InterruptedException {

	}

	//tester la frame apres avoir accepter la modale
	@Test 
	public void testLaFrame() throws InterruptedException, IOException {

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_option");


	}
	// exemple mobiles
///	@Test 
	
	public void chercherLeMugAvecBouton() throws MalformedURLException {
		driver.quit();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session on android web");
		capabilities.setCapability("sessionDescription", "This is example android web testing"); 
		capabilities.setCapability("deviceOrientation", "portrait"); 
		capabilities.setCapability("platformName", "android"); 
		capabilities.setCapability("browserName", "chrome"); 
		capabilities.setCapability("deviceName", "M10");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("chromedriverExecutable", "/Users/dominiquemereaux/code/RobotFramework/Appium/chromedriver");
		

		// Création d'un remote driver pour se connecter au serveur APPIUM
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.get("http://prestashop.qualifiez.fr/en/");

		driver.findElement(By.name("s")).sendKeys("MUG");
		driver.findElement(By.cssSelector("#search_widget > form > button > i")).click();
		assertEquals(driver.getTitle(),"Search");	   
		driver.quit();
	}

	// compter les fenêtres
	@Test
	public void compterLesFenetres() {

		driver.get("http://www.qualifiez.fr/examples/Selenium/project-list.php");
		driver.findElement(By.id("btnNewWindow")).click();
		assertEquals ("Projets",driver.getTitle());
		Set<String> set = driver.getWindowHandles();
		assertEquals(2,set.size());
		driver.switchTo().window("toto");
		assertEquals ("My Window",driver.getTitle());
		System.out.print("Handle: " + driver.getWindowHandle());


	}
	// Utiliser la classe action
	@Test
	public void testActions() throws Exception {
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		Action mouseOverClothes = builder.moveToElement(driver.findElement(By.cssSelector("#category-3 > a"))).build();
		mouseOverClothes.perform();
		assertTrue(driver.findElement(By.xpath("//*[@id='category-4']/a")).isDisplayed());

	} 


	@Test
	// Traitement des alertes
	public void testPrestashopALerte() throws Exception {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.findElement(By.id("accept-choices")).click();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//*[@onclick='myFunction()']")).click();
     
		Wait<WebDriver> MonAttente = new WebDriverWait(driver, Duration.ofSeconds(2));
        MonAttente.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		assertEquals("Hello! I am an alert box!", alert.getText());
		alert.accept();

	}
	@Test
	// Traitement des alertes
	public void testPrestashopALerteAccepteA() throws Exception {
		driver.quit();
		ChromeOptions option = new ChromeOptions();
		option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
		driver= new ChromeDriver(option);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.findElement(By.id("accept-choices")).click();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//*[@onclick='myFunction()']")).click();
		Thread.sleep(2);
		// on peut cliquer sans fermer l'alerte
		driver.findElement(By.xpath("//*[@onclick='myFunction()']")).click();
		driver.quit();

	}



//	@Test
	//exemple avec une application mobile
	public void testPrestashopAPK() throws Exception {

		// Definition du mobile sur lequel on va exécuter les tests
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session on android web");
		capabilities.setCapability("sessionDescription", "This is example android web testing"); 
		capabilities.setCapability("deviceOrientation", "portrait"); 
		capabilities.setCapability("platformName", "android"); 
		capabilities.setCapability("app", "/Users/dominiquemereaux/AndroidStudioProjects/Dice/app/build/outputs/apk/app-debug.apk"); 
		capabilities.setCapability("deviceName", "M10");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.dominiquemereaux.dice");	  
		// Création d'un remote driver pour se connecter au serveur APPIUM
//		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		URL remoteUrl = new URL("http://127.0.0.1:4723//wd/hub");
//		driver = new AndroidDriver(remoteUrl, capabilities);




	}
	@AfterEach
	public void tearDown() throws Exception {
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

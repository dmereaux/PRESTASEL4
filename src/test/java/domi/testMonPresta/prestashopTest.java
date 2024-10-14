package domi.testMonPresta;
import java.util.regex.Pattern;
import java.io.File;

import java.io.IOException;
import java.io.OutputStream;
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
	private static String baseUrl;
	private WebDriver driver;  
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private HashMap<String, Object> vars;
	//  private Util monUtil;
	final static Logger logger = Logger.getLogger(domi.testMonPresta.prestashopTest.class);




	@BeforeEach
	public void setUp() throws Exception {
		ChromeOptions options = new ChromeOptions();
//		FirefoxOptions options =new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
//		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		options.addArguments("--disable-search-engine-choice-screen");
//		options.setCapability("platformName", "Windows");
//		options.setCapability("browserName", "Firefox");
//		WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), options);
		driver=new ChromeDriver(options);
//		driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-search-engine-choice-screen").addArguments("--headless"));
		baseUrl = "http://www.qualifiez.fr/monPrestashop2/prestashop/index.php";
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60))////;
		driver.get(baseUrl);

        // commandes pour lancer un profile firefox spécifique
//		FirefoxOptions options = new FirefoxOptions();
//		FirefoxProfile monProfil = new FirefoxProfile(new File("/Users/dominiquemereaux/Library/Application Support/Firefox/Profiles/u58bocqf.Utilisateur par défaut"));
//		options.setProfile(monProfil);
//		driver = new FirefoxDriver(options);
//		driver.get(baseUrl);
//		DesiredCapabilities capabilities = new DesiredCapabilities().edge();
//		driver = new RemoteWebDriver(new URL("http://192.168.1.34:4444/wd/hub"),capabilities);
		

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
	
	// faire le test de recherche de MUG
	@Test 
	public void chercherLeMug() throws InterruptedException, IOException {
		WebElement elt = driver.findElement(By.name("s"));
		driver.findElement(By.name("s")).sendKeys("MUG");
//		System.out.print(driver.findElement(By.name("s")).getSize());
//		assertEquals("MUG",driver.findElement(By.name("s")).getAttribute("value"));
		driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		TakesScreenshot copieEcran = (TakesScreenshot)driver;
		File depart = copieEcran.getScreenshotAs(OutputType.FILE);
		File destination= new File("./toto.png");
		Files.copy(depart, destination);
		assertEquals("Il y a 5 produits.",driver.findElement(By.cssSelector("#js-product-list-top > div.col-lg-5.hidden-sm-down.total-products > p")).getText(),"dffiyugouiy");
	    
	}
	@Test 
	public void apparitionMenu() throws InterruptedException, MalformedURLException {
	    assertFalse(driver.findElement(By.xpath("//*[@id=\"category-4\"]/a")).isDisplayed());
	}
	

	@Test 
	public void chercherLeMugAttenteChampVisaible() throws InterruptedException, MalformedURLException {

		
	    WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(30)));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("s"))));
		driver.findElement(By.name("s")).sendKeys("MUG");
		driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		assertEquals("Il y a 5 produits.",driver.findElement(By.cssSelector("#js-product-list-top > div.col-lg-5.hidden-sm-down.total-products > p")).getText(),"dffiyugouiy");

	}


	// lancer le test en mode headless
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
		driver.get("http://www.qualifiez.fr/monPrestashop2/prestashop/index.php?id_product=1&id_product_attribute=1&rewrite=hummingbird-printed-t-shirt&controller=product#/1-taille-s/8-couleur-blanc");
		
//		List<WebElement> lesOptions = driver.findElements(By.xpath("//*[@id='group_1']//option"));
//        for (WebElement elt : lesOptions)
//        {
//        	System.out.println(elt.getText());
//        	System.out.println(elt.isSelected());
//        }
        //sélectionner M
//        driver.findElement(By.xpath("//*[@id=\"group_1\"]")).click();
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.xpath("//*[@id='group_1']/option[@title='M']")).isEnabled());
		assertTrue(driver.findElement(By.xpath("//*[@id='group_1']/option[@title='M']")).isDisplayed());
		WebElement elt = driver.findElement(By.xpath("//*[@id='group_1']/option[@title='M']"));
//		elt.click();
		((JavascriptExecutor)driver).executeScript("document.getElementById('group_1').selectedIndex=1");
		Thread.sleep(2000);
		elt = driver.findElement(By.xpath("//*[@id='group_1']/option[@title='M']"));
        assertTrue(elt.isSelected());
        	
	}

	//tester la frame apres avoir accepter la modale
	@Test 
	public void testLaFrame() throws InterruptedException, IOException {

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_option");
		WebElement maFrame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(maFrame);
		assertEquals("Choose a car:",driver.findElement(By.xpath("/html/body/label")).getText());

	}
	// exemple mobiles
	@Test 
	
	public void chercherLeMugMobile() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "android"); 
		capabilities.setCapability("browserName", "chrome"); 
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		capabilities.setCapability("appium:platformVersion", "10");
		capabilities.setCapability("appium:chromedriverExecutable", "/Users/dominiquemereaux/code/appium/chromedriver");

		// Création d'un remote driver pour se connecter au serveur APPIUM
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/"), capabilities);
		driver.get("http://www.qualifiez.fr/monPrestashop2/prestashop/index.php");
		driver.findElement(By.name("s")).sendKeys("MUG");
		driver.findElement(By.cssSelector("#search_widget > form > button > i")).click();
		assertEquals(driver.getTitle(),"Search");	   
		driver.quit();
	}

	// compter les fenêtres
	@Test
	public void compterLesFenetres() {

		driver.get("http://www.qualifiez.fr/examples/Selenium/project-list.php");
		String hdl = driver.getWindowHandle();
		System.out.print(driver.getWindowHandle());
		driver.findElement(By.id("btnNewWindow")).click();
		assertEquals("Projets",driver.getTitle());
		driver.switchTo().window("toto");
		assertEquals("My Window",driver.getTitle());
		Set<String> fen = driver.getWindowHandles();
		assertEquals(fen.size(),2);
		driver.switchTo().window(hdl);
		assertEquals("Projets",driver.getTitle());

	}
	// Utiliser la classe action
	@Test
	public void testActions() throws Exception {
		Actions builder = new Actions(driver);
	    assertFalse(driver.findElement(By.xpath("//*[@id=\"category-4\"]/a")).isDisplayed());
	    Action survolerVetement = builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"category-3\"]"))).build();
	    survolerVetement.perform();
	    assertTrue(driver.findElement(By.xpath("//*[@id=\"category-4\"]/a")).isDisplayed());
	    Action allerSurHomme =  builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"category-3\"]"))).click(driver.findElement(By.xpath("//*[@id=\"category-4\"]/a"))).build();
	    allerSurHomme.perform();
	    assertEquals("Hommes",driver.getTitle());
	} 


	@Test
	// Traitement des alertes
	public void testPrestashopALerte() throws Exception {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		//accepter la modale
		driver.findElement(By.id("accept-choices")).click();
		//switcher sur la frame
		driver.switchTo().frame("iframeResult");
		//cliquer sur le bouton try it
		driver.findElement(By.tagName("button")).click();
		//switch alert
		Alert alert = driver.switchTo().alert();
		//contrôle du texte
		assertEquals("Hello! I am an alert box!",alert.getText());
		alert.accept();


	}
	@Test
	// Traitement des alertes
	public void testPrestashopALerteAccepteA() throws Exception {

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

package domi.testMonPresta;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import domi.testMonPresta.pageRecherche;


public class pageAccueil {
	
	private WebDriver driverAccueil;

	@FindBy(how = How.XPATH, using = "//*[@id='search_widget']/form/input[2]")
    private WebElement champRecherche;

	public pageAccueil(WebDriver driver){
		driverAccueil = driver;
	}
//	@Step("Rechercher les MUG")
	public pageRecherche rechercher(String mot)
	{
		   return PageFactory.initElements(driverAccueil, pageRecherche.class);
	}


}

	



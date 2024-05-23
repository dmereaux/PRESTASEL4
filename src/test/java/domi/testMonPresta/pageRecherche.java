package domi.testMonPresta;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class pageRecherche {

	private WebDriver driverRecherche;
	@FindBy(how = How.XPATH, using = "//*[@id='js-product-list-top']/div[1]/p")
    private WebElement resRecherche;
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-search-no-matches\"]")
	private WebElement rienTrouve;
	@FindBy(how = How.XPATH, using = "//*[@id='js-product-list-top']/div[2]/div/div/button")
	private WebElement listeTri;	
	@FindBy(how = How.XPATH, using = "//*[@id='js-product-list-top']/div[2]/div/div/div/a")
	private List<WebElement> items;
	@FindBy(how = How.XPATH, using = "//*[@id=\"search_widget\"]/form/input[2]")
	private WebElement valeur;
	@FindBy(how = How.XPATH, using = "//article//*[@price]")
	private List<WebElement> prices;





	public pageRecherche(WebDriver driverAccueil) {
		driverRecherche = driverAccueil;
	    if (!"Rechercher".contentEquals(driverRecherche.getTitle()))
	    { throw new IllegalStateException ("pas la page pour RECHERCHER" +driverAccueil.getTitle() ); 	}
	}
   public String nbElementTrouve()
   {
	   return resRecherche.getText();
   }
   public String PasDeResultat()
   
   {
	   return rienTrouve.getText();
   }
   public pageRecherche trier(String item)
   {
	   listeTri.click();
	   for (WebElement elt :items )
	   {
		   if (elt.getText().contains(item))
			   elt.click();
	   }
	   return this;
   }
   public String valeurRecherchee()
   {
	   return valeur.getAttribute("value");
   }
   public boolean verifierTri()
   {
 	  Integer initialVal=0;
 	   for (WebElement elt :prices )
 	   {
 		   String prixS = elt.getText();
 		   prixS.substring(1);
 		   int prix = Integer.parseInt(prixS);
 		   if (prix < initialVal)
 			   return false;
 		   initialVal=prix;
 	   }

 	  return true;
   }

public boolean verifierPertinence()
{

	for ( WebElement elt : items) {
		if(!elt.getText().contains("Mug"))
			return false;
	}
	return true;


}
}


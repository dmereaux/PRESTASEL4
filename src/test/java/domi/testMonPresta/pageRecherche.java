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

	public pageRecherche(WebDriver driverAccueil) {
		driverRecherche = driverAccueil;
	    if (!"Rechercher".contentEquals(driverRecherche.getTitle()))
	    { throw new IllegalStateException ("pas la page pour RECHERCHER" +driverAccueil.getTitle() ); 	}
	}
   public String nbElementTrouve()
   {
	return null;
   }
   public String PasDeResultat()
   
   {
	return null;
   }
   public pageRecherche trier(String item)
   {
	return this;
   }
   public String valeurRecherchee()
   {
	return null;
   }
   public boolean verifierTri()
   {
	return false;
   }


}


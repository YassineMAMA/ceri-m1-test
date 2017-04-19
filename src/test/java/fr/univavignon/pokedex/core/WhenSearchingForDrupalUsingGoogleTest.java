package fr.univavignon.pokedex.core;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;



public class WhenSearchingForDrupalUsingGoogleTest {
	
	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup(); //PhantomJs car inutile de faire du chrome sur CircleCI
	}

	
	/**
	 * setup
	 */
	@Before
	public void setUp() {
		final String baseUrl = "https://pokeassistant.com/main/ivcalculator?locale=en";
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@After
	public void after() throws IOException {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void pageTitleAfterSearchShouldBeginWithDrupal() {
		
		try{
			((WebElement) driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]"))).sendKeys("Bulbasaur");
			((WebElement) driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/span/div/div/div"))).click();
			((WebElement) driver.findElement(By.xpath("//*[@id=\"search_cp\"]"))).sendKeys("613");
			((WebElement) driver.findElement(By.xpath("//*[@id=\"search_hp\"]"))).sendKeys("64");
			((WebElement) driver.findElement(By.xpath("//*[@id=\"search_dust\"]"))).sendKeys("4000");
			((WebElement) driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]"))).click();
	
			// La seule solution car le site effectue le calcul en ajax et on ne
			// peut pas checker un element DOM de la page
			// car l'ensemble des éléments sont déja présent. Et un "wait.until" ne
			// peut pas avoir de condition approprié
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String res = ((WebElement) driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")))
					.getText();
			int n = Math.round(Float.parseFloat(res.replace("%", "")));
			((WebElement) driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]"))).sendKeys(n + "");
			assertEquals(n, 56);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		

	}
}
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pruebaI {
	
	private WebDriver driver;
	
	@Before
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test
	
	public void testGooglePage() throws InterruptedException {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("facebook");
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("facebook - Buscar con Google", driver.getTitle());
		
		
		WebElement Enter = driver.findElement(By.className("yuRUbf"));
		Enter.click();
		System.out.println("Url: " + driver.getCurrentUrl());
		System.out.println("Titulo de la pagina: " + driver.getTitle());
		
		Thread.sleep(3000);
		
		WebElement searchboxFacebook = driver.findElement(By.name("email"));
		searchboxFacebook.clear();
		searchboxFacebook.sendKeys("ejemplo@hotmail.com");
		
		Thread.sleep(3000);
		
		WebElement searchboxFacebookII = driver.findElement(By.name("pass"));
		searchboxFacebookII.clear();
		searchboxFacebookII.sendKeys("escriba a aqui su contraseña");
		
		Thread.sleep(3000);
		
		searchboxFacebook.submit();
		
		String verificacion = driver.getCurrentUrl();	
		
		if(verificacion.equals("https://es-la.facebook.com/")) {
			Thread.sleep(3000);
			WebElement searchboxFacebookIII = driver.findElement(By.name("pass"));
			searchboxFacebookIII.clear();
			searchboxFacebookIII.sendKeys("escriba aqui su contraseña");
			
			searchboxFacebookIII.submit();
		}else if(verificacion.equals("https://es-la.facebook.com/")) {
			
		}
			Thread.sleep(3000);
			WebElement olvidecontraseña = driver.findElement(By.className("_97w3"));
			olvidecontraseña.click();
			
			WebElement restablecercontraseña = driver.findElement(By.name("reset_action"));
			restablecercontraseña.click();
			
			Thread.sleep(3000);
			
			WebElement searchboxFacebookIV = driver.findElement(By.id("identify_email"));
			searchboxFacebookIV.clear();
			searchboxFacebookIV.sendKeys("ejemplo@hotmail.com");
			
	}
	
	
	
	@After
	
	public void tearDown(){
		//driver.quit();
	}
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class RegisterTest {

    @Test
    public void registerSuccessfully() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\faman\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://www.organizze.com.br");
        navegador.findElement(By.linkText("Cadastre-se")).click();


        WebElement formularioSignInbox = navegador.findElement(By.id("signup__form"));

        formularioSignInbox.findElement(By.id("email")).sendKeys("famancio0@gmail.com");
        formularioSignInbox.findElement(By.id("password")).sendKeys("testaut2020");
        formularioSignInbox.findElement(By.id("passwordConfirmation")).sendKeys("testaut2020");
        formularioSignInbox.findElement(By.id("termsOfUse")).click();
        formularioSignInbox.findElement(By.xpath("//*[@id=\"signup__form\"]/button")).click();

        Thread.sleep(10000);

        String message1 = navegador.findElement(By.xpath("/html/body/div[2]/div/div[2]/h3")).getText();
        String message2 = navegador.findElement(By.xpath("/html/body/div[2]/div/div[2]/p")).getText();
        String botaoOk = navegador.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).getText();

        Assertions.assertEquals("Parabéns! O Organizze já está preparado para você!", message1);
        Assertions.assertEquals("Enviamos um e-mail para sua caixa de entrada. Confirme seu cadastro para receber um e-mail importante da nossa equipe.", message2);
        Assertions.assertEquals("Ok, começar agora", botaoOk);
    }
}

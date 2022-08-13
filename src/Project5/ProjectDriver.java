package Project5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass(alwaysRun = true)  // XML de grupladığımızda, alwaysRun=true yapmadan çalışmadı...
    public void BaslangicIslemleri(){

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // max
        driver.manage().deleteAllCookies();  //

        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        Duration dr= Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(dr); // bütün webElement için geçerli

        driver.get("http://demowebshop.tricentis.com/");

    }

    @AfterClass(alwaysRun = true)   // İşlemden sonra kapatması için de bu sefer burada alwaysRun=true yapmamız gerekti.
    public void BitisIslemleri(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public static void loginOl(){

        Project5_Elements elements = new Project5_Elements(driver);

        elements.logginButton.click();
        elements.email.sendKeys("hakan@test.com");
        elements.password.sendKeys("1357908642");

        elements.loginBtn.click();


    }

}

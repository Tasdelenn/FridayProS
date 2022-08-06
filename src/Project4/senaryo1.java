package Project4;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class senaryo1 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get(("http://www.automationpractice.com"));

        for (int i = 1; i <=2 ; i++) {

            WebElement contactUs = driver.findElement(By.cssSelector("[id=\"contact-link\"]>a"));
            wait.until(ExpectedConditions.elementToBeClickable(contactUs));
            contactUs.click();

            WebElement subjectHeading = driver.findElement(By.id("id_contact"));

            Select menu = new Select(subjectHeading);
            menu.selectByValue("" + i + "");

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("hakan@test.com");

            WebElement orderReference = driver.findElement(By.id("id_order"));
            orderReference.sendKeys("1357908642");

            WebElement message = driver.findElement(By.id("message"));
            message.sendKeys("Kırmızı kuyruklu, kırmızı tilki ağaçtaki kargayı görünce ne yapacağını şaşırdı.");

            WebElement sendButton = driver.findElement(By.cssSelector("[id=\"submitMessage\"]>span"));
            sendButton.click();

            WebElement succesMessage = driver.findElement(By.cssSelector("[class=\"alert alert-success\"]"));
            Assert.assertTrue(succesMessage.getText().contains("successfully"));
        }

        BekleKapat();

    }
}

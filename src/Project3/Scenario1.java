package Project3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Scenario1 extends BaseStaticDriver {

    public static void main(String[] args) {

        driver.get("https://shopdemo.e-junkie.com/");

        //WebElement addToCart = driver.findElement(By.cssSelector("button.view_product[onclick^=\"return\"]")); / OLMADI
        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='basicDetails'])[2]/button"));
        addToCart.click();

        WebElement iframe = driver.findElement(By.cssSelector("iframe.EJIframeV3.EJOverlayV3"));
        //WebElement iframe = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement cartItemNo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.Fixed-Actions.Desktop-Only span.Cart-Items-Nos")));
        //WebElement cartItemNo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='Cart-Items-Nos'])[2]")));
        Assert.assertEquals("1", cartItemNo1.getText());

        WebElement removeItemBtn = driver.findElement(By.cssSelector("button.Product-Remove"));
        removeItemBtn.click();

        WebElement continueShoppingBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.Continue-Button.Close-Cart")));
        continueShoppingBtn.click();

        driver.switchTo().defaultContent(); // Ana sayfaya geri çıkıyo.

        WebElement cartItemNo2 = driver.findElement(By.cssSelector("a.navbar-item.cart.smallOnly span#cart_item_nos"));
        //WebElement cartItemNo2 = driver.findElement(By.xpath("//span[@id='cart_item_nos']"));
        Assert.assertEquals("0", cartItemNo2.getText());
        //Assert.assertTrue(cartItemNo2.getText().contains("0")); // Bence equal olmalı. Yoksa mesela 10 u da doğru kabul eder.

        BekleKapat();
    }
}

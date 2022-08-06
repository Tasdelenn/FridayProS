package Project4;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class senaryo2 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get(("http://www.automationpractice.com"));
        WebElement login = driver.findElement(By.className("login"));
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement loginButton = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("hakan@test.com");
        password.sendKeys("1357908642");
        loginButton.click();

        Actions actions = new Actions(driver);

        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();

        WebElement product = driver.findElement(By.cssSelector("[class=\"product-container\"]"));
        actions.moveToElement(product).build().perform();

        WebElement addToCard = driver.findElement(By.linkText("Add to cart"));
        addToCard.click();

        WebElement proceedToCheckOut = driver.findElement(By.xpath("(//div[@class=\"button-container\"]/a)[1]"));
        proceedToCheckOut.click();

        WebElement pChkSignIncheck = driver.findElement(By.linkText("Proceed to checkout"));
        pChkSignIncheck.click();

        WebElement pChkAddress = driver.findElement(By.cssSelector("[name=\"processAddress\"]"));
        pChkAddress.click();

        WebElement iAggreeTick = driver.findElement(By.id("cgv"));
        WebElement pChkShipping = driver.findElement(By.cssSelector("[name=\"processCarrier\"]"));
        iAggreeTick.click();
        pChkShipping.click();

        WebElement payByBankWire = driver.findElement(By.cssSelector("[class=\"payment_module\"]>a[class='bankwire']"));
        payByBankWire.click();

        WebElement confirm = driver.findElement(By.cssSelector("[class=\"button btn btn-default button-medium\"]"));
        confirm.click();

        WebElement complateOrderMsg = driver.findElement(By.cssSelector("p.cheque-indent>strong.dark"));
        WebElement boxMsg = driver.findElement(By.cssSelector("[class=\"box\"]"));
        String boxMessageAll = boxMsg.getText();

        Assert.assertTrue(complateOrderMsg.getText().contains("Your order on My Store is complete."));

        WebElement myCostAccount = driver.findElement(By.xpath("(//div[@class=\"header_user_info\"]/a)[1]"));
        myCostAccount.click();  // Accountumuz üzerinden siparişlere (orders) gideceğiz.

        WebElement myOrdersIcon = driver.findElement(By.cssSelector("[class=\"icon-list-ol\"]"));
        myOrdersIcon.click();

        WebElement orderRefNum = driver.findElement(By.xpath("(//a[@class=\"color-myaccount\"])[1]"));
        String order = orderRefNum.getText().replaceAll("[^A-Z]", "");  // Referansı 9 haneli (ABCDEFGHI) şekle getirdik.

        Assert.assertTrue(boxMessageAll.contains(order));
        System.out.println("Test Passed");

        BekleKapat();
    }
}

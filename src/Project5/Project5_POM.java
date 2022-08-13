package Project5;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Project5_POM extends ProjectDriver {

    @Test(groups = "Login")
    void _01_positive_sce(){

        Project5_Elements elements = new Project5_Elements(driver);
        elements.logginButton.click();
        elements.email.sendKeys("hakan@test.com");
        elements.password.sendKeys("1357908642");

        wait.until(ExpectedConditions.elementToBeClickable(elements.loginBtn)).click();

        Assert.assertTrue(elements.logOut.isDisplayed());

        elements.logOut.click();
    }

    @Test(groups = "Login")
    void _02_nagative_sce(){

        Project5_Elements elements1 = new Project5_Elements(driver);

        elements1.logginButton.click();
        elements1.email.sendKeys("hakan@test.com");
        elements1.password.sendKeys("1357908642!");

        wait.until(ExpectedConditions.elementToBeClickable(elements1.loginBtn)).click();
        Assert.assertTrue(elements1.invalidMessage.getText().contains("incorrect"));

        elements1.email.clear();
        elements1.email.sendKeys("hakan@not.com");
        elements1.password.sendKeys("1357908642");

        wait.until(ExpectedConditions.elementToBeClickable(elements1.loginBtn)).click();
        Assert.assertTrue(elements1.invalidMessage.getText().contains("No customer"));

        elements1.email.clear();

    }

    @Test(groups = "shopping")
    void _03_shopping_sce(){

        Project5_Elements elements2 = new Project5_Elements(driver);

        ProjectDriver.loginOl();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.laptopAddCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.shoppingCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.iAgree)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.checkOut)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.contunie1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.contunie2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.contunie3)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.contunie4)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.contunie5)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements2.confirm)).click();

        Assert.assertTrue(elements2.result.getText().contains("successfully processed!"));

    }
}

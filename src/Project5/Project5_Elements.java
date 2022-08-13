package Project5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Project5_Elements {

    public Project5_Elements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
    public WebElement logginButton;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(css = "[value=\"Log in\"]")
    public WebElement loginBtn;

    @FindBy(linkText = "Log out")
    public WebElement logOut;

    @FindBy(css = "[class=\"validation-summary-errors\"]>ul>li")
    public WebElement invalidMessage;

    @FindBy(xpath = "(//*[@value=\"Add to cart\"])[2]")
    public WebElement laptopAddCart;

    @FindBy(id = "topcartlink")
    public WebElement shoppingCard;

    @FindBy(id = "termsofservice")
    public WebElement iAgree;

    @FindBy(id = "checkout")
    public WebElement checOut;

    @FindBy(css = "[id=\"billing-buttons-container\"]>input")
    public WebElement contunie1;

    @FindBy(css = "[id=\"shipping-buttons-container\"]>input")
    public WebElement contunie2;

    @FindBy(css = "[id=\"shipping-method-buttons-container\"]>input")
    public WebElement contunie3;

    @FindBy(css = "[id=\"payment-method-buttons-container\"]>input")
    public WebElement contunie4;

    @FindBy(css = "[id=\"payment-info-buttons-container\"]>input")
    public WebElement contunie5;

    @FindBy(css = "[id=\"confirm-order-buttons-container\"]>input")
    public WebElement confirm;

    @FindBy(css = "[class=\"section order-completed\"] strong")
    public WebElement result;


}

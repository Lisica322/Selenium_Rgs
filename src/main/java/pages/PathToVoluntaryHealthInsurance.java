package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class PathToVoluntaryHealthInsurance extends BasePage {
    //"Компаниям"
    private static final String PAGE_COMPANIES_LOC = "//*[@href = 'https://www.rgs.ru/products/juristic_person/index.wbp']";
    //"Страхование здоровья"
    private static final String HEALTH_INSURANCE_LOC = "//*[@href='/products/juristic_person/health/index.wbp'][@target]";
    //ДМС
    private static final String DMS_BUTTON_LOC = "//*[@href='/products/juristic_person/health/dms/index.wbp'][@class='list-group-item adv-analytics-navigation-line4-link']";


    public PathToVoluntaryHealthInsurance(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickCompanies() {
        WebElement categoriesElement = webDriver.findElement(By.xpath(PAGE_COMPANIES_LOC));
        webDriverWait.until(ExpectedConditions.visibilityOf(categoriesElement));
        categoriesElement.click();
    }

    public void UntilHealthButtonVisible() {
        WebElement healtButton = webDriver.findElement(By.xpath(HEALTH_INSURANCE_LOC));
        webDriverWait.until(ExpectedConditions.visibilityOf(healtButton));
        healtButton.click();
    }

    public void switchToBabytext(String text) {
        String myTab = webDriver.getWindowHandle();
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        for (String s : tabs) {
            if (!s.equals(myTab)) {
                webDriver.switchTo().window(s);
                if (webDriver.getTitle().contains(text)) {
                    return;
                }
            }
        }
        Assertions.fail("Вкладка " + text + " не найдена");

    }

    public void dmsButtonElement() {
        switchToBabytext("ДМС для сотрудников - добровольное медицинское страхование от Росгосстраха");
        WebElement frameName = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class = 'flocktory-widget']")));
        webDriver.switchTo().frame(frameName);
        WebElement closeBtn = webDriver.findElement(By.xpath("//div[@class='widget__close js-collapse-login']"));
        new Actions(webDriver).moveToElement(closeBtn).click().build().perform();
        webDriver.switchTo().defaultContent();

        WebElement dmsButton = webDriver.findElement(By.xpath(DMS_BUTTON_LOC));
        webDriverWait.until(ExpectedConditions.visibilityOf(dmsButton));
        dmsButton.click();
    }
}

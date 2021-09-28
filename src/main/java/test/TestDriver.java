package test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.DmsPage;
import pages.FillingFields;
import pages.NavigatorRgs;
import pages.PathToVoluntaryHealthInsurance;

//import pages.FillingFields;

public class TestDriver extends BaseTest {


    @Test
    public void theRgsTesting() {
        NavigatorRgs navigatorRgs = new NavigatorRgs(webDriver);
        PathToVoluntaryHealthInsurance pathToHealth = new PathToVoluntaryHealthInsurance(webDriver);
        DmsPage dmsPage = new DmsPage(webDriver);
        FillingFields fillingFields = new FillingFields(webDriver);

        navigatorRgs.clickCookiesButton();
        navigatorRgs.clickMenuButton();
        pathToHealth.clickCompanies();

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,450)");

        pathToHealth.UntilHealthButtonVisible();
        pathToHealth.dmsButtonElement();
        dmsPage.containsDms();
        dmsPage.clickHealthButton();
        dmsPage.clickWindowDms();
        dmsPage.containsApplicationDms();

        fillingFields.clickSomeField(FillingFields.LAST_NAME_LOC, "Фамилия");
        fillingFields.clickSomeField(FillingFields.FIRST_NAME_LOC, "Имя");
        fillingFields.clickSomeField(FillingFields.MIDDLE_NAME_LOC, "Отчество");
        fillingFields.clickSomeField(FillingFields.PHONE_NUMBER_LOC, "8005553535");
        fillingFields.clickSomeField(FillingFields.DATE_CONNECTION_LOC, "12.12.2021");
        fillingFields.clickSomeField(FillingFields.COMMENT_LOC, "У нас было 2 пакета травы, 75 таблеток мескалина, 5 упаковок кислоты, полсолонки кокаина и целое множество транквилизаторов всех сортов");
        fillingFields.clickSomeField(FillingFields.MAIL_LOC, "qwertyqwerty");
        fillingFields.clickSomeField(FillingFields.CLICK_REGION_LOC, "Москва");
        fillingFields.checkSomeField(FillingFields.LAST_NAME_LOC, "Фамилия");
        fillingFields.checkSomeField(FillingFields.FIRST_NAME_LOC,"Имя");
        fillingFields.checkSomeField(FillingFields.MIDDLE_NAME_LOC, "Отчество");
        fillingFields.checkSomeField(FillingFields.PHONE_NUMBER_LOC,"+7 (800) 555-35-35");
        fillingFields.checkSomeField(FillingFields.COMMENT_LOC,"У нас было 2 пакета травы, 75 таблеток мескалина, 5 упаковок кислоты, полсолонки кокаина и целое множество транквилизаторов всех сортов");
        fillingFields.checkSomeField(FillingFields.DATE_CONNECTION_LOC,"12.12.2021");
        fillingFields.checkSomeField(FillingFields.MAIL_LOC, "qwertyqwerty");
        fillingFields.onlyClickField(FillingFields.CLICK_SPACE_LOC);
        fillingFields.onlyClickField(FillingFields.OK_LOC);
        fillingFields.onlyClickField(FillingFields.OK_SPACE_LOC);
        fillingFields.clickCheckboxField();
        fillingFields.checkOkField();
    }
}

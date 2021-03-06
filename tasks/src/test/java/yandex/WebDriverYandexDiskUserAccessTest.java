package yandex;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import taf.browser.BrowserFactory;
import taf.driver.DriverFactory;
import taf.listener.SuiteListener;
import taf.listener.TestListener;
import taf.product.yandex.disk.model.User;
import taf.product.yandex.disk.page.YandexDiskAuthPage;
import taf.product.yandex.disk.service.UserFactory;
import taf.product.yandex.disk.service.YandexDiskService;

@Listeners({TestListener.class, SuiteListener.class})
public class WebDriverYandexDiskUserAccessTest {
  private WebDriver driver;

  @DataProvider(name = "Credentials")
  public static Object[][] getData() {
    return new Object[][]{
        {UserFactory.withInvalidCredentialsFromProperty(), false},
        {UserFactory.withValidCredentialsFromProperty(), true}};
  }

  @BeforeClass
  public void prepareTest() {
    driver = BrowserFactory.createInstance();
    DriverFactory.setDriver(driver);
    driver = DriverFactory.getDriver();
  }

  @BeforeMethod(alwaysRun = true, description = "Google Chrome opens, goes to Yandex Disk Auth page")
  public void goToAuthPage() {
    new YandexDiskService(driver)
        .navigateToYandexDisk();
  }

  @Test(dataProvider = "Credentials",
      description = "Verify that not log or log into account in Yandex Disk")
  public void verifyLoginIntoYandexDisk(User user, boolean shouldSucceed) {
    SoftAssert softAssert = new SoftAssert();
    new YandexDiskService(driver)
        .logIntoAccount(user);
    if (shouldSucceed) {
      softAssert
          .assertEquals(new YandexDiskService(driver).getUserAccountName(), user.getUsername(),
              "User was not logged in");
    } else {
      softAssert.assertTrue(new YandexDiskAuthPage(driver).isErrorMessageDisplayed(),
          "Error message was not displayed");
    }
    softAssert.assertAll();
  }

  @AfterClass(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    DriverFactory.closeDriver();
  }
}

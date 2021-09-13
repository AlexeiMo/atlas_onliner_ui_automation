package com.example;

import com.example.helpers.JsonDataReader;
import org.junit.jupiter.api.DisplayName;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.exists;

import java.util.Map;

public class LoginTest extends TestBase {

    Map<String, String> testData = JsonDataReader.getTestData();

//    @Test
    @DisplayName("Авторизация")
    void loginTest() throws InterruptedException {
        site.onLoginPage().open();
        site.onLoginPage().loginForm().click();
        site.onLoginPage().loginForm().loginInput().sendKeys(testData.get("login"));
        site.onLoginPage().loginForm().passwordInput().sendKeys(testData.get("password"));
        site.onLoginPage().loginForm().submitButton().click();
        site.onMainPage().profileImage().should(exists());
    }
}

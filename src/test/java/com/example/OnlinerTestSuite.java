package com.example;

import com.example.helpers.JsonDataReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.exists;

public class OnlinerTestSuite extends TestBase {

    Map<String, String> testData = JsonDataReader.getTestData();

    @Test
    @DisplayName("Тестирование авторизации")
    void loginTest() throws InterruptedException {
        site.onLoginPage().open();
        site.onLoginPage().loginForm().click();
        site.onLoginPage().loginForm().loginInput().sendKeys(testData.get("login"));
        site.onLoginPage().loginForm().passwordInput().sendKeys(testData.get("password"));
        site.onLoginPage().loginForm().submitButton().click();
        site.onMainPage().profileImage().should(exists());
    }

    @Test
    @DisplayName("Тестирование поиска")
    void searchTest() throws InterruptedException {
        site.onMainPage().open();
        site.onMainPage().searchInput().sendKeys(testData.get("searchOption"));
        driver.switchTo().frame(site.onMainPage().searchFrame());
        site.onMainPage().results().waitUntil(not(empty()));
        for (String item: site.onMainPage().getSearchResults()) {
            assert item.contains(testData.get("searchOption"));
        }
    }

    @Test
    @DisplayName("Тестирование навигации")
    void navigationTest() throws InterruptedException {
        site.onMainPage().open();
        site.onMainPage().headerLink(testData.get("categoryPageName")).click();
        assert driver.getCurrentUrl().contains(testData.get("categoryUrl"));
    }

}

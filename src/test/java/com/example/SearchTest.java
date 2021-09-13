package com.example;

import com.example.helpers.JsonDataReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import java.util.Map;

public class SearchTest extends TestBase {

    Map<String, String> testData = JsonDataReader.getTestData();

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
}

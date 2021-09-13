package com.example;

import com.example.listener.AtlasAllureListener;
import com.example.onliner.site.OnlinerSite;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static com.example.helpers.DriverFactory.Browser.*;
import static com.example.helpers.DriverFactory.getDriver;

public class TestBase {

    protected WebDriver driver;
    protected Atlas atlas;
    protected OnlinerSite site;

    @BeforeEach
    void setUp() {
        driver = getDriver(CHROME);
        driver.manage().window().maximize();
        atlas = new Atlas(new WebDriverConfiguration(driver, "https://onliner.by")).listener(new AtlasAllureListener());
        site = atlas.create(driver, OnlinerSite.class);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
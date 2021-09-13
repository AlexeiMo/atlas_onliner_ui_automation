package com.example.onliner.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface LoginForm extends AtlasWebElement {

    @FindBy("//div/input[@type='text']")
    AtlasWebElement loginInput();

    @FindBy("//div/input[@type='password']")
    AtlasWebElement passwordInput();

    @FindBy("//div/button[@type='submit']")
    AtlasWebElement submitButton();
}

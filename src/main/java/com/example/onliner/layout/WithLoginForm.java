package com.example.onliner.layout;

import com.example.onliner.element.LoginForm;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithLoginForm {

    @FindBy("//div[@class= 'auth-bar__item auth-bar__item--text']")
    LoginForm loginForm();
}

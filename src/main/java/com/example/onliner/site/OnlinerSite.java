package com.example.onliner.site;

import com.example.onliner.page.LoginPage;
import com.example.onliner.page.MainPage;
import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;

public interface OnlinerSite extends WebSite {
    @Page
    LoginPage onLoginPage();

    @Page
    MainPage onMainPage();

}

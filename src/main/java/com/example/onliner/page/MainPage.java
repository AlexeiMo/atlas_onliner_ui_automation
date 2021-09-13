package com.example.onliner.page;

import com.example.onliner.layout.WithSearch;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface MainPage extends WebPage, WithSearch {

    @FindBy("//div[@class='b-top-profile__item b-top-profile__item_arrow']")
    AtlasWebElement profileImage();

}
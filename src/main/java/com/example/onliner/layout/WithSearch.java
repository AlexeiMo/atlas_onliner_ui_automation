package com.example.onliner.layout;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

import java.util.List;

public interface WithSearch extends AtlasWebElement {

    @FindBy("//input[@class='fast-search__input']")
    AtlasWebElement searchInput();

    @FindBy("//a[@class='product__title-link']")
    ElementsCollection<AtlasWebElement> results();

    default List<String> getSearchResults() {
        return results().extract(AtlasWebElement::getText);
    }

    @FindBy("//iframe[@class='modal-iframe']")
    AtlasWebElement searchFrame();

}
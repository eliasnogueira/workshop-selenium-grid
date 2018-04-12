/*
 * Copyright 2018 Elias Nogueira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.eliasnogueira.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PeoplePage {

    private WebDriver driver;

    @FindBy(css = ".ui-h2.hero-title")
    private WebElement title;

    @FindBy(css = ".ui-body.hero-description")
    private WebElement description;

    public PeoplePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("@"));

    }

    public String getTitleName() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getURLAddress() {
        return driver.getCurrentUrl();
    }
}

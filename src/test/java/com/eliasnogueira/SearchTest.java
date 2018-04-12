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
package com.eliasnogueira;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.*;

import com.eliasnogueira.utils.BaseTest;
import com.eliasnogueira.pageobjects.MainPage;
import com.eliasnogueira.pageobjects.PeoplePage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchValidPerson()  {
        String person = "Elias Nogueira";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchIcon();
        mainPage.fillSearch(person);
        mainPage.selectPeople(person);

        PeoplePage peoplePage = new PeoplePage(driver);
        assertThat(peoplePage.getTitleName(), equalTo(person));
        assertThat(peoplePage.getDescription(), equalTo("Senior QA Engineer, Agile Coach and Trainer"));
        assertThat(peoplePage.getURLAddress(), containsString("@eliasnogueira"));
    }
    
}
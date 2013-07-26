/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/

package org.apache.cordova.mobilespec.test;


import org.apache.cordova.mobilespec.*;

import com.jayway.android.robotium.solo.By;
import com.jayway.android.robotium.solo.Solo;
import com.jayway.android.robotium.solo.WebElement;

import android.test.ActivityInstrumentationTestCase2;

public class CordovaClickTest extends ActivityInstrumentationTestCase2<MobileSpec> {


    private Solo solo;
    
    public CordovaClickTest() {
        super(MobileSpec.class);
    }
    
    @Override
    public void setUp() throws Exception {
        //setUp() is run before a test case is started. 
        //This is where the solo object is created.
        solo = new Solo(getInstrumentation(), getActivity());
    }
    
    public void testSound()
    {
        solo.waitForWebElement(By.textContent("Audio Play/Record"), 10, false);
        solo.clickOnWebElement(By.textContent("Audio Play/Record"));
        solo.waitForWebElement(By.textContent("Play"), 10, false);
        WebElement play = solo.getWebElement(By.textContent("Play"), 0);
        assertNotNull(play);
        solo.clickOnWebElement(By.textContent("Play"));
        solo.sleep(10000);
        WebElement result = solo.getWebElement(By.textContent("Running"), 0);
        assertNotNull(result);
    }
    
    @Override
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished. 
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }
}

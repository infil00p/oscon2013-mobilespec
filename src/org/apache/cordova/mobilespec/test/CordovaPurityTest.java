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


import org.apache.cordova.CordovaWebView;
import org.apache.cordova.mobilespec.*;

import com.jayway.android.robotium.solo.By;
import com.jayway.android.robotium.solo.Solo;
import com.jayway.android.robotium.solo.WebElement;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class CordovaPurityTest extends ActivityInstrumentationTestCase2<MobileSpec> {

    private Purity clicker;
    private Instrumentation mInstr;
    private MobileSpec testActivity;
    
    public CordovaPurityTest() {
        super(MobileSpec.class);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        mInstr = this.getInstrumentation();
        testActivity = this.getActivity();
        clicker = new Purity(testActivity, getInstrumentation());    
     }
    
    public void testSound()
    {
        sleep(5000);
        clicker.touch(200, 400);
        sleep(1000);
        clicker.touch(75, 325);
        sleep(10000);
        clicker.touch(75, 400);
        sleep(3000);
    }
    
    private void sleep(int timeout) {
        try {
          Thread.sleep(timeout);
        } catch (InterruptedException e) {
          fail("Unexpected Timeout");
        }
    }
    
    @Override
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished. 
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
    }
}

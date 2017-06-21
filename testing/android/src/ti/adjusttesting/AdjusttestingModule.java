/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.adjusttesting;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import com.adjust.testlibrary.TestLibrary;
import org.appcelerator.kroll.runtime.v8.V8Function;

import java.util.HashMap;
import java.util.Map;

@Kroll.module(name="Adjusttesting", id="ti.adjusttesting")
public class AdjusttestingModule extends KrollModule
{
	// Standard Debugging variables
	private static final String LCAT = "AdjusttestingModule";
	private static final boolean DBG = TiConfig.LOGD;
	private static final String KEY_BASE_URL = "baseUrl";
	private static final String KEY_EXECUTE_COMMAND_CALLBACK = "executeCommandCallback";

	private V8Function jsExecuteCommandCallback = null;
    private TestLibrary testLibrary;

	public AdjusttestingModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Log.d(LCAT, "inside onAppCreate");
	}

    @Kroll.method
    public void initTestSession(String baseUrl, V8Function callback) {
        Log.d(LCAT, "initTestSession() with baseUrl[" + baseUrl + "]");

        this.testLibrary = new TestLibrary(baseUrl, 
                new CommandListener(getKrollObject(), callback) );
        testLibrary.initTestSession("titanium4.11.0@android4.11.4");
    }

    @Kroll.method
    public void addInfoToSend(String key, String value) {
        if (null != testLibrary) {
            testLibrary.addInfoToSend(key, value);
        }
    }

    @Kroll.method
    public void sendInfoToServer() {
        if (null != testLibrary) {
            testLibrary.sendInfoToServer();
        }
    }

    @Kroll.method
    public void setOnExitListener(V8Function callback) {
        if (null != testLibrary) {
            testLibrary.setOnExitListener(new OnExitListener(getKrollObject(), callback));
        }
    }
}

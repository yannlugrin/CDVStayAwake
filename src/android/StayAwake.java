//
//  StayAwake.java
//
//  The MIT License
//
//  Copyright (c) 2013 Yann Lugrin
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of this
//  software and associated documentation files (the "Software"), to deal in the Software
//  without restriction, including without limitation the rights to use, copy, modify, merge,
//  publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
//  whom the Software is furnished to do so, subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all copies or
//  substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
//  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
//  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
//  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
//  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
//  IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//  SOFTWARE.
//

package ch.liquidconcept.cordova.stayawake;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.view.WindowManager;

public class StayAwake extends CordovaPlugin {
	
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	if (action.equals("enable")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                	cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                	callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
                }
            });
    	} else if (action.equals("disable")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                	cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                	callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
                }
            });
    	} else {
        	callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
    		return false;
    	}

    	return true;
    }
}

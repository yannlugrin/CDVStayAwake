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

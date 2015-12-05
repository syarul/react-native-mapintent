package com.syarul.mapintent;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;

/**
 * {@link NativeModule} that allows JS to open the default browser
 *  for an url.
 */
public class RNMapIntentModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public RNMapIntentModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "MapIntent";
  }

  @ReactMethod
  public void open(String lat, String lng, String label) {
    String urlAddress = "http://maps.google.com/maps?q="+ lat  +"," + lng +"("+ label + ")&iwloc=A&hl=es";     
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlAddress));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
}

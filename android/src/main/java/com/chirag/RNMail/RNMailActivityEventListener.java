package com.chirag.RNMail;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;


public class RNMailActivityEventListener extends BaseActivityEventListener {

  private ActivityResultInterface mCallback;

  public RNMailActivityEventListener(ReactApplicationContext reactContext, ActivityResultInterface callback) {
    reactContext.addActivityEventListener(this);
    mCallback = callback;
  }

  // < RN 0.33.0
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    mCallback.callback(requestCode, resultCode, data);
  }

  // >= RN 0.33.0
  public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
    mCallback.callback(requestCode, resultCode, data);
  }
}

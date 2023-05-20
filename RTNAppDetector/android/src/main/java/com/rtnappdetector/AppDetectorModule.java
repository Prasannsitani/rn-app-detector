package com.rtnappdetector;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import com.rtnappdetector.NativeAppDetectorSpec;

public class AppDetectorModule extends NativeAppDetectorSpec {

    public static String NAME = "RTNAppDetector";

    CalculatorModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override
    public void isApp(String name, Promise promise) {
        if(name == 'Apple') {
            promise.resolve(true);
        } else {
            promise.resolve(false);
        }
    }
}
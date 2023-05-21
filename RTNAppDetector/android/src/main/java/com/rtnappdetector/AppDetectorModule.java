package com.rtnappdetector;

import androidx.annotation.NonNull;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.content.Intent;
import android.content.pm.ResolveInfo;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import com.rtnappdetector.NativeAppDetectorSpec;


public class AppDetectorModule extends NativeAppDetectorSpec {

    public static String NAME = "RTNAppDetector";

    Context ctx;

    public AppDetectorModule(ReactApplicationContext context) {
        super(context);
        this.ctx = context.getApplicationContext();
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void allAppsInstalled(Promise promise) {
        PackageManager pm = this.ctx.getPackageManager();
        try {
            List<ApplicationInfo> packages = pm.getInstalledApplications(
                PackageManager.GET_META_DATA
            );
            ArrayList<String> list = new ArrayList<String>();

            for (ApplicationInfo applicationInfo : packages) {
                list.add(applicationInfo.packageName);
            }
            promise.resolve(list.toString());
        } catch (Exception e) {
            promise.resolve("Error Occurred");
        }
    }

    @ReactMethod
    public void testingPackages(Promise promise) {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgAppsList = this.ctx.getPackageManager().queryIntentActivities();
        promise.resolve(pkgAppsList.toString());
    }

    @Override
    public void isAppInstalled(String name, Promise promise) {
        PackageManager pm = this.ctx.getPackageManager();

        try {
            pm.getPackageInfo(name, PackageManager.GET_ACTIVITIES);
            promise.resolve(true);
        } catch (Exception e) {
            promise.resolve(false);
        }
  }
}
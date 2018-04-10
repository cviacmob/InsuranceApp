package com.insurance.insuranceapp.Activites;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by Balaji on 4/10/2018.
 */

public class InsuranceApplication extends MultiDexApplication {


    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

}

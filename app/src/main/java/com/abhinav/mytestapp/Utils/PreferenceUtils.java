package com.abhinav.mytestapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by traveltriangle on 6/5/15.
 */
public class PreferenceUtils {

    private static final String AGENT_APP_PREFERENCE = "RoposoDeveloperExam";

    private static SharedPreferences appPreference;
    private static SharedPreferences getAppPreference(Context context){
        if (appPreference == null)
        {
            appPreference = context.getSharedPreferences(AGENT_APP_PREFERENCE, Context.MODE_PRIVATE);
        }
        return appPreference;
    }

    public static boolean saveFollowStatus(Context context,String id, String status){
        return getAppPreference(context).edit().putString(id,status).commit();
    }

    public static String getFollowStatus(Context context,String id){
        return getAppPreference(context).getString(id,"NoStatus");
    }

}

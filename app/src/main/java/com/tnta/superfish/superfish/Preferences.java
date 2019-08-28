package com.tnta.superfish.superfish;

/**
 * Created by theanh on 10/31/15.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    private static final String HIGHSCORE = "DEFAULT";


    private final SharedPreferences preferences;

    public Preferences(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setScore(String score) {
        if (score != null) {
            preferences.edit().putString(HIGHSCORE, score).apply();
        } else {
            preferences.edit().remove(HIGHSCORE).apply();
        }
    }

    public String getScore() {
        return preferences.getString(HIGHSCORE, null);
    }
}

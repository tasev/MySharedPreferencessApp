package example.sharedpreferences.com.mysharedprefs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;


public class PreferencesManager {

    private static final String ISMALE = "ISMALE";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String AGE = "age";

    private static SharedPreferences getPreferences(Context c) {
        return c.getApplicationContext().getSharedPreferences("MySharedPreffsFile", Activity.MODE_PRIVATE);
    }


    public static void setFirstName(String firstName, Context c) {
        getPreferences(c).edit().putString(FIRSTNAME, firstName).apply();
    }

    public static String getFirstName(Context c) {
        return getPreferences(c).getString(FIRSTNAME, "");
    }

    public static void setLastName(String lastname, Context c) {
        getPreferences(c).edit().putString(LASTNAME, lastname).apply();
    }

    public static String getLastName(Context c) {
        return getPreferences(c).getString(LASTNAME, "");
    }

    public static void setAge(String age, Context c) {
        getPreferences(c).edit().putString(AGE, age).apply();
    }

    public static String getAge(Context c) {
        return getPreferences(c).getString(AGE, "");
    }

    public static void setIsmale(boolean isMale, Context c) {
        getPreferences(c).edit().putBoolean(ISMALE, isMale).apply();
    }

    public static boolean isMale(Context c) {
        return getPreferences(c).getBoolean(ISMALE, false);
    }

    public static void addUser(User user, Context c) {
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        getPreferences(c).edit().putString("user", mapString).apply();
    }

    public static User getUser(Context c) {
        return new Gson().fromJson(getPreferences(c).
                getString("user", ""), User.class);
    }

    public static void  removeUser(Context c){
        getPreferences(c).edit().remove("user").apply();
    }

}

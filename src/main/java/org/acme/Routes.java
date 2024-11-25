package org.acme;

import java.util.prefs.Preferences;

public class Routes {
    private Preferences prefs;
    public Routes (){
        prefs = Preferences.userNodeForPackage(Routes.class);
        prefs.put("APIKey", "XXXXXXXabcde");
        System.out.println(prefs.get("APIKey", "def"));
    }

    public String APIKey(){
        return prefs.get("APIKey", "def");
    }
}

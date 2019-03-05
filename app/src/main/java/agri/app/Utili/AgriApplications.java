package agri.app.Utili;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


public class AgriApplications extends Application {


    public static AgriApplications agriApplications;



    public static boolean isCheckListvisible = false;
    public static boolean isSplashvisible = false;
    public static boolean isHomevisible = false;
    public static boolean isActivationvisible = false;
    public static boolean isDeActivationvisible = false;
    public static boolean isReActivationvisible = false;
    public static boolean isAuditvisible = false;

    public AgriApplications() {
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}





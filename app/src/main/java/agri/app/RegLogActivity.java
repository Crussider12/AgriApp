package agri.app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import agri.app.logRegFragmentModule.LogRegFragment;
import agri.app.loginFragmentModule.LoginFragment;
import agri.app.registrationFragmentModule.RegistrationFragment;

public class RegLogActivity extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction ft;
    LoginFragment loginFragment;
    RegistrationFragment registrationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_log);
        createLoginRegView("LogReg");
    }

    public void createLoginRegView(final String TAG){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        if (TAG.equalsIgnoreCase("LogReg")) {
            LogRegFragment logRegFragment = new LogRegFragment().newInstance();
            ft.replace(R.id.log_reg_container, logRegFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        ft.commit();

    }
    public void LoginHome(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        loginFragment = new LoginFragment().newInstance();
        ft.replace(R.id.log_reg_container, loginFragment).addToBackStack(null);
        ft.commit();
    }


    public void RegistrationHome(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        registrationFragment = new RegistrationFragment().newInstance();
        ft.replace(R.id.log_reg_container, registrationFragment).addToBackStack(null);
        ft.commit();
    }

    public void MainHome(View v) {
     //the change of activity from login towards home page main
        startActivity(new Intent(RegLogActivity.this, MainActivity.class));
    }

    public void RegLog(View v){
        //from registration towards login page
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        loginFragment = new LoginFragment().newInstance();
        ft.replace(R.id.log_reg_container, loginFragment).addToBackStack(null);
        ft.commit();
    }

    public void Close(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        LogRegFragment logRegFragment = new LogRegFragment().newInstance();
        ft.replace(R.id.log_reg_container, logRegFragment).addToBackStack(null);
        ft.commit();
    }
}

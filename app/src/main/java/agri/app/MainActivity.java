package agri.app;

import  android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import agri.app.Interfaces.CropAddListener;
import agri.app.aboutusFragmentModule.AboutusFragment;
import agri.app.addCropFragmentModule.AddCropFragment;
import agri.app.calendarModule.CalenderActivity;
import agri.app.contactusFragmentModule.ContactusFragment;
import agri.app.cropFragmentModule.CropFragment;
import agri.app.Interfaces.FragmentCommunicationCrop;
import agri.app.mandiFragmentModule.MandiItemDetailFragment;
import agri.app.mandiFragmentModule.MandiItemFilterFragment;
import agri.app.cropSelectionFragmentModule.CropSelectionFragment;
import agri.app.homeFragmentModule.HomeFragment;
import agri.app.loanFragmentModule.LoanFragment;
import agri.app.mallFragmentModule.MallFragment;
import agri.app.mallGroupListFragmentModule.MallGroupListFragment;
import agri.app.mandiFragmentModule.MandiFragment;
import agri.app.myOrdersFragmentModule.MyOrdersFragment;
import agri.app.profileFragmentModule.ProfileFragment;
import agri.app.settingsFragmentModule.SettingsFragment;
import agri.app.supportFragmentModule.SupportFragment;
import agri.app.walletFragmentModule.WalletFragment;
import agri.app.weatherFragmentModule.WeatherFragment;
import agri.app.wishlistFragmentModule.WishlistFragment;
import agri.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCommunicationCrop, CropAddListener {

    private Context mContext;
    private static final String TAG = MainActivity.class.getSimpleName();
    Toolbar toolbar;
    ActivityMainBinding activityMainBinding;
    ProfileFragment profileFragment;
    MallGroupListFragment mallGroupListFragment;
    MandiFragment mandiFragment;
    WeatherFragment weatherFragment;
    CropSelectionFragment cropSelectionFragment;
    public static FragmentManager fm;
    public static FragmentTransaction ft;
    ArrayList<Integer> mposCrop;
    ArrayList<Integer> mposCropAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        intiView();
    }

    private void intiView() {
        mContext = MainActivity.this;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Menu menu = activityMainBinding.navView.getMenu();

        MenuItem tools = menu.findItem(R.id.nav_about_us);
        setNavMenuItemColor(tools);
        MenuItem t = menu.findItem(R.id.nav_contact_us);
        setNavMenuItemColor(t);
        MenuItem l = menu.findItem(R.id.nav_logout);
        setNavMenuItemColor(l);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, activityMainBinding.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityMainBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        activityMainBinding.navView.setNavigationItemSelectedListener(this);
        activityMainBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        createInnerView("Crops");
    }

    @Override
    public void onBackPressed() {
        if (activityMainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_noti:


                Toast.makeText(this, "Notification selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.action_order:
                Toast.makeText(this, "Cart selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void createInnerView(final String TAG) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (TAG.equalsIgnoreCase("Home")) {
            HomeFragment homeFragment = new HomeFragment().newInstance();
            ft.replace(R.id.fragment_container, homeFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("Mall")) {

            MallFragment mallFragment = new MallFragment();
            ft.replace(R.id.fragment_container, mallFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        } else if (TAG.equalsIgnoreCase("Crops")) {
            CropFragment cropFragment = new CropFragment().newInstance();
            ft.replace(R.id.fragment_container, cropFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        } else if (TAG.equalsIgnoreCase("Mandi")) {
            MandiFragment mandiFragment = new MandiFragment().newInstance();
            ft.replace(R.id.fragment_container, mandiFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        } else if (TAG.equalsIgnoreCase("Support")) {
            SupportFragment supportFragment = new SupportFragment().newInstance();
            ft.replace(R.id.fragment_container, supportFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        } else if (TAG.equalsIgnoreCase("Wishlist")) {
            WishlistFragment wishlistFragment = new WishlistFragment().newInstance();
            ft.replace(R.id.fragment_container, wishlistFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("My Orders")) {
            MyOrdersFragment myOrdersFragment = new MyOrdersFragment().newInstance();
            ft.replace(R.id.fragment_container, myOrdersFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("Wallet")) {
            WalletFragment walletFragment = new WalletFragment().newInstance();
            ft.replace(R.id.fragment_container, walletFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("Loan")) {
            LoanFragment loanFragment = new LoanFragment().newInstance();
            ft.replace(R.id.fragment_container, loanFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("Settings")) {
            SettingsFragment settingsFragment = new SettingsFragment().newInstance();
            ft.replace(R.id.fragment_container, settingsFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("Contact Us")) {
            ContactusFragment contactusFragment = new ContactusFragment().newInstance();
            ft.replace(R.id.fragment_container, contactusFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("About us")) {
            AboutusFragment aboutusFragment = new AboutusFragment().newInstance();
            ft.replace(R.id.fragment_container, aboutusFragment);
            Window windowStudent = getWindow();
            windowStudent.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else if (TAG.equalsIgnoreCase("LogOut")) {
            startActivity(new Intent(MainActivity.this, RegLogActivity.class));
        }
        ft.commit();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        NavigationView nav = (NavigationView) findViewById(R.id.nav_view);


        switch (item.getItemId()) {
            case R.id.nav_wishlist:
                //enableBackButtonViews(false);
                //setActivityTitle("")
                createInnerView("Wishlist");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_wallet:
                //enableBackButtonViews(false);
                //setActivityTitle("");
                createInnerView("Wallet");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_loan:
                //enableBackButtonViews(false);
                //        setActivityTitle("");

                createInnerView("Loan");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_myorder:
                //enableBackButtonViews(false);
                //        setActivityTitle("");
                createInnerView("My Orders");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_settings:
                //enableBackButtonViews(false);
                //        setActivityTitle("");

                createInnerView("Settings");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.nav_contact_us:
                //enableBackButtonViews(false);
                //        setActivityTitle("");


                createInnerView("Contact Us");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.nav_about_us:
                //enableBackButtonViews(false);
                //        setActivityTitle("");

                createInnerView("About Us");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.nav_logout:
                //enableBackButtonViews(false);
                //        setActivityTitle("");

                createInnerView("LogOut");
                activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }
        return false;


    }


    public void Header(View view) {

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        profileFragment = new ProfileFragment().newInstance();
        ft.replace(R.id.fragment_container, profileFragment).addToBackStack(null);
        ft.commit();
        activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void GroupList(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        mallGroupListFragment = new MallGroupListFragment().newInstance();
        ft.replace(R.id.fragment_container, mallGroupListFragment).addToBackStack(null);
        ft.commit();

    }

    public void WeatherHome(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        weatherFragment = new WeatherFragment().newInstance();
        ft.replace(R.id.fragment_container, weatherFragment).addToBackStack(null);
        ft.commit();
    }

    public void MandiHome(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        mandiFragment = new MandiFragment().newInstance();
        ft.replace(R.id.fragment_container, mandiFragment).addToBackStack(null);
        ft.commit();
    }

    public void CropSelectionHome(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        cropSelectionFragment = new CropSelectionFragment().newInstance();
        ft.replace(R.id.fragment_container, cropSelectionFragment).addToBackStack(null);
        ft.commit();
    }

    public void CropAdd(View view) {

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        HomeFragment homeFragment = new HomeFragment().newInstance();
        ft.replace(R.id.fragment_container, homeFragment).addToBackStack(null);
        ft.commit();
        activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void CalendarHome(View view) {
        startActivity(new Intent(MainActivity.this, CalenderActivity.class));

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.bottom_nav_home:
                    //enableBackButtonViews(false);
                    //setActivityTitle("")
                    createInnerView("Home");
                    return true;
                case R.id.bottom_nav_mall:
                    //enableBackButtonViews(false);
                    //setActivityTitle("");
                    createInnerView("Mall");
                    return true;
                case R.id.bottom_nav_crop:
                    //enableBackButtonViews(false);
                    //        setActivityTitle("");

                    createInnerView("Crops");
                    return true;
                case R.id.bottom_nav_mandi:
                    //enableBackButtonViews(false);
                    //        setActivityTitle("");
                    createInnerView("Mandi");
                    return true;
                case R.id.bottom_nav_support:
                    //enableBackButtonViews(false);
                    //        setActivityTitle("");

                    createInnerView("Support");
                    return true;
            }
            return false;
        }

    };

    //This Function Can be used for changing the color or property of the text of each item in nav drawer
    private void setNavMenuItemColor(MenuItem item) {
        SpannableString span = new SpannableString(item.getTitle());
        span.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, span.length(), 0);
        item.setTitle(span);
    }


    public void MandiGroupItemClick(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        MandiItemDetailFragment mandiItemDetailFragment = new MandiItemDetailFragment().newInstance();
        ft.replace(R.id.fragment_container, mandiItemDetailFragment).addToBackStack(null);
        ft.commit();

    }
    public void FilterClick(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        MandiItemFilterFragment mandiItemFilterFragment = new MandiItemFilterFragment().getInstance();
        ft.replace(R.id.fragment_container, mandiItemFilterFragment).addToBackStack(null);
        ft.commit();

    }


    @Override
    public void respond(ArrayList<Integer> position) {
        mposCrop = position;
        Log.d(TAG, "respond: "+mposCrop);

        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("positions",mposCrop);
        // set Fragmentclass Arguments
        AddCropFragment fragobj = new AddCropFragment();
        fragobj.setArguments(bundle);
        Log.d(TAG, "onCreate: addobj"+mposCrop.size()+""+mposCrop);
    }

    public ArrayList<Integer> getMyData() {
        return mposCrop;
    }

    public ArrayList<Integer> getMyDataCrop() {
        return mposCropAdd;
    }

    @Override
    public void respAdd(ArrayList<Integer> position) {
        mposCropAdd = position;

        Log.d(TAG, "respond: "+mposCropAdd);

        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("positions",mposCropAdd);
        // set Fragmentclass Arguments
        HomeFragment fragobj = new HomeFragment();
        fragobj.setArguments(bundle);
        Log.d(TAG, "onCreate: addobjhh"+mposCropAdd.size()+""+mposCropAdd);
    }
}

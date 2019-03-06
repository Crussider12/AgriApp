package agri.app.loginFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import agri.app.R;
import agri.app.Utili.BaseFragment;

public class LoginFragment extends BaseFragment {


    View view;
    public static LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_login, container, false);

         return view;
    }

    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

    }

    @Override
    public void onClick(View v) {

    }
}

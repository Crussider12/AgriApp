package agri.app.servicesFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import agri.app.R;
import agri.app.Utili.BaseFragment;

public class ServicesFragment extends BaseFragment {


    public static ServicesFragment newInstance() {
        ServicesFragment servicesFragment = new ServicesFragment();
        return servicesFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_services, container, false);
    }

    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

    }

    @Override
    public void onClick(View v) {

    }
}

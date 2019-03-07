package agri.app.mandiFragmentModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import agri.app.R;
import agri.app.Utili.BaseFragment;

public class MandiItemFilterFragment extends BaseFragment {

  TextView txtToolbarTitle;
  ImageView imgToolBarHome;
    FragmentManager manager;

    public static MandiItemFilterFragment getInstance(){
        MandiItemFilterFragment mandiItemFilterFragment=new MandiItemFilterFragment();
        return mandiItemFilterFragment;
    }
    public MandiItemFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.mandi_item_filter, container, false);
        init(view);

        return  view;
    }

    private void init(View view) {
        manager = getFragmentManager();
        txtToolbarTitle = view.findViewById(R.id.txtToolbarTitle);
        imgToolBarHome = view.findViewById(R.id.imgToolbarHome);

        setToolBar("Filter",view);
    }

    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        txtToolbarTitle.setText(name);
        imgToolBarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getFragmentManager().getBackStackEntryCount() > 0)
                    manager.popBackStack();


            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}

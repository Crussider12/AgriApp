package agri.app.profileFragmentModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.jetbrains.annotations.NotNull;

import agri.app.Utili.BaseFragment;
import agri.app.editProfileFragmentModule.EditProfileFragment;
import agri.app.homeFragmentModule.HomeFragment;
import agri.app.MainActivity;
import agri.app.R;



public class ProfileFragment extends BaseFragment {


    View view;
    ImageView close,det_edit;


    public static ProfileFragment newInstance() {
        ProfileFragment profilefragment = new ProfileFragment();
        return profilefragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        close=view.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container,new HomeFragment(),null).addToBackStack(null).commit();
                onStop();

            }
        });

        det_edit=view.findViewById(R.id.edit_details);

        det_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container,new EditProfileFragment(),null).addToBackStack(null).commit();
                onStop();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
      //  setNavigationVisibility(false);
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        //setNavigationVisibility(true);
        getActivity().findViewById(R.id.navigation).setVisibility(View.VISIBLE);
    }


    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

    }

    @Override
    public void onClick(View v) {

    }
}

package agri.app.editProfileFragmentModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import org.jetbrains.annotations.NotNull;

import agri.app.MainActivity;
import agri.app.Utili.BaseFragment;
import agri.app.profileFragmentModule.ProfileFragment;
import agri.app.R;


public class EditProfileFragment extends BaseFragment {

    View view;
    Button save_details;
    ImageView no_edit;

    public static EditProfileFragment newInstance() {
        EditProfileFragment editProfileFragment = new EditProfileFragment();
        return editProfileFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        init(view);


        save_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container, new ProfileFragment(), null).addToBackStack(null).commit();
                onStop();


            }
        });


        no_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container, new ProfileFragment(), null).addToBackStack(null).commit();
                onStop();
            }
        });


        return view;
    }

    private void init(View view) {
        save_details = view.findViewById(R.id.save_user_details);
        no_edit = view.findViewById(R.id.cancel_edit_p);
        save_details.setOnClickListener(this);
        no_edit.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        //  setNavigationVisibility(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        //setNavigationVisibility(true);
        getActivity().findViewById(R.id.navigation).setVisibility(View.VISIBLE);
    }


    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


        }

    }
}

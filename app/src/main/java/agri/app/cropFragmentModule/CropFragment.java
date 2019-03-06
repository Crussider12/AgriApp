package agri.app.cropFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import agri.app.R;
import agri.app.Utili.BaseFragment;


public class CropFragment extends BaseFragment {
    View view;


    public static CropFragment newInstance() {
        CropFragment cropFragment = new CropFragment();
        return cropFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_crop, container, false);
        init(view);
        return view;


    }

    private void init(View view) {
        setToolBar("Crop",view);
    }


    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        getActivity().findViewById(R.id.navigation).setVisibility(View.VISIBLE);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(name);
    }

    @Override
    public void onClick(View v) {

    }
}

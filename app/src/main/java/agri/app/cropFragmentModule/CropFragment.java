package agri.app.cropFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;


public class CropFragment extends Fragment {
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
        return view;
    }
}

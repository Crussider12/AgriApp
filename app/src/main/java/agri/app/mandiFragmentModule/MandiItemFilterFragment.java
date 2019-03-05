package agri.app.mandiFragmentModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MandiItemFilterFragment extends Fragment {



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
        return inflater.inflate(R.layout.mandi_item_filter, container, false);
    }

}

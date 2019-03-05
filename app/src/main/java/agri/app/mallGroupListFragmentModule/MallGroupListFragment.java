package agri.app.mallGroupListFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;


public class MallGroupListFragment extends Fragment {
    View view;

    public static MallGroupListFragment newInstance() {
        MallGroupListFragment mallGroupListFragment = new MallGroupListFragment();
        return mallGroupListFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mall_group_list, container, false);


        return view;
    }
}

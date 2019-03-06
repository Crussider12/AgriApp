package agri.app.mallGroupListFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import agri.app.R;
import agri.app.Utili.BaseFragment;


public class MallGroupListFragment extends BaseFragment {
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

    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

    }

    @Override
    public void onClick(View v) {

    }
}

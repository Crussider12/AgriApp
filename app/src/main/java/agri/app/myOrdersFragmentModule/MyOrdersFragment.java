package agri.app.myOrdersFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;

public class MyOrdersFragment extends Fragment {View view;

    public static MyOrdersFragment newInstance() {
        MyOrdersFragment myOrdersFragment = new MyOrdersFragment();
        return myOrdersFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        return view;
    }
}

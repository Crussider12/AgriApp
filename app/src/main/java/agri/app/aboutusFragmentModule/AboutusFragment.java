package agri.app.aboutusFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;
public class AboutusFragment extends Fragment {
    View view;

    public static AboutusFragment newInstance() {
        AboutusFragment aboutusFragment = new AboutusFragment();
        return aboutusFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_aboutus, container, false);
        return view;
    }
}

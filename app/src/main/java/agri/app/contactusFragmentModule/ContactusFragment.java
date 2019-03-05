package agri.app.contactusFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;

public class ContactusFragment extends Fragment {
    View view;

    public static ContactusFragment newInstance() {
        ContactusFragment contactusFragment = new ContactusFragment();
        return contactusFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contactus, container, false);
        return view;
    }
}

package agri.app.loanFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;

public class LoanFragment extends Fragment {
    View view;

    public static LoanFragment newInstance() {
        LoanFragment loanFragment= new LoanFragment();
        return loanFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_loan, container, false);
        return view;
    }
}

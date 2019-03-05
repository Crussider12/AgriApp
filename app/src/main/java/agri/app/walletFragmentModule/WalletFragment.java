package agri.app.walletFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;

public class WalletFragment extends Fragment {
    View view;

    public static WalletFragment newInstance() {
        WalletFragment inputFragment = new WalletFragment();
        return inputFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wallet, container, false);
        return view;
    }
}

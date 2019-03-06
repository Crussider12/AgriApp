package agri.app.walletFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import agri.app.R;
import agri.app.Utili.BaseFragment;

public class WalletFragment extends BaseFragment {
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
        init();
        return view;
    }

    private void init() {
        setToolBar("Wallet",view);
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

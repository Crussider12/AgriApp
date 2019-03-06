package agri.app.logRegFragmentModule;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import agri.app.R;
import agri.app.Utili.BaseFragment;
import agri.app.databinding.FragmentLogRegBinding;

public class LogRegFragment extends BaseFragment {

    View view;
    FragmentLogRegBinding fragmentLogRegBinding;
    Context mContext;

    public LogRegFragment(){
        //Required Empty Constructor
    }

    public static LogRegFragment newInstance() {
        LogRegFragment logRegFragment = new LogRegFragment();
        return logRegFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentLogRegBinding =  DataBindingUtil.inflate(
                inflater, R.layout.fragment_log_reg, container, false);
        view = fragmentLogRegBinding.getRoot();
        initView();
        return view;
    }


    private void initView() {
        mContext = getActivity();
    }

    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

    }

    @Override
    public void onClick(View v) {

    }
}

package agri.app.mandiFragmentModule;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


import agri.app.Adapter.MandiDetailsAdapter;
import agri.app.R;
import agri.app.Utili.BaseFragment;


public class MandiItemDetailFragment extends BaseFragment {

    View view;

    Context context;
    RecyclerView rv_mandai;
    private ArrayList<String> data = new ArrayList<>();
    TextView txtToolBarTitle;
    ImageView imgToolBarBack;
    FragmentManager manager;

    public static MandiItemDetailFragment newInstance() {
        MandiItemDetailFragment mandiItemDetailFragment = new MandiItemDetailFragment();
        return mandiItemDetailFragment;
    }
    public MandiItemDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mandi_item_detail, container, false);

        init();
        return view;
    }

    private void init() {

        context=getActivity();
        manager = getFragmentManager();
        rv_mandai=view.findViewById(R.id.rv_mandai);
        rv_mandai.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        //data.add("1");data.add("1");data.add("1");data.add("1"); data.add("1");data.add("1");data.add("1");data.add("1"); data.add("1");data.add("1");data.add("1");data.add("1"); data.add("1");data.add("1");data.add("1");data.add("1");
        MandiDetailsAdapter mandiDetailsAdapter=new MandiDetailsAdapter(context,data);
        rv_mandai.setAdapter(mandiDetailsAdapter);

        txtToolBarTitle = view.findViewById(R.id.txtToolbarTitle);
        imgToolBarBack = view.findViewById(R.id.imgToolbarHome);
        setToolBar("Mandi Details",view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setToolBar("Mandi Details",view);
        //  setNavigationVisibility(false);
    }

    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        txtToolBarTitle.setText(name);
        imgToolBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getFragmentManager().getBackStackEntryCount() > 0)
                    manager.popBackStack();


            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}

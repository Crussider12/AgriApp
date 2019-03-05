package agri.app.mandiFragmentModule;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


import agri.app.Adapter.MandiDetailsAdapter;
import agri.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MandiItemDetailFragment extends Fragment {

    View view;

    Context context;
    RecyclerView rv_mandai;
    private ArrayList<String> data = new ArrayList<>();

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
        context=getActivity();
        rv_mandai=view.findViewById(R.id.rv_mandai);
        rv_mandai.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        //data.add("1");data.add("1");data.add("1");data.add("1"); data.add("1");data.add("1");data.add("1");data.add("1"); data.add("1");data.add("1");data.add("1");data.add("1"); data.add("1");data.add("1");data.add("1");data.add("1");
        MandiDetailsAdapter mandiDetailsAdapter=new MandiDetailsAdapter(context,data);
        rv_mandai.setAdapter(mandiDetailsAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        //  setNavigationVisibility(false);
    }
}

package agri.app.mandiFragmentModule;

import android.content.Context;
import android.databinding.DataBindingUtil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import agri.app.Adapter.MandiFragmentAdapters.RecyclerViewMandiDetailCard;
import agri.app.R;
import agri.app.RecyclerMandiItemDecoration.LinePagerIndicatorDecoration;
import agri.app.Utili.BaseFragment;
import agri.app.databinding.FragmentMandiBinding;

import static android.support.constraint.Constraints.TAG;

public class MandiFragment extends BaseFragment {
    View view;
    FragmentMandiBinding fragmentMandiBinding;
    Context mContext;

    private ArrayList<String> mImageURLs = new ArrayList<>();
    private ArrayList<String> mNameMandi = new ArrayList<>();
    private ArrayList<String> mPriceItem = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mDistanceMandi = new ArrayList<>();

    public MandiFragment() {
        // Required empty public constructor
    }

    public static MandiFragment newInstance() {
        MandiFragment mandiFragment = new MandiFragment();
        return mandiFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentMandiBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_mandi, container, false);
        view = fragmentMandiBinding.getRoot();
        initView();
        initDataFields();
        initRecyclerMandiView();
        return view;
    }

    private void initView() {
        mContext = getActivity();
        setToolBar("Mandi",view);
    }

    private void initRecyclerMandiView() {
        Log.d(TAG, "initRecyclerMandiCard: card mand");


        final RecyclerViewMandiDetailCard mandiDetailCard = new RecyclerViewMandiDetailCard(this, mNameMandi, mPriceItem, mDistanceMandi,
                mName ,mImageURLs);

        //These two for making one view on one row at a swipe time
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(fragmentMandiBinding.mandiDetailedRec);

        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fragmentMandiBinding.mandiDetailedRec.setLayoutManager(linearLayoutManager);
        fragmentMandiBinding.mandiDetailedRec.addItemDecoration(new LinePagerIndicatorDecoration());
        fragmentMandiBinding.mandiDetailedRec.setAdapter(mandiDetailCard);

    }

    private void initDataFields(){
        Log.d(TAG, "initDataFields: ");

        mImageURLs.add("https://image.freepik.com/free-photo/green-pepper-white-background_1205-545.jpg?1");
        mName.add("Capsicum");
        mNameMandi.add("Sangvi");
        mDistanceMandi.add("1.8 Km");
        mPriceItem.add("Price: 127");

        mImageURLs.add("https://image.freepik.com/free-photo/ripe-bananas-bunch_78361-10.jpg");
        mName.add("Banana");
        mNameMandi.add("Jakhan");
        mDistanceMandi.add("2.9 Km");
        mPriceItem.add("Price: 44");

        mImageURLs.add("https://image.freepik.com/free-photo/half-food-background-fresh-orange_1203-5919.jpg");
        mName.add("Papaye");
        mNameMandi.add("Rinwat");
        mDistanceMandi.add("0.7 Km");
        mPriceItem.add("Price: 244");

        mImageURLs.add("https://image.freepik.com/free-photo/close-up-halved-dragon-fruit-white-background_23-2147879664.jpg");
        mName.add("Dragon Fruit");
        mNameMandi.add("Kashi");
        mDistanceMandi.add("3.2 Km");
        mPriceItem.add("Price: 110");

    }

    @Override
    public void onResume() {
        super.onResume();
        setToolBar("Mandi",view);
        //  setNavigationVisibility(false);
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

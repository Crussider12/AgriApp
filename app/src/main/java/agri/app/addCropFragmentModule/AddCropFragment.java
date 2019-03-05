package agri.app.addCropFragmentModule;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import agri.app.Adapter.RecyclerViewCropSelectedDetail;
import agri.app.DataModule.CropSelectItemReq;
import agri.app.R;
import agri.app.databinding.FragmentAddCropBinding;

import static android.support.constraint.Constraints.TAG;


public class AddCropFragment extends Fragment {

    View view;
    Context mContext;
    FragmentAddCropBinding fragmentAddCropBinding;


    private ArrayList<String> mImageURLs = new ArrayList<>();
    private ArrayList<String> mNameMandi = new ArrayList<>();
    private ArrayList<String> mPriceItem = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mDistanceMandi = new ArrayList<>();
    private ArrayList<String> mItemReqName = new ArrayList<>();
    private ArrayList<String> mItemReqQuant = new ArrayList<>();
    private ArrayList<List<CropSelectItemReq>> mItemReq = new ArrayList<>();
    private ArrayList<Integer> posCropSelected;
    //   int i;
//    ArrayList<String> mImageURL = new ArrayList<>();
//    ArrayList<String> mNameMand = new ArrayList<>();
//    ArrayList<String> mPriceIte = new ArrayList<>();
//    ArrayList<String> mNam = new ArrayList<>();
//    ArrayList<String> mDistanceMand = new ArrayList<>();
//    ArrayList<String> mItemReqNam = new ArrayList<>();
//    ArrayList<String> mItemReqQuan = new ArrayList<>();

    List<CropSelectItemReq> cropallItem = getCropSelectItemReqObject();


    public AddCropFragment() {
        // Required empty public constructor
    }


    public static AddCropFragment newInstance() {
        AddCropFragment addCropFragment = new AddCropFragment();
        return addCropFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
              posCropSelected = getArguments().getIntegerArrayList("positions");
            Log.d(TAG, "onCreate: addFragcrop"+getArguments());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        fragmentAddCropBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_add_crop, container, false);
        view = fragmentAddCropBinding.getRoot();


        initView();
        initDataFields();


//        for (i = 0; i < posCropSelected.size(); i++) {
//            mImageURL.add(mImageURLs.get(posCropSelected.get(i)));
//            mNameMand.add(mNameMandi.get(posCropSelected.get(i)));
//            mPriceIte.add(mPriceItem.get(posCropSelected.get(i)));
//            mNam.add(mName.get(posCropSelected.get(i)));
//            mDistanceMand.add(mDistanceMandi.get(posCropSelected.get(i)));
//            mItemReqNam.add(mItemReqName.get(posCropSelected.get(i)));
//            mItemReqQuan.add(mItemReqQuant.get(posCropSelected.get(i)));
//            Log.d(TAG, "initRecyclerMandiView: " + posCropSelected + "");
//        }
        initRecyclerMandiView();
        return view;

    }

    private void initView() {
        mContext = getActivity();
    }

    private void initRecyclerMandiView() {
        Log.d(TAG, "initRecyclerMandiCard: card mand");


        final RecyclerViewCropSelectedDetail cropDetailCard = new RecyclerViewCropSelectedDetail(this, mNameMandi, mPriceItem, mDistanceMandi,
                mName, mImageURLs, mItemReqName, mItemReqQuant);

        //These two for making one view on one row at a swipe time
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(fragmentAddCropBinding.cropSelectedDetailedRec);

        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fragmentAddCropBinding.cropSelectedDetailedRec.setLayoutManager(linearLayoutManager);
        fragmentAddCropBinding.cropSelectedDetailedRec.setAdapter(cropDetailCard);

    }

    private void initDataFields() {
        Log.d(TAG, "initDataFields: ");

        mImageURLs.add("https://image.freepik.com/free-photo/green-pepper-white-background_1205-545.jpg?1");
        mName.add("Capsicum");
        mNameMandi.add("5.4 Metric ton");
        mDistanceMandi.add("1.2 Lakh");
        mPriceItem.add("360 Rs/Kg");
        mItemReqName.add("Seed");
        mItemReqQuant.add("50 Kg");
        mItemReqName.add("Irrigation");
        mItemReqQuant.add("500 Lt");


        mImageURLs.add("https://image.freepik.com/free-photo/ripe-bananas-bunch_78361-10.jpg");
        mName.add("Banana");
        mNameMandi.add("2 Metric ton");
        mDistanceMandi.add("90 Thousand");
        mPriceItem.add("36 Rs/Kg");
        mItemReqName.add("Pesticide");
        mItemReqQuant.add("50 Kg");
        mItemReqName.add("PGR");
        mItemReqQuant.add("15 Lt");

        mImageURLs.add("https://image.freepik.com/free-photo/half-food-background-fresh-orange_1203-5919.jpg");
        mName.add("Papaye");
        mNameMandi.add("1 Metric ton");
        mDistanceMandi.add("39 Thousand");
        mPriceItem.add("470 Rs/Kg");
        mItemReqName.add("Seed");
        mItemReqQuant.add("50 Kg");

        mImageURLs.add("https://image.freepik.com/free-photo/close-up-halved-dragon-fruit-white-background_23-2147879664.jpg");
        mName.add("Dragon Fruit");
        mNameMandi.add("3.7 Metric ton");
        mDistanceMandi.add("4.9 Lakh");
        mPriceItem.add("39 Rs/Kg");
        mItemReqName.add("Seed");
        mItemReqQuant.add("5 Kg");
        mItemReqName.add("Pesticide");
        mItemReqQuant.add("10 Kg");


    }

    private List<CropSelectItemReq> getCropSelectItemReqObject() {
        CropSelectItemReq cropSelectItemReq = null;
        List<CropSelectItemReq> items = new ArrayList<>();
        items.add(new CropSelectItemReq("Pesticide", "100 Lt"));
        items.add(new CropSelectItemReq("Seed", "50 Kg"));
        items.add(new CropSelectItemReq("Irrigation", "47 Lt"));
        items.add(new CropSelectItemReq("PGR", "10 Kg"));
        items.add(new CropSelectItemReq("Fertilizer", "57 Kg"));

        return items;
    }

}

package agri.app.homeFragmentModule;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

import agri.app.Adapter.CropHomeAdapter.RecyclerViewCropDetailCard;
import agri.app.Adapter.HomeFragmentAdapters.RecyclerViewMandiCard;
import agri.app.Adapter.RecyclerViewAdapter;
import agri.app.MainActivity;
import agri.app.R;
import agri.app.Utili.BaseFragment;
import agri.app.databinding.FragmentHomeBinding;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends BaseFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    View view;
    FragmentHomeBinding fragmentHomeBinding;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageURLS = new ArrayList<>();
    private ArrayList<String> mNameMandi = new ArrayList<>();
    private ArrayList<String> mPriceItem = new ArrayList<>();
    private ArrayList<String> mDistanceMandi = new ArrayList<>();

    private ArrayList<String> mCropVariety = new ArrayList<>();
    private ArrayList<String> mCropFarmName = new ArrayList<>();
    private ArrayList<String> mCropName = new ArrayList<>();
    private ArrayList<String> mCropLandSize = new ArrayList<>();
    private ArrayList<String> mCropSOD = new ArrayList<>();
    private ArrayList<Integer> posCropSelected;
    int i;
    ArrayList<String> mImageURL = new ArrayList<>();
    ArrayList<String> mNam = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false);
        view = fragmentHomeBinding.getRoot();

        MainActivity activity =(MainActivity)getActivity();
        posCropSelected = activity.getMyDataCrop();
        Log.d(TAG, "onCreate: addFragcrop"+posCropSelected);




        initView();
        intiSilder();
        initImageBitmaps();
        for (i = 0; i < posCropSelected.size(); i++) {
            mImageURL.add(mImageURLS.get(posCropSelected.get(i)));
            mNam.add(mNames.get(posCropSelected.get(i)));
            Log.d(TAG, "initRecyclerMandiView: " + posCropSelected + "");
        }

        initRecyclerView();
        initRecyclerMandiCard();
        initRecyclerCropCard();
        return view;
    }

    private void initView() {
        mContext = getActivity();
        setToolBar("Home",view);
    }

    private void intiSilder() {
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Shop Wise, Be Wise", R.drawable.slide1x);
        file_maps.put("Naap Tol Kiya Kya!", R.drawable.slide2x);
        file_maps.put("Know Prices Before Shopping", R.drawable.slide3x);
        file_maps.put("Latest Prices At Your Fingertips", R.drawable.slide4x);
        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(mContext);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);


            fragmentHomeBinding.slider.addSlider(textSliderView);
            fragmentHomeBinding.slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
            fragmentHomeBinding.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            fragmentHomeBinding.slider.setCustomAnimation(new DescriptionAnimation());
            fragmentHomeBinding.slider.setDuration(4000);
            fragmentHomeBinding.slider.addOnPageChangeListener(this);
        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: recyclerviewinitialisation");
        //it refers to the adapter made seperately
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNam, mImageURL);

        //The fragment recycler for adding the starting crop addition





        fragmentHomeBinding.veglititem.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (mNam.size()<=3 && fragmentHomeBinding.vegArrow.getVisibility() == View.VISIBLE) {
                    fragmentHomeBinding.vegArrow.setVisibility(View.INVISIBLE);

                } else if (mNam.size()> 3 && fragmentHomeBinding.vegArrow.getVisibility() != View.VISIBLE) {
                    fragmentHomeBinding.vegArrow.setVisibility(View.VISIBLE);
                }

            }
        });

        //Horizontal View for Recycler View
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fragmentHomeBinding.veglititem.setLayoutManager(linearLayoutManager);
        fragmentHomeBinding.veglititem.setAdapter(adapter);
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageURLS.add("https://image.freepik.com/free-photo/green-pepper-white-background_1205-545.jpg?1");
        mNames.add("Capsicum");
        mNameMandi.add("Sangvi");
        mDistanceMandi.add("1.8 Km");
        mPriceItem.add("Price: 127");
        mCropFarmName.add("First Farm");
        mCropVariety.add("Class 1");
        mCropName.add("Capsicum");
        mCropLandSize.add("350 sqFt");
        mCropSOD.add("19-05-2018");



        mImageURLS.add("https://image.freepik.com/free-photo/ripe-bananas-bunch_78361-10.jpg");
        mNames.add("Banana");
        mNameMandi.add("Jakhan");
        mDistanceMandi.add("2.9 Km");
        mPriceItem.add("Price: 44");
        mCropFarmName.add("Second Farm");
        mCropVariety.add("Class A");
        mCropName.add("Banana");
        mCropLandSize.add("1787 sqFt");
        mCropSOD.add("07-09-2018");

        mImageURLS.add("https://image.freepik.com/free-photo/half-food-background-fresh-orange_1203-5919.jpg");
        mNames.add("Papaye");
        mNameMandi.add("Rinwat");
        mDistanceMandi.add("0.7 Km");
        mPriceItem.add("Price: 244");
        mCropFarmName.add("Third Farm");
        mCropVariety.add("Second S");
        mCropName.add("Papaye");
        mCropLandSize.add("2420 sqFt");
        mCropSOD.add("12-05-2018");

        mImageURLS.add("https://image.freepik.com/free-photo/close-up-halved-dragon-fruit-white-background_23-2147879664.jpg");
        mNames.add("Dragon Fruit");
        mNameMandi.add("Kashi");
        mDistanceMandi.add("3.2 Km");
        mPriceItem.add("Price: 110");
        mCropFarmName.add("Farm Fourth");
        mCropVariety.add("Special");
        mCropName.add("Dragon Fruit");
        mCropLandSize.add("980 sqFt");
        mCropSOD.add("19-01-2018");

        mImageURLS.add("https://png.pngtree.com/svg/20151023/add_button_88459.png");
        mNames.add("Add");

    }

    private void initRecyclerMandiCard() {
        Log.d(TAG, "initRecyclerMandiCard: card mand");


        final RecyclerViewMandiCard mandiCard = new RecyclerViewMandiCard(this, mNameMandi, mPriceItem, mDistanceMandi,
                mImageURLS);

        //These two for making one view on one row at a swipe time
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(fragmentHomeBinding.mandiCardRec);


        fragmentHomeBinding.mandiCardRec.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx,int dy) {
                super.onScrolled(recyclerView,dx,dy);
                    mandiCard.updateArrow(dx);
            }
        });


        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fragmentHomeBinding.mandiCardRec.setLayoutManager(linearLayoutManager);
        fragmentHomeBinding.mandiCardRec.setAdapter(mandiCard);

    }

    private void initRecyclerCropCard(){
        Log.d(TAG, "initRecyclerCropCard: Card crop");

        final RecyclerViewCropDetailCard cropDetailCard = new RecyclerViewCropDetailCard(this, mCropName,
                mCropFarmName, mCropVariety, mCropLandSize,mCropSOD, mImageURLS);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(fragmentHomeBinding.cropRec);

        fragmentHomeBinding.cropRec.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx,int dy) {
                super.onScrolled(recyclerView,dx,dy);
               // mandiCard.updateArrow(dx);
            }
        });


        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fragmentHomeBinding.cropRec.setLayoutManager(linearLayoutManager);
        fragmentHomeBinding.cropRec.setAdapter(cropDetailCard);


    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onResume() {
        super.onResume();
        setToolBar("Home",view);


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

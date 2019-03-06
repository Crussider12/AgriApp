package agri.app.cropFragmentModule;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import agri.app.Adapter.CropAdditionGridAdapter;
import agri.app.DataModule.CropAddItemPOJO;
import agri.app.MainActivity;
import agri.app.R;
import agri.app.Utili.BaseFragment;
import agri.app.databinding.FragmentCropBinding;
import agri.app.homeFragmentModule.HomeFragment;

import static android.support.constraint.Constraints.TAG;


public class CropFragment extends BaseFragment {

    View view;
    FragmentCropBinding fragmentCropBinding;
    List<CropAddItemPOJO> cropallItem = getAllCropItemObject();
    Context mContext;
    TextView txtToolBarTitle;
    ImageView imgToolBarBack;
    FragmentManager manager;
    int i;
    ArrayList<Integer> posCropSelected;

    private static final String TAG = "CropFragment";

    public CropFragment() {
        // Required empty public constructor
    }

    public static CropFragment newInstance() {
        CropFragment cropFragment = new CropFragment();
        return cropFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentCropBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_crop, container, false);
        view = fragmentCropBinding.getRoot();

        initView();
        CropAdditionGridAdapter gridAd = new CropAdditionGridAdapter(mContext, cropallItem);
        // gridAd.notifyDataSetChanged();
        fragmentCropBinding.cropSelectionFirstView.setAdapter(gridAd);

        fragmentCropBinding.cropSelectionFirstAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MainActivity activity = (MainActivity) getActivity();

                posCropSelected = activity.getMyCrop();
                Log.d(TAG, "onCreateView: " + posCropSelected);

                if (posCropSelected!=null){i = posCropSelected.size();}

                if (i!= 0) {
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment_container, homeFragment).addToBackStack(null).commit();
                }else{

                    Toast.makeText(getActivity(), "AddMore", Toast.LENGTH_LONG).show();
                  //  Log.d(TAG, "onClick: after adition "+i);
                }
            }
        });

        return view;
    }

    public void initView() {
        mContext = getActivity();
        manager = getFragmentManager();
        txtToolBarTitle = fragmentCropBinding.toolbar.findViewById(R.id.txtToolbarTitle);
        txtToolBarTitle.setText("Crop Addition");
        i=0;

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        imgToolBarBack = fragmentCropBinding.toolbar.findViewById(R.id.imgToolbarHome);
        imgToolBarBack.setVisibility(View.GONE);
        //        imgToolBarBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (getFragmentManager().getBackStackEntryCount() > 0)
//                    manager.popBackStack();
//
//
//            }
//        });
    }

    private List<CropAddItemPOJO> getAllCropItemObject() {
        CropAddItemPOJO cropAddItemPOJO = null;
        List<CropAddItemPOJO> items = new ArrayList<>();
        items.add(new CropAddItemPOJO("Capsicum", "https://image.freepik.com/free-photo/green-pepper-white-background_1205-545.jpg?1"));
        items.add(new CropAddItemPOJO("Banana", "https://image.freepik.com/free-photo/ripe-bananas-bunch_78361-10.jpg"));
        items.add(new CropAddItemPOJO("Papaya", "https://image.freepik.com/free-photo/half-food-background-fresh-orange_1203-5919.jpg"));
        items.add(new CropAddItemPOJO("Dragon Fruit", "https://image.freepik.com/free-photo/close-up-halved-dragon-fruit-white-background_23-2147879664.jpg"));
        items.add(new CropAddItemPOJO("Random1", "https://image.freepik.com/free-photo/half-food-background-fresh-orange_1203-5919.jpg"));
        items.add(new CropAddItemPOJO("Random2", "https://image.freepik.com/free-photo/close-up-halved-dragon-fruit-white-background_23-2147879664.jpg"));

        return items;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        //  setNavigationVisibility(false);
    }


    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

    }

    @Override
    public void onClick(View v) {

    }
}

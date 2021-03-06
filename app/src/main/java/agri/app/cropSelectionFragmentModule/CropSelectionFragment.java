package agri.app.cropSelectionFragmentModule;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import agri.app.Adapter.CropSelectionAdapter.CropSelectionGridAdapter;
import agri.app.MainActivity;
import agri.app.Utili.BaseFragment;
import agri.app.addCropFragmentModule.AddCropFragment;
import agri.app.DataModule.CropItemSelectionPOJO;
import agri.app.Interfaces.FragmentCommunicationCrop;
import agri.app.R;
import agri.app.databinding.FragmentCropSelectionBinding;
import agri.app.databinding.FragmentHomeBinding;

import static android.support.constraint.Constraints.TAG;


public class CropSelectionFragment extends BaseFragment implements FragmentCommunicationCrop {


    View view;
    FragmentCropSelectionBinding fragmentCropSelectionBinding;
    List<CropItemSelectionPOJO> cropallItem = getAllCropItemObject();
    Context mContext;
    TextView txtToolBarTitle;
    ImageView imgToolBarBack;
    FragmentManager manager;
    ArrayList<Integer> posCrop;
    int i;
    String strtext;

    private static final String TAG = "CropSelectionFragment";

    public CropSelectionFragment() {
        // Required empty public constructor
    }


    public static CropSelectionFragment newInstance() {
        CropSelectionFragment cropSelectionFragment = new CropSelectionFragment();
        return cropSelectionFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        strtext = getArguments().getString("from_fragment");
        Log.d(TAG, "onCreateView: " + strtext);

        fragmentCropSelectionBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_crop_selection, container, false);
        view = fragmentCropSelectionBinding.getRoot();

        initView();

        CropSelectionGridAdapter gridAd = new CropSelectionGridAdapter(mContext, cropallItem);
        gridAd.notifyDataSetChanged();
        fragmentCropSelectionBinding.cropSelectionGrid.setAdapter(gridAd);

        fragmentCropSelectionBinding.cropSelectionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity = (MainActivity) getActivity();
                posCrop = activity.getMyDaCr();
                Log.d(TAG, "onCreateView: " + posCrop);

                if (posCrop != null) {
                    i = posCrop.size();
                }

                if (i != 0) {

                    AddCropFragment addCropFragment = new AddCropFragment();

                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment_container, addCropFragment).addToBackStack(null).commit();
                } else {

                    Toast.makeText(getActivity(), "AddMore", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onClick: after adition " + i);
                }
            }
        });
        return view;
    }


    public void initView() {
        mContext = getActivity();
        manager = getFragmentManager();
        setToolBar("Crop selection", view);
        i = 0;

    }

    private List<CropItemSelectionPOJO> getAllCropItemObject() {
        CropItemSelectionPOJO cropItemSelectionPOJO = null;
        List<CropItemSelectionPOJO> items = new ArrayList<>();
        items.add(new CropItemSelectionPOJO("Capsicum", "https://image.freepik.com/free-photo/green-pepper-white-background_1205-545.jpg?1"));
        items.add(new CropItemSelectionPOJO("Banana", "https://image.freepik.com/free-photo/ripe-bananas-bunch_78361-10.jpg"));
        items.add(new CropItemSelectionPOJO("Papaya", "https://image.freepik.com/free-photo/half-food-background-fresh-orange_1203-5919.jpg"));
        items.add(new CropItemSelectionPOJO("Dragon Fruit", "https://image.freepik.com/free-photo/close-up-halved-dragon-fruit-white-background_23-2147879664.jpg"));
        items.add(new CropItemSelectionPOJO("Random1", "https://image.freepik.com/free-photo/half-food-background-fresh-orange_1203-5919.jpg"));
        items.add(new CropItemSelectionPOJO("Random2", "https://image.freepik.com/free-photo/close-up-halved-dragon-fruit-white-background_23-2147879664.jpg"));

        return items;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (strtext == "add") {
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
            getActivity().findViewById(R.id.navigation).setVisibility(View.GONE);
        } else {
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
            getActivity().findViewById(R.id.navigation).setVisibility(View.VISIBLE);
        }

        //  setNavigationVisibility(false);
    }

    ArrayList<Integer> posCropSelected;

    @Override
    public void respond(ArrayList<Integer> position) {
        posCropSelected = position;
        Log.d(TAG, "respond: frag" + position);
    }


    @Override
    public void setToolBar(@NotNull String name, @NotNull View view) {

        if (strtext == "add") {
            txtToolBarTitle = fragmentCropSelectionBinding.toolbar.findViewById(R.id.txtToolbarTitle);
            txtToolBarTitle.setText(name);
            imgToolBarBack = fragmentCropSelectionBinding.toolbar.findViewById(R.id.imgToolbarHome);
            imgToolBarBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (getFragmentManager().getBackStackEntryCount() > 0)
                        manager.popBackStack();


                }
            });
        }else{
            fragmentCropSelectionBinding.collapsingToolbar.setVisibility(View.GONE);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(name);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)fragmentCropSelectionBinding.cropAddLinLay.getLayoutParams();
            int x = getActivity().findViewById(R.id.navigation).getHeight();
            Log.d(TAG, "setToolBar: "+x);
            params.setMargins(0, 0, 0, x);
            fragmentCropSelectionBinding.cropAddLinLay.setLayoutParams(params);

        }
    }

    @Override
    public void onClick(View v) {

    }
}

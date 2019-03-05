package agri.app.registrationFragmentModule;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import agri.app.Customviews.HelveticaNeuRegularEditText;
import agri.app.R;

import static android.support.constraint.Constraints.TAG;

public class RegistrationFragment extends Fragment {


    View view;
    LinearLayout linearLayout, mech_lay;
    HelveticaNeuRegularEditText input_uname_last;
    Button btn_male, btn_female, btn_pum, btn_can, btn_dri, btn_spri, btn_mech_own, btn_mech_rent, mech_own_hi, mech_own_med, mech_own_lo;
    Spinner unit_spin;
    String item;
    Boolean bt,bt2,bt3,bt4,bt5,bt6;


    public static RegistrationFragment newInstance() {
        RegistrationFragment registrationFragment = new RegistrationFragment();
        return registrationFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_registration, container, false);

        bt=bt2=bt3=bt4=bt5=bt6=false;
        mech_own_hi = view.findViewById(R.id.reg_mech_own_high);
        mech_own_med = view.findViewById(R.id.reg_mech_own_med);
        mech_own_lo = view.findViewById(R.id.reg_mech_own_low);
        linearLayout = view.findViewById(R.id.name_parts);
        btn_male = view.findViewById(R.id.reg_gender_male);
        btn_female = view.findViewById(R.id.reg_gender_female);
        mech_lay = view.findViewById(R.id.reg_mech_size_lay);
        unit_spin = view.findViewById(R.id.unit_spin);


        List<String> categories = new ArrayList<String>();
        categories.add("Select");
        categories.add("Acre");
        categories.add("Ghunta");
        categories.add("Bigha");
        categories.add("Gaj");
        categories.add("Yard");
        categories.add("SQMeter");
        categories.add("SQMile");

        String[] fruits = {"Apple", "appricot", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};

        ArrayAdapter<String> autoadap = new ArrayAdapter<String>
                (this.getActivity(), android.R.layout.select_dialog_item, fruits);
        final AutoCompleteTextView actv = view.findViewById(R.id.autoCompleteTextView);


        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }
        });
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(autoadap);//setting the adapter data into the AutoCompleteTextView


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        unit_spin.setAdapter(adapter);


        btn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_male.setBackgroundResource(R.drawable.button_background_reg);
                btn_male.setTextColor(Color.WHITE);
                btn_female.setBackgroundResource(R.drawable.button_border);
                btn_female.setTextColor(Color.GRAY);

            }
        });


        btn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_female.setBackgroundResource(R.drawable.button_background_reg);
                btn_female.setTextColor(Color.WHITE);
                btn_male.setBackgroundResource(R.drawable.button_border);
                btn_male.setTextColor(Color.GRAY);

            }
        });

        input_uname_last = view.findViewById(R.id.reg_input_uname_last);


        input_uname_last.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });


        btn_pum = view.findViewById(R.id.reg_iri_pump);
        btn_can = view.findViewById(R.id.reg_iri_canal);
        btn_dri = view.findViewById(R.id.reg_iri_drip);
        btn_spri = view.findViewById(R.id.reg_iri_sprin);

        btn_pum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!bt) {
                    btn_pum.setBackgroundResource(R.drawable.button_background_reg);
                    btn_pum.setTextColor(Color.WHITE);
                    Log.d(TAG, "onClick: " + bt);
                    bt = true;

                } else {
                    btn_pum.setBackgroundResource(R.drawable.button_border);
                    btn_pum.setTextColor(Color.GRAY);
                    Log.d(TAG, "onClick: " + bt);
                    bt = false;
                }
            }
        });


        btn_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bt2) {
                    btn_can.setBackgroundResource(R.drawable.button_background_reg);
                    btn_can.setTextColor(Color.WHITE);
                    Log.d(TAG, "onClick: " + bt);
                    bt2 = true;

                } else {
                    btn_can.setBackgroundResource(R.drawable.button_border);
                    btn_can.setTextColor(Color.GRAY);
                    Log.d(TAG, "onClick: " + bt);
                    bt2 = false;
                }
            }
        });


        btn_dri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bt3) {
                    btn_dri.setBackgroundResource(R.drawable.button_background_reg);
                    btn_dri.setTextColor(Color.WHITE);
                    Log.d(TAG, "onClick: " + bt);
                    bt3 = true;

                } else {
                    btn_dri.setBackgroundResource(R.drawable.button_border);
                    btn_dri.setTextColor(Color.GRAY);
                    Log.d(TAG, "onClick: " + bt);
                    bt3 = false;
                }
            }
        });


        btn_spri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bt4) {
                    btn_spri.setBackgroundResource(R.drawable.button_background_reg);
                    btn_spri.setTextColor(Color.WHITE);
                    Log.d(TAG, "onClick: " + bt);
                    bt4 = true;

                } else {
                    btn_spri.setBackgroundResource(R.drawable.button_border);
                    btn_spri.setTextColor(Color.GRAY);
                    Log.d(TAG, "onClick: " + bt);
                    bt4 = false;
                }
            }
        });

        btn_mech_own = view.findViewById(R.id.reg_mech_own);
        btn_mech_rent = view.findViewById(R.id.reg_mech_rent);


        btn_mech_own.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bt5) {
                    btn_mech_own.setBackgroundResource(R.drawable.button_background_reg);
                    btn_mech_own.setTextColor(Color.WHITE);
                    Log.d(TAG, "onClick: " + bt);
                    mech_lay.setVisibility(View.VISIBLE);
                    bt5 = true;

                } else {
                    btn_mech_own.setBackgroundResource(R.drawable.button_border);
                    btn_mech_own.setTextColor(Color.GRAY);
                    Log.d(TAG, "onClick: " + bt);
                    mech_lay.setVisibility(View.GONE);
                    bt5 = false;
                }
            }
        });


        btn_mech_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bt6) {
                    btn_mech_rent.setBackgroundResource(R.drawable.button_background_reg);
                    btn_mech_rent.setTextColor(Color.WHITE);
                    Log.d(TAG, "onClick: " + bt);
                    bt6 = true;

                } else {
                    btn_mech_rent.setBackgroundResource(R.drawable.button_border);
                    btn_mech_rent.setTextColor(Color.GRAY);
                    Log.d(TAG, "onClick: " + bt);
                    bt6 = false;
                }
            }
        });

        mech_own_hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mech_own_hi.setBackgroundResource(R.drawable.button_background_reg);
                mech_own_hi.setTextColor(Color.WHITE);
                mech_own_med.setBackgroundResource(R.drawable.button_border);
                mech_own_med.setTextColor(Color.GRAY);
                mech_own_lo.setBackgroundResource(R.drawable.button_border);
                mech_own_lo.setTextColor(Color.GRAY);

            }
        });

        mech_own_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mech_own_med.setBackgroundResource(R.drawable.button_background_reg);
                mech_own_med.setTextColor(Color.WHITE);
                mech_own_hi.setBackgroundResource(R.drawable.button_border);
                mech_own_hi.setTextColor(Color.GRAY);
                mech_own_lo.setBackgroundResource(R.drawable.button_border);
                mech_own_lo.setTextColor(Color.GRAY);

            }
        });

        mech_own_lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mech_own_lo.setBackgroundResource(R.drawable.button_background_reg);
                mech_own_lo.setTextColor(Color.WHITE);
                mech_own_med.setBackgroundResource(R.drawable.button_border);
                mech_own_med.setTextColor(Color.GRAY);
                mech_own_hi.setBackgroundResource(R.drawable.button_border);
                mech_own_hi.setTextColor(Color.GRAY);

            }
        });

        return view;
    }
}

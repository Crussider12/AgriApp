package agri.app.Utili;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


import agri.app.Customviews.HelveticaNeuRegularEditText;
import agri.app.R;

public class CustomDialogCropFarm extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    public HelveticaNeuRegularEditText mFarmName, mSowDate, mCultivationArea;
    String mFarm_name, mSow_date, mCultivation_area;

    public CustomDialogCropFarm(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.crop_add_dialog);
        yes = (Button) findViewById(R.id.dialog_add);
        no = (Button) findViewById(R.id.dialog_cancel);
        mFarmName = findViewById(R.id.crop_farm_name);
        mSowDate = findViewById(R.id.crop_farm_sow_date);
        mCultivationArea = findViewById(R.id.crop_farm_area);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_add:
                Toast.makeText(c,"working dialog",Toast.LENGTH_SHORT).show();
                mFarm_name = mFarmName.getText().toString();
                mSow_date = mSowDate.getText().toString();
                mCultivation_area = mCultivationArea.getText().toString();
                if (!mFarm_name.isEmpty() && !mSow_date.isEmpty() && !mCultivation_area.isEmpty()) {
                    //do something
                    Toast.makeText(c,"working dialog gettng strings",Toast.LENGTH_SHORT).show();
                }else{
                    if (mFarm_name.isEmpty()){
                        Toast.makeText(c,"Empty Field: Farm Name",Toast.LENGTH_SHORT).show();
                    }else if(mSow_date.isEmpty()){
                        Toast.makeText(c,"Empty Field: Farm Name",Toast.LENGTH_SHORT).show();
                    }else if(mCultivation_area.isEmpty()){
                        Toast.makeText(c,"Empty Field: Farm Name",Toast.LENGTH_SHORT).show();
                    }

                }
                break;
            case R.id.dialog_cancel:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
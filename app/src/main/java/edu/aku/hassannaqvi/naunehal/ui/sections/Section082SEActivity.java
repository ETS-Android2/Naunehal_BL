package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection082seBinding;
import edu.aku.hassannaqvi.naunehal.ui.EndingActivity;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.utils.extension.ActivityExtKt.gotoActivityWithSerializable;

public class Section082SEActivity extends AppCompatActivity {

    ActivitySection082seBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // only in First Section
        //MainApp.form = new Form();

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_082se);
        bi.setForm(MainApp.form);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.se23.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.llse23.setVisibility(View.VISIBLE);
            if (i == bi.se2302.getId()) {
                Clear.clearAllFields(bi.llse23);
                bi.llse23.setVisibility(View.GONE);
            }
        });

        bi.se36.setOnCheckedChangeListener(((radioGroup, i) -> {
            bi.fldGrpse36.setVisibility(View.VISIBLE);
            bi.fldGrpse37.setVisibility(View.VISIBLE);
            if (i == bi.se3602.getId()) {
                Clear.clearAllFields(bi.fldGrpse36);
                Clear.clearAllFields(bi.fldGrpse37);
                bi.fldGrpse36.setVisibility(View.GONE);
                bi.fldGrpse37.setVisibility(View.GONE);
            }
        }));
    }


    private void saveDraft() {

        form.setSe2201(bi.se220101.isChecked() ? "1"
                : bi.se220102.isChecked() ? "2"
                : "-1");

        form.setSe2202(bi.se220201.isChecked() ? "1"
                : bi.se220202.isChecked() ? "2"
                : "-1");

        form.setSe2203(bi.se220301.isChecked() ? "1"
                : bi.se220302.isChecked() ? "2"
                : "-1");

        form.setSe2204(bi.se220401.isChecked() ? "1"
                : bi.se220402.isChecked() ? "2"
                : "-1");

        form.setSe2205(bi.se220501.isChecked() ? "1"
                : bi.se220502.isChecked() ? "2"
                : "-1");

        form.setSe2206(bi.se220601.isChecked() ? "1"
                : bi.se220602.isChecked() ? "2"
                : "-1");

        form.setSe2207(bi.se220701.isChecked() ? "1"
                : bi.se220702.isChecked() ? "2"
                : "-1");

        form.setSe2208(bi.se220801.isChecked() ? "1"
                : bi.se220802.isChecked() ? "2"
                : "-1");

        form.setSe2209(bi.se220901.isChecked() ? "1"
                : bi.se220902.isChecked() ? "2"
                : "-1");

        form.setSe2210(bi.se221001.isChecked() ? "1"
                : bi.se221002.isChecked() ? "2"
                : "-1");

        form.setSe2211(bi.se221101.isChecked() ? "1"
                : bi.se221102.isChecked() ? "2"
                : "-1");

        form.setSe2212(bi.se221201.isChecked() ? "1"
                : bi.se221202.isChecked() ? "2"
                : "-1");

        form.setSe2213(bi.se221301.isChecked() ? "1"
                : bi.se221302.isChecked() ? "2"
                : "-1");

        form.setSe2214(bi.se221401.isChecked() ? "1"
                : bi.se221402.isChecked() ? "2"
                : "-1");

        form.setSe2215(bi.se221501.isChecked() ? "1"
                : bi.se221502.isChecked() ? "2"
                : "-1");

        form.setSe2216(bi.se221601.isChecked() ? "1"
                : bi.se221602.isChecked() ? "2"
                : "-1");

        form.setSe2217(bi.se221701.isChecked() ? "1"
                : bi.se221702.isChecked() ? "2"
                : "-1");

        form.setSe2218(bi.se221801.isChecked() ? "1"
                : bi.se221802.isChecked() ? "2"
                : "-1");

        form.setSe23(bi.se2301.isChecked() ? "1"
                : bi.se2302.isChecked() ? "2"
                : "-1");

        form.setSe24(bi.se24.getText().toString());

        form.setSe25(bi.se25.getText().toString());

        form.setSe26(bi.se26.getText().toString());

        form.setSe2701(bi.se2701.isChecked() ? "1" : "-1");

        form.setSe2702(bi.se2702.isChecked() ? "2" : "-1");

        form.setSe2703(bi.se2703.isChecked() ? "3" : "-1");

        form.setSe2704(bi.se2704.isChecked() ? "4" : "-1");

        form.setSe2801(bi.se2801.isChecked() ? "1" : "-1");

        form.setSe2802(bi.se2802.isChecked() ? "2" : "-1");

        form.setSe2803(bi.se2803.isChecked() ? "3" : "-1");

        form.setSe29(bi.se2901.isChecked() ? "1"
                : bi.se2902.isChecked() ? "2"
                : "-1");

        form.setSe3001(bi.se3001.isChecked() ? "1" : "-1");

        form.setSe3002(bi.se3002.isChecked() ? "2" : "-1");

        form.setSe3003(bi.se3003.isChecked() ? "3" : "-1");

        form.setSe3096(bi.se3096.isChecked() ? "96" : "-1");

        form.setSe3096x(bi.se3096x.getText().toString());
        form.setSe31(bi.se3101.isChecked() ? "1"
                : bi.se3102.isChecked() ? "2"
                : bi.se3196.isChecked() ? "96"
                : "-1");

        form.setSe3196x(bi.se3196x.getText().toString());
        form.setSe32(bi.se3201.isChecked() ? "1"
                : bi.se3202.isChecked() ? "2"
                : bi.se3203.isChecked() ? "3"
                : bi.se3204.isChecked() ? "4"
                : bi.se3205.isChecked() ? "5"
                : bi.se3206.isChecked() ? "6"
                : bi.se3207.isChecked() ? "7"
                : bi.se3208.isChecked() ? "8"
                : bi.se3209.isChecked() ? "9"
                : "-1");

        form.setSe3302(bi.se3302.getText().toString());
        form.setSe3301(bi.se3301.getText().toString());
        form.setSe3401(bi.se3401.getText().toString());
        form.setSe3402(bi.se3402.getText().toString());
        form.setSe35(bi.se3501.isChecked() ? "1"
                : bi.se3502.isChecked() ? "2"
                : bi.se3598.isChecked() ? "98"
                : "-1");

        form.setSe36(bi.se3601.isChecked() ? "1"
                : bi.se3602.isChecked() ? "2"
                : bi.se3698.isChecked() ? "98"
                : "-1");

        form.setSe3701(bi.se3701.isChecked() ? "1" : "-1");

        form.setSe3702(bi.se3702.isChecked() ? "2" : "-1");

        form.setSe3703(bi.se3703.isChecked() ? "3" : "-1");

        form.setSe3704(bi.se3704.isChecked() ? "4" : "-1");

        form.setSe3705(bi.se3705.isChecked() ? "5" : "-1");

        form.setSe3706(bi.se3706.isChecked() ? "6" : "-1");

        form.setSe3707(bi.se3707.isChecked() ? "7" : "-1");

        form.setSe3708(bi.se3708.isChecked() ? "8" : "-1");

        form.setSe3709(bi.se3709.isChecked() ? "9" : "-1");

        form.setSe3796(bi.se3796.isChecked() ? "96" : "-1");

        form.setSe3796x(bi.se3796x.getText().toString());
        form.setSe38(bi.se3801.isChecked() ? "1"
                : bi.se3802.isChecked() ? "2"
                : bi.se3803.isChecked() ? "3"
                : bi.se3804.isChecked() ? "4"
                : bi.se3805.isChecked() ? "5"
                : bi.se3898.isChecked() ? "98"
                : "-1");

        form.setSe39(bi.se3901.isChecked() ? "1"
                : bi.se3902.isChecked() ? "2"
                : "-1");

        form.setSe40(bi.se4001.isChecked() ? "1"
                : bi.se4002.isChecked() ? "2"
                : bi.se4098.isChecked() ? "98"
                : "-1");
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S08SE, form.s08SEtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        if (UpdateDB()) {
            finish();
            gotoActivityWithSerializable(this, EndingActivity.class, "complete", true);
        }
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    public void BtnEnd(View view) {
        AppUtilsKt.openSectionEndingActivity(this);
    }


    public void se25OnTextChanged(CharSequence s, int start, int before, int count) {
        if (!bi.se25.isRangeTextValidate())
            return;

        int se25 = Integer.parseInt(bi.se25.getText().toString());

        if (se25 == 0) {
            bi.fldGrpse25.setVisibility(View.GONE);
            Clear.clearAllFields(bi.fldGrpse25);
        } else bi.fldGrpse25.setVisibility(View.VISIBLE);
    }

    public void se26OnTextChanged(CharSequence s, int start, int before, int count) {
        if (!bi.se26.isRangeTextValidate())
            return;

        int se26 = Integer.parseInt(bi.se26.getText().toString());

        if (se26 == 0) {
            bi.fldGrpse26.setVisibility(View.GONE);
            Clear.clearAllFields(bi.fldGrpse26);
        } else bi.fldGrpse26.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
}
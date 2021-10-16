package edu.aku.hassannaqvi.naunehal.ui.sections;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;

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
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;

public class Section082SEActivity extends AppCompatActivity implements EndSectionActivity {

    ActivitySection082seBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_082se);
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);
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
            if (i == bi.se3601.getId()) {
                bi.llse36.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.llse36);
                bi.llse36.setVisibility(View.GONE);
            }
        }));

        bi.se4298.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.se42check, !b));

        bi.se41.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVse42);
            Clear.clearAllFields(bi.fldGrpCVse43);
            Clear.clearAllFields(bi.fldGrpCVse44);
            Clear.clearAllFields(bi.fldGrpCVse45);
            Clear.clearAllFields(bi.fldGrpCVse46);
            Clear.clearAllFields(bi.fldGrpCVse47);
            bi.fldGrpCVse42.setVisibility(View.GONE);
            bi.fldGrpCVse43.setVisibility(View.GONE);
            bi.fldGrpCVse44.setVisibility(View.GONE);
            bi.fldGrpCVse45.setVisibility(View.GONE);
            bi.fldGrpCVse46.setVisibility(View.GONE);
            bi.fldGrpCVse47.setVisibility(View.GONE);
            if (i == bi.se4101.getId()) {
                bi.fldGrpCVse43.setVisibility(View.VISIBLE);
                bi.fldGrpCVse44.setVisibility(View.VISIBLE);
                bi.fldGrpCVse45.setVisibility(View.VISIBLE);
                bi.fldGrpCVse46.setVisibility(View.VISIBLE);
                bi.fldGrpCVse47.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVse42.setVisibility(View.VISIBLE);
            }
        }));

        bi.se45.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVse46);
            bi.fldGrpCVse46.setVisibility(View.GONE);
            if (i == bi.se4501.getId()) bi.fldGrpCVse46.setVisibility(View.VISIBLE);
        });

        bi.se48.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVse49);
            bi.fldGrpCVse49.setVisibility(View.GONE);
            if (i == bi.se4801.getId()) bi.fldGrpCVse49.setVisibility(View.VISIBLE);
        });

        bi.se4998.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.se49check, !b));
    }


    private void saveDraft(boolean flag) {

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

        form.setSe41(bi.se4101.isChecked() ? "1"
                : bi.se4102.isChecked() ? "2"
                : bi.se4198.isChecked() ? "98"
                : "-1");

        form.setSe4201(bi.se4201.isChecked() ? "1" : "-1");
        form.setSe4202(bi.se4202.isChecked() ? "2" : "-1");
        form.setSe4203(bi.se4203.isChecked() ? "3" : "-1");
        form.setSe4204(bi.se4204.isChecked() ? "4" : "-1");
        form.setSe4205(bi.se4205.isChecked() ? "5" : "-1");
        form.setSe4296(bi.se4296.isChecked() ? "96" : "-1");
        form.setSe4298(bi.se4298.isChecked() ? "98" : "-1");
        form.setSe4296x(bi.se4296x.getText().toString().trim().isEmpty() ? "-1" : bi.se4296x.getText().toString());

        form.setSe4301(bi.se4301.isChecked() ? "1" : "-1");
        form.setSe4302(bi.se4302.isChecked() ? "2" : "-1");
        form.setSe4303(bi.se4303.isChecked() ? "3" : "-1");
        form.setSe4304(bi.se4304.isChecked() ? "4" : "-1");
        form.setSe4305(bi.se4305.isChecked() ? "5" : "-1");
        form.setSe4306(bi.se4306.isChecked() ? "6" : "-1");
        form.setSe4307(bi.se4307.isChecked() ? "7" : "-1");
        form.setSe4308(bi.se4308.isChecked() ? "8" : "-1");
        form.setSe4309(bi.se4309.isChecked() ? "9" : "-1");
        form.setSe4310(bi.se4310.isChecked() ? "10" : "-1");
        form.setSe4311(bi.se4311.isChecked() ? "11" : "-1");
        form.setSe4396(bi.se4396.isChecked() ? "96" : "-1");
        form.setSe4396x(bi.se4396x.getText().toString().trim().isEmpty() ? "-1" : bi.se4396x.getText().toString());

        form.setSe4401(bi.se4401.isChecked() ? "1" : "-1");
        form.setSe4402(bi.se4402.isChecked() ? "2" : "-1");
        form.setSe4403(bi.se4403.isChecked() ? "3" : "-1");
        form.setSe4404(bi.se4404.isChecked() ? "4" : "-1");
        form.setSe4496(bi.se4496.isChecked() ? "96" : "-1");
        form.setSe4496x(bi.se4496x.getText().toString().trim().isEmpty() ? "-1" : bi.se4496x.getText().toString());

        form.setSe45(bi.se4501.isChecked() ? "1"
                : bi.se4502.isChecked() ? "2"
                : bi.se4598.isChecked() ? "98"
                : "-1");

        form.setSe4601(bi.se4601.isChecked() ? "1" : "-1");
        form.setSe4602(bi.se4602.isChecked() ? "2" : "-1");
        form.setSe4603(bi.se4603.isChecked() ? "3" : "-1");
        form.setSe4604(bi.se4604.isChecked() ? "4" : "-1");
        form.setSe4605(bi.se4605.isChecked() ? "5" : "-1");
        form.setSe4606(bi.se4606.isChecked() ? "6" : "-1");
        form.setSe4696(bi.se4696.isChecked() ? "96" : "-1");
        form.setSe4696x(bi.se4696x.getText().toString().trim().isEmpty() ? "-1" : bi.se4696x.getText().toString());

        form.setSe4701(bi.se4701.isChecked() ? "1" : "-1");
        form.setSe4702(bi.se4702.isChecked() ? "2" : "-1");
        form.setSe4703(bi.se4703.isChecked() ? "3" : "-1");
        form.setSe4704(bi.se4704.isChecked() ? "4" : "-1");
        form.setSe4705(bi.se4705.isChecked() ? "5" : "-1");
        form.setSe4706(bi.se4706.isChecked() ? "6" : "-1");
        form.setSe4707(bi.se4707.isChecked() ? "7" : "-1");
        form.setSe4796(bi.se4796.isChecked() ? "96" : "-1");
        form.setSe4796x(bi.se4796x.getText().toString().trim().isEmpty() ? "-1" : bi.se4796x.getText().toString());

        form.setSe48(bi.se4801.isChecked() ? "1"
                : bi.se4802.isChecked() ? "2"
                : bi.se4898.isChecked() ? "98"
                : "-1");

        form.setSe4901(bi.se4901.isChecked() ? "1" : "-1");
        form.setSe4902(bi.se4902.isChecked() ? "2" : "-1");
        form.setSe4903(bi.se4903.isChecked() ? "3" : "-1");
        form.setSe4904(bi.se4904.isChecked() ? "4" : "-1");
        form.setSe4998(bi.se4998.isChecked() ? "98" : "-1");
        form.setSe4996(bi.se4996.isChecked() ? "96" : "-1");
        form.setSe4996x(bi.se4996x.getText().toString().trim().isEmpty() ? "-1" : bi.se4996x.getText().toString());

        form.setSe50(bi.se5001.isChecked() ? "1"
                : bi.se5002.isChecked() ? "2"
                : bi.se5003.isChecked() ? "3"
                : bi.se5096.isChecked() ? "96"
                : bi.se5098.isChecked() ? "98"
                : "-1");
        form.setSe5096x(bi.se5096x.getText().toString().trim().isEmpty() ? "-1" : bi.se5096x.getText().toString());

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
        form.setSe3710(bi.se3710.isChecked() ? "10" : "-1");
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


        form.setHhflag(flag ? "1" : "2");
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
        saveDraft(true);
        if (UpdateDB()) {
            finish();
        }
    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false;

        // TODO: *** THIS IS A DOUBTFUL CONDITION FOR VALIDATION.

        if (Integer.parseInt(bi.se3301.getText().toString()) + Integer.parseInt(bi.se3302.getText().toString()) == 0) {
            return Validator.emptyCustomTextBox(this, bi.se3301, "Both Minutes & Hours can't be zero");
        }

        if (Integer.parseInt(bi.se3401.getText().toString()) + Integer.parseInt(bi.se3402.getText().toString()) == 0) {
            return Validator.emptyCustomTextBox(this, bi.se3401, "Both Month and Year can't be zero");
        }

        if (bi.se2301.isChecked()) {
            if (Integer.valueOf(bi.se25.getText().toString()) > Integer.valueOf(bi.se24.getText().toString())) {
                return Validator.emptyCustomTextBox(this, bi.se25, "Smart phones cannot be more than total mobile phones");
            }

            if (Integer.valueOf(bi.se26.getText().toString()) > Integer.valueOf(bi.se25.getText().toString())) {
                return Validator.emptyCustomTextBox(this, bi.se26, "Android phones cannot be more than total smart phones");
            }
        }
        return true;

    }


    public void BtnEnd(View view) {
        AppUtilsKt.contextEndActivity(this);
    }

    @Override
    public void endSecActivity(boolean flag) {
        saveDraft(false);
        if (UpdateDB()) {
            finish();
        }
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
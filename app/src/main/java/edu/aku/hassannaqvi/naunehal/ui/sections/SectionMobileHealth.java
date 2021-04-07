package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.contracts.MHContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivityMobileHealthBinding;
import edu.aku.hassannaqvi.naunehal.ui.MainActivity;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.core.MainApp.mobileHealth;

public class SectionMobileHealth extends AppCompatActivity implements EndSectionActivity {

    ActivityMobileHealthBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_mobile_health);
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);

        setupSkips();
    }

    private void setupSkips() {
        bi.mh010.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.mh01001.getId()) {
                Clear.clearAllFields(bi.fldGrpCVmh017);
                Clear.clearAllFields(bi.llmh020);
                bi.fldGrpCVmh017.setVisibility(View.GONE);
                bi.llmh020.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVmh017.setVisibility(View.VISIBLE);
                bi.llmh020.setVisibility(View.VISIBLE);
            }
        });
    }


    public void mh09yOnTextChanged(CharSequence s, int i, int i1, int i2) {

        if (TextUtils.isEmpty(bi.mh09m.getText()) || TextUtils.isEmpty(bi.mh09y.getText()))
            return;

        int age = Integer.parseInt(bi.mh09m.getText().toString()) + (Integer.parseInt(bi.mh09y.getText().toString()) * 12);

        if (age > 60) {
            Clear.clearAllFields(bi.fldGrpCVmh015);
            Clear.clearAllFields(bi.fldGrpCVmh016);
            bi.fldGrpCVmh015.setVisibility(View.GONE);
            bi.fldGrpCVmh016.setVisibility(View.GONE);
        } else {
            bi.fldGrpCVmh015.setVisibility(View.VISIBLE);
            bi.fldGrpCVmh016.setVisibility(View.VISIBLE);
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesMHColumn(MHContract.MHTable.COLUMN_SA, mobileHealth.sAtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void saveDraft() {

        mobileHealth.setMh06(bi.mh06.getText().toString().trim().isEmpty() ? "-1" : bi.mh06.getText().toString());

        mobileHealth.setMh07(bi.mh07.getText().toString().trim().isEmpty() ? "-1" : bi.mh07.getText().toString());

        mobileHealth.setMh08(bi.mh0801.isChecked() ? "1"
                : bi.mh0802.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh0801x(bi.mh0801x.getText().toString().trim().isEmpty() ? "-1" : bi.mh0801x.getText().toString());
        mobileHealth.setMh0802x(bi.mh0802x.getText().toString().trim().isEmpty() ? "-1" : bi.mh0802x.getText().toString());

        mobileHealth.setMh09y(bi.mh09y.getText().toString().trim().isEmpty() ? "-1" : bi.mh09y.getText().toString());
        mobileHealth.setMh09m(bi.mh09m.getText().toString().trim().isEmpty() ? "-1" : bi.mh09m.getText().toString());
        mobileHealth.setMh09d(bi.mh09d.getText().toString().trim().isEmpty() ? "-1" : bi.mh09d.getText().toString());

        mobileHealth.setMh010(bi.mh01001.isChecked() ? "1"
                : bi.mh01002.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh011(bi.mh011.getText().toString().trim().isEmpty() ? "-1" : bi.mh011.getText().toString());

        mobileHealth.setMh012(bi.mh012.getText().toString().trim().isEmpty() ? "-1" : bi.mh012.getText().toString());

        mobileHealth.setMh013(bi.mh013a.isChecked() ? "1"
                : bi.mh013b.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh014(bi.mh014a.isChecked() ? "1"
                : bi.mh014b.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh015(bi.mh015.getText().toString().trim().isEmpty() ? "-1" : bi.mh015.getText().toString());

        mobileHealth.setMh016(bi.mh016.getText().toString().trim().isEmpty() ? "-1" : bi.mh016.getText().toString());

        mobileHealth.setMh01701(bi.mh01701.isChecked() ? "1" : "-1");
        mobileHealth.setMh01702(bi.mh01702.isChecked() ? "2" : "-1");
        mobileHealth.setMh01703(bi.mh01703.isChecked() ? "3" : "-1");
        mobileHealth.setMh017077(bi.mh017077.isChecked() ? "" : "-1");
        mobileHealth.setMh017077x(bi.mh017077x.getText().toString().trim().isEmpty() ? "-1" : bi.mh017077x.getText().toString());

        mobileHealth.setMh01801(bi.mh01801.isChecked() ? "1" : "-1");
        mobileHealth.setMh01802(bi.mh01802.isChecked() ? "2" : "-1");
        mobileHealth.setMh01803(bi.mh01803.isChecked() ? "3" : "-1");
        mobileHealth.setMh01804(bi.mh01804.isChecked() ? "4" : "-1");
        mobileHealth.setMh01805(bi.mh01805.isChecked() ? "5" : "-1");
        mobileHealth.setMh01806(bi.mh01806.isChecked() ? "6" : "-1");
        mobileHealth.setMh01807(bi.mh01807.isChecked() ? "7" : "-1");
        mobileHealth.setMh01808(bi.mh01808.isChecked() ? "8" : "-1");
        mobileHealth.setMh01809(bi.mh01809.isChecked() ? "9" : "-1");
        mobileHealth.setMh018010(bi.mh018010.isChecked() ? "10" : "-1");
        mobileHealth.setMh018011(bi.mh018011.isChecked() ? "11" : "-1");
        //mobileHealth.setMh018012(bi.mh018012.isChecked() ? "12" : "-1");
        //mobileHealth.setMh018013(bi.mh018013.isChecked() ? "13" : "-1");
        mobileHealth.setMh018014(bi.mh018014.isChecked() ? "14" : "-1");
        mobileHealth.setMh018015(bi.mh018015.isChecked() ? "15" : "-1");
        mobileHealth.setMh018016(bi.mh018016.isChecked() ? "16" : "-1");
        mobileHealth.setMh018077(bi.mh018077.isChecked() ? "77" : "-1");
        mobileHealth.setMh018077x(bi.mh018077x.getText().toString().trim().isEmpty() ? "-1" : bi.mh018077x.getText().toString());

        mobileHealth.setMh01901(bi.mh01901.isChecked() ? "1" : "-1");
        mobileHealth.setMh01902(bi.mh01902.isChecked() ? "2" : "-1");
        mobileHealth.setMh01903(bi.mh01903.isChecked() ? "3" : "-1");
        mobileHealth.setMh01904(bi.mh01904.isChecked() ? "4" : "-1");
        mobileHealth.setMh01905(bi.mh01905.isChecked() ? "5" : "-1");
        mobileHealth.setMh01906(bi.mh01906.isChecked() ? "6" : "-1");
        mobileHealth.setMh01907(bi.mh01907.isChecked() ? "7" : "-1");
        mobileHealth.setMh01908(bi.mh01908.isChecked() ? "8" : "-1");
        mobileHealth.setMh01909(bi.mh01909.isChecked() ? "9" : "-1");
        mobileHealth.setMh019010(bi.mh019010.isChecked() ? "10" : "-1");
        mobileHealth.setMh019011(bi.mh019011.isChecked() ? "11" : "-1");
        mobileHealth.setMh019012(bi.mh019012.isChecked() ? "12" : "-1");
        mobileHealth.setMh019013(bi.mh019013.isChecked() ? "13" : "-1");
        mobileHealth.setMh019014(bi.mh019014.isChecked() ? "14" : "-1");
        mobileHealth.setMh019015(bi.mh019015.isChecked() ? "15" : "-1");
        mobileHealth.setMh019077(bi.mh019077.isChecked() ? "77" : "-1");
        mobileHealth.setMh019077x(bi.mh019077x.getText().toString().trim().isEmpty() ? "-1" : bi.mh019077x.getText().toString());

        mobileHealth.setMh020(bi.mh02001.isChecked() ? "1"
                : bi.mh02002.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh021(bi.mh02101.isChecked() ? "1"
                : bi.mh02102.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh022(bi.mh02201.isChecked() ? "1"
                : bi.mh02202.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh023(bi.mh02301.isChecked() ? "1"
                : bi.mh02302.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh024(bi.mh02401.isChecked() ? "1"
                : bi.mh02402.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh025(bi.mh02501.isChecked() ? "1"
                : bi.mh02502.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh02601(bi.mh02601.isChecked() ? "1" : "-1");
        mobileHealth.setMh02602(bi.mh02602.isChecked() ? "2" : "-1");
        mobileHealth.setMh02603(bi.mh02603.isChecked() ? "3" : "-1");
        mobileHealth.setMh02604(bi.mh02604.isChecked() ? "4" : "-1");
        mobileHealth.setMh02605(bi.mh02605.isChecked() ? "5" : "-1");
        mobileHealth.setMh02606(bi.mh02606.isChecked() ? "6" : "-1");
//        mobileHealth.setMh02607(bi.mh02607.isChecked() ? "7" : "-1");
        mobileHealth.setMh02608(bi.mh02608.isChecked() ? "8" : "-1");
        mobileHealth.setMh02609(bi.mh02609.isChecked() ? "9" : "-1");
        mobileHealth.setMh026010(bi.mh026010.isChecked() ? "10" : "-1");
        mobileHealth.setMh026011(bi.mh026011.isChecked() ? "11" : "-1");
        //mobileHealth.setMh026012(bi.mh026012.isChecked() ? "12" : "-1");
        //Aku@kuj2021
        // mobileHealth.setMh026013(bi.mh026013.isChecked() ? "13" : "-1");
        mobileHealth.setMh026014(bi.mh026014.isChecked() ? "14" : "-1");
        mobileHealth.setMh026015(bi.mh026015.isChecked() ? "15" : "-1");
        mobileHealth.setMh026016(bi.mh026016.isChecked() ? "16" : "-1");
        //mobileHealth.setMh026017(bi.mh026017.isChecked() ? "17" : "-1");
        //mobileHealth.setMh026018(bi.mh026018.isChecked() ? "18" : "-1");
        //mobileHealth.setMh026019(bi.mh026019.isChecked() ? "19" : "-1");

        mobileHealth.setMh027(bi.mh02701.isChecked() ? "1"
                : bi.mh02702.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh028(bi.mh02801.isChecked() ? "1"
                : bi.mh02802.isChecked() ? "2"
                : "-1");

        mobileHealth.setMh029(bi.mh02901.isChecked() ? "1"
                : bi.mh02902.isChecked() ? "2"
                : "-1");
    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }

    public void BtnEnd(View view) {
        AppUtilsKt.contextEndActivity(this);
    }

    @Override
    public void endSecActivity(boolean flag) {
        saveDraft();
        form.setHhflag("2");
        if (UpdateDB()) {
            finish();
        }
    }
}
package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.databinding.ActivityMobileHealthBinding;
import edu.aku.hassannaqvi.naunehal.ui.MainActivity;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;

public class SectionMobileHealth extends AppCompatActivity implements EndSectionActivity {

    ActivityMobileHealthBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_mobile_health);
        bi.setCallback(this);
        setupSkips();
    }

    private void setupSkips() {
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S08SE, form.s08SEtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void saveDraft() {


       /* form.setMh01(bi.mh01.getText().toString());

        form.setMh02(bi.mh02.getText().toString());

        form.setMh03(bi.mh03.getText().toString());

        form.setMh04(bi.mh04.getText().toString());

        form.setMh05(bi.mh05.getText().toString());

        form.setMh06(bi.mh06.getText().toString());

        form.setMh07(bi.mh07.getText().toString());


        form.setMh08( bi.mh0801.isChecked() ? "1"
                : bi.mh0802.isChecked() ? "2"
                :  "-1");

        form.setMh0801x(bi.mh0801x.getText().toString());
        form.setMh0802x(bi.mh0802x.getText().toString());
        form.setMh09y(bi.mh09y.getText().toString());

        form.setMh09m(bi.mh09m.getText().toString());

        form.setMh09d(bi.mh09d.getText().toString());

        form.setMh010( bi.mh01001.isChecked() ? "1"
                : bi.mh01002.isChecked() ? "2"
                :  "-1");

        form.setMh011(bi.mh011.getText().toString());

        form.setMh012(bi.mh012.getText().toString());

        form.setMh013(bi.mh013.getText().toString());

        form.setMh014(bi.mh014.getText().toString());

        form.setMh015(bi.mh015.getText().toString());

        form.setMh016(bi.mh016.getText().toString());

        form.setMh01701(bi.mh01701.isChecked() ? "1" : "-1");

        form.setMh01702(bi.mh01702.isChecked() ? "2" : "-1");

        form.setMh01703(bi.mh01703.isChecked() ? "3" : "-1");

        form.setMh017077(bi.mh017077.isChecked() ? "" : "-1");

        form.setMh017077x(bi.mh017077x.getText().toString());
        form.setMh01801(bi.mh01801.isChecked() ? "1" : "-1");

        form.setMh01802(bi.mh01802.isChecked() ? "2" : "-1");

        form.setMh01803(bi.mh01803.isChecked() ? "3" : "-1");

        form.setMh01804(bi.mh01804.isChecked() ? "4" : "-1");

        form.setMh01805(bi.mh01805.isChecked() ? "5" : "-1");

        form.setMh01806(bi.mh01806.isChecked() ? "6" : "-1");

        form.setMh01807(bi.mh01807.isChecked() ? "7" : "-1");

        form.setMh01808(bi.mh01808.isChecked() ? "8" : "-1");

        form.setMh01809(bi.mh01809.isChecked() ? "9" : "-1");

        form.setMh018010(bi.mh018010.isChecked() ? "10" : "-1");

        form.setMh018011(bi.mh018011.isChecked() ? "11" : "-1");

        form.setMh018012(bi.mh018012.isChecked() ? "12" : "-1");

        form.setMh018013(bi.mh018013.isChecked() ? "13" : "-1");

        form.setMh018014(bi.mh018014.isChecked() ? "14" : "-1");

        form.setMh018015(bi.mh018015.isChecked() ? "15" : "-1");

        form.setMh018016(bi.mh018016.isChecked() ? "16" : "-1");

        form.setMh018077(bi.mh018077.isChecked() ? "77" : "-1");

        form.setMh018077x(bi.mh018077x.getText().toString());
        form.setMh01901(bi.mh01901.isChecked() ? "1" : "-1");

        form.setMh01902(bi.mh01902.isChecked() ? "2" : "-1");

        form.setMh01903(bi.mh01903.isChecked() ? "3" : "-1");

        form.setMh01904(bi.mh01904.isChecked() ? "4" : "-1");

        form.setMh01905(bi.mh01905.isChecked() ? "5" : "-1");

        form.setMh01906(bi.mh01906.isChecked() ? "6" : "-1");

        form.setMh01907(bi.mh01907.isChecked() ? "7" : "-1");

        form.setMh01908(bi.mh01908.isChecked() ? "8" : "-1");

        form.setMh01909(bi.mh01909.isChecked() ? "9" : "-1");

        form.setMh019010(bi.mh019010.isChecked() ? "10" : "-1");

        form.setMh019011(bi.mh019011.isChecked() ? "11" : "-1");

        form.setMh019012(bi.mh019012.isChecked() ? "12" : "-1");

        form.setMh019013(bi.mh019013.isChecked() ? "13" : "-1");

        form.setMh019014(bi.mh019014.isChecked() ? "14" : "-1");

        form.setMh019015(bi.mh019015.isChecked() ? "15" : "-1");

        form.setMh019077(bi.mh019077.isChecked() ? "77" : "-1");

        form.setMh019077x(bi.mh019077x.getText().toString());
        form.setMh020( bi.mh02001.isChecked() ? "1"
                : bi.mh02002.isChecked() ? "2"
                :  "-1");

        form.setMh021( bi.mh02101.isChecked() ? "1"
                : bi.mh02102.isChecked() ? "2"
                :  "-1");

        form.setMh022( bi.mh02201.isChecked() ? "1"
                : bi.mh02202.isChecked() ? "2"
                :  "-1");

        form.setMh023( bi.mh02301.isChecked() ? "1"
                : bi.mh02302.isChecked() ? "2"
                :  "-1");

        form.setMh024( bi.mh02401.isChecked() ? "1"
                : bi.mh02402.isChecked() ? "2"
                :  "-1");

        form.setMh025( bi.mh02501.isChecked() ? "1"
                : bi.mh02502.isChecked() ? "2"
                :  "-1");

        form.setMh02601(bi.mh02601.isChecked() ? "1" : "-1");

        form.setMh02602(bi.mh02602.isChecked() ? "2" : "-1");

        form.setMh02603(bi.mh02603.isChecked() ? "3" : "-1");

        form.setMh02604(bi.mh02604.isChecked() ? "4" : "-1");

        form.setMh02605(bi.mh02605.isChecked() ? "5" : "-1");

        form.setMh02606(bi.mh02606.isChecked() ? "6" : "-1");

        form.setMh02607(bi.mh02607.isChecked() ? "7" : "-1");

        form.setMh02608(bi.mh02608.isChecked() ? "8" : "-1");

        form.setMh02609(bi.mh02609.isChecked() ? "9" : "-1");

        form.setMh026010(bi.mh026010.isChecked() ? "10" : "-1");

        form.setMh026011(bi.mh026011.isChecked() ? "11" : "-1");

        form.setMh026012(bi.mh026012.isChecked() ? "12" : "-1");

        form.setMh026013(bi.mh026013.isChecked() ? "13" : "-1");

        form.setMh026014(bi.mh026014.isChecked() ? "14" : "-1");

        form.setMh026015(bi.mh026015.isChecked() ? "15" : "-1");

        form.setMh026016(bi.mh026016.isChecked() ? "16" : "-1");

        form.setMh026017(bi.mh026017.isChecked() ? "17" : "-1");

        form.setMh026018(bi.mh026018.isChecked() ? "18" : "-1");

        form.setMh026019(bi.mh026019.isChecked() ? "19" : "-1");

        form.setMh027( bi.mh02701.isChecked() ? "1"
                : bi.mh02702.isChecked() ? "2"
                :  "-1");

        form.setMh02801(bi.mh02801.isChecked() ? "1" : "-1");

        form.setMh02802(bi.mh02802.isChecked() ? "2" : "-1");

        form.setMh029( bi.mh02901.isChecked() ? "1"
                : bi.mh02902.isChecked() ? "2"
                :  "-1");*/


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
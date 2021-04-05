package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.contracts.MHContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivityInfoMobileHealthBinding;
import edu.aku.hassannaqvi.naunehal.models.MobileHealth;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.core.MainApp.mobileHealth;

public class InfoSectionMobileHealth extends AppCompatActivity implements EndSectionActivity {

    ActivityInfoMobileHealthBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_info_mobile_health);
        bi.setCallback(this);
        setupSkips();
    }

    private void setupSkips() {
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.dbHelper;
        long updcount = db.addMH(mobileHealth);
        mobileHealth.setId(String.valueOf(updcount));
        if (updcount > 0) {
            mobileHealth.setUid(mobileHealth.getDeviceId() + mobileHealth.getId());
            long count = db.updatesMHColumn(MHContract.MHTable.COLUMN_UID, mobileHealth.getUid());
            if (count > 0)
                count = db.updatesMHColumn(MHContract.MHTable.COLUMN_MH01, mobileHealth.getMh01());
            count = db.updatesMHColumn(MHContract.MHTable.COLUMN_MH02, mobileHealth.getMh02());
            count = db.updatesMHColumn(MHContract.MHTable.COLUMN_MH03, mobileHealth.getMh03());
            count = db.updatesMHColumn(MHContract.MHTable.COLUMN_MH04, mobileHealth.getMh04());
            count = db.updatesMHColumn(MHContract.MHTable.COLUMN_MH05, mobileHealth.getMh05());
            if (count > 0) return true;
            else {
                Toast.makeText(this, "SORRY! Failed to update DB)", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(this, "SORRY!! Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void saveDraft() {

        mobileHealth = new MobileHealth();
        mobileHealth.setSysDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        mobileHealth.setUuid(MainApp.form.getUid());
        mobileHealth.setUserName(MainApp.user.getUserName());
        mobileHealth.setDcode(MainApp.form.getDcode());
        mobileHealth.setUcode(MainApp.form.getUcode());
        mobileHealth.setCluster(MainApp.form.getCluster());
        mobileHealth.setHhno(MainApp.form.getHhno());
        mobileHealth.setDeviceId(MainApp.appInfo.getDeviceID());
        mobileHealth.setDeviceTag(MainApp.appInfo.getTagName());
        mobileHealth.setAppver(MainApp.appInfo.getAppVersion());

        mobileHealth.setMh01(bi.mh01.getText().toString().trim().isEmpty() ? "-1" : bi.mh01.getText().toString());

        mobileHealth.setMh02(bi.mh02.getText().toString().trim().isEmpty() ? "-1" : bi.mh02.getText().toString());

        mobileHealth.setMh03(bi.mh03.getText().toString().trim().isEmpty() ? "-1" : bi.mh03.getText().toString());

        mobileHealth.setMh04(bi.mh04.getText().toString().trim().isEmpty() ? "-1" : bi.mh04.getText().toString());

        mobileHealth.setMh05(bi.mh05.getText().toString().trim().isEmpty() ? "-1" : bi.mh05.getText().toString());

    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, InfoSectionMobileHealth.class));
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
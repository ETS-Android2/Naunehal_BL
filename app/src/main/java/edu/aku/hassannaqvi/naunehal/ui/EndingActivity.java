package edu.aku.hassannaqvi.naunehal.ui;

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
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivityEndingBinding;

import static edu.aku.hassannaqvi.naunehal.CONSTANTS.SECTION_MAIN_CHECK_FOR_END;
import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.utils.extension.ActivityExtKt.gotoActivityWithNoHistory;


public class EndingActivity extends AppCompatActivity {

    ActivityEndingBinding bi;
    boolean sectionMainCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setForm(MainApp.form);
/*
        setupSkips();
*/

        boolean check = getIntent().getBooleanExtra("complete", false);
        sectionMainCheck = getIntent().getBooleanExtra(SECTION_MAIN_CHECK_FOR_END, false);

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
            bi.istatusc.setEnabled(false);
            bi.istatusd.setEnabled(false);
            bi.istatuse.setEnabled(false);
            bi.istatusf.setEnabled(false);
            bi.istatusg.setEnabled(false);
            bi.istatus96.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
            bi.istatusc.setEnabled(true);
            bi.istatusd.setEnabled(true);
            bi.istatuse.setEnabled(true);
            bi.istatusf.setEnabled(true);
            bi.istatusg.setEnabled(true);
            bi.istatus96.setEnabled(true);
        }

//
    }

    private void saveDraft() {

        form.setHh26(bi.istatusa.isChecked() ? "1"
                : bi.istatusb.isChecked() ? "2"
                : bi.istatusc.isChecked() ? "3"
                : bi.istatusd.isChecked() ? "4"
                : bi.istatuse.isChecked() ? "5"
                : bi.istatusf.isChecked() ? "6"
                : bi.istatusg.isChecked() ? "7"
                : bi.istatus96.isChecked() ? "96"
                : "-1");
        form.setHh2696x(bi.istatus96x.getText().toString().trim().isEmpty() ? "-1" : bi.istatus96x.getText().toString());
        form.setIStatus(form.getHh26());
        form.setIStatus96x(form.getHh2696x());
        form.setEndTime(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(new Date().getTime()));
    }


    public void BtnEnd(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
            gotoActivityWithNoHistory(this, MainActivity.class);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updateEnding();
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpEnd);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
    }

}

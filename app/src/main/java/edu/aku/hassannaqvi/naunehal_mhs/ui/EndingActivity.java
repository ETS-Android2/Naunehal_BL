package edu.aku.hassannaqvi.naunehal_mhs.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.naunehal_mhs.R;
import edu.aku.hassannaqvi.naunehal_mhs.contracts.FormsContract;
import edu.aku.hassannaqvi.naunehal_mhs.core.MainApp;
import edu.aku.hassannaqvi.naunehal_mhs.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal_mhs.databinding.ActivityEndingBinding;
import edu.aku.hassannaqvi.naunehal_mhs.ui.sections.SectionMobileHealth;

import static edu.aku.hassannaqvi.naunehal_mhs.CONSTANTS.SECTION_MAIN_CHECK_FOR_END;
import static edu.aku.hassannaqvi.naunehal_mhs.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal_mhs.core.MainApp.mobileHealth;
import static edu.aku.hassannaqvi.naunehal_mhs.utils.extension.ActivityExtKt.gotoActivity;
import static edu.aku.hassannaqvi.naunehal_mhs.utils.extension.ActivityExtKt.gotoActivityWithNoHistory;


public class EndingActivity extends AppCompatActivity {

    ActivityEndingBinding bi;
    int sectionMainCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setForm(MainApp.form);
        setSupportActionBar(bi.toolbar);

        boolean check = getIntent().getBooleanExtra("complete", false);
        sectionMainCheck = getIntent().getIntExtra(SECTION_MAIN_CHECK_FOR_END, 0);

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
            bi.istatusc.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
            bi.istatusc.setEnabled(true);
            bi.btnEnd.setBackgroundColor(getResources().getColor(R.color.redLight));
        }

    }

    private void saveDraft() {
        mobileHealth.setStatus(bi.istatusa.isChecked() ? "1"
                : bi.istatusb.isChecked() ? "2"
                : bi.istatusc.isChecked() ? "3"
                : "-1");
        mobileHealth.setEndTime(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(new Date().getTime()));
    }


    public void BtnEnd(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
            gotoActivity(this, SectionMobileHealth.class);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S01HH, form.s01HHtoString());
        if (updcount > 0) {
            int count = db.updateEnding();
            return count > 0;
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

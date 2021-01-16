package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.util.Util;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection081seBinding;
import edu.aku.hassannaqvi.naunehal.ui.MainActivity;
import edu.aku.hassannaqvi.naunehal.utils.AndroidUtilityKt;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;

public class Section081SEActivity extends AppCompatActivity {

    ActivitySection081seBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // only in First Section
        //MainApp.form = new Form();
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_081se);
        bi.setForm(MainApp.form);

        setupSkips();
    }

    private void setupSkips() {

        // se05
        bi.se05.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.se0501.getId() || checkedId == bi.se0503.getId() || checkedId == bi.se0596.getId()) {
                Clear.clearAllFields(bi.fldGrpCVse06);
                bi.fldGrpCVse06.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVse06.setVisibility(View.VISIBLE);
            }
        });


        // se09
        bi.se09.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.se0902.getId()) {
                Clear.clearAllFields(bi.fldGrpCVse10);
                bi.fldGrpCVse10.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVse10.setVisibility(View.VISIBLE);
            }
        });

        // se16
        bi.se16.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.se1602.getId()) {
                Clear.clearAllFields(bi.fldGrpCVse17);
                bi.fldGrpCVse17.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVse17.setVisibility(View.VISIBLE);
            }
        });

        // se1705
        bi.se1705.setOnCheckedChangeListener((compoundButton, id) -> {
            if (id) {
                Clear.clearAllFields(bi.se17check, false);
            } else {
                Clear.clearAllFields(bi.se17check, true);
            }
        });
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
            startActivity(new Intent(this, Section082SEActivity.class));
        }
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    public void BtnEnd(View view) {
        AppUtilsKt.contextEndActivity(this);
    }


}
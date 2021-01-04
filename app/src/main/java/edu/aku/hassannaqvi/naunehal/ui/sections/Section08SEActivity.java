package edu.aku.hassannaqvi.naunehal.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection08seBinding;

import android.os.Bundle;
import android.view.View;

import com.validatorcrawler.aliazaz.Clear;

public class Section08SEActivity extends AppCompatActivity {

    ActivitySection08seBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // only in First Section
        //MainApp.form = new Form();

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_08se);
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
    }
}
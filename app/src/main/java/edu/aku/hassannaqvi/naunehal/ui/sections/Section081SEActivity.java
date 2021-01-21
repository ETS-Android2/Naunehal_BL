package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.content.Intent;
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
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection081seBinding;
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
            Clear.clearAllFields(bi.se17check, !id);
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


    private void saveDraft() {

        form.setSe01(bi.se0101.isChecked() ? "1"
                : bi.se0102.isChecked() ? "2"
                : bi.se0103.isChecked() ? "3"
                : bi.se0104.isChecked() ? "4"
                : bi.se0105.isChecked() ? "5"
                : bi.se0106.isChecked() ? "6"
                : bi.se0107.isChecked() ? "7"
                : bi.se0196.isChecked() ? "96"
                : "-1");

        form.setSe0196x(bi.se0196x.getText().toString());
        form.setSe02(bi.se0211.isChecked() ? "1"
                : bi.se0212.isChecked() ? "2"
                : bi.se0221.isChecked() ? "3"
                : bi.se0222.isChecked() ? "4"
                : bi.se0231.isChecked() ? "5"
                : bi.se0232.isChecked() ? "6"
                : bi.se0233.isChecked() ? "7"
                : bi.se0234.isChecked() ? "8"
                : bi.se0235.isChecked() ? "9"
                : bi.se0236.isChecked() ? "10"
                : bi.se0237.isChecked() ? "11"
                : bi.se0296.isChecked() ? "96"
                : "-1");

        form.setSe0296x(bi.se0296x.getText().toString());
        form.setSe03(bi.se0301.isChecked() ? "1"
                : bi.se0302.isChecked() ? "2"
                : bi.se0303.isChecked() ? "3"
                : bi.se0304.isChecked() ? "4"
                : bi.se0305.isChecked() ? "5"
                : bi.se0306.isChecked() ? "6"
                : bi.se0307.isChecked() ? "7"
                : bi.se0308.isChecked() ? "8"
                : bi.se0309.isChecked() ? "9"
                : bi.se0310.isChecked() ? "10"
                : bi.se0311.isChecked() ? "11"
                : bi.se0312.isChecked() ? "12"
                : bi.se0313.isChecked() ? "13"
                : bi.se0314.isChecked() ? "14"
                : bi.se0315.isChecked() ? "15"
                : bi.se0316.isChecked() ? "16"
                : bi.se0317.isChecked() ? "17"
                : bi.se0396.isChecked() ? "96"
                : "-1");

        form.setSe0396x(bi.se0396x.getText().toString());
        form.setSe04(bi.se0401.isChecked() ? "01"
                : bi.se0402.isChecked() ? "2"
                : bi.se0403.isChecked() ? "3"
                : bi.se0404.isChecked() ? "4"
                : bi.se0405.isChecked() ? "5"
                : bi.se0406.isChecked() ? "6"
                : bi.se0407.isChecked() ? "7"
                : bi.se0408.isChecked() ? "8"
                : bi.se0409.isChecked() ? "9"
                : bi.se0410.isChecked() ? "10"
                : bi.se0411.isChecked() ? "11"
                : bi.se0412.isChecked() ? "12"
                : bi.se0413.isChecked() ? "13"
                : bi.se0414.isChecked() ? "14"
                : bi.se0415.isChecked() ? "15"
                : bi.se0496.isChecked() ? "96"
                : "-1");

        form.setSe0496x(bi.se0496x.getText().toString());
        form.setSe05(bi.se0501.isChecked() ? "1"
                : bi.se0502.isChecked() ? "2"
                : bi.se0503.isChecked() ? "3"
                : bi.se0596.isChecked() ? "96"
                : "-1");

        form.setSe0596x(bi.se0596x.getText().toString());
        form.setSe06a(bi.se06a.getText().toString());
        form.setSe07a(bi.se07a.getText().toString());
        form.setSe08(bi.se0801.isChecked() ? "1"
                : bi.se0802.isChecked() ? "2"
                : bi.se0803.isChecked() ? "3"
                : bi.se0804.isChecked() ? "4"
                : bi.se0805.isChecked() ? "5"
                : bi.se0806.isChecked() ? "6"
                : bi.se0807.isChecked() ? "7"
                : bi.se0808.isChecked() ? "8"
                : bi.se0809.isChecked() ? "9"
                : bi.se0810.isChecked() ? "10"
                : bi.se0811.isChecked() ? "11"
                : bi.se0812.isChecked() ? "12"
                : bi.se0813.isChecked() ? "13"
                : bi.se0814.isChecked() ? "14"
                : bi.se0896.isChecked() ? "96"
                : "-1");

        form.setSe0896x(bi.se0896x.getText().toString());
        form.setSe09(bi.se0901.isChecked() ? "1"
                : bi.se0902.isChecked() ? "2"
                : bi.se0998.isChecked() ? "98"
                : "-1");

        form.setSe10(bi.se1001.isChecked() ? "1"
                : bi.se1002.isChecked() ? "2"
                : bi.se1003.isChecked() ? "3"
                : bi.se1004.isChecked() ? "4"
                : bi.se1005.isChecked() ? "5"
                : bi.se1006.isChecked() ? "6"
                : bi.se1098.isChecked() ? "98"
                : bi.se1099.isChecked() ? "99"
                : "-1");

        form.setSe1099x(bi.se1099x.getText().toString());
        form.setSe11(bi.se1101.isChecked() ? "1"
                : bi.se1102.isChecked() ? "2"
                : bi.se1103.isChecked() ? "3"
                : bi.se1104.isChecked() ? "4"
                : bi.se1105.isChecked() ? "5"
                : bi.se1106.isChecked() ? "6"
                : bi.se1107.isChecked() ? "7"
                : bi.se1108.isChecked() ? "8"
                : bi.se1109.isChecked() ? "9"
                : bi.se1110.isChecked() ? "10"
                : bi.se1111.isChecked() ? "11"
                : bi.se1112.isChecked() ? "12"
                : bi.se1196.isChecked() ? "96"
                : "-1");

        form.setSe1196x(bi.se1196x.getText().toString());
        form.setSe12(bi.se1201.isChecked() ? "1"
                : bi.se1202.isChecked() ? "2"
                : bi.se1203.isChecked() ? "3"
                : bi.se1296.isChecked() ? "96"
                : "-1");

        form.setSe1296x(bi.se1296x.getText().toString());
        form.setSe13(bi.se1301.isChecked() ? "1"
                : bi.se1302.isChecked() ? "2"
                : bi.se1303.isChecked() ? "3"
                : bi.se1304.isChecked() ? "4"
                : bi.se1305.isChecked() ? "5"
                : "-1");

        form.setSe14(bi.se1401.isChecked() ? "1"
                : bi.se1402.isChecked() ? "2"
                : "-1");

        form.setSe15(bi.se1501.isChecked() ? "1"
                : bi.se1502.isChecked() ? "2"
                : bi.se1503.isChecked() ? "3"
                : "-1");

        form.setSe16(bi.se1601.isChecked() ? "1"
                : bi.se1602.isChecked() ? "2"
                : "-1");

        form.setSe1701(bi.se1701.isChecked() ? "1" : "-1");

        form.setSe1702(bi.se1702.isChecked() ? "2" : "-1");

        form.setSe1703(bi.se1703.isChecked() ? "3" : "-1");

        form.setSe1704(bi.se1704.isChecked() ? "4" : "-1");

        form.setSe1705(bi.se1705.isChecked() ? "5" : "-1");

        form.setSe1801(bi.se180101.isChecked() ? "1"
                : bi.se180102.isChecked() ? "2"
                : "-1");

        form.setSe1802(bi.se180201.isChecked() ? "1"
                : bi.se180202.isChecked() ? "2"
                : "-1");

        form.setSe1803(bi.se180301.isChecked() ? "1"
                : bi.se180302.isChecked() ? "2"
                : "-1");

        form.setSe1804(bi.se180401.isChecked() ? "1"
                : bi.se180402.isChecked() ? "2"
                : "-1");

        form.setSe1805(bi.se180501.isChecked() ? "1"
                : bi.se180502.isChecked() ? "2"
                : "-1");

        form.setSe1896(bi.se189601.isChecked() ? "1"
                : bi.se189602.isChecked() ? "2"
                : "-1");

        form.setSe189601x(bi.se189601x.getText().toString());
        form.setSe19(bi.se1901.isChecked() ? "1"
                : bi.se1902.isChecked() ? "2"
                : bi.se1903.isChecked() ? "3"
                : bi.se1904.isChecked() ? "4"
                : bi.se1905.isChecked() ? "5"
                : bi.se1906.isChecked() ? "6"
                : bi.se1907.isChecked() ? "7"
                : bi.se1908.isChecked() ? "8"
                : bi.se1909.isChecked() ? "9"
                : bi.se1910.isChecked() ? "10"
                : bi.se1911.isChecked() ? "11"
                : bi.se1912.isChecked() ? "12"
                : bi.se1996.isChecked() ? "96"
                : "-1");

        form.setSe1996x(bi.se1996x.getText().toString());
        form.setSe2001(bi.se2001.isChecked() ? "1" : "-1");

        form.setSe2002(bi.se2002.isChecked() ? "2" : "-1");

        form.setSe2003(bi.se2003.isChecked() ? "3" : "-1");

        form.setSe2004(bi.se2004.isChecked() ? "4" : "-1");

        form.setSe2005(bi.se2005.isChecked() ? "5" : "-1");

        form.setSe2096(bi.se2096.isChecked() ? "96" : "-1");

        form.setSe2096x(bi.se2096x.getText().toString());
        form.setSe2101(bi.se2101.isChecked() ? "1" : "-1");

        form.setSe2102(bi.se2102.isChecked() ? "2" : "-1");

        form.setSe2103(bi.se2103.isChecked() ? "3" : "-1");

        form.setSe2104(bi.se2104.isChecked() ? "4" : "-1");

        form.setSe2105(bi.se2105.isChecked() ? "5" : "-1");

        form.setSe2196(bi.se2196.isChecked() ? "96" : "-1");

        form.setSe2196x(bi.se2196x.getText().toString());
    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, Section082SEActivity.class));
        }
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }

    public void BtnEnd(View view) {
        AppUtilsKt.openSectionEndingActivity(this);
    }

}
package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection05pdBinding;
import edu.aku.hassannaqvi.naunehal.models.ChildCard;
import edu.aku.hassannaqvi.naunehal.models.ChildInformation;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.convertStringToUpperCase;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.shortStringLength;
import static edu.aku.hassannaqvi.naunehal.utils.extension.ActivityExtKt.gotoActivity;

public class Section05PDActivity extends AppCompatActivity implements EndSectionActivity {

    ActivitySection05pdBinding bi;
    ChildInformation info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_05pd);
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);
        info = Section03CSActivity.selectedChildInfo;
        bi.mainCard.setChildCard(new ChildCard(shortStringLength(convertStringToUpperCase(info.getCb02())), String.format("Mother: %s", shortStringLength(convertStringToUpperCase(info.getCb07()))), Integer.parseInt(info.getCb03())));
        form.setPd01(info.getCb01());
        form.setPd02(info.getCb07());
        setupSkips();

    }


    private void setupSkips() {

/*        bi.pd04.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVpd05);
            Clear.clearAllFields(bi.fldGrpCVpd06);
            Clear.clearAllFields(bi.fldGrpCVpd07);
            bi.fldGrpCVpd05.setVisibility(View.VISIBLE);
            bi.fldGrpCVpd06.setVisibility(View.VISIBLE);
            bi.fldGrpCVpd07.setVisibility(View.VISIBLE);
            if (i == bi.pd0402.getId()) {
                bi.fldGrpCVpd05.setVisibility(View.GONE);
                bi.fldGrpCVpd06.setVisibility(View.GONE);
                bi.fldGrpCVpd07.setVisibility(View.GONE);
            }
        });*/


        bi.pd08b.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVpd08c);
            bi.fldGrpCVpd08c.setVisibility(View.GONE);
            if (i == bi.pd08b01.getId()) {
                bi.fldGrpCVpd08c.setVisibility(View.VISIBLE);
            }
        });

        bi.pd09.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVpd10);
            Clear.clearAllFields(bi.fldGrpCVpd11);
            bi.fldGrpCVpd10.setVisibility(View.VISIBLE);
            bi.fldGrpCVpd11.setVisibility(View.VISIBLE);
            if (i == bi.pd0902.getId()) {
                bi.fldGrpCVpd10.setVisibility(View.GONE);
                bi.fldGrpCVpd11.setVisibility(View.GONE);
            }
        });

        bi.pd13.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVpd14);
            bi.fldGrpCVpd14.setVisibility(View.VISIBLE);
            if (i == bi.pd1301.getId() || i == bi.pd1302.getId()) {
                bi.fldGrpCVpd14.setVisibility(View.VISIBLE);
            } else bi.fldGrpCVpd14.setVisibility(View.GONE);
        });

        bi.pd15.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVpd16);
            Clear.clearAllFields(bi.fldGrpCVpd17);
            Clear.clearAllFields(bi.fldGrpCVpd18);
            bi.fldGrpCVpd16.setVisibility(View.GONE);
            bi.fldGrpCVpd17.setVisibility(View.GONE);
            bi.fldGrpCVpd18.setVisibility(View.GONE);
            if (i == bi.pd1501.getId()) {
                bi.fldGrpCVpd16.setVisibility(View.VISIBLE);
                bi.fldGrpCVpd17.setVisibility(View.VISIBLE);
                bi.fldGrpCVpd18.setVisibility(View.VISIBLE);
            }
        });

        bi.pd19.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVpd20);
            Clear.clearAllFields(bi.fldGrpCVpd21);
            Clear.clearAllFields(bi.fldGrpCVpd22);
            bi.fldGrpCVpd20.setVisibility(View.GONE);
            bi.fldGrpCVpd21.setVisibility(View.GONE);
            bi.fldGrpCVpd22.setVisibility(View.GONE);
            if (i == bi.pd1901.getId()) {
                bi.fldGrpCVpd20.setVisibility(View.VISIBLE);
                bi.fldGrpCVpd21.setVisibility(View.VISIBLE);
                bi.fldGrpCVpd22.setVisibility(View.VISIBLE);
            }
        });

        bi.pd04.setOnCheckedChangeListener((radioGroup, i) -> {
            if (bi.pd0402.getId() == i) {
                Clear.clearAllFields(bi.fldGrppd04);
                bi.fldGrppd04.setVisibility(View.GONE);
                bi.fldGrpCVpd08.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrppd04.setVisibility(View.VISIBLE);
                bi.fldGrpCVpd08.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVpd08);
            }
        });

        /*bi.pd17.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVpd18.setVisibility(View.VISIBLE);
            if (bi.pd1798.getId() == i) {
                Clear.clearAllFields(bi.fldGrpCVpd18);
                bi.fldGrpCVpd18.setVisibility(View.GONE);
            }
        });

        bi.pd21.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVpd22.setVisibility(View.VISIBLE);
            if (bi.pd2198.getId() == i) {
                Clear.clearAllFields(bi.fldGrpCVpd22);
                bi.fldGrpCVpd22.setVisibility(View.GONE);
            }
        });*/

        bi.pd23.setOnCheckedChangeListener((radioGroup, i) -> {
            if (bi.pd2301.getId() == i) {
                bi.fldGrpCVpd24.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVpd24);
                bi.fldGrpCVpd24.setVisibility(View.GONE);
            }
        });

        bi.pd2498.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.pd24check, !b));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S05PD, form.s05PDtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
            if (info.getIsSelected().equals("2"))
                gotoActivity(this, Section061BFActivity.class);
            else
                gotoActivity(this, Section07CVActivity.class);
        }
    }


    private void saveDraft() {

        form.setPd01(bi.pd01.getText().toString());

        form.setPd02(bi.pd02.getText().toString());

        form.setPd03(bi.pd0301.isChecked() ? "1"
                : bi.pd0302.isChecked() ? "2"
                : bi.pd0303.isChecked() ? "3"
                : bi.pd0304.isChecked() ? "4"
                : "-1");

        form.setPd04(bi.pd0401.isChecked() ? "1"
                : bi.pd0402.isChecked() ? "2"
                : bi.pd0498.isChecked() ? "98"
                : "-1");

        form.setPd05(bi.pd0501.isChecked() ? "1"
                : bi.pd0502.isChecked() ? "2"
                : bi.pd0503.isChecked() ? "3"
                : bi.pd0504.isChecked() ? "4"
                : bi.pd0505.isChecked() ? "5"
                : bi.pd0506.isChecked() ? "6"
                : bi.pd0507.isChecked() ? "7"
                : bi.pd0508.isChecked() ? "8"
                : bi.pd0509.isChecked() ? "9"
                : bi.pd0596.isChecked() ? "96"
                : "-1");

        form.setPd0596x(bi.pd0596x.getText().toString());
        form.setPd06(bi.pd0601.isChecked() ? "1"
                : bi.pd0602.isChecked() ? "2"
                : bi.pd0603.isChecked() ? "3"
                : bi.pd0604.isChecked() ? "4"
                : bi.pd0605.isChecked() ? "5"
                : bi.pd06961.isChecked() ? "961"
                : bi.pd0607.isChecked() ? "7"
                : bi.pd0608.isChecked() ? "8"
                : bi.pd0609.isChecked() ? "9"
                : bi.pd06962.isChecked() ? "962"
                : "-1");

        form.setPd06961x(bi.pd06961x.getText().toString());
        form.setPd06962x(bi.pd06962x.getText().toString());
        form.setPd07(bi.pd0701.isChecked() ? "0"
                : bi.pd0798.isChecked() ? "98"
                : "-1");

        form.setPd0701x(bi.pd0701x.getText().toString());
        form.setPd08(bi.pd0801.isChecked() ? "1"
                : bi.pd0802.isChecked() ? "2"
                : bi.pd0803.isChecked() ? "3"
                : bi.pd0804.isChecked() ? "4"
                : bi.pd0805.isChecked() ? "5"
                : bi.pd0806.isChecked() ? "6"
                : "-1");


/*        form.setPd08a(bi.pd08a01.isChecked() ? "1"
                : bi.pd08a02.isChecked() ? "2"
                : bi.pd08a03.isChecked() ? "3"
                : bi.pd08a04.isChecked() ? "4"
                : bi.pd08a05.isChecked() ? "5"
                : bi.pd08a06.isChecked() ? "6"
                : bi.pd08a07.isChecked() ? "7"
                : bi.pd08a08.isChecked() ? "8"
                : bi.pd08a09.isChecked() ? "9"
                : bi.pd08a96.isChecked() ? "96"
                : "-1");
        form.setPd08a96x(bi.pd08a96x.getText().toString());*/

        form.setPd08a01(bi.pd08a01.isChecked() ? "1" : "-1");
        form.setPd08a02(bi.pd08a02.isChecked() ? "2" : "-1");
        form.setPd08a03(bi.pd08a03.isChecked() ? "3" : "-1");
        form.setPd08a04(bi.pd08a04.isChecked() ? "4" : "-1");
        form.setPd08a05(bi.pd08a05.isChecked() ? "5" : "-1");
        form.setPd08a06(bi.pd08a06.isChecked() ? "6" : "-1");
        form.setPd08a07(bi.pd08a07.isChecked() ? "7" : "-1");
        form.setPd08a08(bi.pd08a08.isChecked() ? "8" : "-1");
        form.setPd08a09(bi.pd08a09.isChecked() ? "9" : "-1");
        form.setPd08a96(bi.pd08a96.isChecked() ? "96" : "-1");

        form.setPd08a96x(bi.pd08a96x.getText().toString());


        form.setPd08b(bi.pd08b01.isChecked() ? "1"
                : bi.pd08b02.isChecked() ? "2"
                : bi.pd08b98.isChecked() ? "98"
                : "-1");

        form.setPd08c(bi.pd08c.getText().toString());


        form.setPd09(bi.pd0901.isChecked() ? "1"
                : bi.pd0902.isChecked() ? "2"
                : "-1");

        form.setPd10(bi.pd1001.isChecked() ? "1"
                : bi.pd1002.isChecked() ? "2"
                : bi.pd1003.isChecked() ? "3"
                : bi.pd1004.isChecked() ? "4"
                : bi.pd1005.isChecked() ? "5"
                : "-1");

        form.setPd1101(bi.pd1101.getText().toString());
        form.setPd1102(bi.pd1102.getText().toString());
        form.setPd12(bi.pd1201.isChecked() ? "1"
                : bi.pd1202.isChecked() ? "2"
                : bi.pd1203.isChecked() ? "3"
                : bi.pd1204.isChecked() ? "4"
                : bi.pd1205.isChecked() ? "5"
                : bi.pd1206.isChecked() ? "6"
                : bi.pd1207.isChecked() ? "7"
                : bi.pd1296.isChecked() ? "96"
                : "-1");

        form.setPd1296x(bi.pd1296x.getText().toString());
        form.setPd13(bi.pd1301.isChecked() ? "1"
                : bi.pd1302.isChecked() ? "2"
                : bi.pd1303.isChecked() ? "3"
                : bi.pd1304.isChecked() ? "4"
                : bi.pd1305.isChecked() ? "5"
                : bi.pd1306.isChecked() ? "6"
                : bi.pd13961.isChecked() ? "961"
                : bi.pd1307.isChecked() ? "7"
                : bi.pd13962.isChecked() ? "962"
                : "-1");

        form.setPd13961x(bi.pd13961x.getText().toString());
        form.setPd13962x(bi.pd13962x.getText().toString());
        form.setPd14(bi.pd1401.isChecked() ? "1"
                : bi.pd1402.isChecked() ? "2"
                : bi.pd1403.isChecked() ? "3"
                : bi.pd1404.isChecked() ? "4"
                : bi.pd1405.isChecked() ? "5"
                : bi.pd1496.isChecked() ? "96"
                : "-1");

        form.setPd1496x(bi.pd1496x.getText().toString());
        form.setPd15(bi.pd1501.isChecked() ? "1"
                : bi.pd1502.isChecked() ? "2"
                : "-1");

        form.setPd1601(bi.pd1601.isChecked() ? "1" : "-1");
        form.setPd1602(bi.pd1602.isChecked() ? "2" : "-1");
        form.setPd1603(bi.pd1603.isChecked() ? "3" : "-1");
        form.setPd1604(bi.pd1604.isChecked() ? "4" : "-1");
        form.setPd1605(bi.pd1605.isChecked() ? "5" : "-1");
        form.setPd1606(bi.pd1606.isChecked() ? "6" : "-1");
        form.setPd1607(bi.pd1607.isChecked() ? "7" : "-1");
        form.setPd1696(bi.pd1696.isChecked() ? "96" : "-1");

        form.setPd1696x(bi.pd1696x.getText().toString());

        form.setPd17(bi.pd1701.isChecked() ? "1"
                : bi.pd1702.isChecked() ? "2"
                : bi.pd1703.isChecked() ? "3"
                : bi.pd1798.isChecked() ? "98"
                : "-1");

        form.setPd1701x(bi.pd1701x.getText().toString());
        form.setPd1702x(bi.pd1702x.getText().toString());
        form.setPd1703x(bi.pd1703x.getText().toString());

        form.setPd18(bi.pd18.getText().toString());

        form.setPd19(bi.pd1901.isChecked() ? "1"
                : bi.pd1902.isChecked() ? "2"
                : bi.pd1998.isChecked() ? "98"
                : "-1");

        form.setPd2001(bi.pd2001.isChecked() ? "1" : "-1");
        form.setPd2002(bi.pd2002.isChecked() ? "2" : "-1");
        form.setPd2003(bi.pd2003.isChecked() ? "3" : "-1");
        form.setPd2004(bi.pd2004.isChecked() ? "4" : "-1");
        form.setPd2005(bi.pd2005.isChecked() ? "5" : "-1");
        form.setPd2006(bi.pd2006.isChecked() ? "6" : "-1");
        form.setPd2007(bi.pd2007.isChecked() ? "7" : "-1");
        form.setPd2096(bi.pd2096.isChecked() ? "96" : "-1");
        form.setPd2096x(bi.pd2096x.getText().toString());

        form.setPd21(bi.pd2101.isChecked() ? "1"
                : bi.pd2102.isChecked() ? "2"
                : bi.pd2103.isChecked() ? "3"
                : bi.pd2198.isChecked() ? "98"
                : "-1");

        form.setPd2101x(bi.pd2101x.getText().toString());
        form.setPd2102x(bi.pd2102x.getText().toString());
        form.setPd2103x(bi.pd2103x.getText().toString());
        form.setPd22(bi.pd22.getText().toString());


        form.setPd23(bi.pd2301.isChecked() ? "1"
                : bi.pd2302.isChecked() ? "2"
                : bi.pd2398.isChecked() ? "98"
                : "-1");

        form.setPd2401(bi.pd2401.isChecked() ? "1" : "-1");

        form.setPd2402(bi.pd2402.isChecked() ? "2" : "-1");

        form.setPd2403(bi.pd2403.isChecked() ? "3" : "-1");

        form.setPd2404(bi.pd2404.isChecked() ? "4" : "-1");

        form.setPd2405(bi.pd2405.isChecked() ? "5" : "-1");

        form.setPd2406(bi.pd2406.isChecked() ? "6" : "-1");

        form.setPd2496(bi.pd2496.isChecked() ? "96" : "-1");

        form.setPd2496x(bi.pd2496x.getText().toString());
        form.setPd2498(bi.pd2498.isChecked() ? "98" : "-1");


    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false;

        if (bi.pd0901.isChecked() && (Integer.parseInt(bi.pd1101.getText().toString()) + Integer.parseInt(bi.pd1102.getText().toString())) == 0)
            return Validator.emptyCustomTextBox(this, bi.pd1101, "Both values can't be ZERO");
        return true;
    }


    public void BtnEnd(View view) {
        AppUtilsKt.contextEndActivity(this);
    }

    @Override
    public void endSecActivity(boolean flag) {
        finish();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
}
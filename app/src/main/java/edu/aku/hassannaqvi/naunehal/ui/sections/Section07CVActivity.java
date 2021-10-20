package edu.aku.hassannaqvi.naunehal.ui.sections;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.convertStringToUpperCase;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.shortStringLength;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection07cvBinding;
import edu.aku.hassannaqvi.naunehal.models.ChildCard;
import edu.aku.hassannaqvi.naunehal.models.ChildInformation;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;

public class Section07CVActivity extends AppCompatActivity implements EndSectionActivity {

    ActivitySection07cvBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_07cv);
        ChildInformation info = Section03CSActivity.selectedChildInfo;
        bi.mainCard.setChildCard(new ChildCard(shortStringLength(convertStringToUpperCase(info.getCb02())), String.format("Mother: %s", shortStringLength(convertStringToUpperCase(info.getCb07()))), Integer.parseInt(info.getCb03())));
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);
        setupSkips();

    }


    private void setupSkips() {
        rgLsnr(bi.cv01, bi.cv0102, bi.llcv01);
        rgLsnr(bi.cv11, bi.cv1102, bi.fldGrpCVcv12);
        rgLsnr(bi.cv15, bi.cv1501, bi.fldGrpCVcv16);
        rgLsnr(bi.cv17, bi.cv1702, bi.fldGrpCVcv18);
        rgLsnr(bi.cv20, bi.cv2001, bi.fldGrpCVcv21);

        bi.cv0898.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.cv08check, !b));
        bi.cv0998.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.cv09check, !b));
        bi.cv1098.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.cv10check, !b));
        bi.cv2198.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.cv21check, !b));

    }


    private void rgLsnr(@NotNull RadioGroup rg, RadioButton rb, ViewGroup vg) {
        rg.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(vg);
            vg.setVisibility(View.VISIBLE);
            if (i == rb.getId()) vg.setVisibility(View.GONE);
        });
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S07CV, form.s07CVtoString());
        if (updcount == 1) {
            updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_G5FLAG, "1");
            if (updcount == 1) {
                return true;
            } else {
                Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void saveDraft() {

        form.setCv01(bi.cv0101.isChecked() ? "1"
                : bi.cv0102.isChecked() ? "2"
                : "-1");

        form.setCv02(bi.cv0201.isChecked() ? "1"
                : bi.cv0202.isChecked() ? "2"
                : bi.cv0203.isChecked() ? "3"
                : bi.cv0204.isChecked() ? "4"
                : bi.cv0205.isChecked() ? "5"
                : "-1");

        form.setCv03(bi.cv0301.isChecked() ? "1"
                : bi.cv0302.isChecked() ? "2"
                : bi.cv0398.isChecked() ? "98"
                : "-1");

        form.setCv04(bi.cv0401.isChecked() ? "1"
                : bi.cv0402.isChecked() ? "2"
                : bi.cv0403.isChecked() ? "3"
                : bi.cv0404.isChecked() ? "4"
                : bi.cv0405.isChecked() ? "5"
                : bi.cv0498.isChecked() ? "98"
                : "-1");

        form.setCv0501(bi.cv0501.isChecked() ? "1" : "-1");
        form.setCv0502(bi.cv0502.isChecked() ? "2" : "-1");
        form.setCv0503(bi.cv0503.isChecked() ? "3" : "-1");
        form.setCv0504(bi.cv0504.isChecked() ? "4" : "-1");
        form.setCv0505(bi.cv0505.isChecked() ? "5" : "-1");
        form.setCv0506(bi.cv0506.isChecked() ? "6" : "-1");
        form.setCv0507(bi.cv0507.isChecked() ? "7" : "-1");
        form.setCv0596(bi.cv0596.isChecked() ? "96" : "-1");
        form.setCv0596x(bi.cv0596x.getText().toString());


        form.setCv0601(bi.cv0601.isChecked() ? "1" : "-1");
        form.setCv0602(bi.cv0602.isChecked() ? "2" : "-1");
        form.setCv0603(bi.cv0603.isChecked() ? "3" : "-1");
        form.setCv0604(bi.cv0604.isChecked() ? "4" : "-1");
        form.setCv0605(bi.cv0605.isChecked() ? "5" : "-1");
        form.setCv0606(bi.cv0606.isChecked() ? "6" : "-1");
        form.setCv0607(bi.cv0607.isChecked() ? "7" : "-1");
        form.setCv0608(bi.cv0608.isChecked() ? "8" : "-1");
        form.setCv0609(bi.cv0609.isChecked() ? "9" : "-1");
        form.setCv0610(bi.cv0610.isChecked() ? "10" : "-1");
        form.setCv0611(bi.cv0611.isChecked() ? "11" : "-1");
        form.setCv0612(bi.cv0612.isChecked() ? "12" : "-1");
        form.setCv0696(bi.cv0696.isChecked() ? "96" : "-1");
        form.setCv0696x(bi.cv0696x.getText().toString());


        form.setCv07(bi.cv0701.isChecked() ? "1"
                : bi.cv0702.isChecked() ? "2"
                : bi.cv0798.isChecked() ? "98"
                : "-1");

        form.setCv0801(bi.cv0801.isChecked() ? "1" : "-1");
        form.setCv0802(bi.cv0802.isChecked() ? "2" : "-1");
        form.setCv0803(bi.cv0803.isChecked() ? "3" : "-1");
        form.setCv0804(bi.cv0804.isChecked() ? "4" : "-1");
        form.setCv0805(bi.cv0805.isChecked() ? "5" : "-1");
        form.setCv0806(bi.cv0806.isChecked() ? "6" : "-1");
        form.setCv0807(bi.cv0807.isChecked() ? "7" : "-1");
        form.setCv0898(bi.cv0898.isChecked() ? "98" : "-1");
        form.setCv0896(bi.cv0896.isChecked() ? "96" : "-1");
        form.setCv0896x(bi.cv0896x.getText().toString());

        form.setCv0901(bi.cv0901.isChecked() ? "1" : "-1");
        form.setCv0902(bi.cv0902.isChecked() ? "2" : "-1");
        form.setCv0903(bi.cv0903.isChecked() ? "3" : "-1");
        form.setCv0904(bi.cv0904.isChecked() ? "4" : "-1");
        form.setCv0905(bi.cv0905.isChecked() ? "5" : "-1");
        form.setCv0906(bi.cv0906.isChecked() ? "6" : "-1");
        form.setCv0907(bi.cv0907.isChecked() ? "7" : "-1");
        form.setCv0908(bi.cv0908.isChecked() ? "8" : "-1");
        form.setCv0998(bi.cv0998.isChecked() ? "98" : "-1");
        form.setCv0996(bi.cv0996.isChecked() ? "96" : "-1");
        form.setCv0996x(bi.cv0996x.getText().toString());

        form.setCv1001(bi.cv1001.isChecked() ? "1" : "-1");
        form.setCv1002(bi.cv1002.isChecked() ? "2" : "-1");
        form.setCv1003(bi.cv1003.isChecked() ? "3" : "-1");
        form.setCv1004(bi.cv1004.isChecked() ? "4" : "-1");
        form.setCv1005(bi.cv1005.isChecked() ? "5" : "-1");
        form.setCv1006(bi.cv1006.isChecked() ? "6" : "-1");
        form.setCv1007(bi.cv1007.isChecked() ? "7" : "-1");
        form.setCv1008(bi.cv1008.isChecked() ? "8" : "-1");
        form.setCv1009(bi.cv1009.isChecked() ? "9" : "-1");
        form.setCv1098(bi.cv1098.isChecked() ? "98" : "-1");
        form.setCv1096(bi.cv1096.isChecked() ? "96" : "-1");
        form.setCv1096x(bi.cv1096x.getText().toString());

        form.setCv11(bi.cv1101.isChecked() ? "1"
                : bi.cv1102.isChecked() ? "2"
                : "-1");

        form.setCv12(bi.cv1201.isChecked() ? "1"
                : bi.cv1202.isChecked() ? "2"
                : bi.cv1203.isChecked() ? "3"
                : bi.cv1204.isChecked() ? "4"
                : bi.cv1205.isChecked() ? "5"
                : bi.cv1296.isChecked() ? "96"
                : "-1");

        form.setCv1296x(bi.cv1296x.getText().toString());
        form.setCv13(bi.cv1301.isChecked() ? "1"
                : bi.cv1302.isChecked() ? "2"
                : "-1");

        form.setCv14(bi.cv1401.isChecked() ? "1"
                : bi.cv1402.isChecked() ? "2"
                : "-1");

        form.setCv15(bi.cv1501.isChecked() ? "1"
                : bi.cv1502.isChecked() ? "2"
                : "-1");

        form.setCv16(bi.cv1601.isChecked() ? "1"
                : bi.cv1602.isChecked() ? "2"
                : bi.cv1603.isChecked() ? "3"
                : bi.cv1604.isChecked() ? "4"
                : bi.cv1605.isChecked() ? "5"
                : bi.cv1606.isChecked() ? "6"
                : bi.cv1696.isChecked() ? "96"
                : "-1");
        form.setCv1696x(bi.cv1696x.getText().toString());

        form.setCv17(bi.cv1701.isChecked() ? "1"
                : bi.cv1702.isChecked() ? "2"
                : "-1");

        form.setCv18(bi.cv1801.isChecked() ? "1"
                : bi.cv1802.isChecked() ? "2"
                : bi.cv1803.isChecked() ? "3"
                : bi.cv1804.isChecked() ? "4"
                : bi.cv1805.isChecked() ? "5"
                : bi.cv1806.isChecked() ? "6"
                : bi.cv1896.isChecked() ? "96"
                : "-1");

        form.setCv1896x(bi.cv1896x.getText().toString());
        form.setCv19(bi.cv1901.isChecked() ? "1"
                : bi.cv1902.isChecked() ? "2"
                : bi.cv1903.isChecked() ? "3"
                : bi.cv1904.isChecked() ? "4"
                : bi.cv1905.isChecked() ? "5"
                : bi.cv1906.isChecked() ? "6"
                : bi.cv1996.isChecked() ? "96"
                : "-1");

        form.setCv1996x(bi.cv1996x.getText().toString());

        form.setCv20(bi.cv2001.isChecked() ? "1"
                : bi.cv2002.isChecked() ? "2"
                : "-1");

        form.setCv2101(bi.cv2101.isChecked() ? "1" : "-1");
        form.setCv2102(bi.cv2102.isChecked() ? "2" : "-1");
        form.setCv2103(bi.cv2103.isChecked() ? "3" : "-1");
        form.setCv2104(bi.cv2104.isChecked() ? "4" : "-1");
        form.setCv2105(bi.cv2105.isChecked() ? "5" : "-1");
        form.setCv2106(bi.cv2106.isChecked() ? "6" : "-1");
        form.setCv2107(bi.cv2107.isChecked() ? "7" : "-1");
        form.setCv2108(bi.cv2108.isChecked() ? "8" : "-1");
        form.setCv2109(bi.cv2109.isChecked() ? "9" : "-1");
        form.setCv2198(bi.cv2198.isChecked() ? "98" : "-1");
        form.setCv2196(bi.cv2196.isChecked() ? "96" : "-1");
        form.setCv2196x(bi.cv2196x.getText().toString().trim().isEmpty() ? "-1" : bi.cv2196x.getText().toString());

        form.setG5Flag("1");

    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
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
        finish();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
}
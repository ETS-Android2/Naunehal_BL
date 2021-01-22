package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.content.Intent;
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
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection06bfBinding;
import edu.aku.hassannaqvi.naunehal.models.ChildCard;
import edu.aku.hassannaqvi.naunehal.models.ChildInformation;
import edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.convertStringToUpperCase;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.shortStringLength;

public class Section06BFActivity extends AppCompatActivity implements EndSectionActivity {

    ActivitySection06bfBinding bi;
    ChildInformation info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_06bf);
        info = Section03CSActivity.selectedChildInfo;
        bi.mainCard.setChildCard(new ChildCard(shortStringLength(convertStringToUpperCase(info.cb02)), String.format("Mother: %s", shortStringLength(convertStringToUpperCase(info.cb07))), Integer.parseInt(info.cb03)));
        bi.bf01.setText(info.cb01);
        bi.bf02.setText(info.cb07);
        bi.bf03m.setText(info.getCb04mm());
        bi.bf3y.setText(info.getCb04yy());
        bi.bf3d.setText(info.getCb04dd());
        bi.bf03a02.setText(info.getCb0501());
        bi.bf03a01.setText(info.getCb0502());

        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.bf04.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVbf05);
            Clear.clearAllFields(bi.fldGrpCVbf06);
            Clear.clearAllFields(bi.fldGrpCVbf07);
            Clear.clearAllFields(bi.fldGrpCVbf08);
            Clear.clearAllFields(bi.fldGrpCVbf09);
            Clear.clearAllFields(bi.fldGrpCVbf10);
            bi.fldGrpCVbf05.setVisibility(View.GONE);
            bi.fldGrpCVbf06.setVisibility(View.GONE);
            bi.fldGrpCVbf07.setVisibility(View.GONE);
            bi.fldGrpCVbf08.setVisibility(View.GONE);
            bi.fldGrpCVbf09.setVisibility(View.GONE);
            bi.fldGrpCVbf10.setVisibility(View.GONE);
            if (i == bi.bf0401.getId()) {
                bi.fldGrpCVbf05.setVisibility(View.VISIBLE);
                bi.fldGrpCVbf06.setVisibility(View.VISIBLE);
                bi.fldGrpCVbf07.setVisibility(View.VISIBLE);
                bi.fldGrpCVbf08.setVisibility(View.VISIBLE);
                bi.fldGrpCVbf09.setVisibility(View.VISIBLE);
                bi.fldGrpCVbf10.setVisibility(View.VISIBLE);
            }
        });

        bi.bf06.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVbf07);
            bi.fldGrpCVbf07.setVisibility(View.VISIBLE);
            if (i == bi.bf0601.getId()) {
                bi.fldGrpCVbf07.setVisibility(View.GONE);
            }
        });

        bi.bf08.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVbf09);
            bi.fldGrpCVbf09.setVisibility(View.GONE);
            if (i == bi.bf0801.getId()) {
                bi.fldGrpCVbf09.setVisibility(View.VISIBLE);
            }
        });

        bi.bf10.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVbf11);
            bi.fldGrpCVbf11.setVisibility(View.VISIBLE);
            if (i == bi.bf1001.getId()) {
                bi.fldGrpCVbf11.setVisibility(View.GONE);
            }
        });

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S06BF, form.s06BFtoString());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void saveDraft() {

        form.setBf01(bi.bf01.getText().toString());

        form.setBf02(bi.bf02.getText().toString());

        form.setBf3y(bi.bf3y.getText().toString());
        form.setBf03m(bi.bf03m.getText().toString());
        form.setBf3d(bi.bf3d.getText().toString());


        form.setBf03a01(bi.bf03a01.getText().toString());
        form.setBf03a02(bi.bf03a02.getText().toString());

        form.setBf04(bi.bf0401.isChecked() ? "1"
                : bi.bf0402.isChecked() ? "2"
                : bi.bf0498.isChecked() ? "98"
                : "-1");

        form.setBf05(bi.bf0501.isChecked() ? "1"
                : bi.bf0502.isChecked() ? "2"
                : bi.bf0503.isChecked() ? "3"
                : "-1");
        form.setBf0502x(bi.bf0502x.getText().toString());
        form.setBf0503x(bi.bf0503x.getText().toString());

        form.setBf06(bi.bf0601.isChecked() ? "1"
                : bi.bf0602.isChecked() ? "2"
                : bi.bf0698.isChecked() ? "98"
                : "-1");

        form.setBf07(bi.bf0701.isChecked() ? "1"
                : bi.bf0702.isChecked() ? "2"
                : bi.bf0703.isChecked() ? "3"
                : bi.bf0796.isChecked() ? "96"
                : "-1");

        form.setBf0796x(bi.bf0796x.getText().toString());
        form.setBf08(bi.bf0801.isChecked() ? "1"
                : bi.bf0802.isChecked() ? "2"
                : bi.bf0898.isChecked() ? "98"
                : "-1");

        form.setBf09(bi.bf0901.isChecked() ? "1"
                : bi.bf0902.isChecked() ? "2"
                : bi.bf0903.isChecked() ? "3"
                : bi.bf0904.isChecked() ? "4"
                : bi.bf0905.isChecked() ? "5"
                : bi.bf0906.isChecked() ? "6"
                : bi.bf0907.isChecked() ? "7"
                : bi.bf0908.isChecked() ? "8"
                : bi.bf0909.isChecked() ? "9"
                : bi.bf0910.isChecked() ? "10"
                : bi.bf0999.isChecked() ? "99"
                : bi.bf0996.isChecked() ? "96"
                : "-1");

        form.setBf0996x(bi.bf0996x.getText().toString());

        form.setBf10(bi.bf1001.isChecked() ? "1"
                : bi.bf1002.isChecked() ? "2"
                : bi.bf1096.isChecked() ? "96"
                : "-1");

        form.setBf11(bi.bf1101.isChecked() ? "1"
                : bi.bf1102.isChecked() ? "2"
                : bi.bf1198.isChecked() ? "98"
                : "-1");

        form.setBf12(bi.bf1201.isChecked() ? "1"
                : bi.bf1202.isChecked() ? "2"
                : bi.bf1298.isChecked() ? "98"
                : "-1");

        form.setBf13(bi.bf1301.isChecked() ? "1"
                : bi.bf1302.isChecked() ? "2"
                : bi.bf1398.isChecked() ? "98"
                : "-1");
    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, Section07CVActivity.class));
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
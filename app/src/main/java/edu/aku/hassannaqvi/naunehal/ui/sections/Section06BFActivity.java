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

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.convertStringToUpperCase;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.shortStringLength;

public class Section06BFActivity extends AppCompatActivity {

    ActivitySection06bfBinding bi;
    ChildInformation info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_06bf);
        info = Section03CSActivity.selectedChildInfo;
        bi.mainCard.setChildCard(new ChildCard(shortStringLength(convertStringToUpperCase(info.cb02)), String.format("Mother: %s", shortStringLength(convertStringToUpperCase(info.cb07))), Integer.parseInt(info.cb03)));
        form.setBf01(info.cb01);
        form.setBf02(info.cb07);
        bi.setForm(MainApp.form);
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


    public void BtnContinue(View view) {
        if (!formValidation()) return;
        if (UpdateDB()) {
            finish();
            if (info.getIsSelected().equals("1"))
                startActivity(new Intent(this, Section07CVActivity.class));
        }
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
}
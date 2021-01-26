package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.contracts.IMContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection04imBinding;
import edu.aku.hassannaqvi.naunehal.models.ChildInformation;
import edu.aku.hassannaqvi.naunehal.models.Immunization;
import edu.aku.hassannaqvi.naunehal.ui.TakePhoto;
import edu.aku.hassannaqvi.naunehal.utils.DateUtilsKt;
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity;
import edu.aku.hassannaqvi.naunehal.utils.datecollection.AgeModel;
import edu.aku.hassannaqvi.naunehal.utils.datecollection.DateRepository;
import kotlin.Pair;

import static edu.aku.hassannaqvi.naunehal.core.MainApp.form;
import static edu.aku.hassannaqvi.naunehal.utils.AppUtilsKt.contextEndActivity;
import static edu.aku.hassannaqvi.naunehal.utils.extension.ActivityExtKt.gotoActivity;

public class Section04IMActivity extends AppCompatActivity implements EndSectionActivity {

    ActivitySection04imBinding bi;
    boolean im01Flag = true, imFlag = true, daysFlag = true;
    private LocalDate calculatedDOB = null;
    private ChildInformation info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_04im);
        bi.setCallback(this);
//        setSupportActionBar(bi.toolbar);
        info = Section03CSActivity.selectedChildInfo;

        MainApp.immunization = new Immunization();
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);
        //bi.setForm(MainApp.immunization);
        setupSkips();
        setupTextWatchers();

        /*
         * Setting DOB boundry
         * */
        if (form.getLocalDate() != null) {
            int maxYears = form.getLocalDate().getYear();
            int minYears = form.getLocalDate().minusYears(3).getYear();
            bi.im04yy.setMinvalue(minYears);
            bi.im04yy.setMaxvalue(maxYears);
        }

    }

    // Only in First Section of every Table.
    private void initForm() {
        MainApp.immunization.setSysDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        MainApp.immunization.setUuid(MainApp.form.getUid());
        MainApp.immunization.setUserName(MainApp.user.getUserName());
        MainApp.immunization.setDcode(MainApp.form.getDcode());
        MainApp.immunization.setUcode(MainApp.form.getUcode());
        MainApp.immunization.setCluster(MainApp.form.getCluster());
        MainApp.immunization.setHhno(MainApp.form.getHhno());
        MainApp.immunization.setDeviceId(MainApp.appInfo.getDeviceID());
        MainApp.immunization.setDeviceTag(MainApp.appInfo.getTagName());
        MainApp.immunization.setAppver(MainApp.appInfo.getAppVersion());
        MainApp.immunization.setSerial(info.getCb01());
        MainApp.immunization.setFmuid(info.getUid());
        MainApp.immunization.setChildname(info.getCb02());
        MainApp.immunization.setMothername(info.getCb07());


        MainApp.immunization.setIm01(bi.im0101.isChecked() ? "1"
                : bi.im0102.isChecked() ? "2"
                : "-1");

        MainApp.immunization.setIm02(bi.im0201.isChecked() ? "1"
                : bi.im0202.isChecked() ? "2"
                : "-1");

        MainApp.immunization.setIm03(bi.im0301.isChecked() ? "1"
                : bi.im0302.isChecked() ? "2"
                : bi.im0303.isChecked() ? "3"
                : bi.im0304.isChecked() ? "4"
                : bi.im0305.isChecked() ? "5"
                : bi.im0306.isChecked() ? "6"
                : bi.im0396.isChecked() ? "96"
                : "-1");

        MainApp.immunization.setIm0396x(bi.im03096x.getText().toString());
        MainApp.immunization.setIm04dd(bi.im04dd.getText().toString());
        MainApp.immunization.setIm04mm(bi.im04mm.getText().toString());
        MainApp.immunization.setIm04yy(bi.im04yy.getText().toString());
        MainApp.immunization.setIm0501dd(bi.im0501dd.getText().toString());
        MainApp.immunization.setIm0501mm(bi.im0501mm.getText().toString());
        MainApp.immunization.setIm0501yy(bi.im0501yy.getText().toString());
        MainApp.immunization.setIm0502dd(bi.im0502dd.getText().toString());
        MainApp.immunization.setIm0502mm(bi.im0502mm.getText().toString());
        MainApp.immunization.setIm0502yy(bi.im0502yy.getText().toString());
        MainApp.immunization.setIm0503dd(bi.im0503dd.getText().toString());
        MainApp.immunization.setIm0503mm(bi.im0503mm.getText().toString());
        MainApp.immunization.setIm0503yy(bi.im0503yy.getText().toString());
        MainApp.immunization.setIm0504dd(bi.im0504dd.getText().toString());
        MainApp.immunization.setIm0504mm(bi.im0504mm.getText().toString());
        MainApp.immunization.setIm0504yy(bi.im0504yy.getText().toString());
        MainApp.immunization.setIm0505dd(bi.im0505dd.getText().toString());
        MainApp.immunization.setIm0505mm(bi.im0505mm.getText().toString());
        MainApp.immunization.setIm0505yy(bi.im0505yy.getText().toString());
        MainApp.immunization.setIm0506dd(bi.im0506dd.getText().toString());
        MainApp.immunization.setIm0506mm(bi.im0506mm.getText().toString());
        MainApp.immunization.setIm0506yy(bi.im0506yy.getText().toString());
        MainApp.immunization.setIm0507dd(bi.im0507dd.getText().toString());
        MainApp.immunization.setIm0507mm(bi.im0507mm.getText().toString());
        MainApp.immunization.setIm0507yy(bi.im0507yy.getText().toString());
        MainApp.immunization.setIm0508dd(bi.im0508dd.getText().toString());
        MainApp.immunization.setIm0508mm(bi.im0508mm.getText().toString());
        MainApp.immunization.setIm0508yy(bi.im0508yy.getText().toString());
        MainApp.immunization.setIm0509dd(bi.im0509dd.getText().toString());
        MainApp.immunization.setIm0509mm(bi.im0509mm.getText().toString());
        MainApp.immunization.setIm0509yy(bi.im0509yy.getText().toString());
        MainApp.immunization.setIm0510dd(bi.im0510dd.getText().toString());
        MainApp.immunization.setIm0510mm(bi.im0510mm.getText().toString());
        MainApp.immunization.setIm0510yy(bi.im0510yy.getText().toString());
        MainApp.immunization.setIm0511dd(bi.im0511dd.getText().toString());
        MainApp.immunization.setIm0511mm(bi.im0511mm.getText().toString());
        MainApp.immunization.setIm0511yy(bi.im0511yy.getText().toString());
        MainApp.immunization.setIm0512dd(bi.im0512dd.getText().toString());
        MainApp.immunization.setIm0512mm(bi.im0512mm.getText().toString());
        MainApp.immunization.setIm0512yy(bi.im0512yy.getText().toString());
        MainApp.immunization.setIm0513dd(bi.im0513dd.getText().toString());
        MainApp.immunization.setIm0513mm(bi.im0513mm.getText().toString());
        MainApp.immunization.setIm0513yy(bi.im0513yy.getText().toString());
        MainApp.immunization.setIm0514dd(bi.im0514dd.getText().toString());
        MainApp.immunization.setIm0514mm(bi.im0514mm.getText().toString());
        MainApp.immunization.setIm0514yy(bi.im0514yy.getText().toString());
        MainApp.immunization.setIm0515dd(bi.im0515dd.getText().toString());
        MainApp.immunization.setIm0515mm(bi.im0515mm.getText().toString());
        MainApp.immunization.setIm0515yy(bi.im0515yy.getText().toString());
        MainApp.immunization.setIm0516dd(bi.im0516dd.getText().toString());
        MainApp.immunization.setIm0516mm(bi.im0516mm.getText().toString());
        MainApp.immunization.setIm0516yy(bi.im0516yy.getText().toString());
        MainApp.immunization.setIm07(bi.im0701.isChecked() ? "1"
                : bi.im0702.isChecked() ? "2"
                : "-1");

        MainApp.immunization.setIm08(bi.im0801.isChecked() ? "1"
                : bi.im0802.isChecked() ? "2"
                : bi.im0803.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm08a(bi.im08a1.isChecked() ? "1"
                : bi.im08a2.isChecked() ? "2"
                : bi.im08a3.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm08b(bi.im08b.getText().toString());

        MainApp.immunization.setIm09(bi.im0901.isChecked() ? "1"
                : bi.im0902.isChecked() ? "2"
                : bi.im0903.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm10(bi.im1001.isChecked() ? "1"
                : bi.im1002.isChecked() ? "2"
                : bi.im1003.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm11(bi.im1101.isChecked() ? "1"
                : bi.im1102.isChecked() ? "2"
                : bi.im1103.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm12(bi.im1201.isChecked() ? "1"
                : bi.im1298.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm1201x(bi.im1201x.getText().toString());

        MainApp.immunization.setIm12a(bi.im12a1.isChecked() ? "1"
                : bi.im12a98.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm12a1x(bi.im12a1x.getText().toString());

        MainApp.immunization.setIm13(bi.im1301.isChecked() ? "1"
                : bi.im1302.isChecked() ? "2"
                : bi.im1303.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm14(bi.im1401.isChecked() ? "1"
                : bi.im1402.isChecked() ? "2"
                : bi.im1403.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm15(bi.im15a.isChecked() ? "1"
                : bi.im1598.isChecked() ? "98"
                : "-1");
        MainApp.immunization.setIm1501(bi.im1501.getText().toString());

        MainApp.immunization.setIm16(bi.im1601.isChecked() ? "1"
                : bi.im1602.isChecked() ? "2"
                : bi.im1603.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm17(bi.im17a.isChecked() ? "1"
                : bi.im1798.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm1701(bi.im1701.getText().toString());

        MainApp.immunization.setIm18(bi.im1801.isChecked() ? "1"
                : bi.im1802.isChecked() ? "2"
                : bi.im1803.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm19(bi.im1901.isChecked() ? "1"
                : bi.im1998.isChecked() ? "98"
                : "-1");
        MainApp.immunization.setIm1901x(bi.im1901x.getText().toString());

        MainApp.immunization.setIm20(bi.im2001.isChecked() ? "1"
                : bi.im2002.isChecked() ? "2"
                : bi.im2003.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm21(bi.im2101.isChecked() ? "1"
                : bi.im2102.isChecked() ? "2"
                : bi.im2103.isChecked() ? "98"
                : "-1");

        MainApp.immunization.setIm22(bi.im22a.isChecked() ? "1"
                : bi.im2298.isChecked() ? "98"
                : "-1");
        MainApp.immunization.setIm2201(bi.im2201.getText().toString());

        MainApp.immunization.setIm23(bi.im2301.isChecked() ? "1"
                : bi.im2302.isChecked() ? "2"
                : bi.im2303.isChecked() ? "3"
                : bi.im2306.isChecked() ? "96"
                : "-1");
        MainApp.immunization.setIm2306x(bi.im2306x.getText().toString());

        MainApp.immunization.setIm23a(bi.im23a1.isChecked() ? "1"
                : bi.im23a2.isChecked() ? "2"
                : bi.im23a3.isChecked() ? "3"
                : bi.im23a4.isChecked() ? "4"
                : bi.im23a5.isChecked() ? "5"
                : bi.im23a96.isChecked() ? "96"
                : "-1");
        MainApp.immunization.setIm23a96x(bi.im23a96x.getText().toString());

        MainApp.immunization.setIm23b1(bi.im23b1.getText().toString());
        MainApp.immunization.setIm23b2(bi.im23b2.getText().toString());

        MainApp.immunization.setIm24(bi.im2401.isChecked() ? "1"
                : bi.im2402.isChecked() ? "2"
                : bi.im2403.isChecked() ? "3"
                : bi.im2404.isChecked() ? "4"
                : bi.im2405.isChecked() ? "5"
                : bi.im2406.isChecked() ? "6"
                : bi.im2407.isChecked() ? "7"
                : bi.im2408.isChecked() ? "8"
                : bi.im2409.isChecked() ? "9"
                : bi.im2410.isChecked() ? "10"
                : bi.im2411.isChecked() ? "11"
                : bi.im2412.isChecked() ? "12"
                : bi.im2413.isChecked() ? "13"
                : bi.im2414.isChecked() ? "14"
                : bi.im2415.isChecked() ? "15"
                : bi.im2416.isChecked() ? "16"
                : bi.im2417.isChecked() ? "17"
                : bi.im2498.isChecked() ? "98"
                : bi.im2496.isChecked() ? "96"
                : "-1");

        MainApp.immunization.setIm2496x(bi.im2496x.getText().toString());
        MainApp.immunization.setIm25(bi.im2501.isChecked() ? "1"
                : bi.im2502.isChecked() ? "2"
                : bi.im2503.isChecked() ? "3"
                : bi.im2504.isChecked() ? "4"
                : "-1");


    }

    private void setupSkips() {

        bi.im01.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im0101.getId()) {
                bi.fldGrpCVim02.setVisibility(View.VISIBLE);

                Clear.clearAllFields(bi.fldGrpCVim03);
                bi.fldGrpCVim03.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpDOBCheck03);
                bi.fldGrpDOBCheck03.setVisibility(View.GONE);

            } else if (i == bi.im0102.getId()) {
                bi.fldGrpCVim03.setVisibility(View.VISIBLE);
                bi.fldGrpDOBCheck03.setVisibility(View.VISIBLE);

                Clear.clearAllFields(bi.fldGrpCVim02);
                bi.fldGrpCVim02.setVisibility(View.GONE);
                Clear.clearAllFields(bi.llim01);
                bi.llim01.setVisibility(View.GONE);

                bi.fldGrpDOBCheck02.setVisibility(View.VISIBLE);
            }
        });

        bi.im02.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im0201.getId()) {
                bi.fldGrpDOBCheck02.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpDOBCheck02);
                bi.fldGrpDOBCheck03.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.fldGrpDOBCheck03);
                bi.fldGrpIm24.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpIm24);
                Clear.clearAllFields(bi.fldGrpim0802);
                bi.fldGrpim0802.setVisibility(View.GONE);
                bi.llim01.setVisibility(View.VISIBLE);
                bi.fldGrpIm23.setVisibility(View.VISIBLE);


                bi.im04dd.setEnabled(true);
                bi.im04mm.setEnabled(true);

            } else if (i == bi.im0202.getId()) {
                bi.fldGrpDOBCheck02.setVisibility(View.VISIBLE);
                bi.fldGrpDOBCheck03.setVisibility(View.VISIBLE);
                bi.fldGrpim0802.setVisibility(View.VISIBLE);
                bi.llim01.setVisibility(View.GONE);
                Clear.clearAllFields(bi.llim01);
                bi.frontFileName.setText(null);
                bi.backFileName.setText(null);
            }
        });

        bi.im04yy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.childAgeWarning.setVisibility(View.GONE);
                calculatedDOB = null;
                if (!bi.im0201.isChecked()) return;
                String txt01, txt02, txt03;
                bi.im04dd.setEnabled(true);
                bi.im04mm.setEnabled(true);
                if (!TextUtils.isEmpty(bi.im04dd.getText()) && !TextUtils.isEmpty(bi.im04mm.getText()) && !TextUtils.isEmpty(bi.im04yy.getText())) {
                    txt01 = bi.im04dd.getText().toString();
                    txt02 = bi.im04mm.getText().toString();
                    txt03 = bi.im04yy.getText().toString();
                } else return;
                if ((!bi.im04dd.isRangeTextValidate()) ||
                        (!bi.im04mm.isRangeTextValidate()) ||
                        (!bi.im04yy.isRangeTextValidate()))
                    return;
                int day = bi.im04dd.getText().toString().equals("98") ? 15 : Integer.parseInt(txt01);
                int month = Integer.parseInt(txt02);
                int year = Integer.parseInt(txt03);

                AgeModel age;
                if (form.getLocalDate() != null)
                    age = DateRepository.Companion.getCalculatedAge(form.getLocalDate(), year, month, day);
                else
                    age = DateRepository.Companion.getCalculatedAge(year, month, day);
                if (age == null) {
                    bi.im04yy.setError("Invalid date!!");
                    im01Flag = false;
                } else {
                    im01Flag = true;
                    bi.im04dd.setEnabled(false);
                    bi.im04mm.setEnabled(false);
                    try {
                        Instant dtInstant = Instant.parse(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(
                                day + "-" + month + "-" + year
                        )) + "T06:24:01Z");

                        calculatedDOB = LocalDateTime.ofInstant(dtInstant, ZoneId.systemDefault()).toLocalDate();

                        //Calculate months
                        boolean monthFlag = true;
                        if (calculatedDOB != null) {
                            Pair<String, String> month_year;
                            if (bi.im0201.isChecked())
                                month_year = getMonthAndYearFromDate(LocalDateTime.ofInstant(dtInstant, ZoneId.systemDefault()).toLocalDate().toString());
                            else month_year = getMonthAndYearFromDate(calculatedDOB.toString());
                            int totalMonths = Integer.parseInt(month_year.getFirst()) + Integer.parseInt(month_year.getSecond()) * 12;
                            monthFlag = totalMonths > 35;
                            if (monthFlag) {
                                bi.fldGrpDOBCheck01.setVisibility(View.GONE);
                                bi.fldGrpDOBCheck03.setVisibility(View.GONE);

                                bi.childAgeWarning.setVisibility(View.VISIBLE);
                            } else {
                                bi.fldGrpDOBCheck01.setVisibility(View.VISIBLE);
                                bi.fldGrpDOBCheck03.setVisibility(View.VISIBLE);
                            }
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.im08.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im0801.getId()) {
                bi.fldGrpim0801.setVisibility(View.VISIBLE);
                bi.fldGrpim0802.setVisibility(View.VISIBLE);
                bi.fldGrpIm24.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpIm24);
                bi.fldGrpIm23.setVisibility(View.VISIBLE);
            } else if (i == bi.im0802.getId() || i == bi.im0803.getId()) {
                bi.fldGrpim0801.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpim0801);
                bi.fldGrpim0802.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpim0802);
                bi.fldGrpIm24.setVisibility(View.VISIBLE);
                bi.fldGrpIm23.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpIm23);
            }
        });

        bi.im10.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpim10));

        bi.im14.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpim15));

        bi.im16.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpim17));

        bi.im18.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpim19));

        bi.im21.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpim22));

        bi.im23.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.cvim23a.setVisibility(View.VISIBLE);
            bi.cvim23b.setVisibility(View.VISIBLE);
            bi.fldGrpIm24.setVisibility(View.VISIBLE);
            if (i == bi.im2303.getId()) {
                Clear.clearAllFields(bi.cvim23a);
                Clear.clearAllFields(bi.cvim23b);
                bi.cvim23a.setVisibility(View.GONE);
                bi.cvim23b.setVisibility(View.GONE);
                bi.fldGrpIm24.setVisibility(View.GONE);
            }
        });

    }


    public void BtnContinue(View view) {
        if (!formValidation()) return;

        if (calculatedDOB == null) {
            Clear.clearAllFields(bi.fldGrpDOBCheck01);
            Clear.clearAllFields(bi.fldGrpDOBCheck02);
        }
        initForm();
        MainApp.immunization.setStatus("1");
        if (updateDB()) {
            finish();
            if (info.getIsSelected().equals("1") || info.getIsSelected().equals("2"))
                gotoActivity(this, Section05PDActivity.class);
        }
    }


    private Boolean updateDB() {
        DatabaseHelper db = MainApp.appInfo.dbHelper;
        long updcount = db.addIM(MainApp.immunization);
        MainApp.immunization.setId(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.immunization.setUid(MainApp.immunization.getDeviceId() + MainApp.immunization.getId());
            long count = db.updatesIMColumn(IMContract.IMTable.COLUMN_UID, MainApp.immunization.getUid());
            if (count > 0)
                count = db.updatesIMColumn(IMContract.IMTable.COLUMN_SIM, MainApp.immunization.getSim());
            if (count > 0) return true;
            else {
                Toast.makeText(this, "SORRY! Failed to update DB)", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private boolean formValidation() {
        if (!im01Flag) {
            Toast.makeText(this, "Invalid DOB date!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!imFlag) {
            Toast.makeText(this, "Invalid vaccination date!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;
        if (bi.im0201.isChecked() && (TextUtils.isEmpty(bi.frontFileName.getText()) || TextUtils.isEmpty(bi.backFileName.getText()))) {
            Toast.makeText(this, "No Photos attached", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (bi.im0801.isChecked())
            if (Integer.parseInt(bi.im23b1.getText().toString()) + Integer.parseInt(bi.im23b2.getText().toString()) == 0) {
                return Validator.emptyCustomTextBox(this, bi.im23b1, "Both values can't be ZERO");
            }
        return true;
    }


    public void BtnEnd(View view) {
        contextEndActivity(this);
    }


    public void takePhoto(int id) {

        Intent intent = new Intent(this, TakePhoto.class);

        intent.putExtra("picID", info.getCluster() + "_" + info.getHhno() + "_" + info.getCb01() + "_");
        intent.putExtra("childName", info.getCb02());

        if (id == 1) {
            intent.putExtra("picView", "front".toUpperCase());
            startActivityForResult(intent, 1); // Activity is started with requestCode 1 = Front
        } else {
            intent.putExtra("picView", "back".toUpperCase());
            startActivityForResult(intent, 2); // Activity is started with requestCode 2 = Back
        }
    }


    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            Toast.makeText(this, requestCode + "_" + resultCode, Toast.LENGTH_SHORT).show();

            String fileName = data.getStringExtra("FileName");

            // Check if the requestCode 1 = Front : 2 = Back -- resultCode 1 = Success : 2 = Failure
            // Results received with requestCode 1 = Front

            if (requestCode == 1 && resultCode == 1) {
                Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show();

                bi.frontFileName.setText(fileName);
                bi.frontPhoto.setEnabled(false);


            } else if (requestCode == 1 && resultCode != 1) {
                Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show();

                //TODO: Implement functionality below when photo was not taken
                // ...
                bi.frontFileName.setText("Photo not taken.");

            }

            // Results received with requestCode 2 = Back
            if (requestCode == 2 && resultCode == 1) {
                Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show();

                bi.backFileName.setText(fileName);
                bi.backPhoto.setEnabled(false);
            } else if (requestCode == 2 && resultCode != 1) {

                Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show();

                //TODO: Implement functionality below when photo was not taken
                // ...
                bi.backFileName.setText("Photo not taken.");

            }
        }
    }

    private Pair<String, String> getMonthAndYearFromDate(String date) {
        Calendar cal = DateUtilsKt.getCalendarDate(date.replace("-", "/"));
        int curdate = form.getLocalDate().getDayOfMonth();
        int curmonth = form.getLocalDate().getMonthValue();
        int curyear = form.getLocalDate().getYear();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        if (day > curdate) {
            curmonth -= 1;
        }
        if (month > curmonth) {
            curyear -= 1;
            curmonth += 12;
        }
        return new Pair<>(String.valueOf(curmonth - month), String.valueOf(curyear - year));
    }


    private LocalDate getLocalDate(EditTextPicker[] editTextsArray) {
        if (editTextsArray.length < 3) return null;
        EditTextPicker editTextPicker01 = editTextsArray[0];
        EditTextPicker editTextPicker02 = editTextsArray[1];
        EditTextPicker editTextPicker03 = editTextsArray[2];
        if (TextUtils.isEmpty(editTextPicker01.getText()) || TextUtils.isEmpty(editTextPicker02.getText()) || TextUtils.isEmpty(editTextPicker03.getText()))
            return null;
        String txt01 = editTextPicker01.getText().toString();
        if (txt01.trim().equals("44") || txt01.trim().equals("97") || txt01.trim().equals("66") || txt01.trim().equals("88"))
            return null;
        try {
            String txt02 = editTextPicker02.getText().toString();
            String txt03 = editTextPicker03.getText().toString();
            Instant instant = Instant.parse(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(
                    txt01 + "-" + txt02 + "-" + txt03
            )) + "T06:24:01Z");
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void clearEditTextFields(ArrayList<EditTextPicker[]> respArrayList) {
        if (respArrayList == null) return;
        for (EditTextPicker[] editItems : respArrayList) {
            for (EditTextPicker items : editItems) {
                items.setText(null);
                items.setError(null);
            }
        }
    }

    private void setupTextWatchers() {

        EditTextPicker[] BCG = new EditTextPicker[]{bi.im0501dd, bi.im0501mm, bi.im0501yy};
        editTextImplementation("BCG", BCG, null, null);

        EditTextPicker[] OPV0 = new EditTextPicker[]{bi.im0502dd, bi.im0502mm, bi.im0502yy};
        EditTextPicker[] OPV1 = new EditTextPicker[]{bi.im0503dd, bi.im0503mm, bi.im0503yy};
        EditTextPicker[] OPV2 = new EditTextPicker[]{bi.im0507dd, bi.im0507mm, bi.im0507yy};
        EditTextPicker[] OPV3 = new EditTextPicker[]{bi.im0511dd, bi.im0511mm, bi.im0511yy};
        editTextImplementation("OPV0", OPV0, null, new ArrayList<EditTextPicker[]>() {
            {
                add(OPV1);
                add(OPV2);
                add(OPV3);
            }
        });
        editTextImplementation("OPV1", OPV1, OPV0, null);
        editTextImplementation("OPV2", OPV2, OPV1, null);
        editTextImplementation("OPV3", OPV3, OPV2, null);

        EditTextPicker[] PENTA1 = new EditTextPicker[]{bi.im0504dd, bi.im0504mm, bi.im0504yy};
        EditTextPicker[] PENTA2 = new EditTextPicker[]{bi.im0508dd, bi.im0508mm, bi.im0508yy};
        EditTextPicker[] PENTA3 = new EditTextPicker[]{bi.im0512dd, bi.im0512mm, bi.im0512yy};
        editTextImplementation("PENTA1", PENTA1, null, new ArrayList<EditTextPicker[]>() {
            {
                add(PENTA2);
                add(PENTA3);
            }
        });
        editTextImplementation("PENTA2", PENTA2, PENTA1, null);
        editTextImplementation("PENTA3", PENTA3, PENTA2, null);

        EditTextPicker[] PCV1 = new EditTextPicker[]{bi.im0505dd, bi.im0505mm, bi.im0505yy};
        EditTextPicker[] PCV2 = new EditTextPicker[]{bi.im0509dd, bi.im0509mm, bi.im0509yy};
        EditTextPicker[] PCV3 = new EditTextPicker[]{bi.im0513dd, bi.im0513mm, bi.im0513yy};
        editTextImplementation("PCV1", PCV1, null, new ArrayList<EditTextPicker[]>() {
            {
                add(PCV2);
                add(PCV3);
            }
        });
        editTextImplementation("PCV2", PCV2, PCV1, null);
        editTextImplementation("PCV3", PCV3, PCV2, null);

        EditTextPicker[] RV1 = new EditTextPicker[]{bi.im0506dd, bi.im0506mm, bi.im0506yy};
        EditTextPicker[] RV2 = new EditTextPicker[]{bi.im0510dd, bi.im0510mm, bi.im0510yy};
        editTextImplementation("RV1", RV1, null, new ArrayList<EditTextPicker[]>() {
            {
                add(RV2);
            }
        });
        editTextImplementation("RV2", RV2, RV1, null);

        EditTextPicker[] IPV = new EditTextPicker[]{bi.im0514dd, bi.im0514mm, bi.im0514yy};
        editTextImplementation("IPV", IPV, null, null);

        EditTextPicker[] MEASLES1 = new EditTextPicker[]{bi.im0515dd, bi.im0515mm, bi.im0515yy};
        EditTextPicker[] MEASLES2 = new EditTextPicker[]{bi.im0516dd, bi.im0516mm, bi.im0516yy};
        editTextImplementation("MEASLES1", MEASLES1, null, new ArrayList<EditTextPicker[]>() {
            {
                add(MEASLES2);
            }
        });
        editTextImplementation("MEASLES2", MEASLES2, MEASLES1, null);
    }

    public void editTextImplementation(String type, EditTextPicker[] editTextsArray, EditTextPicker[] respTextsArray, ArrayList<EditTextPicker[]> respArrayList) {
        if (editTextsArray.length != 3) return;
        EditTextPicker editTextPicker01 = editTextsArray[0];
        EditTextPicker editTextPicker02 = editTextsArray[1];
        EditTextPicker editTextPicker03 = editTextsArray[2];

        if (calculatedDOB != null) {
            int minYears = calculatedDOB.getYear();
            int maxYears = form.getLocalDate().getYear();
            editTextPicker03.setMinvalue(minYears);
            editTextPicker03.setMaxvalue(maxYears);
        }

        editTextPicker01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextPicker03.setText(null);
                editTextPicker03.setError(null);

                editTextPicker02.setEnabled(true);
                editTextPicker03.setEnabled(true);

                daysFlag = true;
                imFlag = true;

                String txt01;
                if (!TextUtils.isEmpty(editTextPicker01.getText())) {
                    txt01 = editTextPicker01.getText().toString();

                    if (txt01.trim().equals("44") || txt01.trim().equals("97") || txt01.trim().equals("66") || txt01.trim().equals("88")) {
                        editTextPicker02.setText(null);
                        editTextPicker03.setText(null);
                        editTextPicker02.setEnabled(false);
                        editTextPicker03.setEnabled(false);
                        editTextPicker01.setRangedefaultvalue(Float.parseFloat(txt01));

                        daysFlag = false;
                        imFlag = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextPicker02.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextPicker03.setText(null);
                editTextPicker03.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextPicker03.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String txt01, txt02, txt03;
                    LocalDate respLocalDate = null;
                    if (!daysFlag) return;
                    editTextPicker01.setEnabled(true);
                    editTextPicker02.setEnabled(true);
                    if (!TextUtils.isEmpty(editTextPicker01.getText()) && !TextUtils.isEmpty(editTextPicker02.getText()) && !TextUtils.isEmpty(editTextPicker03.getText())) {
                        txt01 = editTextPicker01.getText().toString();
                        txt02 = editTextPicker02.getText().toString();
                        txt03 = editTextPicker03.getText().toString();
                    } else return;
                    clearEditTextFields(respArrayList);
                    if (respTextsArray != null) {
                        respLocalDate = getLocalDate(respTextsArray);
                        int minYears, maxYears;
                        if (respLocalDate != null) {
                            minYears = respLocalDate.getYear();
                        } else {
                            minYears = calculatedDOB.getYear();
                        }
                        maxYears = form.getLocalDate().getYear();
                        editTextPicker03.setMinvalue(minYears);
                        editTextPicker03.setMaxvalue(maxYears);
                    }
                    if ((!editTextPicker01.isRangeTextValidate() || txt01.trim().equals("44") || txt01.trim().equals("97") || txt01.trim().equals("66") || txt01.trim().equals("88")) ||
                            (!editTextPicker02.isRangeTextValidate()) ||
                            (!editTextPicker03.isRangeTextValidate()))
                        return;
                    int day = Integer.parseInt(txt01);
                    int month = Integer.parseInt(txt02);
                    int year = Integer.parseInt(txt03);

                    AgeModel age;
                    age = DateRepository.Companion.getCalculatedAge(form.getLocalDate(), Integer.parseInt(editTextsArray[2].getText().toString()), Integer.parseInt(editTextsArray[1].getText().toString()), Integer.parseInt(editTextsArray[0].getText().toString()));
                    if (age == null) {
                        editTextPicker03.setError("Invalid date");
                        imFlag = false;
                        return;
                    }
                    if (respLocalDate != null) {
                        age = DateRepository.Companion.getCalculatedAge(Objects.requireNonNull(getLocalDate(editTextsArray)), Integer.parseInt(respTextsArray[2].getText().toString()), Integer.parseInt(respTextsArray[1].getText().toString()), Integer.parseInt(respTextsArray[0].getText().toString()), false);
                    } else if (calculatedDOB != null)
                        age = DateRepository.Companion.getCalculatedAge(Objects.requireNonNull(getLocalDate(editTextsArray)), calculatedDOB.getYear(), calculatedDOB.getMonthValue(), calculatedDOB.getDayOfMonth(), type.equals("BCG") || type.equals("OPV0"));
                    else
                        age = DateRepository.Companion.getCalculatedAge(year, month, day);
                    if (age == null) {
                        editTextPicker03.setError("Invalid date");
                        imFlag = false;
                    } else {
                        imFlag = true;
                        editTextPicker01.setEnabled(false);
                        editTextPicker02.setEnabled(false);
                    }
                } catch (Exception ignored) {
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void endSecActivity(boolean flag) {
        initForm();
        MainApp.immunization.setStatus("2");
        if (updateDB()) {
            finish();
        }
    }
}
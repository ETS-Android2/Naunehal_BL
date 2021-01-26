package edu.aku.hassannaqvi.naunehal.ui.sections

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.edittextpicker.aliazaz.EditTextPicker
import com.validatorcrawler.aliazaz.Clear
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.naunehal.BR
import edu.aku.hassannaqvi.naunehal.R
import edu.aku.hassannaqvi.naunehal.contracts.ChildInformationContract
import edu.aku.hassannaqvi.naunehal.core.MainApp
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection02cbBinding
import edu.aku.hassannaqvi.naunehal.utils.datecollection.AgeModel
import edu.aku.hassannaqvi.naunehal.utils.datecollection.DateRepository.Companion.getCalculatedAge
import edu.aku.hassannaqvi.naunehal.utils.openWarningDialog
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class Section02CBActivity : AppCompatActivity() {
    lateinit var bi: ActivitySection02cbBinding
    var dtFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_02cb)
        bi.callback = this
        setSupportActionBar(bi.toolbar)

        // TODO: After itemClick on childlist fetchChildByUID() from TABLE_FAMILY and update contents MainApp.Family before entering this activity.
        if (MainApp.form.hh14 == "1") bi.cb0601.isEnabled = false
        else bi.cb0602.isEnabled = false
        bi.setVariable(BR.childInformation, MainApp.childInformation)
        setupSkips()

        /*
         * Setup Listeners
         * */
        val txtListener = arrayOf<EditText>(bi.cb04dd, bi.cb04mm)
        for (txtItem in txtListener) {
            txtItem.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    bi.cb0501.text = null
                    bi.cb0502.text = null
                    bi.cb04yy.text = null
                }

                override fun afterTextChanged(s: Editable) {}
            })
        }
    }

    private fun setupSkips() {
        bi.cb06.setOnCheckedChangeListener { radioGroup: RadioGroup?, i: Int ->
            when (i) {
                bi.cb0601.id -> {
                    Clear.clearAllFields(bi.fldGrpCVcb07, false)
                    Clear.clearAllFields(bi.fldGrpCVcb08, false)
                    Clear.clearAllFields(bi.fldGrpCVcb09, false)
                    Clear.clearAllFields(bi.fldGrpCVcb10, false)
                    Clear.clearAllFields(bi.fldGrpCVcb11, false)
                    bi.fldGrpCVcb11.visibility = View.GONE
                    MainApp.childInformation.setCb07(MainApp.form.getHh12())
                    MainApp.childInformation.setCb08(MainApp.form.getHh13())
                    MainApp.childInformation.setCb09(MainApp.form.getHh16())
                    MainApp.childInformation.setCb10(MainApp.form.getHh17())


                    Clear.clearAllFields(bi.fldGrpCVcb12, true)
                    Clear.clearAllFields(bi.fldGrpCVcb13, true)
                    Clear.clearAllFields(bi.fldGrpCVcb14, true)
                    bi.cb1413.isEnabled = false

                    MainApp.childInformation.setCb11("1")
                }
                bi.cb0602.id -> {
                    Clear.clearAllFields(bi.fldGrpCVcb12, false)
                    Clear.clearAllFields(bi.fldGrpCVcb13, false)
                    Clear.clearAllFields(bi.fldGrpCVcb14, false)

                    MainApp.childInformation.setCb12(MainApp.form.getHh12())
                    MainApp.childInformation.setCb13(MainApp.form.getHh16())
                    MainApp.childInformation.setCb14(MainApp.form.getHh17())

                    Clear.clearAllFields(bi.fldGrpCVcb07, true)
                    Clear.clearAllFields(bi.fldGrpCVcb08, true)
                    Clear.clearAllFields(bi.fldGrpCVcb09, true)
                    Clear.clearAllFields(bi.fldGrpCVcb10, true)

                    bi.fldGrpCVcb11.visibility = View.VISIBLE
                }
                else -> {
                    Clear.clearAllFields(bi.fldGrpCVcb12, true)
                    Clear.clearAllFields(bi.fldGrpCVcb13, true)
                    Clear.clearAllFields(bi.fldGrpCVcb14, true)
                    Clear.clearAllFields(bi.fldGrpCVcb07, true)
                    Clear.clearAllFields(bi.fldGrpCVcb08, true)
                    Clear.clearAllFields(bi.fldGrpCVcb09, true)
                    Clear.clearAllFields(bi.fldGrpCVcb10, true)
                    bi.cb1413.isEnabled = false

                    bi.fldGrpCVcb11.visibility = View.VISIBLE
                }
            }
        }

        bi.cb14.setOnCheckedChangeListener { radioGroup: RadioGroup?, i: Int ->
            when (i) {
                bi.cb1496.id -> {
                    bi.cb1496x.visibility = View.VISIBLE
                }
                else -> {
                    bi.cb1496x.visibility = View.GONE
                    bi.cb1496x.text = null
                }
            }
        }

        bi.cb10.setOnCheckedChangeListener { radioGroup: RadioGroup?, i: Int ->
            when (i) {
                bi.cb1096.id -> {
                    bi.cb1096x.visibility = View.VISIBLE
                }
                else -> {
                    bi.cb1096x.visibility = View.GONE
                    bi.cb1096x.text = null
                }
            }
        }

        txtWatch(bi.cb09)
        txtWatch(bi.cb13)

    }


    private fun txtWatch(edx: EditTextPicker) {
        edx.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (edx.text.toString().isNotEmpty()) {
                    if (Integer.parseInt(edx.text.toString()) == 22)
                        edx.rangedefaultvalue = 22f
                    if (Integer.parseInt(edx.text.toString()) == 55)
                        edx.rangedefaultvalue = 55f
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }


    fun BtnContinue(view: View) {
        if (!formValidation()) return
        initForm()
        // SaveDraft(); //<== This function is no longer needed after DataBinding
        if (updateDB()) {
            finish()
        }
    }

    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addChildInformation(MainApp.childInformation)
        MainApp.childInformation.id = updcount.toString()
        return if (updcount > 0) {
            MainApp.childInformation.uid = MainApp.childInformation.deviceId + MainApp.childInformation.id
            var count = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_UID, MainApp.childInformation.uid)
            if (count > 0) count = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_SCB, MainApp.childInformation.sCBtoString())
            if (count > 0) true else {
                Toast.makeText(this, "SORRY! Failed to update DB)", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun formValidation(): Boolean {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false
        val totalMonths = bi.cb0501.text.toString().toInt() * 12 + bi.cb0502.text.toString().toInt()
        if (totalMonths > 59) {
            this.openWarningDialog("Warning", "Add children having age of less then or equal to 59 Months")
            return false
        }
        return true
    }

    fun BtnEnd(view: View) {
        finish()
    }

    // Only in First Section of every Table.
    private fun initForm() {
        MainApp.childInformation.sysDate = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(Date().time)
        MainApp.childInformation.uuid = MainApp.form.uid
        MainApp.childInformation.userName = MainApp.user.userName
        MainApp.childInformation.dcode = MainApp.form.dcode
        MainApp.childInformation.ucode = MainApp.form.ucode
        MainApp.childInformation.cluster = MainApp.form.cluster
        MainApp.childInformation.hhno = MainApp.form.hhno
        MainApp.childInformation.deviceId = MainApp.appInfo.deviceID
        MainApp.childInformation.deviceTag = MainApp.appInfo.tagName
        MainApp.childInformation.appver = MainApp.appInfo.appVersion
        MainApp.childInformation.cb15 = if (bi.cb1598.isChecked) "98" else MainApp.childInformation.cb15



        MainApp.childInformation.setCb01(bi.cb01.text.toString())

        MainApp.childInformation.setCb02(bi.cb02.text.toString())

        MainApp.childInformation.setCb03(if (bi.cb0301.isChecked) "1" else if (bi.cb0302.isChecked) "2" else "-1")

        MainApp.childInformation.setCb04dd(bi.cb04dd.text.toString())
        MainApp.childInformation.setCb04mm(bi.cb04mm.text.toString())
        MainApp.childInformation.setCb04yy(bi.cb04yy.text.toString())
        MainApp.childInformation.setCb0501(bi.cb0501.text.toString())
        MainApp.childInformation.setCb0502(bi.cb0502.text.toString())

        MainApp.childInformation.setCb06(when {
            bi.cb0601.isChecked -> "1"
            bi.cb0602.isChecked -> "2"
            bi.cb0603.isChecked -> "3"
            bi.cb0696.isChecked -> "4"
            else -> "-1"
        })

        MainApp.childInformation.setCb07(bi.cb07.text.toString())

        MainApp.childInformation.setCb08(bi.cb08.text.toString())

        MainApp.childInformation.setCb09(bi.cb09.text.toString())

        MainApp.childInformation.setCb10(when {
            bi.cb1001.isChecked -> "1"
            bi.cb1002.isChecked -> "2"
            bi.cb1003.isChecked -> "3"
            bi.cb1004.isChecked -> "4"
            bi.cb1005.isChecked -> "5"
            bi.cb1006.isChecked -> "6"
            bi.cb1007.isChecked -> "7"
            bi.cb1008.isChecked -> "8"
            bi.cb1009.isChecked -> "9"
            bi.cb1010.isChecked -> "10"
            bi.cb1011.isChecked -> "11"
            bi.cb1012.isChecked -> "12"
            bi.cb1013.isChecked -> "13"
            bi.cb1096.isChecked -> "96"
            else -> "-1"
        })

        MainApp.childInformation.setCb1096x(bi.cb1096x.text.toString())
        MainApp.childInformation.setCb11(if (bi.cb1101.isChecked) "1" else if (bi.cb1102.isChecked) "2" else "-1")

        MainApp.childInformation.setCb12(bi.cb12.text.toString())

        MainApp.childInformation.setCb13(bi.cb13.text.toString())

        MainApp.childInformation.setCb14(if (bi.cb1401.isChecked) "1" else if (bi.cb1402.isChecked) "2" else if (bi.cb1403.isChecked) "3" else if (bi.cb1404.isChecked) "4" else if (bi.cb1405.isChecked) "5" else if (bi.cb1406.isChecked) "6" else if (bi.cb1407.isChecked) "7" else if (bi.cb1408.isChecked) "8" else if (bi.cb1409.isChecked) "9" else if (bi.cb1410.isChecked) "10" else if (bi.cb1411.isChecked) "11" else if (bi.cb1412.isChecked) "12" else if (bi.cb1413.isChecked) "13" else if (bi.cb1496.isChecked) "96" else "-1")

        MainApp.childInformation.setCb1496x(bi.cb1496x.text.toString())
        MainApp.childInformation.setCb15(bi.cb15.text.toString())

        MainApp.childInformation.setCb16(if (bi.cb1601.isChecked) "1" else if (bi.cb1602.isChecked) "2" else if (bi.cb1603.isChecked) "3" else "-1")


    }

    fun cb04yyOnTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        bi.cb0502.isEnabled = false
        bi.cb0502.text = null
        bi.cb0501.isEnabled = false
        bi.cb0501.text = null
        MainApp.childInformation.calculatedDOB = null
        if (TextUtils.isEmpty(bi.cb04dd.text) || TextUtils.isEmpty(bi.cb04mm.text) || TextUtils.isEmpty(bi.cb04yy.text)) return
        if (!bi.cb04dd.isRangeTextValidate || !bi.cb04mm.isRangeTextValidate || !bi.cb04yy.isRangeTextValidate) return
        if (bi.cb04dd.text.toString() == "98" && bi.cb04mm.text.toString() == "98" && bi.cb04yy.text.toString() == "9998") {
            bi.cb0502.isEnabled = true
            bi.cb0501.isEnabled = true
            dtFlag = true
            return
        }
        val day = if (bi.cb04dd.text.toString() == "98") 15 else bi.cb04dd.text.toString().toInt()
        val month = bi.cb04mm.text.toString().toInt()
        val year = bi.cb04yy.text.toString().toInt()
        val age: AgeModel?
        age = if (MainApp.form.localDate != null) getCalculatedAge(MainApp.form.localDate, year, month, day) else getCalculatedAge(year = year, month = month, day = day)
        if (age == null) {
            bi.cb04yy.error = "Invalid date!!"
            dtFlag = false
            return
        }
        dtFlag = true
        bi.cb0502.setText(age.month.toString())
        bi.cb0501.setText(age.year.toString())

        //Setting Date
        try {
            val instant = Instant.parse(SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(
                    "$day-$month-$year"
            )) + "T06:24:01Z")
            MainApp.childInformation.calculatedDOB = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
}
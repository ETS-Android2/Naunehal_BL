package edu.aku.hassannaqvi.naunehal.ui.sections

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Clear
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.naunehal.CONSTANTS
import edu.aku.hassannaqvi.naunehal.R
import edu.aku.hassannaqvi.naunehal.contracts.ChildContract
import edu.aku.hassannaqvi.naunehal.core.MainApp
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection03csBinding
import edu.aku.hassannaqvi.naunehal.models.Child
import edu.aku.hassannaqvi.naunehal.models.ChildCard
import edu.aku.hassannaqvi.naunehal.models.ChildInformation
import edu.aku.hassannaqvi.naunehal.utils.EndSectionActivity
import edu.aku.hassannaqvi.naunehal.utils.contextEndActivity
import edu.aku.hassannaqvi.naunehal.utils.convertStringToUpperCase
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivity
import edu.aku.hassannaqvi.naunehal.utils.shortStringLength
import java.text.SimpleDateFormat
import java.util.*

class Section03CSActivity : AppCompatActivity(), EndSectionActivity {
    lateinit var bi: ActivitySection03csBinding
    private val info: ChildInformation by lazy {
        intent.getSerializableExtra(CONSTANTS.CHILD_DATA_UNDER5) as ChildInformation
    }

    companion object {
        lateinit var selectedChildInfo: ChildInformation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_03cs)
        bi.mainCard.childCard = ChildCard(info.cb02.convertStringToUpperCase().shortStringLength(), String.format("Mother: %s", info.cb07.convertStringToUpperCase().shortStringLength()), info.cb03.toInt())
        MainApp.child = Child(
                info.cb01,
                info.cb02,
                info.cb07,
                info.uid)
        bi.callback
        selectedChildInfo = info
        setupSkips()
    }

    private fun setupSkips() {
        bi.cs03.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            Clear.clearAllFields(bi.llcs03)
            bi.llcs03.visibility = View.VISIBLE
            if (i == bi.cs0302.id) {
                bi.llcs03.visibility = View.GONE
            }
        }
        bi.cs06.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            Clear.clearAllFields(bi.fldGrpCVcs07)
            Clear.clearAllFields(bi.fldGrpCVcs08)
            Clear.clearAllFields(bi.fldGrpCVcs08a)
            Clear.clearAllFields(bi.fldGrpCVcs08b)
            Clear.clearAllFields(bi.fldGrpCVcs09)
            Clear.clearAllFields(bi.fldGrpCVcs10)
            Clear.clearAllFields(bi.fldGrpCVcs11)
            bi.fldGrpCVcs07.visibility = View.VISIBLE
            bi.fldGrpCVcs08.visibility = View.VISIBLE
            bi.fldGrpCVcs08a.visibility = View.VISIBLE
            bi.fldGrpCVcs08b.visibility = View.VISIBLE
            bi.fldGrpCVcs09.visibility = View.VISIBLE
            bi.fldGrpCVcs10.visibility = View.VISIBLE
            bi.fldGrpCVcs11.visibility = View.VISIBLE
            if (i == bi.cs0602.id) {
                bi.fldGrpCVcs07.visibility = View.GONE
                bi.fldGrpCVcs08.visibility = View.GONE
                bi.fldGrpCVcs08a.visibility = View.GONE
                bi.fldGrpCVcs08b.visibility = View.GONE
            } else if (i == bi.cs0601.id) {
                bi.fldGrpCVcs10.visibility = View.GONE
                bi.fldGrpCVcs11.visibility = View.GONE
                bi.fldGrpCVcs09.visibility = View.GONE
            }
        }

        bi.cs08a.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            Clear.clearAllFields(bi.fldGrpCVcs08b)
            bi.fldGrpCVcs08b.visibility = View.VISIBLE
            if (i == bi.cs08ab.id) {
                bi.fldGrpCVcs08b.visibility = View.GONE
            }
        }


        bi.cs16.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            Clear.clearAllFields(bi.fldGrpCVcs17)
            Clear.clearAllFields(bi.fldGrpCVcs17a)
            Clear.clearAllFields(bi.fldGrpCVcs17b)
            Clear.clearAllFields(bi.fldGrpCVcs18)
            Clear.clearAllFields(bi.fldGrpCVcs19)
            if (i == bi.cs1601.id) {
                bi.fldGrpCVcs17.visibility = View.VISIBLE
                bi.fldGrpCVcs17a.visibility = View.VISIBLE
                bi.fldGrpCVcs17b.visibility = View.VISIBLE
                bi.fldGrpCVcs18.visibility = View.VISIBLE
                bi.fldGrpCVcs19.visibility = View.GONE
            } else if (i == bi.cs1602.id) {
                bi.fldGrpCVcs17.visibility = View.GONE
                bi.fldGrpCVcs17a.visibility = View.GONE
                bi.fldGrpCVcs17b.visibility = View.GONE
                bi.fldGrpCVcs18.visibility = View.GONE
                bi.fldGrpCVcs19.visibility = View.VISIBLE
            }
        }



        bi.cs17a.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            Clear.clearAllFields(bi.fldGrpCVcs17b)
            bi.fldGrpCVcs17b.visibility = View.VISIBLE
            if (i == bi.cs17ab.id) {
                bi.fldGrpCVcs17b.visibility = View.GONE
            }
        }

        radioGroup(bi.cs12)
        radioGroup(bi.cs13)
        radioGroup(bi.cs14)
    }

    private fun radioGroup(grp: RadioGroup) {
        grp.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            Clear.clearAllFields(bi.fldGrpCVcs15)
            Clear.clearAllFields(bi.fldGrpCVcs16)
            Clear.clearAllFields(bi.fldGrpCVcs17)
            Clear.clearAllFields(bi.fldGrpCVcs17a)
            Clear.clearAllFields(bi.fldGrpCVcs17b)
            Clear.clearAllFields(bi.fldGrpCVcs18)
            Clear.clearAllFields(bi.fldGrpCVcs19)
            bi.fldGrpCVcs15.visibility = View.VISIBLE
            bi.fldGrpCVcs16.visibility = View.VISIBLE
            bi.fldGrpCVcs17.visibility = View.VISIBLE
            bi.fldGrpCVcs17a.visibility = View.VISIBLE
            bi.fldGrpCVcs17b.visibility = View.VISIBLE
            bi.fldGrpCVcs18.visibility = View.VISIBLE
            bi.fldGrpCVcs19.visibility = View.VISIBLE
            if (bi.cs1202.isChecked
                    && bi.cs1302.isChecked
                    && bi.cs1402.isChecked) {
                bi.fldGrpCVcs15.visibility = View.GONE
                bi.fldGrpCVcs16.visibility = View.GONE
                bi.fldGrpCVcs17.visibility = View.GONE
                bi.fldGrpCVcs17a.visibility = View.GONE
                bi.fldGrpCVcs17b.visibility = View.GONE
                bi.fldGrpCVcs18.visibility = View.GONE
                bi.fldGrpCVcs19.visibility = View.GONE
            }
            if (i == bi.cs1402.id) {
                bi.fldGrpCVcs15.visibility = View.GONE
            }
        }
    }

    fun BtnContinue(view: View) {
        if (!formValidation()) return
        initForm()
        MainApp.child.status = "1"
        if (updateDB()) {
            finish()
            if (info.isUnder35)
                gotoActivity(Section04IMActivity::class.java)
        }
    }

    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addChild(MainApp.child)
        MainApp.child.id = updcount.toString()
        return if (updcount > 0) {
            MainApp.child.uid = MainApp.child.deviceId + MainApp.child.id
            var count = db.updatesChildColumn(ChildContract.ChildTable.COLUMN_UID, MainApp.child.uid)
            if (count > 0) count = db.updatesChildColumn(ChildContract.ChildTable.COLUMN_SCS, MainApp.child.s03CStoString())
            if (count > 0) true else {
                Toast.makeText(this, "SORRY! Failed to update DB)", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
            false
        }
    }

    // Only in First Section of every Table.
    private fun initForm() {
        MainApp.child.sysDate = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(Date().time)
        MainApp.child.uuid = MainApp.form.uid
        MainApp.child.userName = MainApp.user.userName
        MainApp.child.dcode = MainApp.form.dcode
        MainApp.child.ucode = MainApp.form.ucode
        MainApp.child.cluster = MainApp.form.cluster
        MainApp.child.hhno = MainApp.form.hhno
        MainApp.child.deviceId = MainApp.appInfo.deviceID
        MainApp.child.deviceTag = MainApp.appInfo.tagName
        MainApp.child.appver = MainApp.appInfo.appVersion
        MainApp.child.serial = info.cb01
        MainApp.child.childname = info.cb02
        MainApp.child.mothername = info.cb07


        MainApp.child.setCs01(
                if (bi.cs01.text.toString().trim().isEmpty()) "-1"
                else bi.cs01.text.toString())

        MainApp.child.setCs02(
                if (bi.cs02.text.toString().trim().isEmpty()) "-1"
                else bi.cs02.text.toString())

        MainApp.child.setCs03(
                when {
                    bi.cs0301.isChecked -> "1"
                    bi.cs0302.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs04(
                when {
                    bi.cs0401.isChecked -> "1"
                    bi.cs0402.isChecked -> "2"
                    bi.cs0403.isChecked -> "3"
                    bi.cs0404.isChecked -> "4"
                    bi.cs0405.isChecked -> "5"
                    bi.cs0498.isChecked -> "98"
                    else -> "-1"
                })

        MainApp.child.setCs05(
                when {
                    bi.cs0501.isChecked -> "1"
                    bi.cs0502.isChecked -> "2"
                    bi.cs0503.isChecked -> "3"
                    bi.cs0504.isChecked -> "4"
                    bi.cs0505.isChecked -> "5"
                    bi.cs0598.isChecked -> "98"
                    else -> "-1"
                })

        MainApp.child.setCs06(
                when {
                    bi.cs0601.isChecked -> "1"
                    bi.cs0602.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs07(
                when {
                    bi.cs0701.isChecked -> "1"
                    bi.cs0702.isChecked -> "2"
                    bi.cs0703.isChecked -> "3"
                    bi.cs0704.isChecked -> "4"
                    bi.cs0706.isChecked -> "6"
                    bi.cs07961.isChecked -> "961"
                    bi.cs0707.isChecked -> "7"
                    bi.cs0708.isChecked -> "8"
                    bi.cs0709.isChecked -> "9"
                    bi.cs0710.isChecked -> "10"
                    bi.cs0711.isChecked -> "11"
                    bi.cs0712.isChecked -> "12"
                    bi.cs0713.isChecked -> "13"
                    bi.cs07962.isChecked -> "962"
                    else -> "-1"
                })

        MainApp.child.setCs07961x(
                if (bi.cs07961x.text.toString().trim().isEmpty()) "-1"
                else bi.cs07961x.text.toString())

        MainApp.child.setCs07962x(
                if (bi.cs07962x.text.toString().trim().isEmpty()) "-1"
                else bi.cs07962x.text.toString())


        MainApp.child.setCs0801(if (bi.cs0801.isChecked) "1" else "-1")
        MainApp.child.setCs0802(if (bi.cs0802.isChecked) "2" else "-1")
        MainApp.child.setCs0803(if (bi.cs0803.isChecked) "3" else "-1")
        MainApp.child.setCs0804(if (bi.cs0804.isChecked) "4" else "-1")
        MainApp.child.setCs0805(if (bi.cs0805.isChecked) "5" else "-1")
        MainApp.child.setCs0806(if (bi.cs0806.isChecked) "6" else "-1")
        MainApp.child.setCs0807(if (bi.cs0807.isChecked) "7" else "-1")
        MainApp.child.setCs0808(if (bi.cs0808.isChecked) "8" else "-1")
        MainApp.child.setCs0809(if (bi.cs0809.isChecked) "9" else "-1")
        MainApp.child.setCs0810(if (bi.cs0810.isChecked) "10" else "-1")
        MainApp.child.setCs0896(if (bi.cs0896.isChecked) "96" else "-1")

        MainApp.child.setCs0896x(
                when {
                    bi.cs0896x.text.toString().trim().isEmpty() -> "-1"
                    else -> bi.cs0896x.text.toString()
                })

        MainApp.child.setCs08a(
                when {
                    bi.cs08aa.isChecked -> "1"
                    bi.cs08ab.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs08b(
                if (bi.cs08b.text.toString().trim().isEmpty()) "-1"
                else bi.cs08b.text.toString())


        MainApp.child.setCs09(
                when {
                    bi.cs0901.isChecked -> "1"
                    bi.cs0902.isChecked -> "2"
                    bi.cs0903.isChecked -> "3"
                    bi.cs0904.isChecked -> "4"
                    bi.cs0905.isChecked -> "5"
                    bi.cs0906.isChecked -> "6"
                    bi.cs0996.isChecked -> "96"
                    else -> "-1"
                })

        MainApp.child.setCs0996x(
                if (bi.cs0996x.text.toString().trim().isEmpty()) "-1"
                else bi.cs0996x.text.toString())

        MainApp.child.setCs10(
                when {
                    bi.cs1001.isChecked -> "1"
                    bi.cs1002.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs11(
                when {
                    bi.cs1101.isChecked -> "1"
                    bi.cs1102.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs12(
                when {
                    bi.cs1201.isChecked -> "1"
                    bi.cs1202.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs13(
                when {
                    bi.cs1301.isChecked -> "1"
                    bi.cs1302.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs14(
                when {
                    bi.cs1401.isChecked -> "1"
                    bi.cs1402.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs15(
                when {
                    bi.cs1501.isChecked -> "1"
                    bi.cs1502.isChecked -> "2"
                    bi.cs1503.isChecked -> "3"
                    bi.cs1596.isChecked -> "96"
                    else -> "-1"
                })

        MainApp.child.setCs1596x(
                if (bi.cs1596x.text.toString().trim().isEmpty()) "-1"
                else bi.cs1596x.text.toString())

        MainApp.child.setCs16(
                when {
                    bi.cs1601.isChecked -> "1"
                    bi.cs1602.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs17(
                when {
                    bi.cs1701.isChecked -> "1"
                    bi.cs1702.isChecked -> "2"
                    bi.cs1703.isChecked -> "3"
                    bi.cs1704.isChecked -> "4"
                    bi.cs17961.isChecked -> "961"
                    bi.cs1706.isChecked -> "6"
                    bi.cs1707.isChecked -> "7"
                    bi.cs1708.isChecked -> "8"
                    bi.cs1709.isChecked -> "9"
                    bi.cs1710.isChecked -> "10"
                    bi.cs1711.isChecked -> "11"
                    bi.cs1712.isChecked -> "12"
                    bi.cs1713.isChecked -> "13"
                    bi.cs17962.isChecked -> "962"
                    else -> "-1"
                })

        MainApp.child.setCs17961x(
                if (bi.cs17961x.text.toString().trim().isEmpty()) "-1"
                else bi.cs17961x.text.toString())

        MainApp.child.setCs17962x(
                if (bi.cs17962x.text.toString().trim().isEmpty()) "-1"
                else bi.cs17962x.text.toString())

        MainApp.child.setCs17a(
                when {
                    bi.cs17aa.isChecked -> "1"
                    bi.cs17ab.isChecked -> "2"
                    else -> "-1"
                })

        MainApp.child.setCs17b(
                if (bi.cs17b.text.toString().trim().isEmpty()) "-1"
                else bi.cs17b.text.toString())


        MainApp.child.setCs1802(if (bi.cs1802.isChecked) "2" else "-1")
        MainApp.child.setCs1803(if (bi.cs1803.isChecked) "3" else "-1")
        MainApp.child.setCs1804(if (bi.cs1804.isChecked) "4" else "-1")
        MainApp.child.setCs1805(if (bi.cs1805.isChecked) "5" else "-1")
        MainApp.child.setCs1806(if (bi.cs1806.isChecked) "6" else "-1")
        MainApp.child.setCs1807(if (bi.cs1807.isChecked) "7" else "-1")
        MainApp.child.setCs1808(if (bi.cs1808.isChecked) "8" else "-1")
        MainApp.child.setCs1896(if (bi.cs1896.isChecked) "96" else "-1")

        MainApp.child.setCs1896x(
                if (bi.cs1896x.text.toString().trim().isEmpty()) "-1"
                else bi.cs1896x.text.toString())

        MainApp.child.setCs19(
                when {
                    bi.cs1901.isChecked -> "1"
                    bi.cs1902.isChecked -> "2"
                    bi.cs1903.isChecked -> "3"
                    bi.cs1904.isChecked -> "4"
                    bi.cs1905.isChecked -> "5"
                    bi.cs1906.isChecked -> "6"
                    bi.cs1996.isChecked -> "96"
                    else -> "-1"
                })

        MainApp.child.setCs1996x(
                if (bi.cs1996x.text.toString().trim().isEmpty()) "-1"
                else bi.cs1996x.text.toString())

        MainApp.child.setCs20(
                when {
                    bi.cs2001.isChecked -> "1"
                    bi.cs2002.isChecked -> "2"
                    bi.cs2098.isChecked -> "98"
                    else -> "-1"
                })

        MainApp.child.setCs21(
                when {
                    bi.cs2101.isChecked -> "1"
                    bi.cs2102.isChecked -> "2"
                    bi.cs2103.isChecked -> "3"
                    bi.cs2104.isChecked -> "4"
                    bi.cs2105.isChecked -> "5"

                    else -> "-1"
                })

    }


    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }

    fun BtnEnd(view: View) {
        contextEndActivity(this)
    }

    override fun endSecActivity(flag: Boolean) {
        initForm()
        MainApp.child.status = "2"
        if (updateDB()) {
            finish()
        }
    }


    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }


}
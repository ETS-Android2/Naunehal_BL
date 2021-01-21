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
        bi.form = MainApp.child
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
            Clear.clearAllFields(bi.fldGrpCVcs09)
            Clear.clearAllFields(bi.fldGrpCVcs10)
            Clear.clearAllFields(bi.fldGrpCVcs11)
            bi.fldGrpCVcs07.visibility = View.VISIBLE
            bi.fldGrpCVcs08.visibility = View.VISIBLE
            bi.fldGrpCVcs09.visibility = View.VISIBLE
            bi.fldGrpCVcs10.visibility = View.VISIBLE
            bi.fldGrpCVcs11.visibility = View.VISIBLE
            if (i == bi.cs0602.id) {
                bi.fldGrpCVcs07.visibility = View.GONE
                bi.fldGrpCVcs08.visibility = View.GONE
            } else if (i == bi.cs0601.id) {
                bi.fldGrpCVcs10.visibility = View.GONE
                bi.fldGrpCVcs11.visibility = View.GONE
                bi.fldGrpCVcs09.visibility = View.GONE
            }
        }
        bi.cs16.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            if (i == bi.cs1601.id) {
                bi.fldGrpCVcs17.visibility = View.VISIBLE
                bi.fldGrpCVcs18.visibility = View.VISIBLE
                bi.fldGrpCVcs19.visibility = View.GONE
            } else if (i == bi.cs1602.id) {
                bi.fldGrpCVcs17.visibility = View.GONE
                bi.fldGrpCVcs18.visibility = View.GONE
                bi.fldGrpCVcs19.visibility = View.VISIBLE
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
            Clear.clearAllFields(bi.fldGrpCVcs18)
            Clear.clearAllFields(bi.fldGrpCVcs19)
            bi.fldGrpCVcs15.visibility = View.VISIBLE
            bi.fldGrpCVcs16.visibility = View.VISIBLE
            bi.fldGrpCVcs17.visibility = View.VISIBLE
            bi.fldGrpCVcs18.visibility = View.VISIBLE
            bi.fldGrpCVcs19.visibility = View.VISIBLE
            if (bi.cs1202.isChecked
                    && bi.cs1302.isChecked
                    && bi.cs1402.isChecked) {
                bi.fldGrpCVcs15.visibility = View.GONE
                bi.fldGrpCVcs16.visibility = View.GONE
                bi.fldGrpCVcs17.visibility = View.GONE
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



        MainApp.child.setCs01(bi.cs01.text.toString())

        MainApp.child.setCs02(bi.cs02.text.toString())

        MainApp.child.setCs03(if (bi.cs0301.isChecked) "1" else if (bi.cs0302.isChecked) "2" else "-1")

        MainApp.child.setCs04(if (bi.cs0401.isChecked) "1" else if (bi.cs0402.isChecked) "2" else if (bi.cs0403.isChecked) "3" else if (bi.cs0404.isChecked) "4" else if (bi.cs0405.isChecked) "5" else if (bi.cs0498.isChecked) "98" else "-1")

        MainApp.child.setCs05(if (bi.cs0501.isChecked) "1" else if (bi.cs0502.isChecked) "2" else if (bi.cs0503.isChecked) "3" else if (bi.cs0504.isChecked) "4" else if (bi.cs0505.isChecked) "5" else if (bi.cs0598.isChecked) "98" else "-1")

        MainApp.child.setCs06(if (bi.cs0601.isChecked) "1" else if (bi.cs0602.isChecked) "2" else "-1")

        MainApp.child.setCs07(if (bi.cs0701.isChecked) "1" else if (bi.cs0702.isChecked) "2" else if (bi.cs0703.isChecked) "3" else if (bi.cs0704.isChecked) "4" else if (bi.cs0706.isChecked) "6" else if (bi.cs07961.isChecked) "961" else if (bi.cs0707.isChecked) "7" else if (bi.cs0708.isChecked) "8" else if (bi.cs0709.isChecked) "9" else if (bi.cs0710.isChecked) "10" else if (bi.cs0711.isChecked) "11" else if (bi.cs0712.isChecked) "12" else if (bi.cs0713.isChecked) "13" else if (bi.cs07962.isChecked) "962" else "-1")

        MainApp.child.setCs07961x(bi.cs07961x.text.toString())
        MainApp.child.setCs07962x(bi.cs07962x.text.toString())
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

        MainApp.child.setCs0896x(bi.cs0896x.text.toString())
        MainApp.child.setCs09(if (bi.cs0901.isChecked) "1" else if (bi.cs0902.isChecked) "2" else if (bi.cs0903.isChecked) "3" else if (bi.cs0904.isChecked) "4" else if (bi.cs0905.isChecked) "5" else if (bi.cs0906.isChecked) "6" else if (bi.cs0996.isChecked) "96" else "-1")

        MainApp.child.setCs0996x(bi.cs0996x.text.toString())
        MainApp.child.setCs10(if (bi.cs1001.isChecked) "1" else if (bi.cs1002.isChecked) "2" else "-1")

        MainApp.child.setCs11(if (bi.cs1101.isChecked) "1" else if (bi.cs1102.isChecked) "2" else "-1")

        MainApp.child.setCs12(if (bi.cs1201.isChecked) "1" else if (bi.cs1202.isChecked) "2" else "-1")

        MainApp.child.setCs13(if (bi.cs1301.isChecked) "1" else if (bi.cs1302.isChecked) "2" else "-1")

        MainApp.child.setCs14(if (bi.cs1401.isChecked) "1" else if (bi.cs1402.isChecked) "2" else "-1")

        MainApp.child.setCs15(if (bi.cs1501.isChecked) "1" else if (bi.cs1502.isChecked) "2" else if (bi.cs1503.isChecked) "3" else if (bi.cs1596.isChecked) "96" else "-1")

        MainApp.child.setCs1596x(bi.cs1596x.text.toString())
        MainApp.child.setCs16(if (bi.cs1601.isChecked) "1" else if (bi.cs1602.isChecked) "2" else "-1")

        MainApp.child.setCs17(if (bi.cs1701.isChecked) "1" else if (bi.cs1702.isChecked) "2" else if (bi.cs1703.isChecked) "3" else if (bi.cs1704.isChecked) "4" else if (bi.cs17961.isChecked) "961" else if (bi.cs1706.isChecked) "6" else if (bi.cs1707.isChecked) "7" else if (bi.cs1708.isChecked) "8" else if (bi.cs1709.isChecked) "9" else if (bi.cs1710.isChecked) "10" else if (bi.cs1711.isChecked) "11" else if (bi.cs1712.isChecked) "12" else if (bi.cs1713.isChecked) "13" else if (bi.cs17962.isChecked) "962" else "-1")

        MainApp.child.setCs17961x(bi.cs17961x.text.toString())
        MainApp.child.setCs17962x(bi.cs17962x.text.toString())
        MainApp.child.setCs18(if (bi.cs1802.isChecked) "2" else if (bi.cs1803.isChecked) "3" else if (bi.cs1804.isChecked) "4" else if (bi.cs1805.isChecked) "5" else if (bi.cs1806.isChecked) "6" else if (bi.cs1807.isChecked) "7" else if (bi.cs1808.isChecked) "8" else if (bi.cs1896.isChecked) "96" else "-1")

        MainApp.child.setCs1896x(bi.cs1896x.text.toString())
        MainApp.child.setCs19(if (bi.cs1901.isChecked) "1" else if (bi.cs1902.isChecked) "2" else if (bi.cs1903.isChecked) "3" else if (bi.cs1904.isChecked) "4" else if (bi.cs1905.isChecked) "5" else if (bi.cs1906.isChecked) "6" else if (bi.cs1996.isChecked) "96" else "-1")

        MainApp.child.setCs1996x(bi.cs1996x.text.toString())


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
}
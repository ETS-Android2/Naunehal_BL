package edu.aku.hassannaqvi.naunehal.ui.sections

import android.content.Intent
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
import edu.aku.hassannaqvi.naunehal.ui.MainActivity
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivity
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivityWithSerializable
import java.text.SimpleDateFormat
import java.util.*

class Section03CSActivity : AppCompatActivity() {
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
        bi.mainCard.childCard = ChildCard(info.cb02, info.cb07, if (info.cb03 == "1") R.drawable.ctr_childboy else R.drawable.ctr_childgirl)
        MainApp.child = Child(info.cb01, info.cb02, info.cb07, info.uid)
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
            Clear.clearAllFields(bi.fldGrpCVcs10)
            Clear.clearAllFields(bi.fldGrpCVcs11)
            bi.fldGrpCVcs07.visibility = View.VISIBLE
            bi.fldGrpCVcs08.visibility = View.VISIBLE
            bi.fldGrpCVcs10.visibility = View.VISIBLE
            bi.fldGrpCVcs11.visibility = View.VISIBLE
            if (i == bi.cs0602.id) {
                bi.fldGrpCVcs07.visibility = View.GONE
                bi.fldGrpCVcs08.visibility = View.GONE
            } else if (i == bi.cs0601.id) {
                bi.fldGrpCVcs10.visibility = View.GONE
                bi.fldGrpCVcs11.visibility = View.GONE
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
    }


    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }

    fun BtnEnd(view: View) {
        initForm()
        MainApp.child.status = "2"
        if (updateDB()) {
            finish()
            if (info.isUnder35)
                gotoActivityWithSerializable(Section04IMActivity::class.java, CONSTANTS.CHILD_DATA_UNDER3, info)
        }
    }
}
package edu.aku.hassannaqvi.naunehal.ui.sections

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.validatorcrawler.aliazaz.Clear
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.naunehal.R
import edu.aku.hassannaqvi.naunehal.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatus
import edu.aku.hassannaqvi.naunehal.base.viewmodel.H1ViewModel
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract
import edu.aku.hassannaqvi.naunehal.core.MainApp
import edu.aku.hassannaqvi.naunehal.core.MainApp.form
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySection01hhBinding
import edu.aku.hassannaqvi.naunehal.models.BLRandom
import edu.aku.hassannaqvi.naunehal.models.Form
import edu.aku.hassannaqvi.naunehal.utils.*
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivity
import edu.aku.hassannaqvi.naunehal.utils.extension.obtainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class Section01HHActivity : AppCompatActivity() {
    lateinit var bi: ActivitySection01hhBinding
    lateinit var viewModel: H1ViewModel
    var district = mutableListOf("....")
    var districtCode = mutableListOf<String>()
    var uc = mutableListOf("....")
    var ucCode = mutableListOf<String>()
    lateinit var districtAdapter: ArrayAdapter<String>
    lateinit var ucAdapter: ArrayAdapter<String>
    lateinit var blRandom: BLRandom

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_01hh)
        bi.callback
        setSupportActionBar(bi.toolbar)
        bi.aa01.setMinDate(getDaysBack("dd/MM/yyyy", -7))

        /*
        * Obtaining ViewModel
        * */
        viewModel = obtainViewModel(H1ViewModel::class.java, GeneralRepository(DatabaseHelper(this)))

        /*
        * Setting Adapters
        * */
        districtAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, district)
        bi.hh05.adapter = districtAdapter
        ucAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, uc)
        bi.hh06.adapter = ucAdapter

        /*
        * Calling viewmodel district data function
        * Fetch district result response
        * */
        viewModel.districtResponse.observe(this, Observer {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        lifecycleScope.launch {
                            it.data?.forEach { item ->
                                district.add(item.districtName)
                                districtCode.add(item.districtCode)
                            }
                            districtAdapter.notifyDataSetChanged()
                        }
                    }
                    ResponseStatus.ERROR -> {
                        lifecycleScope.launch {
                            Toast.makeText(this@Section01HHActivity, "Please sync data first", Toast.LENGTH_LONG).show()
                            delay(3000)
                            finish()
                        }
                    }
                    ResponseStatus.LOADING -> {
                    }
                }
            }
        })

        /*
        * Calling viewmodel uc data function
        * Fetch uc result response
        * */
        viewModel.ucResponse.observe(this, Observer {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        lifecycleScope.launch {
                            it.data?.forEach { item ->
                                uc.add(item.ucName)
                                ucCode.add(item.ucCode)
                            }
                            ucAdapter.notifyDataSetChanged()
                        }
                    }
                    ResponseStatus.ERROR -> {
                        Toast.makeText(this@Section01HHActivity, "Village not found!", Toast.LENGTH_LONG).show()
                    }
                    ResponseStatus.LOADING -> {
                    }
                }
            }
        })

        /*
        * Calling viewmodel blrandom data function
        * Fetch blrandom result response
        * */
        viewModel.blResponse.observe(this, {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        lifecycleScope.launch {
                            bi.fldGrpcheck.visibility = View.VISIBLE
                            bi.hh09.isEnabled = false
                            bi.checkHH.visibility = View.GONE
                            bi.progressBL.visibility = View.GONE
                            blRandom = it.data as BLRandom
                            bi.hhHEad.text = "Head: ${blRandom.hhhead.convertStringToUpperCase().shortStringLength()}"
                        }
                    }
                    ResponseStatus.ERROR -> {
                        Toast.makeText(this@Section01HHActivity, it.message, Toast.LENGTH_LONG).show()
                        bi.hh09.isEnabled = true
                        bi.checkHH.visibility = View.VISIBLE
                        bi.progressBL.visibility = View.GONE
                    }
                    ResponseStatus.LOADING -> {
                        lifecycleScope.launch {
                            bi.progressBL.visibility = View.VISIBLE
                            delay(2000)
                        }
                    }
                }
            }
        })

        // TODO: Check if form already exist in database.
        if ( /*!formExists()*/false) //<== If form exist in database formExists() will also populateForm() and return true;
        {
            saveDraft() //<== If form does not exist in database (New Form)
        }
        form = Form()
        setupSkips()
    }

    private fun setupSkips() {
        rgListener(bi.hh11, bi.hh1102, bi.llhh11)
        rgListener(bi.hh18, bi.hh1801, bi.llhh18)

        bi.hh05.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.hh06.setSelection(0)
                if (position == 0) {
                    bi.hh06.isEnabled = false
                    return
                }
                bi.hh06.isEnabled = true
                uc.clear()
                ucCode.clear()
                uc.add("....")
                viewModel.getUCsDistrictFromDB(districtCode[position - 1])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        bi.hh08.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bi.hh09.isEnabled = true
                bi.fldGrpcheck.visibility = View.GONE
                bi.checkHH.visibility = View.VISIBLE
                bi.progressBL.visibility = View.GONE
                bi.hhHEad.text = null
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        bi.hh09.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                Log.d("TAG", "beforeTextChanged: " + i + " " + i1 + " " + i2 + " ")
                //      Toast.makeText(SectionHHActivity.this, charSequence+" i="+i+" i1="+i1+" i2="+i2, Toast.LENGTH_LONG).show();
                if (i == 1 && i1 == 0 && i2 == 1) {
                    bi.hh09.setText(bi.hh09.text.toString().plus("-"))
                }
                if (i == 6 && i1 == 0 && i2 == 1) {
                    bi.hh09.setText(bi.hh09.text.toString().plus("-"))
                }
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                Log.d("TAG", "beforeTextChanged: " + i + " " + i1 + " " + i2 + " ")

                if (i == 0 && i1 == 0 && i2 == 1) {
                    bi.hh09.setText(bi.hh09.text.toString().plus("-"))
                }
                if (i == 2 && i1 == 1 && i2 == 0) {
                    bi.hh09.setText(bi.hh09.text.toString().substring(0, 1))
                }
                if (i == 1 && i1 == 4 && i2 == 5) {
                    bi.hh09.setText(bi.hh09.text.toString().plus("-"))
                }
                if (i == 7 && i1 == 1 && i2 == 0) {
                    bi.hh09.setText(bi.hh09.text.toString().substring(0, 6))
                }
            }

            override fun afterTextChanged(editable: Editable) {

                bi.hh09.setSelection(bi.hh09.text.toString().length)

            }
        })

        bi.hh14.setOnCheckedChangeListener { radioGroup: RadioGroup?, i: Int ->
            bi.hh1713.isEnabled = i == bi.hh1402.id
        }

        bi.hh16.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (bi.hh16.text.toString().isNotEmpty()) {
                    if (Integer.parseInt(bi.hh16.text.toString()) == 22)
                        bi.hh16.rangedefaultvalue = 22f
                    if (Integer.parseInt(bi.hh16.text.toString()) == 55)
                        bi.hh16.rangedefaultvalue = 55f
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun rgListener(rg: RadioGroup, rb: RadioButton, vg: ViewGroup) {
        rg.setOnCheckedChangeListener { radioGroup: RadioGroup?, i: Int ->
            Clear.clearAllFields(vg)
            vg.visibility = View.VISIBLE
            if (i == rb.id) vg.visibility = View.GONE
        }
    }

    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            val response = when {
                bi.hh1102.isChecked -> 1
                bi.hh24.text.toString().toInt().plus(bi.hh25.text.toString().toInt()) == 0 -> 2
                bi.hh25a02.isChecked -> 3
                else -> 0
            }
            when (response) {
                1 -> return openWarningDialogh("WARNING", response, resources.getString(R.string.hh2603))
                2 -> return openWarningDialogh("WARNING", response, resources.getString(R.string.hh2607))
                3 -> return openWarningDialogh("WARNING", response, resources.getString(R.string.hh2608))
                0 -> {
                    finish()
                    gotoActivity(ChildrenListActivity::class.java)
                }
            }
        }
    }

    fun checkHHExist(view: View) {
        Clear.clearAllFields(bi.fldGrpcheck)
        if (!Validator.emptyCheckingContainer(this, bi.fldGrpHH01)) return
        bi.checkHH.visibility = View.GONE
        viewModel.getBLRandomDataFromDB(
                districtCode[bi.hh05.selectedItemPosition - 1],
                bi.hh08.text.toString(),
                bi.hh09.text.toString()
        )
    }

    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addForm(form)
        form.id = updcount.toString()
        return if (updcount > 0) {
            form.uid = form.deviceId + form.id
            var count = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.uid)
            if (count > 0) count = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S01HH, MainApp.form.s01HHtoString())
            if (count > 0) true else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun formValidation(): Boolean {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false
        if (bi.hh1102.isChecked) return true
        val totalMembers = ((if (TextUtils.isEmpty(bi.hh22.text)) 0 else bi.hh22.text.toString().trim().toInt())
                + if (TextUtils.isEmpty(bi.hh23.text)) 0 else bi.hh23.text.toString().trim().toInt())
        when {
            totalMembers == 0 -> {
                return Validator.emptyCustomTextBox(this, bi.hh21, "Invalid Count")
            }
            totalMembers != bi.hh21.text.toString().toInt() -> {
                return Validator.emptyCustomTextBox(this, bi.hh21, "Invalid Count")
            }
            bi.hh24.text.toString().toInt() > bi.hh22.text.toString().toInt() -> {
                return Validator.emptyCustomTextBox(this, bi.hh24, "Total male Children cannot be greater than HH22")
            }
            bi.hh25.text.toString().toInt() > bi.hh23.text.toString().toInt() -> {
                return Validator.emptyCustomTextBox(this, bi.hh25, "Total female Children cannot be greater than HH22")
            }
//            bi.hh24.text.toString().toInt().plus(bi.hh25.text.toString().toInt()) == 0 -> return Validator.emptyCustomTextBox(this, bi.hh21, "Male & Female Children cannot be zero")
            bi.hh22.text.toString().toInt().plus(bi.hh23.text.toString().toInt()).minus(bi.hh24.text.toString().toInt().plus(bi.hh25.text.toString().toInt())) == 0 ->
                return Validator.emptyCustomTextBox(this, bi.hh21, "Male & Female children count couldn't be same as Men & Women count")
            else -> return true
        }
    }

    private fun saveDraft() {
        form.sysDate = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(Date().time)
        form.userName = MainApp.user.userName
        form.dcode = districtCode[bi.hh05.selectedItemPosition - 1]
        form.ucode = ucCode[bi.hh06.selectedItemPosition - 1]
        form.cluster = bi.hh08.text.toString()
        form.hhno = bi.hh09.text.toString()
        form.deviceId = MainApp.appInfo.deviceID
        form.deviceTag = MainApp.appInfo.tagName
        form.appver = MainApp.appInfo.appVersion

        //Setting Date
        try {
            bi.aa01.text?.let {
                val instant = Instant.parse(SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
                        .format(
                                SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(it.toString())
                        ) + "T06:24:01Z")
                form.localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }


        form.hh01 = when {
            bi.aa01.text.toString().trim().isNotEmpty() -> bi.aa01.text.toString()
            else -> "-1"
        }

        form.hh0201 = when {
            bi.hh0201.text.toString().trim().isNotEmpty() -> bi.hh0201.text.toString()
            else -> "-1"
        }

        /* form.setHh0202(bi.hh0202.getText().toString())
         form.setHh03(bi.hh03.getText().toString())

         form.setHh04(bi.hh04.getText().toString())*/

        form.hh05 = bi.hh05.selectedItem.toString()

        form.hh06 = bi.hh06.selectedItem.toString()



        form.hh07 = when {
            bi.hh07.text.toString().trim().isNotEmpty() -> bi.hh07.text.toString()
            else -> "-1"
        }

        form.hh08 = when {
            bi.hh08.text.toString().trim().isNotEmpty() -> bi.hh08.text.toString()
            else -> "-1"
        }

        form.hh09 = when {
            bi.hh09.text.toString().trim().isNotEmpty() -> bi.hh09.text.toString()
            else -> "-1"
        }

        form.hh10 = when {
            bi.hh10.text.toString().trim().isNotEmpty() -> bi.hh10.text.toString()
            else -> "-1"
        }

        form.hh11 = when {
            bi.hh1101.isChecked -> "1"
            bi.hh1102.isChecked -> "2"
            else -> "-1"
        }

        form.hh12 = when {
            bi.hh12.text.toString().trim().isNotEmpty() -> bi.hh12.text.toString()
            else -> "-1"
        }

        form.hh13 = when {
            bi.hh13.text.toString().trim().isNotEmpty() -> bi.hh13.text.toString()
            else -> "-1"
        }

        form.hh14 = when {
            bi.hh1401.isChecked -> "1"
            bi.hh1402.isChecked -> "2"
            else -> "-1"
        }


        /*Removal Instructed by Chaudary Sahab - 25Jan2021*/
        /* form.setHh15(when {
             bi.hh1501.isChecked -> "1"
             bi.hh1502.isChecked -> "2"
             bi.hh1503.isChecked -> "3"
             bi.hh1504.isChecked -> "4"
             bi.hh1505.isChecked -> "5"
             else -> "-1"
         })*/

        form.hh16 = when {
            bi.hh16.text.toString().trim().isNotEmpty() -> bi.hh16.text.toString()
            else -> "-1"
        }

        form.hh17 = when {
            bi.hh1701.isChecked -> "1"
            bi.hh1702.isChecked -> "2"
            bi.hh1703.isChecked -> "3"
            bi.hh1704.isChecked -> "4"
            bi.hh1705.isChecked -> "5"
            bi.hh1706.isChecked -> "6"
            bi.hh1707.isChecked -> "7"
            bi.hh1708.isChecked -> "8"
            bi.hh1709.isChecked -> "9"
            bi.hh1710.isChecked -> "10"
            bi.hh1711.isChecked -> "11"
            bi.hh1712.isChecked -> "12"
            bi.hh1713.isChecked -> "13"
            bi.hh1796.isChecked -> "96"
            else -> "-1"
        }

        form.hh1796x = when {
            bi.hh1796x.text.toString().trim().isNotEmpty() -> bi.hh1796x.text.toString()
            else -> "-1"
        }

        form.hh18 = when {
            bi.hh1801.isChecked -> "1"
            bi.hh1802.isChecked -> "2"
            else -> "-1"
        }

        form.hh19 = when {
            bi.hh19.text.toString().trim().isNotEmpty() -> bi.hh19.text.toString()
            else -> "-1"
        }

        form.hh20 = when {
            bi.hh2001.isChecked -> "1"
            bi.hh2002.isChecked -> "2"
            bi.hh2003.isChecked -> "3"
            bi.hh2004.isChecked -> "4"
            bi.hh2005.isChecked -> "5"
            bi.hh2006.isChecked -> "6"
            bi.hh2007.isChecked -> "7"
            bi.hh2008.isChecked -> "8"
            bi.hh2009.isChecked -> "9"
            bi.hh2010.isChecked -> "10"
            bi.hh2011.isChecked -> "11"
            bi.hh2012.isChecked -> "12"
            bi.hh2013.isChecked -> "13"
            bi.hh2096.isChecked -> "96"
            else -> "-1"
        }

        form.hh2096x = when {
            bi.hh2096x.text.toString().trim().isNotEmpty() -> bi.hh2096x.text.toString()
            else -> "-1"
        }

        form.hh21 = when {
            bi.hh21.text.toString().trim().isNotEmpty() -> bi.hh21.text.toString()
            else -> "-1"
        }

        form.hh22 = when {
            bi.hh22.text.toString().trim().isNotEmpty() -> bi.hh22.text.toString()
            else -> "-1"
        }

        form.hh23 = when {
            bi.hh23.text.toString().trim().isNotEmpty() -> bi.hh23.text.toString()
            else -> "-1"
        }

        form.hh24 = when {
            bi.hh24.text.toString().trim().isNotEmpty() -> bi.hh24.text.toString()
            else -> "-1"
        }

        form.hh25 = when {
            bi.hh25.text.toString().trim().isNotEmpty() -> bi.hh25.text.toString()
            else -> "-1"
        }

        form.hh25a = when {
            bi.hh25a01.isChecked -> "1"
            bi.hh25a02.isChecked -> "2"
            else -> "-1"
        }


    }

}
package edu.aku.hassannaqvi.naunehal.ui.sections

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
import edu.aku.hassannaqvi.naunehal.core.MainApp
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper
import edu.aku.hassannaqvi.naunehal.databinding.ActivityIdentificationSectionBinding
import edu.aku.hassannaqvi.naunehal.models.Form
import edu.aku.hassannaqvi.naunehal.utils.convertStringToUpperCase
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivity
import edu.aku.hassannaqvi.naunehal.utils.extension.obtainViewModel
import edu.aku.hassannaqvi.naunehal.utils.shortStringLength
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*





class IdentificationSectionActivity : AppCompatActivity() {
    lateinit var bi: ActivityIdentificationSectionBinding
    lateinit var viewModel: H1ViewModel
    var district = mutableListOf("....")
    var districtCode = mutableListOf<String>()
    var uc = mutableListOf("....")
    var ucCode = mutableListOf<String>()
    lateinit var districtAdapter: ArrayAdapter<String>
    lateinit var ucAdapter: ArrayAdapter<String>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_identification_section)

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
                            Toast.makeText(this@IdentificationSectionActivity, "Please sync data first", Toast.LENGTH_LONG).show()
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
                        Toast.makeText(this@IdentificationSectionActivity, "Village not found!", Toast.LENGTH_LONG).show()
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
        viewModel.formResponse.observe(this, {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        lifecycleScope.launch {
                            bi.fldGrpcheck.visibility = View.VISIBLE
                            bi.hh09.isEnabled = false
                            bi.checkHH.visibility = View.GONE
                            bi.progressBL.visibility = View.GONE
                            MainApp.form = it.data as Form
                            MainApp.form.isExist = true
                            bi.hhHEad.text = "Respondent: ${MainApp.form.hh12.convertStringToUpperCase().shortStringLength()}"
                        }
                    }
                    ResponseStatus.ERROR -> {
                        Toast.makeText(this@IdentificationSectionActivity, "BL Random not found!", Toast.LENGTH_LONG).show()
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
        setupSkips()
    }

    private fun setupSkips() {

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
                //      Toast.makeText(SectionHHActivity.this, charSequence+" i="+i+" i1="+i1+" i2="+i2, Toast.LENGTH_LONG).show();
                if (i == 1 && i1 == 0 && i2 == 1) {
                    bi.hh09.setText(bi.hh09.text.toString().plus("-"))
                }
                if (i == 6 && i1 == 0 && i2 == 1) {
                    bi.hh09.setText(bi.hh09.text.toString().plus("-"))
                }
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
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
    }

    fun childList(view: View) {
        gotoActivity(SelectedChildrenListActivity::class.java)
    }

    fun checkHHExist(view: View) {
        Clear.clearAllFields(bi.fldGrpcheck)
        if (!formValidation()) return
        bi.checkHH.visibility = View.GONE
        viewModel.getFormDataFromDB(
                districtCode[bi.hh05.selectedItemPosition - 1],
                bi.hh08.text.toString(),
                bi.hh09.text.toString()
        )
    }

    private fun formValidation() = Validator.emptyCheckingContainer(this, bi.GrpName)

}
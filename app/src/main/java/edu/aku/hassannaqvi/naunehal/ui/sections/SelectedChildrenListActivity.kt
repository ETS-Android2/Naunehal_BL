package edu.aku.hassannaqvi.naunehal.ui.sections

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.kennyc.view.MultiStateView
import com.leinardi.android.speeddial.SpeedDialActionItem
import edu.aku.hassannaqvi.naunehal.CONSTANTS
import edu.aku.hassannaqvi.naunehal.R
import edu.aku.hassannaqvi.naunehal.adapters.SelectedChildListAdapter
import edu.aku.hassannaqvi.naunehal.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatus
import edu.aku.hassannaqvi.naunehal.base.viewmodel.SelectedChildrenListViewModel
import edu.aku.hassannaqvi.naunehal.core.MainApp
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper
import edu.aku.hassannaqvi.naunehal.databinding.ActivitySelectedChildrenListBinding
import edu.aku.hassannaqvi.naunehal.models.ChildInformation
import edu.aku.hassannaqvi.naunehal.ui.EndingActivity
import edu.aku.hassannaqvi.naunehal.utils.WarningActivityInterface
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivity
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivityWithSerializable
import edu.aku.hassannaqvi.naunehal.utils.extension.obtainViewModel
import edu.aku.hassannaqvi.naunehal.utils.openSectionEndingActivity
import edu.aku.hassannaqvi.naunehal.utils.openWarningActivity
import org.apache.commons.lang3.StringUtils
import java.util.*

class SelectedChildrenListActivity : AppCompatActivity(), WarningActivityInterface {

    lateinit var adapter: SelectedChildListAdapter
    lateinit var bi: ActivitySelectedChildrenListBinding

    /*
    * Using old approach to visible viewmodel in all sub classes
    * Serial no increment on every new entry
    * */
    companion object {
        lateinit var viewModel: SelectedChildrenListViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_selected_children_list)
        viewModel = obtainViewModel(SelectedChildrenListViewModel::class.java, GeneralRepository(DatabaseHelper(this)))
        callingRecyclerView()

        /*
        * Nested Toolbar
        * */
        bi.toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.black))
        bi.toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.black))


        /*
        * Setting Floating button functionality
        * */
        val actionItems = mutableListOf<SpeedDialActionItem>(
                SpeedDialActionItem.Builder(R.id.fab_exit, R.drawable.ic_exit).setLabel("Force exit").create(),
                SpeedDialActionItem.Builder(R.id.fab_finish, R.drawable.ic_finish).setLabel("Next Section").create()
        )
        bi.speedDial.addAllActionItems(actionItems)
        bi.speedDial.setOnActionSelectedListener { actionItem ->
            when (actionItem.id) {
                R.id.fab_finish -> {
                    if (adapter.childItems.filter { it.childTableDataExist != null }.size != adapter.childItems.filter { it.isMotherAvailable }.size) {
                        Snackbar.make(findViewById(android.R.id.content), "Please update all children's for proceeding to the next section", Snackbar.LENGTH_LONG)
                                .show()
                        return@setOnActionSelectedListener false
                    }
                    if (MainApp.form.se2201 == StringUtils.EMPTY) {
                        openWarningActivity(
                                id = 1,
                                title = "WARNING!",
                                message = "Household Information Section not filled.\n Are you sure, you want to exit this interview?",
                                btnYesTxt = "YES", btnNoTxt = "RE-THINK")
                        return@setOnActionSelectedListener false
                    }
                    openWarningActivity(
                            id = 3,
                            title = "CONFIRMATION!",
                            message = "Are you sure, you want to exit this interview?",
                            btnYesTxt = "YES", btnNoTxt = "NO")

                }
                R.id.fab_exit -> {
                    openSectionEndingActivity()
                    return@setOnActionSelectedListener true // false will close it without animation
                }
            }
            false
        }


        /*
        * Fetch child list
        * */
        bi.multiStateView.viewState = MultiStateView.ViewState.EMPTY
        viewModel.childResponse.observe(this, {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        adapter.childItems = it.data as ArrayList<ChildInformation>
                        bi.multiStateView.viewState = MultiStateView.ViewState.CONTENT
                    }
                    ResponseStatus.ERROR -> {
                        bi.multiStateView.viewState = MultiStateView.ViewState.EMPTY
                    }
                    ResponseStatus.LOADING -> {
                        bi.multiStateView.viewState = MultiStateView.ViewState.LOADING
                    }
                }
            }
        })

    }

    /*
    * Callback call after pressing Child item in recyclerview
    * */
    override fun callWarningActivity(id: Int, item: Any?) {
        when (id) {
            1 -> {
                finish()
                gotoActivity(EndingActivity::class.java)
            }
            2 -> {
                val information = item as ChildInformation
                gotoActivityWithSerializable(Section03CSActivity::class.java, CONSTANTS.CHILD_DATA_UNDER5, information)
            }
            3 -> {
                finish()
                gotoActivityWithSerializable(EndingActivity::class.java, "complete", true)
            }

        }
    }


    /*
    * Initialize recyclerView with onClickListener
    * */
    private fun callingRecyclerView() {
        adapter = SelectedChildListAdapter(object : SelectedChildListAdapter.OnItemClickListener {
            override fun onItemClick(item: ChildInformation, position: Int) {
                openWarningActivity(
                        id = 2,
                        title = "CONFIRMATION!",
                        message = "Are you sure, you want to continue ${item.cb02.toUpperCase(Locale.ENGLISH)} interview?",
                        item = item)
            }
        })
        bi.childList.adapter = adapter
    }

    /*
    * Get childList on resume event
    * */
    override fun onResume() {
        super.onResume()

        viewModel.getChildDataFromDB(MainApp.form.cluster, MainApp.form.hhno, MainApp.form.uid)
    }

    /*
    * SE section clicked
    * */
    fun seSectionClick(view: View) {
        gotoActivity(Section081SEActivity::class.java)
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext, "You Can't go back", Toast.LENGTH_LONG).show()
    }
}
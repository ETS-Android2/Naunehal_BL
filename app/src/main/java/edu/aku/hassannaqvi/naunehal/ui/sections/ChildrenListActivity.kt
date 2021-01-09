package edu.aku.hassannaqvi.naunehal.ui.sections

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.kennyc.view.MultiStateView
import com.leinardi.android.speeddial.SpeedDialActionItem
import edu.aku.hassannaqvi.naunehal.R
import edu.aku.hassannaqvi.naunehal.adapters.ChildListAdapter
import edu.aku.hassannaqvi.naunehal.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatus
import edu.aku.hassannaqvi.naunehal.base.viewmodel.ChildListViewModel
import edu.aku.hassannaqvi.naunehal.core.MainApp
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper
import edu.aku.hassannaqvi.naunehal.databinding.ActivityChildrenListBinding
import edu.aku.hassannaqvi.naunehal.models.ChildInformation
import edu.aku.hassannaqvi.naunehal.utils.WarningActivityInterface
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivity
import edu.aku.hassannaqvi.naunehal.utils.extension.obtainViewModel
import edu.aku.hassannaqvi.naunehal.utils.openSectionEndingActivity
import edu.aku.hassannaqvi.naunehal.utils.openWarningActivity
import java.util.*

class ChildrenListActivity : AppCompatActivity(), WarningActivityInterface {

    lateinit var adapter: ChildListAdapter
    lateinit var bi: ActivityChildrenListBinding

    companion object {
        lateinit var viewModel: ChildListViewModel
        var serial = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_children_list)
        viewModel = obtainViewModel(ChildListViewModel::class.java, GeneralRepository(DatabaseHelper(this)))
        callingRecyclerView()

        /*
        * Nested Toolbar
        * */
        bi.toolbarLayout.title = "Children List (${MainApp.form.cluster} -> ${MainApp.form.hhno})"
        bi.toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.black))
        bi.toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.black))


        /*
        * Setting Floating button functionality
        * */
        val actionItems = mutableListOf<SpeedDialActionItem>(
                SpeedDialActionItem.Builder(R.id.fab_add, R.drawable.ic_finish).setLabel("Add Children").create(),
                SpeedDialActionItem.Builder(R.id.fab_finish, R.drawable.ic_finish).setLabel("Finish").create(),
                SpeedDialActionItem.Builder(R.id.fab_exit, R.drawable.ic_exit).setLabel("Force exit").create()
        )
        bi.speedDial.addAllActionItems(actionItems)
        bi.speedDial.setOnActionSelectedListener { actionItem ->
            when (actionItem.id) {
                R.id.fab_add -> {
                    MainApp.childInformation = ChildInformation(serial.toString())
                    gotoActivity(Section02CBActivity::class.java)
                }
                R.id.fab_finish -> {
                    if (serial == 1) {
                        Snackbar.make(findViewById(android.R.id.content), "Please add children's for proceeding to the next section", Snackbar.LENGTH_LONG)
                                .show()
                        return@setOnActionSelectedListener false
                    }
//                    val flag = adapter.mList.find { item -> item.memFlag == 3 }
//                    finish()
//                    startActivity(Intent(this, EndingActivity::class.java).putExtra("complete", flag == null).putExtra(CONSTANTS.NOT_IN_HOME_END, flag != null))
//                    return@OnActionSelectedListener true // false will close it without animation
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

    override fun callWarningActivity(item: Any?) {
        MainApp.childInformation = item as ChildInformation
        gotoActivity(Section02CBActivity::class.java)
    }

    /*
    * Initialize recyclerView with onClickListener
    * */
    private fun callingRecyclerView() {
        adapter = ChildListAdapter(object : ChildListAdapter.OnItemClickListener {
            override fun onItemClick(item: ChildInformation, position: Int) {
                openWarningActivity(
                        title = "CONFIRMATION!",
                        message = "Are you sure, you want to edit ${item.cb02.toUpperCase(Locale.ENGLISH)} interview?",
                        data = item)
            }

            override fun onButtonItemClick(item: ChildInformation, flag: Boolean) {
                MainApp.childInformation = ChildInformation(serial.toString(), flag)
                gotoActivity(Section02CBActivity::class.java)
            }
        })
        bi.childList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        viewModel.getChildDataFromDB(MainApp.form.cluster, MainApp.form.hhno, MainApp.form.uid)
    }
}
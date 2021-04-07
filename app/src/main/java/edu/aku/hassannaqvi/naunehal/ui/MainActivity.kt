package edu.aku.hassannaqvi.naunehal.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import edu.aku.hassannaqvi.naunehal.CONSTANTS
import edu.aku.hassannaqvi.naunehal.R
import edu.aku.hassannaqvi.naunehal.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatus
import edu.aku.hassannaqvi.naunehal.base.viewmodel.MainViewModel
import edu.aku.hassannaqvi.naunehal.core.MainApp
import edu.aku.hassannaqvi.naunehal.database.AndroidDatabaseManager
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper
import edu.aku.hassannaqvi.naunehal.databinding.ActivityMainBinding
import edu.aku.hassannaqvi.naunehal.models.Camps
import edu.aku.hassannaqvi.naunehal.ui.list_activity.FormsReportCluster
import edu.aku.hassannaqvi.naunehal.ui.list_activity.FormsReportDate
import edu.aku.hassannaqvi.naunehal.ui.login_activity.LoginActivity
import edu.aku.hassannaqvi.naunehal.ui.sections.SectionMobileHealth
import edu.aku.hassannaqvi.naunehal.utils.extension.*
import edu.aku.hassannaqvi.naunehal.utils.extension.gotoActivityWithSerializable
import edu.aku.hassannaqvi.naunehal.utils.isNetworkConnected
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var bi: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private var exit = false
    private var sysdateToday = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Date())
    private lateinit var camp: Camps

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        if (MainApp.admin) bi.adminSection.visibility = View.VISIBLE
        viewModel = obtainViewModel(MainViewModel::class.java, GeneralRepository(DatabaseHelper(this)))


        /*
        * Calling viewmodel district data function
        * Fetch district result response
        * */
        viewModel.campsResponse.observe(this) {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        lifecycleScope.launch {
                            it.data?.let { item ->
                                bi.btnSection.visibility = View.VISIBLE
                                camp = item
                            }

                            bi.btnCheckCamp.visibility = View.VISIBLE
                        }
                    }
                    ResponseStatus.ERROR -> {
                        bi.btnCheckCamp.visibility = View.VISIBLE
                    }
                    ResponseStatus.LOADING -> {
                        lifecycleScope.launch {
                            bi.btnCheckCamp.visibility = View.GONE
                            bi.btnSection.visibility = View.GONE
                            delay(2000)
                        }
                    }
                }
            }
        }

        /*
        * Get Today's form from DB
        * If it's null then return 0 otherwise return count
        * Show loading while data is fetching
        * */
        viewModel.todayForms.observe(this) {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    Log.d("Today's form count:", it.data.toString())
                    bi.statisticLayout.tf.text = it.data.toString()
                }
                ResponseStatus.ERROR -> {
                }
                ResponseStatus.LOADING -> {
                    lifecycleScope.launch { delay(1000) }
                }
            }
        }

        /*
        * Get Form status from DB
        * If it's null then return 0 otherwise return count
        * Show loading while data is fetching
        * */
        viewModel.formsStatus.observe(this) {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    it.data?.let { item ->
                        Log.d("Complete count:", item.closedForms.toString())
                        Log.d("In-complete count:", item.openedForms.toString())
                        bi.statisticLayout.cf.text = String.format("%02d", item.closedForms)
                        bi.statisticLayout.icf.text = String.format("%02d", item.openedForms)
                    }

                }
                ResponseStatus.ERROR -> {
                    animateFadeOut()
                    Log.d("Status", "error")
                }
                ResponseStatus.LOADING -> {
                    lifecycleScope.launch { delay(1000) }
                }
            }
        }

        /*
        * Get Upload & Download status of form from DB
        * If it's null then return 0 otherwise return count
        * Show loading while data is fetching
        * */
        viewModel.uploadForms.observe(this) {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    it.data?.let { item ->
                        Log.d("Synced count:", item.closedForms.toString())
                        Log.d("Un-Synced count:", item.openedForms.toString())
                        bi.statisticLayout.sf.text = item.closedForms.toString()
                        bi.statisticLayout.usf.text = item.openedForms.toString()
                    }
                    animateFadeOut()
                }
                ResponseStatus.ERROR -> {
                    animateFadeOut()
                    Log.d("Sync", "error")
                }
                ResponseStatus.LOADING -> {
                    lifecycleScope.launch { delay(2000) }
                }
            }
        }

    }

    /*
    * Back press button that will route to login activity after pressing -
    * back button two times
    * */
    override fun onBackPressed() {
        if (exit) {
            gotoActivityWithNoHistory(LoginActivity::class.java)
        } else {
            Toast.makeText(this, "Press back again to exit",
                    Toast.LENGTH_SHORT).show()
            exit = true
            Handler(Looper.getMainLooper()).postDelayed({ exit = false }, 3000)
        }
    }

    /*
    * Inflate menu on current activity
    * */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    /*
    * Menu items selection
    * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_data_sync -> {
                if (isNetworkConnected(this)) {
                    gotoActivity(SyncActivity::class.java)

                } else
                    Toast.makeText(this, "Network connection not available!", Toast.LENGTH_SHORT).show()

                return true
            }
            R.id.formsReportDate -> {
                gotoActivity(FormsReportDate::class.java)
                return true
            }

            R.id.formsReportCluster -> {
                gotoActivity(FormsReportCluster::class.java)
                return true
            }
            R.id.action_database -> {
                gotoActivity(AndroidDatabaseManager::class.java)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        animateFadeIn()
        viewModel.getFormsStatusUploadStatus(sysdateToday)
    }


    /*
    * Route to specific activity according to selection
    * For uploading/downloading data, the network needs to work
    * */
    fun openSpecificActivity(v: View) {
        when (v.id) {
            R.id.formA -> {
                gotoActivityWithParcelable(SectionMobileHealth::class.java, CONSTANTS.CAMP_DATA, camp)
            }
            R.id.databaseBtn -> startActivity(Intent(this, AndroidDatabaseManager::class.java))
            R.id.btn_check_camp -> {
                viewModel.getCampFromDB(bi.camps.text.toString())
            }
        }
    }


    /*
    * Stop animation on statistic Layout
    * */
    private fun animateFadeOut() {
        val shortAnimationDuration = 2000
        /*
        * Animate the content view to 100% opacity, and clear any animation
        * listener set on the view.
        * */
        bi.statisticLayout.syncLinearLayout.animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)
        bi.statisticLayout.statusLinearLayout.animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)

        /* 
        * Animate the loading view to 0% opacity. After the animation ends, 
        * set its visibility to GONE as an optimization step (it won't participate 
        * in layout passes, etc.)
        * */
        bi.statisticLayout.loading.animate()
                .alpha(0f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        bi.statisticLayout.loading.visibility = View.GONE
                    }
                })
    }

    /*
    * Start animation on statistic Layout
    * */
    private fun animateFadeIn() {
        bi.statisticLayout.syncLinearLayout.alpha = 0f
        bi.statisticLayout.statusLinearLayout.alpha = 0f
        bi.statisticLayout.loading.alpha = 1f
        bi.statisticLayout.loading.visibility = View.VISIBLE
    }


}
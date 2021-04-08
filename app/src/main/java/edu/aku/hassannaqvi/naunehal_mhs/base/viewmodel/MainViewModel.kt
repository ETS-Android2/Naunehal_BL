package edu.aku.hassannaqvi.naunehal_mhs.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.naunehal_mhs.models.FormIndicatorsModel
import edu.aku.hassannaqvi.naunehal_mhs.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal_mhs.base.repository.ResponseStatusCallbacks
import edu.aku.hassannaqvi.naunehal_mhs.models.Camps
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(val repository: GeneralRepository) : ViewModel() {

    /*
    * Today's form
    * */
    private var _tf: MutableLiveData<ResponseStatusCallbacks<Int>> = MutableLiveData()
    val todayForms: MutableLiveData<ResponseStatusCallbacks<Int>>
        get() = _tf

    /*
    * Unsynced and Synced Forms as upload forms
    * */
    private var _uf: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>> = MutableLiveData()
    val uploadForms: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>>
        get() = _uf

    /*
    * Complete and Incomplete forms as status forms
    * */
    private var _fs: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>> = MutableLiveData()
    val formsStatus: MutableLiveData<ResponseStatusCallbacks<FormIndicatorsModel>>
        get() = _fs


    /*
    * Get districts from DB
    * */
    private val _campsResponse: MutableLiveData<ResponseStatusCallbacks<Camps>> = MutableLiveData()
    val campsResponse: MutableLiveData<ResponseStatusCallbacks<Camps>>
        get() = _campsResponse


    fun getFormsStatusUploadStatus(date: String) {
        _uf.value = ResponseStatusCallbacks.loading(null)
        _fs.value = ResponseStatusCallbacks.loading(null)
        _tf.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            launch {
                try {
                    repository.getFormsByDate(date).collect { item ->
                        _tf.value = ResponseStatusCallbacks.success(data = item.size, message = "Forms exist")
                    }
                } catch (e: Exception) {
                    _tf.value = ResponseStatusCallbacks.error(null, e.message.toString())
                }
            }
            launch {
                try {
                    repository.getUploadStatus().collect { item ->
                        _uf.value = ResponseStatusCallbacks.success(data = item, message = "Upload status exist")
                    }
                } catch (e: Exception) {
                    _fs.value = ResponseStatusCallbacks.error(null, e.message.toString())
                }
            }
            launch {
                try {
                    repository.getFormStatus(date).collect { fstatus ->
                        _fs.value = ResponseStatusCallbacks.success(data = fstatus, message = "Form status exist")
                    }
                } catch (e: Exception) {
                    _fs.value = ResponseStatusCallbacks.error(null, e.message.toString())
                }
            }
        }
    }

    fun getCampFromDB(campNo: String) {
        _campsResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                delay(1000)
                val camp = repository.getCampsFromDB(campNo)
                _campsResponse.value = ResponseStatusCallbacks.success(data = camp)
            } catch (e: Exception) {
                _campsResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = e.message.toString())
            }

        }

    }

    init {
        /*getDistrictFromDB()
        getTodayForms(sysdateToday)
        getUploadFormsStatus()
        getFormsStatus(sysdateToday)*/
    }

}
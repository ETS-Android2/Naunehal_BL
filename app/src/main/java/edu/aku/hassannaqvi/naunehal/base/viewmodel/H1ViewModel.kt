package edu.aku.hassannaqvi.naunehal.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.naunehal.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatusCallbacks
import edu.aku.hassannaqvi.naunehal.models.BLRandom
import edu.aku.hassannaqvi.naunehal.models.Districts
import edu.aku.hassannaqvi.naunehal.models.Form
import edu.aku.hassannaqvi.naunehal.models.UCs
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class H1ViewModel(internal val repository: GeneralRepository) : ViewModel() {

    private val _districtResponse: MutableLiveData<ResponseStatusCallbacks<List<Districts>>> = MutableLiveData()
    val districtResponse: MutableLiveData<ResponseStatusCallbacks<List<Districts>>>
        get() = _districtResponse

    private val _ucResponse: MutableLiveData<ResponseStatusCallbacks<List<UCs>>> = MutableLiveData()
    val ucResponse: MutableLiveData<ResponseStatusCallbacks<List<UCs>>>
        get() = _ucResponse

    private val _blResponse: MutableLiveData<ResponseStatusCallbacks<BLRandom>> = MutableLiveData()
    val blResponse: MutableLiveData<ResponseStatusCallbacks<BLRandom>>
        get() = _blResponse

    private val _formResponse: MutableLiveData<ResponseStatusCallbacks<Form>> = MutableLiveData()
    val formResponse: MutableLiveData<ResponseStatusCallbacks<Form>>
        get() = _formResponse

    init {
        getDistrictFromDB()
    }

    private fun getDistrictFromDB() {
        _districtResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                val district = repository.getDistrictsFromDB()
                _districtResponse.value = if (district.size > 0) {
                    ResponseStatusCallbacks.success(data = district, message = "District item found")
                } else
                    ResponseStatusCallbacks.error(data = null, message = "No district found!")
            } catch (e: Exception) {
                _districtResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = e.message.toString())
            }

        }

    }

    fun getUCsDistrictFromDB(dCode: String) {
        _ucResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                val uc = repository.getUcsByDistrictsFromDB(dCode)
                _ucResponse.value = if (uc.size > 0) {
                    ResponseStatusCallbacks.success(data = uc, message = "UC item found")
                } else
                    ResponseStatusCallbacks.error(data = null, message = "No uc found!")
            } catch (e: Exception) {
                _ucResponse.value =
                        ResponseStatusCallbacks.error(data = null, message = e.message.toString())
            }

        }

    }

    fun getBLRandomDataFromDB(distCode: String, cluster: String, hhno: String) {
        _blResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                delay(1000)
                /*val hh = repository.getFormByDistrictsFromDB(distCode, cluster, hhno)
                if (hh != null){
                    _blResponse.value = ResponseStatusCallbacks.error(null, "BlRandom data not found!")
                    return@launch
                }*/
                val bl = repository.getBLByDistrictsFromDB(distCode, cluster, hhno)
                _blResponse.value = ResponseStatusCallbacks.success(data = bl, message = "BLRandom data found")
            } catch (e: Exception) {
                _blResponse.value = ResponseStatusCallbacks.error(null, "BlRandom data not found!")
            }
        }
    }

    fun getFormDataFromDB(distCode: String, cluster: String, hhno: String) {
        _formResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                val hl = repository.getFormByDistrictsFromDB(distCode, cluster, hhno)
                _formResponse.value = ResponseStatusCallbacks.success(data = hl, message = "Form data found")
            } catch (e: Exception) {
                _formResponse.value = ResponseStatusCallbacks.error(null, "Form data not found!")
            }
        }
    }
}
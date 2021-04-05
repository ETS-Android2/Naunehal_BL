package edu.aku.hassannaqvi.naunehal

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatus
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatusCallbacks
import java.lang.Exception
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@Suppress("UNCHECKED_CAST")
fun <T> LiveData<ResponseStatusCallbacks<T>>.getLiveDataValue(): ResponseStatusCallbacks<T> {
    var dt: ResponseStatusCallbacks<T>? = null
    val latch = CountDownLatch(1)

    val observer = object : Observer<ResponseStatusCallbacks<T>> {
        override fun onChanged(t: ResponseStatusCallbacks<T>?) {
            dt = t as ResponseStatusCallbacks<T>
            when (dt!!.status) {
                ResponseStatus.SUCCESS -> {
                    this@getLiveDataValue.removeObserver(this)
                    latch.countDown()
                }
                ResponseStatus.ERROR -> {
                    this@getLiveDataValue.removeObserver(this)
                    latch.countDown()
                }
                ResponseStatus.LOADING -> {
                }
            }
        }
    }
    this.observeForever(observer)

    try {
        if (!latch.await(2, TimeUnit.SECONDS))
            throw TimeoutException("No data received from live data")
    } catch (ex: Exception) {
        this.removeObserver(observer)
    }

    return dt as ResponseStatusCallbacks<T>
}
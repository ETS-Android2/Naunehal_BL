package edu.aku.hassannaqvi.naunehal_mhs.base.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.aku.hassannaqvi.naunehal_mhs.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal_mhs.base.viewmodel.*

/*
* @author Ali Azaz Alam dt. 01.07.21
* */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: GeneralRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository) as T
            modelClass.isAssignableFrom(ChildListViewModel::class.java) -> ChildListViewModel(repository) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository) as T
            modelClass.isAssignableFrom(SelectedChildrenListViewModel::class.java) -> SelectedChildrenListViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown viewModel class $modelClass")
        }
    }

}
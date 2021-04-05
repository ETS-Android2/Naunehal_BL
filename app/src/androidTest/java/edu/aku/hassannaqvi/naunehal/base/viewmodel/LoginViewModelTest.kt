package edu.aku.hassannaqvi.naunehal.base.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import edu.aku.hassannaqvi.naunehal.base.repository.GeneralRepository
import edu.aku.hassannaqvi.naunehal.base.repository.ResponseStatusCallbacks
import edu.aku.hassannaqvi.naunehal.base.usecase.LoginUsecase
import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper
import edu.aku.hassannaqvi.naunehal.getLiveDataValue
import edu.aku.hassannaqvi.naunehal.models.Users
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import io.mockk.*
import io.mockk.impl.annotations.MockK

@RunWith(AndroidJUnit4::class)
class LoginViewModelTest : TestCase() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var repo: GeneralRepository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var loginUsecase: LoginUsecase

    @Before
    public override fun setUp() {
        super.setUp()
        MockKAnnotations.init(this)
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = DatabaseHelper(context)
        repo = GeneralRepository(db)
    }

    @Test
    fun check_login_information_exist_or_not() = runBlocking {
        val uiObserver = mockk<Observer<ResponseStatusCallbacks<Users>>>(relaxed = true)

        coEvery { loginUsecase.invoke(any(), any()) }

        viewModel = LoginViewModel(loginUsecase)
//        viewModel.getLoginInfoFromDB("user0001", "user0001")
        //val result = viewModel.loginResponse.getLiveDataValue()
        //assert(result.data != null)
        viewModel.loginResponse.observeForever(uiObserver)

        // Then
        coVerify(exactly = 1) { loginUsecase.invoke("user0001", "user0001") }
        verify { uiObserver.onChanged(match { true }) }
    }


}
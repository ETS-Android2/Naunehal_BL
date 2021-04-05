package edu.aku.hassannaqvi.naunehal.base.usecase

import edu.aku.hassannaqvi.naunehal.base.repository.GeneralRepository

class LoginUsecase(val repository: GeneralRepository) {
    suspend operator fun invoke(
            username: String, password: String
    ) = repository.getLoginInformation(
            username, password
    )
}
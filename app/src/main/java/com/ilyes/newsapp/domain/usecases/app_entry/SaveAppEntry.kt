package com.ilyes.newsapp.domain.usecases.app_entry

import com.ilyes.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()

    }
}
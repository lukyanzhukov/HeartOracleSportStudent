package com.heartoracle.sport.student.feature.splash

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import com.heartoracle.sport.student.feature.service.MainService
import com.heartoracle.sport.student.feature.settings.presentation.SettingsActivity

class SplashActivity : AppCompatActivity() {
    @TargetApi(Build.VERSION_CODES.O)
    override fun onPostResume() {
        super.onPostResume()
        startService(Intent(this, MainService::class.java))
        startActivity(Intent(this, SettingsActivity::class.java))
        finish()
    }
}
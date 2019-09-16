package com.heartoracle.sport.student.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.heartoracle.sport.student.feature.heartrate.presentation.HeartRateActivity
import com.heartoracle.sport.student.feature.settings.presentation.SettingsActivity

class SplashActivity : AppCompatActivity() {
    override fun onPostResume() {
        super.onPostResume()
        startActivity(Intent(this, SettingsActivity::class.java))
        finish()
    }
}
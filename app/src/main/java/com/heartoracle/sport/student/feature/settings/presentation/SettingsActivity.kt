package com.heartoracle.sport.student.feature.settings.presentation

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivitySettingsBinding
import com.heartoracle.sport.student.feature.settings.presentation.permission_dialog.PermissionDialog
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity :
    EventsActivity<ActivitySettingsBinding, SettingsViewModel, SettingsViewModel.EventsListener>(),
    SettingsViewModel.EventsListener {

    override fun getNumber(number: Int) {
        numberPicker.value = number
    }

    override val eventsListener: SettingsViewModel.EventsListener = this
    override val viewModelVariableId: Int = BR.viewModel
    @Inject
    override lateinit var viewModel: SettingsViewModel

    override val layoutId = R.layout.activity_settings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupPicker()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun requestPermissions() {
        Dexter.withActivity(this)
            .withPermissions(
                Manifest.permission.BODY_SENSORS,
                Manifest.permission.FOREGROUND_SERVICE,
                Manifest.permission.INTERNET
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    if (report.deniedPermissionResponses.isEmpty()) {
                        showPermissionDialog()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest>,
                    token: PermissionToken
                ) {
                    token.continuePermissionRequest()
                }
            }).withErrorListener {
                showPermissionDialog()
            }.check()
    }

    private fun setupPicker() {
        numberPicker.minValue = 1
        numberPicker.maxValue = 99
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            viewModel.setNumber(newVal)
        }
        numberPicker.setOnLongClickListener {
            Toast.makeText(applicationContext, SUCCESS_MESSAGE, Toast.LENGTH_SHORT).show()
            finish()
            true
        }
    }

    private fun showPermissionDialog() {
        PermissionDialog(this@SettingsActivity).show()
    }

    companion object {
        const val SUCCESS_MESSAGE = "Номер успешно выбран"
    }
}
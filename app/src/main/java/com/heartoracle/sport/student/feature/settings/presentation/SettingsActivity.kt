package com.heartoracle.sport.student.feature.settings.presentation

import android.os.Bundle
import android.widget.Toast
import com.heartoracle.sport.student.BR
import com.heartoracle.sport.student.R
import com.heartoracle.sport.student.core.presentation.activity.EventsActivity
import com.heartoracle.sport.student.databinding.ActivitySettingsBinding
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

    private fun setupPicker() {
        numberPicker.minValue = 1
        numberPicker.maxValue = 99
        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            viewModel.setNumber(newVal)
        }
        numberPicker.setOnLongClickListener {
            Toast.makeText(applicationContext, SUCCESS_MESSAGE, Toast.LENGTH_SHORT).show()
            finish()
            true
        }
    }

    companion object {
        const val SUCCESS_MESSAGE = "Номер успешно выбран"
    }
}
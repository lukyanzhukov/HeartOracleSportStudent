package com.heartoracle.sport.student.feature.settings.presentation.permission_dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.heartoracle.sport.student.R
import kotlinx.android.synthetic.main.dialog_permission.*
import android.net.Uri.fromParts
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.content.Intent


class PermissionDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        setContentView(R.layout.dialog_permission)
        onDialogClickListener()
    }

    private fun onDialogClickListener() {
        dialogPermission.setOnClickListener {
            val intent = Intent()
            intent.action = ACTION_APPLICATION_DETAILS_SETTINGS
            val uri = fromParts(PACKAGE_TEXT, context.packageName, null)
            intent.data = uri
            context.startActivity(intent)
            cancel()
        }
    }
    companion object {
        const val PACKAGE_TEXT = "package"
    }
}
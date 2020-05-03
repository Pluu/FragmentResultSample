package com.pluu.fragmentresult.sample.old.targetfragment

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class OldTargetStepDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setTitle("TargetFragment Sample")
            .setPositiveButton("Dismiss") { _, _ ->
                pendingData()
            }.create()
    }

    private fun pendingData() {
        val intent = Intent().apply {
            putExtras(bundleOf("sample" to "result"))
        }
        targetFragment?.onActivityResult(
            OldTargetStep1Fragment.sampleTargetRequestCode,
            Activity.RESULT_OK,
            intent
        )
        dismiss()
    }
}
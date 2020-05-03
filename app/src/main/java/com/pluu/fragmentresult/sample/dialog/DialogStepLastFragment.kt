package com.pluu.fragmentresult.sample.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

class DialogStepLastFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setTitle("DialogFragment Sample")
            .setPositiveButton("OK") { _, _ ->
                pendingData()
            }.create()
    }

    private fun pendingData() {
        setFragmentResult(
            requestKey, bundleOf(
                "key" to "Dialog  Sample"
            )
        )
        dismiss()
    }

    companion object {
        const val requestKey = "dialog"
    }
}
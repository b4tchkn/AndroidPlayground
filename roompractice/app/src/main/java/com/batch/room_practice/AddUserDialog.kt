package com.batch.room_practice

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AddUserDialog : DialogFragment() {

    private var addButton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_dialog_user_add_user, null)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("SMAP", "onCreateDialog")
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.layout_dialog_user_add_user, null))
            val dialog = builder.create()

            Log.d("SMAP", addButton.toString())
            addButton = dialog.findViewById(R.id.button_user_add_user)
            Log.d("SMAP", addButton.toString())

            return dialog
        } ?: throw IllegalStateException("Activity cannnot be null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("SMAP", "onViewCreated")
        Log.d("SMAP", addButton.toString())
    }
}
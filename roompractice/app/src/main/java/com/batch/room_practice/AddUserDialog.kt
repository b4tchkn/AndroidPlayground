package com.batch.room_practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class AddUserDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_dialog_user_add_user, null)
    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        return activity?.let {
//            val builder = AlertDialog.Builder(it)
//            val inflater = requireActivity().layoutInflater
//            builder.setView(inflater.inflate(R.layout.layout_dialog_user_add_user, null))
//                .setPositiveButton(R.string.add, DialogInterface.OnClickListener { dialog, id ->
//                    listener.onDialogAddClick(this)
//                })
////            builder.create().findViewById<Button>(R.id.button_user_add_user)?.setOnClickListener {}
//            builder.create()
//        } ?: throw IllegalStateException("Activity cannnot be null")
//    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        try {
//            listener = context as Listener
//        } catch (e: ClassCastException) {
//            throw ClassCastException((context.toString() + "must implement AddUserDialog"))
//        }
//    }
}
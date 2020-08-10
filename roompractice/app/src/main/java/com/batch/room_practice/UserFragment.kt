package com.batch.room_practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_add.setOnClickListener {
//            viewModel.insertUser(User(id = 0, name = "BATCa"))
            showDialog()
        }

        viewModel.users.observe(viewLifecycleOwner) {
            text_user.text = it.toString()
        }
    }

    private fun showDialog() {
        // 本当はこっちのやりかたでやりたいけどうまくDialogの中のViewにアクセスできない
//        val dialog = AddUserDialog()
//        dialog.show(childFragmentManager, "AddUserDialog")

        val view =
            requireActivity().layoutInflater.inflate(R.layout.layout_dialog_user_add_user, null)
        val userIdEditText = view.findViewById<EditText>(R.id.edit_text_user_user_id)
        val userNameEditText = view.findViewById<EditText>(R.id.edit_text_user_user_name)
        val addButton = view.findViewById<Button>(R.id.button_user_add_user)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(view)
            .create()
        addButton.setOnClickListener {
            dialog.dismiss()
            val userId = userIdEditText.text.toString().toInt()
            val userName = userNameEditText.text.toString()
            viewModel.insertUser(User(id = userId, name = userName))
        }
        dialog.show()
    }
}
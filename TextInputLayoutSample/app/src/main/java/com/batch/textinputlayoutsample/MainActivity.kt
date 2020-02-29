package com.batch.textinputlayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var message: String
            when(TextUtils.isEmpty(custom_edit_text.text)) {
                true -> {
                    message = "入力されていません"
                    custom_text_input.error = message
//                    custom_edit_text.error = message
                }
                false -> {
                    message = "入力されています"
                    custom_text_input.error = null
                }
            }
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
    }
}

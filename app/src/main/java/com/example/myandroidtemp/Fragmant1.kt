package com.example.myandroidtemp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.eclipsesource.json.Json
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException

class Fragmant1: Fragment() {
    private val uRL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=400040"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sarimaruButton.setOnClickListener { parallelGet() }
    }

    fun parallelGet() = GlobalScope.launch(Dispatchers.Main) {
        val textView = view?.findViewById<TextView>(R.id.sarimaruText)
        try {
            val http = HttpUtil()
            async(Dispatchers.Default) { http.httpGET1(uRL) }.await().let {
                val result = Json.parse(it).asObject()
                textView?.setText(result.get("description").asObject().get("text").asString())
            }
        } catch (e: IOException) {
            e.printStackTrace()
            textView?.setText("だめだった")
        }
    }
}
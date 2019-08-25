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

class Fragmant1: Fragment() {
    val uRL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=400040"
    var result = ""

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
        val http = HttpUtil()
        async(Dispatchers.Default) { http.httpGET1(uRL) }.await().let {
            val result = Json.parse(it).asObject()
            val textView = view?.findViewById<TextView>(R.id.sarimaruText)
            textView?.setText(result.get("description").asObject().get("text").asString())
        }
    }
}
package com.example.recyclerviewfilter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity(), TextWatcher {

    var recyclerView: RecyclerView? = null
    var editText: EditText? = null
    var adapter: RecyclerViewAdapter? = null

    var items = ArrayList<list>()
    var data = list()
    var data1 = list()
    var data2 = list()
    var data3 = list()
    var data4 = list()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recylcerview)
        editText = findViewById<EditText>(R.id.edittext)
        editText!!.addTextChangedListener(this)

        data.no = 1
        data.name = "박씨"
        data.friend = "교회친구"
        items.add(0, data)

        data1.no = 2
        data1.name = "김씨"
        data1.friend = "친한친구"

        items.add(1, data1)

        data2.no = 3
        data2.name = "이씨"
        data2.friend = "반친구"

        items.add(2, data2)

        data3.no = 4
        data3.name = "정씨"
        data3.friend = "학원친구"
        items.add(3, data3)

        data4.no = 5
        data4.name = "오씨"
        data4.friend = "친한친구"
        items.add(4, data4)

        adapter = RecyclerViewAdapter(this, items)
        recyclerView!!.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.adapter = adapter

        adapter!!.setItemClickListener(object : RecyclerViewAdapter.OnItemClickListener {

            override fun onClick(v: View, position: Int, data: ArrayList<list>) {
                val intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("position", adapter!!.getFilterList()[position].name)
                startActivity(intent)
                finish()
            }
        })
    }


    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
        adapter!!.filter!!.filter(charSequence)

    }

    override fun afterTextChanged(p0: Editable?) {

    }


}
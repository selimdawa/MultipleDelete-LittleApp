package com.littleapp.multipledelete.Activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.littleapp.multipledelete.Adapter.MultiDeleteAdapter
import com.littleapp.multipledelete.R
import com.littleapp.multipledelete.Unit.THEME
import com.littleapp.multipledelete.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    var arrayList = ArrayList<String>()
    var adapter: MultiDeleteAdapter? = null
    var activity: Activity? = null
    var context: Context = also { activity = it }

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(context)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        //Add values in array list
        arrayList.addAll(getResources().getStringArray(R.array.values))
        //Set layout manager
        binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        //Initialize adapter
        adapter = MultiDeleteAdapter(context, activity, arrayList, binding!!.tvEmpty)
        //Set adapter
        binding!!.recyclerView.adapter = adapter
    }
}
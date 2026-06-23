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

    private lateinit var binding: ActivityMainBinding
    var arrayList = ArrayList<String>()
    var adapter: MultiDeleteAdapter? = null
    var activity: Activity? = null
    var context: Context = also { activity = it }

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(context)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayList.addAll(resources.getStringArray(R.array.values))
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MultiDeleteAdapter(context, activity, arrayList, binding.tvEmpty)
        binding.recyclerView.adapter = adapter
    }
}
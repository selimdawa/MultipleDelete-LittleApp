package com.littleapp.multipledelete.Activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        arrayList.addAll(resources.getStringArray(R.array.values))
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MultiDeleteAdapter(context, activity, arrayList, binding.tvEmpty)
        binding.recyclerView.adapter = adapter
    }
}
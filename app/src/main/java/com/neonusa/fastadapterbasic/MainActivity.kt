package com.neonusa.fastadapterbasic

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.neonusa.fastadapterbasic.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // from string resource
    private val hadithList = ArrayList<HadithItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//         get data from strings resource.
        hadithList.addAll(listHadithLocale)
        Log.i("MainActivity", "onCreate: $hadithList")

        val itemAdapter = ItemAdapter<HadithItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)

        //set the items to your ItemAdapter
        itemAdapter.add(listHadithLocale)

        //set our adapters to the RecyclerView
        binding.rvMain.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.rvMain.adapter = fastAdapter

        fastAdapter.onClickListener = { view, adapter, item, position ->
            Toast.makeText(this, "the hadits is ${item.hadith.hadits}", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private val listHadithLocale: ArrayList<HadithItem>
        get() {
            val dataIndoTitle = resources.getStringArray(R.array.data_judul_indo)
            val dataArabicTitle = resources.getStringArray(R.array.data_judul_arab)

            val listHadith = ArrayList<HadithItem>()
            for (i in dataIndoTitle.indices) {
                val hadith = Hadith(dataIndoTitle[i],dataArabicTitle[i])
                val hadithItem = HadithItem(hadith)
                listHadith.add(hadithItem)
            }
            return listHadith
        }
}
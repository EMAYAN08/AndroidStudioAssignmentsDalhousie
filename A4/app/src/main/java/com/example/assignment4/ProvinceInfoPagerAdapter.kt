package com.example.assignment4

// ProvinceInfoPagerAdapter.kt
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.util.Log

class ProvinceInfoPagerAdapter(
    fragmentManager: FragmentManager,
    private val countryName: String
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // Define province info for each country
    private val provinceInfoMap: Map<String, List<String>> = mapOf(
        "canada" to listOf("Nova Scotia", "Ontrio", "Alberta"),
        "usa" to listOf("California", "Texas", "Virgina"),
        // Add more countries and their corresponding province info as needed
    )

    private val provinceInfoList: List<String> by lazy {
        provinceInfoMap[countryName] ?: emptyList()
    }

    override fun getCount(): Int {
        return provinceInfoList.size
    }

    override fun getItem(position: Int): Fragment {
        val provinceInfo = provinceInfoList[position]
        return ProvinceInfoFragment.newInstance(provinceInfo)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Set tab titles (optional)
        return "Info $position"
    }
}

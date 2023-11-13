package com.example.assignment4

// ProvinceInfoFragment.kt
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProvinceInfoFragment : Fragment() {

    private var provinceInfo: String? = null

    companion object {
        fun newInstance(provinceInfo: String): ProvinceInfoFragment {
            val fragment = ProvinceInfoFragment()
            val args = Bundle()
            args.putString("provinceInfo", provinceInfo)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            provinceInfo = it.getString("provinceInfo")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_province_info, container, false)

        val textViewProvinceInfo: TextView = view.findViewById(R.id.textViewProvinceInfo)
        textViewProvinceInfo.text = provinceInfo

        return view
    }
}

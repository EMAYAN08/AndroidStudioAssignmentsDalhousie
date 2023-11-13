package com.example.assignment4

// CityFragment.kt
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

class CityFragment : Fragment() {

    private var cityImageResId: Int = 0

    companion object {
        private const val ARG_CITY_IMAGE_RES_ID = "cityImageResId"

        fun newInstance(cityImageResId: Int): CityFragment {
            val fragment = CityFragment()
            val args = Bundle()
            args.putInt(ARG_CITY_IMAGE_RES_ID, cityImageResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityImageResId = it.getInt(ARG_CITY_IMAGE_RES_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_city, container, false)

        val imageViewCity: ImageView = view.findViewById(R.id.imageViewCity)
        Glide.with(this).load(cityImageResId).into(imageViewCity)

        // Add additional views and logic for city-specific information if needed

        return view
    }
}

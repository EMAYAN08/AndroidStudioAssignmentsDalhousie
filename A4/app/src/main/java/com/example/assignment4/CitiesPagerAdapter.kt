package com.example.assignment4

class CitiesPagerAdapter(fragmentManager: FragmentManager, private val countryName: String) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val cityImageResIdsMap: Map<String, List<Int>> = mapOf(
        "canada" to listOf(
            R.drawable.city1_image_country1,
            R.drawable.city2_image_country1,
            R.drawable.city3_image_country1
        ),
        "usa" to listOf(
            R.drawable.city1_image_country2,
            R.drawable.city2_image_country2,
            R.drawable.city3_image_country2
        ),
        // Add more countries and their corresponding city images as needed
    )

    private val cityImageResIds: List<Int> by lazy {
        cityImageResIdsMap[countryName] ?: emptyList()
    }

    override fun getCount(): Int {
        return cityImageResIds.size
    }

    override fun getItem(position: Int): Fragment {
        val cityImageResId = cityImageResIds[position]
        return CityFragment.newInstance(cityImageResId)
    }

    private val cityNamesMap: Map<String, List<String>> = mapOf(
        "canada" to listOf("Halifax", "Darthmouth", "Spriefield"),
        "usa" to listOf("Houston", "Austin", "Dallas"),
        // Add more countries and their corresponding city names as needed
    )

    private val cityNames: List<String> by lazy {
        cityNamesMap[countryName] ?: emptyList()
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return cityNames.getOrNull(position) ?: "City ${position + 1}"
    }
}


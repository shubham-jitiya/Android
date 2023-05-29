package com.example.myapplication.uiwidgets

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityGuestLocationDetailsBinding
import com.example.myapplication.uiwidgets.adapter.CarouselGuestLocationDetailsAdapter
import com.example.myapplication.uiwidgets.adapter.LocationDetailsViewPagerAdapter
import com.example.myapplication.uiwidgets.fragments.LocationDetailsPersonalFragment
import com.example.myapplication.uiwidgets.models.BookLocation
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.smarteist.autoimageslider.SliderView

class GuestLocationDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestLocationDetailsBinding
    private lateinit var carouselImagesUrl: ArrayList<String>
    private lateinit var sliderView: SliderView
    private lateinit var sliderAdapter: CarouselGuestLocationDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestLocationDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialSetup()
    }

    private fun initialSetup() {
        navigateBack()
        setupTabLayout()
        setupCarousel()
        submitUserDetails()
    }

    private fun submitUserDetails() {
        binding.buttonBookNow.setOnClickListener { it ->
            getUserDetails()
            Snackbar.make(
                it,
                "You location has been booked successfully!",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun setupTabLayout() {
        val tabs = arrayOf("Personal", "Business")
        val adapter = LocationDetailsViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPagerLocationDetails.adapter = adapter
        TabLayoutMediator(
            binding.tabLayoutLocationDetailsAccountType, binding.viewPagerLocationDetails
        ) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }

    private fun setupCarousel() {
        sliderView = binding.sliderHeaderImages
        carouselImagesUrl = ArrayList<String>()
        carouselImagesUrl.add("https://img.freepik.com/premium-photo/cars-parking-lot-evening-light-sun_150893-219.jpg")
        carouselImagesUrl.add("https://hips.hearstapps.com/hmg-prod/images/vacant-car-parking-space-royalty-free-image-1591721505.jpg")
        carouselImagesUrl.add("https://img.freepik.com/free-photo/underground-car-parking-shopping-center_93675-134540.jpg")
        sliderAdapter = CarouselGuestLocationDetailsAdapter(imageURL = carouselImagesUrl)
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()
        binding.textViewCurrentImageCount.text =
            String.format("%d/%d", sliderView.currentPagePosition + 1, carouselImagesUrl.size)
        sliderView.setCurrentPageListener {
            binding.textViewCurrentImageCount.text =
                String.format("%d/%d", sliderView.currentPagePosition + 1, carouselImagesUrl.size)
        }
    }

    private fun navigateBack() {
        binding.toolbarGuestLocation.setNavigationOnClickListener {
            finish()
        }
    }

    private fun getDataPersonalAccount() {
        val fragment =
            supportFragmentManager.findFragmentByTag("f" + binding.viewPagerLocationDetails.currentItem) as LocationDetailsPersonalFragment
        val selectedTab =
            binding.tabLayoutLocationDetailsAccountType.getTabAt(binding.viewPagerLocationDetails.currentItem)
        val etAfterDate = fragment.view?.findViewById<EditText>(R.id.editTextEnterAfterDate)
        val etAfterTime = fragment.view?.findViewById<EditText>(R.id.editTextEnterAfterTime)
        val etBeforeDate = fragment.view?.findViewById<EditText>(R.id.editTextExitBeforeDate)
        val etBeforeTime = fragment.view?.findViewById<EditText>(R.id.editTextExitBeforeTime)
        val chipGroup = fragment.view?.findViewById<ChipGroup>(R.id.chipGroupSelectInterval)
        val chip = chipGroup?.checkedChipId?.let { fragment.view?.findViewById<Chip>(it) }
        val locationBooked = BookLocation(
            accountType = selectedTab?.text.toString(),
            schedule = chip?.text.toString(),
            dateAfter = etAfterDate?.text.toString(),
            timeAfter = etAfterTime?.text.toString(),
            dateBefore = etBeforeDate?.text.toString(),
            timeBefore = etBeforeTime?.text.toString()
        )
        Log.d("TAG", "getDataPersonalAccount: $locationBooked")
    }

    private fun getUserDetails() {
        val currentTab = binding.tabLayoutLocationDetailsAccountType.selectedTabPosition
        if (currentTab == 0) {
            getDataPersonalAccount()
        } else {

        }
    }
}
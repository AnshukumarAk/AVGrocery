package com.anshu.fooddeliver.Fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.anshu.fooddeliver.Adapter.greadAdapter
import com.anshu.fooddeliver.Adapter.ptoduct_list_oneAdapter
import com.anshu.fooddeliver.R
import com.anshu.fooddeliver.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.gtappdevelopers.kotlingfgproject.SliderAdapter
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val handler = Handler()

    private val hints = arrayOf(
        "Search Chocolate",
        "Search Atta",
        "Search Colgate",
        "Search Biskut",
        "Search Milk",
        "Search Gifts",
        "Search Rice",

        )

    lateinit var ptoductListadapter: ptoduct_list_oneAdapter
    lateinit var greadAdapter: greadAdapter
    val greadArreyList=ArrayList<String>()
    val ptoductListArrylist = ArrayList<String>()
    private var hintIndex = 0
    lateinit var imageUrl: java.util.ArrayList<String>
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        handler.postDelayed(hintChangerRunnable, 3000)



        binding.productListOne.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.productListOne.setHasFixedSize(true)
        ptoductListadapter = ptoduct_list_oneAdapter(ptoductListArrylist, requireContext())
        binding.productListOne.adapter = ptoductListadapter




        binding.greadlist.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.greadlist.setHasFixedSize(true)
        greadAdapter = greadAdapter(greadArreyList, requireContext())
        binding.greadlist.adapter = greadAdapter



        binding.profile.setAnimation(R.raw.profile)
        binding.profile.playAnimation()
        binding.profile.loop(true)



        binding.profile.setOnClickListener {
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment, ProfileFragment(), null)
//                .addToBackStack(null)
//                .commit()

            showBottomSheetDialog()
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageUrl = java.util.ArrayList()
        imageUrl.add(
            0,
            "https://www.echelon.lk/wp-content/uploads/2020/09/keells-banner-size.jpg"
        )
        imageUrl.add(1, "https://www.quantretail.com/loadImage?imageOid=966376")
        imageUrl.add(
            2,
            "https://www.adb.org/sites/default/files/styles/content_media/public/content-media/146416-211207-supermarket-image.jpeg?itok=ItZz1-JT"
        )
        sliderAdapter = SliderAdapter(imageUrl)
        binding.slider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        binding.slider.setSliderAdapter(sliderAdapter)
        binding.slider.scrollTimeInSec = 3
        binding.slider.isAutoCycle = true
        binding.slider.startAutoCycle()


    }

    private val hintChangerRunnable = object : Runnable {
        override fun run() {
            if (hintIndex < hints.size) {
                binding.searchProduct.animate()
                    .translationY(-binding.searchProduct.height.toFloat()) // Move the view upwards
                    .alpha(0f) // Fade out the view
                    .setDuration(500)
                    .withEndAction {
                        binding.searchProduct.hint = hints[hintIndex]
                        binding.searchProduct.animate()
                            .translationY(0f) // Move the view back to original position
                            .alpha(1f) // Fade in the view
                            .setDuration(500)
                            .start()
                        hintIndex++
                        handler.postDelayed(this, 3000)
                    }
            } else {
                hintIndex = 0
                handler.postDelayed(this, 3000)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val bottomSheetView = layoutInflater.inflate(R.layout.custome_language_popup, null)
        bottomSheetDialog.setContentView(bottomSheetView)

//        bottomSheetView.findViewById<Button>(R.id.btnAction).setOnClickListener {
//            // Handle button click
//            bottomSheetDialog.dismiss() // Close the bottom sheet
//        }

        bottomSheetDialog.show()
    }

}
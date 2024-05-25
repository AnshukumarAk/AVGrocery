package com.anshu.fooddeliver.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anshu.fooddeliver.databinding.CostomProductBinding
import java.util.ArrayList

class ptoduct_list_oneAdapter(
    private var ptoductListArrylist: ArrayList<String>,
    private val requireContext: Context
) : RecyclerView.Adapter<ptoduct_list_oneAdapter.ViewHolder>() {


    lateinit var binding: CostomProductBinding
    private var isExpanded = false

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ):
            ptoduct_list_oneAdapter.ViewHolder {
        binding = CostomProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ptoduct_list_oneAdapter.ViewHolder, position: Int) {




    }

    override fun getItemCount(): Int {
        return 20
    }

    class ViewHolder(val binding: CostomProductBinding) : RecyclerView.ViewHolder(binding.root)


}
package com.anshu.fooddeliver.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anshu.fooddeliver.databinding.GreadItemViewBinding
import java.util.ArrayList

class greadAdapter(
    private var greadArreyList: ArrayList<String>,
    private val requireContext: Context
) : RecyclerView.Adapter<greadAdapter.ViewHolder>() {


    lateinit var binding: GreadItemViewBinding
    private var isExpanded = false

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ):
            greadAdapter.ViewHolder {
        binding = GreadItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: greadAdapter.ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return 20
    }

    class ViewHolder(val binding: GreadItemViewBinding) : RecyclerView.ViewHolder(binding.root)


}
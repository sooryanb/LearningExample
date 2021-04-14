package com.example.activitylifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.activitylifecycle.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding  = FragmentFirstBinding.bind(view)
        _binding = binding

        val context = context as MainActivity

        var fruitsArray = resources.getStringArray(R.array.FruitsName)
        val fruitsListView = binding.listView1

        val fruitAdapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, fruitsArray)
        fruitsListView.adapter = fruitAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
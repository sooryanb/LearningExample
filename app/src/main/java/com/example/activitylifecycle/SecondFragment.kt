package com.example.activitylifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.activitylifecycle.databinding.FragmentFirstBinding
import com.example.activitylifecycle.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {

    private var _binding: FragmentSecondBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding  = FragmentSecondBinding.bind(view)
        _binding = binding

        val context = context as MainActivity

        var carArray = arrayOf("BMW", "Audi", "Harrier", "Altroz", "Tiago", "Alto", "SWIFT", "Nexon",
                "BMW", "Audi", "Harrier", "Altroz", "Tiago", "Alto", "SWIFT", "Nexon")
        val carListView: ListView = binding.listView2

        val carAdapter = ArrayAdapter(context, R.layout.list_view_model, carArray)
//        carListView.adapter = carAdapter
        carListView.adapter = carAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
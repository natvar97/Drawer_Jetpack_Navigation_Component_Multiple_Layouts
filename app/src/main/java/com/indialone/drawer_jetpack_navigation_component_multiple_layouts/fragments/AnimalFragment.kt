package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.adapters.AnimalRecyclerAdapter
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.FragmentAnimalBinding
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.animal.AnimalItem
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.AnimalViewModel
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.ViewModelFactory

class AnimalFragment : Fragment() {

    private lateinit var mBinding: FragmentAnimalBinding
    private lateinit var animalViewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAnimalBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animalList = ArrayList<AnimalItem>()

        animalViewModel =
            ViewModelProvider(this, ViewModelFactory()).get(AnimalViewModel::class.java)

        animalViewModel.getAllElephants().observe(viewLifecycleOwner) { animals ->
            animalList.addAll(animals)
            val layoutManager = LinearLayoutManager(mBinding.root.context)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            mBinding.rvAnimal.layoutManager = layoutManager
            mBinding.rvAnimal.adapter = AnimalRecyclerAdapter(animalList)
        }

        Log.e("animal List","$animalList")
    }


}
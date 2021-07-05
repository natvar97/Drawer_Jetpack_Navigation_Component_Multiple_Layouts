package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.FragmentCatFactBinding
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.model.cat_fact.CatFactEntity
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.CatFactViewModel
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.ViewModelFactory

class CatFactFragment : Fragment() {

    private lateinit var mBinding: FragmentCatFactBinding
    private lateinit var catFactViewModel: CatFactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentCatFactBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catFactViewModel = ViewModelProvider(this, ViewModelFactory()).get(CatFactViewModel::class.java)

        getRandomCatFact()

        mBinding.swipeToRefresh.setOnRefreshListener {
            catFactViewModel.fetchCatFact()
        }

    }

    private fun getRandomCatFact() {
        catFactViewModel.getCatFact().observe(viewLifecycleOwner) { fact ->
            if (mBinding.swipeToRefresh.isRefreshing) {
                mBinding.swipeToRefresh.isRefreshing = false
            }
            setUpUi(fact)
        }
    }

    private fun setUpUi(fact: CatFactEntity) {
        mBinding.tvCatFact.text = fact.fact
        mBinding.tvLength.text = "Length- ${fact.length}"
    }

}
package com.indialone.drawer_jetpack_navigation_component_multiple_layouts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.databinding.FragmentRandomJokeBinding
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.RandomJokeViewModel
import com.indialone.drawer_jetpack_navigation_component_multiple_layouts.viewmodel.ViewModelFactory

class RandomJokeFragment : Fragment() {

    private lateinit var mBinding: FragmentRandomJokeBinding
    private lateinit var randomJokeViewModel: RandomJokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentRandomJokeBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomJokeViewModel =
            ViewModelProvider(this, ViewModelFactory()).get(RandomJokeViewModel::class.java)

        randomJokeViewModel.getRandomJoke().observe(viewLifecycleOwner) { joke ->
            if (mBinding.swipeToRefresh.isRefreshing){
                mBinding.swipeToRefresh.isRefreshing = false
            }

            mBinding.tvIdJoke.text = "${joke.id}"
            mBinding.tvPunchlineJoke.text = joke.punchline
            mBinding.tvSetupJoke.text = joke.setup
        }

        mBinding.swipeToRefresh.setOnRefreshListener {
            randomJokeViewModel.fetchRandomJoke()
        }



    }

}
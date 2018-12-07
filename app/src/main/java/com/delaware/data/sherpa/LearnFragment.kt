package com.delaware.data.sherpa

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class LearnFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.learn_fragment, null)
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        var binding : LearnFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.learn_fragment, container, false)
//        var myView: View = binding.root
//
//
//        // setting values to model
//        val user = LearnObject("Vineeth", "Chohan")
//        binding.user = user
//
//        return myView
//    }
}

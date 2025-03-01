package com.example.rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import androidx.lifecycle.ViewModelProvider


abstract class BaseFragment<VB : ViewBinding, VM: ViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    abstract fun getViewModelClass(): Class<VM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container)

        viewModel = ViewModelProvider(this)[getViewModelClass()]

        return binding.root
    }
}

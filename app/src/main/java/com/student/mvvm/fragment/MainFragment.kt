package com.student.mvvm.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentController
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.student.mvvm.R
import com.student.mvvm.adapter.RvNoteAdapter
import com.student.mvvm.databinding.FragmentMainBinding
import com.student.mvvm.databinding.FragmentShowNoteBinding
import com.student.mvvm.viewmodel.MainViewModel

class MainFragment : Fragment(R.layout.fragment_main), RvNoteAdapter.OnItemClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val rvNoteAdapter = RvNoteAdapter()
        rvNoteAdapter.setOnClickListener(this)
        val layoutManager = GridLayoutManager(context, 2)


        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addNoteFragment)
        }
        viewModel.getAllNotes().observe(viewLifecycleOwner) {
            rvNoteAdapter.updateData(it)
        }
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = rvNoteAdapter
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onClick(id : Int) {
        val bundle = Bundle().also {
            it.putInt("id",id)
        }
        findNavController().navigate(R.id.action_mainFragment_to_showNoteFragment,bundle)
    }

}
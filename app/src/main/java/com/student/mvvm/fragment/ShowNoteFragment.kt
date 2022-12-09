package com.student.mvvm.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.student.mvvm.R
import com.student.mvvm.databinding.FragmentShowNoteBinding
import com.student.mvvm.util.toNoteModel
import com.student.mvvm.viewmodel.ShowNotViewModel

class ShowNoteFragment : Fragment(R.layout.fragment_show_note) {
    private var _binding: FragmentShowNoteBinding? = null
    private val binding: FragmentShowNoteBinding get() = _binding!!
    private var viewModel: ShowNotViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentShowNoteBinding.bind(view)
        val _bundle = arguments
        val bundle = _bundle!!
        viewModel = ViewModelProvider(this)[ShowNotViewModel::class.java]
        Log.i("TTT", "onViewCreated: ${bundle.getInt("id")}")
        viewModel?.getNote(id = bundle.getInt("id"))?.observe(viewLifecycleOwner) {
            if (it != null) {
                val note = it.toNoteModel()
                binding.noteTetx.text = note.noteText
                binding.noteTitle.text = note.noteTitle
                Log.i("TTT", "onViewCreated: $note")
            }
        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}
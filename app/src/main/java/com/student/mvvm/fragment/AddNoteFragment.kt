package com.student.mvvm.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.student.mvvm.R
import com.student.mvvm.database.NoteEntity
import com.student.mvvm.databinding.FragmentAddNoteBinding
import com.student.mvvm.model.NoteModel
import com.student.mvvm.viewmodel.AddNoteViewModel

class AddNoteFragment : Fragment(R.layout.fragment_add_note) {
    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AddNoteViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddNoteBinding.bind(view)
        viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]

        binding.saveBtn.setOnClickListener {
            val title = binding.idTitle.text.toString()
            val text = binding.idText.text.toString()
            if (title.isEmpty() || text.isEmpty()) {
                Toast.makeText(context, "Tekshrib keyn kiriting", Toast.LENGTH_LONG).show()
            } else {
                val note = NoteModel(title, text)
                viewModel.insert(note)
                Toast.makeText(context, "Saqlandi", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addNoteFragment_to_mainFragment)
            }
        }
        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(R.id.action_addNoteFragment_to_mainFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
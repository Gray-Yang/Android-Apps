package ui.assignments.a4notes.ui

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ui.assignments.a4notes.R
import ui.assignments.a4notes.viewmodel.NotesViewModel

class add_screen : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_screen, container, false)
        val model : NotesViewModel by activityViewModels { NotesViewModel.Factory }
        view.findViewById<Button>(R.id.create).setOnClickListener {
            findNavController().navigate(R.id.action_otherFragment_to_blankFragment)
            model.addNote(view.findViewById<EditText>(R.id.newTitle).toString(),
                view.findViewById<EditText>(R.id.newContent).toString(),
                view.findViewById<Switch>(R.id.newImportant).isChecked)

            println(model.getNotes().value?.let { it1 -> print(it1.size) })
        }
        return view
    }

}

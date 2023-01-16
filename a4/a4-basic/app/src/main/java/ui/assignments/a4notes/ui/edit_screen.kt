package ui.assignments.a4notes.ui
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Switch
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ui.assignments.a4notes.R
import ui.assignments.a4notes.viewmodel.NotesViewModel

class edit_screen : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.edit_screen, container, false)
        val model : NotesViewModel by activityViewModels { NotesViewModel.Factory }

        view.findViewById<EditText>(R.id.edittitle).text = Editable.Factory.getInstance().newEditable(model.id.title)
        view.findViewById<EditText>(R.id.editcontent).text = Editable.Factory.getInstance().newEditable(model.id.content)
        view.findViewById<Switch>(R.id.editswitchimportant).isChecked = model.id.important
        view.findViewById<Switch>(R.id.editswitcharchived).isChecked = model.id.archived

        view.findViewById<EditText>(R.id.edittitle).addTextChangedListener(
            afterTextChanged = {
                model.updateNoteTitle(model.id.id,
                view.findViewById<EditText>(R.id.edittitle).text.toString())
            }
        )

        view.findViewById<EditText>(R.id.editcontent).addTextChangedListener(
            afterTextChanged = {
                model.updateNoteContent(model.id.id,
                    view.findViewById<EditText>(R.id.editcontent).text.toString())
            }
        )



        view.findViewById<Switch>(R.id.editswitchimportant).setOnCheckedChangeListener { _, ischecked ->
            model.updateNoteImportant(model.id.id, ischecked)

            if(ischecked){
                view.findViewById<Switch>(R.id.editswitcharchived).isChecked = false
                model.updateNoteArchived(model.id.id, false)
            }



        }

        view.findViewById<Switch>(R.id.editswitcharchived).setOnCheckedChangeListener { _, ischecked ->
            model.updateNoteArchived(model.id.id, ischecked)

            if(ischecked) {
                view.findViewById<Switch>(R.id.editswitchimportant).isChecked = false
                model.updateNoteImportant(model.id.id, false)
            }



        }

        return view
    }
}



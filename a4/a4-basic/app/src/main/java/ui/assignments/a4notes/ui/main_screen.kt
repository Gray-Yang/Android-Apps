package ui.assignments.a4notes.ui
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ui.assignments.a4notes.R
import ui.assignments.a4notes.viewmodel.NotesViewModel


class main_screen : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.main_screen, container, false)
        val model : NotesViewModel by activityViewModels { NotesViewModel.Factory }

        // Any change to the List of String in the ViewModel results in an update of the TextView in this View.
        model.getNotes().observe(viewLifecycleOwner) { list ->
            val linearLayout = view.findViewById<LinearLayout>(R.id.string_container)
            linearLayout.removeAllViews()
            list.forEach { string ->
                // Using the layoutInflator to generate a small "sub-scene-graph" out of string_view.xml.
                //   The layoutInflator returns a View, which is than added to the LinearLayout in activity_main.xml.
                //   For this, the LinearLayout has to have an id. (Usually, ViewGroup are not given an id because it is rarely needed.)
                layoutInflater.inflate(R.layout.single_note, null, false).apply {
                    findViewById<TextView>(R.id.Title).text = " \"${string.value?.title}\""
                    findViewById<TextView>(R.id.Content).text = " ${string.value?.content}"
                    if(string.value?.important == true){
                        findViewById<LinearLayout>(R.id.allnotes).setBackgroundColor(Color.parseColor("#FFFF00"))
                    }
                    else if(string.value?.archived  == true){
                        findViewById<LinearLayout>(R.id.allnotes).setBackgroundColor(Color.parseColor("#FFBDBDBD"))
                    }else {
                        findViewById<LinearLayout>(R.id.allnotes).setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                    }
                    //findViewById<TextView>(R.id.text_string_frequency).text = "#1 letter: '${string.groupingBy { it }.eachCount().maxBy { it.value }.key }'"
                    linearLayout.addView(this)
                    findViewById<Button>(R.id.A).setOnClickListener{
                        println(string.value?.let { it1 -> println(it1.id) })
                        string.value?.let { it1 -> model.updateNoteArchived(it1.id,true) }
                    }
                    findViewById<Button>(R.id.D).setOnClickListener{
                        println(string.value?.let { it1 -> println(it1.id) })
                        string.value?.let { it1 -> model.removeNote(it1.id) }
                    }

                    setOnClickListener {
                        model.id = string.value!!
                        findNavController().navigate(R.id.action_blankFragment_to_edit)
                    }
                }

            }
        }

        view.findViewById<Switch>(R.id.gray).setOnCheckedChangeListener {
                _, isChecked ->
            model.set(isChecked)
            println(isChecked)

            model.getNotes().observe(viewLifecycleOwner) { list ->
                val linearLayout = view.findViewById<LinearLayout>(R.id.string_container)
                linearLayout.removeAllViews()
                list.forEach { string ->
                    // Using the layoutInflator to generate a small "sub-scene-graph" out of string_view.xml.
                    //   The layoutInflator returns a View, which is than added to the LinearLayout in activity_main.xml.
                    //   For this, the LinearLayout has to have an id. (Usually, ViewGroup are not given an id because it is rarely needed.)
                    layoutInflater.inflate(R.layout.single_note, null, false).apply {
                        findViewById<TextView>(R.id.Title).text = "\"${string.value?.title}\""
                        findViewById<TextView>(R.id.Content).text = " ${string.value?.content}"
                        if(string.value?.important == true){
                            findViewById<LinearLayout>(R.id.allnotes).setBackgroundColor(Color.parseColor("#FFFF00"))
                        }
                        else if(string.value?.archived  == true){
                            findViewById<LinearLayout>(R.id.allnotes).setBackgroundColor(Color.parseColor("#FFBDBDBD"))
                        }else {
                            findViewById<LinearLayout>(R.id.allnotes).setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                        }
                        //findViewById<TextView>(R.id.text_string_frequency).text = "#1 letter: '${string.groupingBy { it }.eachCount().maxBy { it.value }.key }'"
                        linearLayout.addView(this)
                        findViewById<Button>(R.id.A).setOnClickListener{
                            println(string.value?.let { it1 -> println(it1.id) })
                            string.value?.let { it1 -> model.updateNoteArchived(it1.id,true) }
                        }
                        findViewById<Button>(R.id.D).setOnClickListener{
                            println(string.value?.let { it1 -> println(it1.id) })
                            string.value?.let { it1 -> model.removeNote(it1.id) }
                        }

                        setOnClickListener {
                            model.id = string.value!!
                            findNavController().navigate(R.id.action_blankFragment_to_edit)
                        }
                    }

                }
            }

        }

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_otherFragment)
        }

        return view
    }
}


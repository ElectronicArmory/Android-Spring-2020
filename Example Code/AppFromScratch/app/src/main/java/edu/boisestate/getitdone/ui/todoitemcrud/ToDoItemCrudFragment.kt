package edu.boisestate.getitdone.ui.todoitemcrud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.boisestate.getitdone.R
import edu.boisestate.getitdone.ToDoItemCrudActivity
import edu.boisestate.getitdone.ToDoManager
import edu.boisestate.getitdone.models.ToDoItem
import kotlinx.android.synthetic.main.to_do_item_crud_fragment.*
import kotlinx.android.synthetic.main.to_do_item_crud_fragment.view.*

class ToDoItemCrudFragment : Fragment() {

    companion object {
        fun newInstance() = ToDoItemCrudFragment()
    }

    private lateinit var viewModel: ToDoItemCrudViewModel
    private var todoItem:ToDoItem? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.to_do_item_crud_fragment, container, false)

        todoItem = (activity as ToDoItemCrudActivity).todoItem

        todoItem?.let {
            val title = it.todoTitle
            val description = it.todoDescription

            view.todoTitleEditText.setText(title)
            view.todoDescriptionEditText.setText(description)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ToDoItemCrudViewModel::class.java)
        // TODO: Use the ViewModel

        saveButton.setOnClickListener {
            val todoTitle = todoTitleEditText.text.toString()
            val todoDescription = todoDescriptionEditText.text.toString()
            val todoDate = todoDateEditText.text.toString()

            if( todoItem == null ) {
                ToDoManager.addToDoItem(todoTitle, todoDescription, todoDate)
            }
            else{
                todoItem?.todoTitle = todoTitle
                todoItem?.todoDescription = todoDescription
            }
            requireActivity().finish()
        }
    }

}

package edu.boisestate.getitdone

import android.content.Context
import android.os.Bundle
import android.util.EventLog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import edu.boisestate.getitdone.dummy.DummyContent
import edu.boisestate.getitdone.dummy.DummyContent.DummyItem
import edu.boisestate.getitdone.models.ToDoItem
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ToDoItemFragment.OnListFragmentInteractionListener] interface.
 */
class ToDoItemFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null
    lateinit var todoAdapter:ToDoItemRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_to_do_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = ToDoItemRecyclerViewAdapter(ToDoManager.todoList(), listener)
                todoAdapter = adapter as ToDoItemRecyclerViewAdapter
            }
        }

        EventBus.getDefault().register(this)

        return view
    }


    override fun onResume() {
        super.onResume()
//        todoAdapter.notifyDataSetChanged() // This happens too frequently. Only update when there's new data like updatedToDos
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun updatedToDos(event:NewTodoItemsEvent){
        todoAdapter.notifyDataSetChanged()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: ToDoItem?)
    }

}

package com.android.socialapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.android.socialapp.adapters.DataAdapter
import com.android.socialapp.databinding.FragmentSwipeViewBinding
import com.android.socialapp.models.Body


class PageFragment : Fragment() {

    private var _binding: FragmentSwipeViewBinding? = null
    private var dataAdapter:DataAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSwipeViewBinding.inflate(inflater, container, false)
        val root = binding.root
        var position = arguments?.getInt(ARG_SECTION_NUMBER)
        var data= arguments?.getSerializable("data") as Body
        dataAdapter = DataAdapter(position!!,data)
        binding.listView.adapter = dataAdapter
        binding.listView.layoutManager = LinearLayoutManager(container?.context,LinearLayoutManager.VERTICAL,false)
        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int,data: Body?): PageFragment {
            return PageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                    putSerializable("data",data)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
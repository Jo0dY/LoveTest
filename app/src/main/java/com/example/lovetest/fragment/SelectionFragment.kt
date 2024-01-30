package com.example.lovetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R

class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    lateinit var btn_back:ImageView
    lateinit var option_1:TextView
    lateinit var option_2:TextView
    lateinit var option_3:TextView
    lateinit var option_4:TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        btn_back = view.findViewById<ImageView>(R.id.btn_back)
        option_1 = view.findViewById<TextView>(R.id.option_1)
        option_2 = view.findViewById<TextView>(R.id.option_2)
        option_3 = view.findViewById<TextView>(R.id.option_3)
        option_4 = view.findViewById<TextView>(R.id.option_4)

        btn_back.setOnClickListener(this)
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_1->{navigateWithIndex(1)}
            R.id.option_2->{navigateWithIndex(2)}
            R.id.option_3->{navigateWithIndex(3)}
            R.id.option_4->{navigateWithIndex(4)}
            R.id.btn_back->{
                navController.popBackStack()
            }
        }
    }
    fun navigateWithIndex(index : Int){
        val bundle= bundleOf("index" to index)
        navController.navigate(R.id.action_selectionFragment_to_resultFragment2,bundle)

    }
}
package com.example.lovetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R


class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var option=-1

    lateinit var navController: NavController
    lateinit var btn_home: ImageView
    lateinit var tv_main: TextView
    lateinit var tv_sub: TextView //의도대로 Button, Text는 수정해 주세요.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        option = arguments?.getInt("Index")?:-1
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_home = view.findViewById(R.id.btn_home)

        navController=Navigation.findNavController(view)
        btn_home = view.findViewById<ImageView>(R.id.btn_home)
        setResult(option)


        btn_home.setOnClickListener{
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }
    fun setResult(option : Int){
        when(option){
            1->{
                tv_main.text="1111"
                tv_sub.text="1입니다."
            }
            2->{
                tv_main.text="2222"
                tv_sub.text="2입니다."

            }
            3->{
                tv_main.text="3333"
                tv_sub.text="3입니다."

            }
            4-> {
                tv_main.text = "4444"
                tv_sub.text = "4입니다."
            }
        }
    }
}
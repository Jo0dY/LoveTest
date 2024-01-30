package com.example.lovetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R


class MainFragment : Fragment() {
    lateinit var navController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)


        // findViewById() 사용하여 뷰 참조
        val btnNext = view.findViewById<ImageView>(R.id.btn_next)

        // 다음 프레그먼트로 이동
        btnNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_questionFragment)
        }

        return view
    }
}
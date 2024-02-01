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
        option = arguments?.getInt("index")?:-1
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_home = view.findViewById(R.id.btn_home)
        tv_main = view.findViewById(R.id.tv_main) // 수정: tv_main 초기화
        tv_sub = view.findViewById(R.id.tv_sub)
        navController=Navigation.findNavController(view)
        btn_home = view.findViewById<ImageView>(R.id.btn_home)
        setResult(option)


        btn_home.setOnClickListener{
            navController.navigate(R.id.action_resultFragment4_to_mainFragment)
        }
    }
    fun setResult(option : Int){
        when(option){
            1 -> {
                tv_main.text = "따뜻한 마음씨의 소유자"
                tv_sub.text = "우동이를 선택한 당신은 따뜻한 성격의 소유자입니다.\n" +
                        "추운 날씨에도 우동국물이 사람을 녹여주듯이, 주변 사람들의 마음을 녹여주는 마음 따뜻한 사람입니다."
            }
            2 -> {
                tv_main.text = "개성만점 당신"
                tv_sub.text = "슴슥이를 선택한 당신은 다채로운 성격의 소유자입니다.\n" +
                        "슴슥이의 삼색이 잘 어우러져 매력적이듯이, 다채로운 성격이 조화를 이루어 매력적인 사람입니다."
            }
            3 -> {
                tv_main.text = "편안함을 주는 사람"
                tv_sub.text = "지붕이를 선택한 당신은 주변을 편안하게 해주는 마음씨를 소유하셨군요!\n" +
                        "지붕이 집안을 둘러싸고 사람들에게 안식처를 제공하듯이, 당신은 주변 사람들에게 편안함을 주는 사람입니다."
            }
            4 -> {
                tv_main.text = "포용력있는 성격의 소유자"
                tv_sub.text = "짜장이를 선택한 당신은 포용력있는 성격을 가지고 있습니다.\n" +
                        "남녀노소 가리지 않고 인기가 많은 짜장면처럼, 모두를 아우르는 능력이 있는 포용력을 가지고 있는 사람입니다."
            }
        }
    }
}
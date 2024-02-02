package com.example.lovetest


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lovetest.fragment.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginActivity : AppCompatActivity() {
    var auth: FirebaseAuth? = null
    private var email_login_button: Button? = null
    private var email_edittext: EditText? = null
    private var password_edittext: EditText? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        val email_sign_button = findViewById<Button>(R.id.email_sign_button)
        val email_login_button = findViewById<Button>(R.id.email_login_button)
        val email_edittext = findViewById<EditText>(R.id.email_edittext)
        val password_edittext = findViewById<EditText>(R.id.password_edittext)

        email_login_button?.setOnClickListener {
            signinEmail(email_edittext.text.toString(), password_edittext.text.toString())
        }

        email_sign_button?.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }


    fun signinEmail(email: String, pw: String) {
        auth?.signInWithEmailAndPassword(email, pw)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Login, 아이디와 패스워드가 맞았을 때
                    moveMainPage(task.result?.user)
                } else {
                    // Show the error message, 아이디와 패스워드가 틀렸을 때
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }

    // 로그인이 성공하면 다음 페이지로 넘어가는 함수
    fun moveMainPage(user: FirebaseUser?) {
        // 파이어베이스 유저 상태가 있을 경우 다음 페이지로 넘어갈 수 있음
        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


}

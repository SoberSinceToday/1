package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        val userPhone: EditText = findViewById(R.id.logPhone)
        val userPassword: EditText = findViewById(R.id.logPas)
        val buttonLogin: Button = findViewById(R.id.logButton)
        val linkToReg: TextView = findViewById(R.id.linkToReg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
        val clickListener = View.OnClickListener {
            val userPhoneListener = userPhone.text.toString().trim()
            val userPasswordListener = userPassword.text.toString().trim()
            // Почему-то при написании активити он попросил сделать телефон класса Phone
            // но ковертации в него базовой нет так что похуй пока что


            if (userPasswordListener == "" || userPhoneListener == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else{
                //ДБШКА ТИПО
                //val db = DBHelper(this, null)
                //val isLogged = db.getUser(userPhoneListener, userPasswordListener)
                val isLogged = false
                if(isLogged){
                    Toast.makeText(this, "Успешно!", Toast.LENGTH_LONG).show()
                    userPhone.text.clear()
                    userPassword.text.clear()
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this, "Неправильные данные", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
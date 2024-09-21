package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        // vals

        val userPhone: EditText = findViewById(R.id.regPhone)
        val userPassword: EditText = findViewById(R.id.regPas)
        val buttonLogin: Button = findViewById(R.id.regButton)
        val linkToLog: TextView = findViewById(R.id.linkToLog)
        val offlineChoose: RadioButton = findViewById(R.id.worker)
        val onlineChoose: RadioButton = findViewById(R.id.boss)
        val onlineOfflineMode: RadioGroup = findViewById(R.id.workerMode)

        var userMode = "offline"

        val clickListener = View.OnClickListener {
            val userPhoneListener = userPhone.text.toString().trim()
            val userPasswordListener = userPassword.text.toString().trim()
            if (userPasswordListener == "" || userPhoneListener == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else {//ТИПО БДШКА
                //val user = User(userPhoneListener, userPasswordListener, userMode)
                //val db = DBHelper(this, null)
                //db.addUser(user)
                Toast.makeText(this, "Успешно!", Toast.LENGTH_LONG).show()
                userPhone.text.clear()
                userPassword.text.clear()
                startActivity(Intent(this, MainActivity::class.java)) // Переход к мейну`

            }
        }
        buttonLogin.setOnClickListener(clickListener)

        linkToLog.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }

        onlineOfflineMode.setOnCheckedChangeListener { group, checkedID ->
            if (checkedID == R.id.worker) {
                userMode = "worker"
                offlineChoose.setTextColor(ContextCompat.getColor(this, R.color.white))
                onlineChoose.setTextColor(ContextCompat.getColor(this, R.color.grey))
                //Toast.makeText(this, userMode, Toast.LENGTH_SHORT).show()
            }
            if (checkedID == R.id.boss) {
                userMode = "customer"
                offlineChoose.setTextColor(ContextCompat.getColor(this, R.color.grey))
                onlineChoose.setTextColor(ContextCompat.getColor(this, R.color.white))
                //Toast.makeText(this, userMode, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
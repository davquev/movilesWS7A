package com.example.appgeoqsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("¿Es Santiago capital de Chile?", true)
        questions.add(question)

        question = Question("¿Es Madrid capital de España?", true)
        questions.add(question)

        question = Question("¿Es La Paz capital de Bolivia?", true)
        questions.add(question)

        question = Question("¿Es Lima capital de Chile?", false)
        questions.add(question)

        question = Question("¿Es Quito capital de Ecuador?", true)
        questions.add(question)
    }

    fun setupViews() {
        //1ra forma de vincular el boton del xml a mi codigo
        //val btYes = findViewById<Button>(R.id.btYes)

        showSentence()
        //2da forma de vincular el boton del xml a mi codigo
        btYes.setOnClickListener {
            Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
        }

        btNo.setOnClickListener {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
        }

        btNext.setOnClickListener {
            position++
            showSentence()
        }
    }

    private fun showSentence() {
        tvSentence.text = questions[position].sentence
    }
}
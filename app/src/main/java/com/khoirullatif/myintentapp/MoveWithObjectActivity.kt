package com.khoirullatif.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObjectReceived: TextView = findViewById(R.id.tv_object_received)

        val person: Person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name: ${person.name},\nEmail: ${person.email},\nAge: ${person.age},\nLocation: ${person.city}"
        tvObjectReceived.text = text
    }
}
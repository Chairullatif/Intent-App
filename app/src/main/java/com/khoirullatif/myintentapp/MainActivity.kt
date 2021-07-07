package com.khoirullatif.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)

        tvResult = findViewById(R.id.tv_result)

        btnMoveActivity.setOnClickListener(this)
        btnMoveDataActivity.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil: $selectedValue"
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveDatawithIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveDatawithIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dicoding Academy Boy")
                moveDatawithIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveDatawithIntent)
            }
            R.id.btn_dial_number -> {
                val number = "08574330238"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Chairullatif",
                    20,
                    "khoirullatif334@gmail.com",
                    "Wonogiri"
                )

                val intentWithObject = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                intentWithObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(intentWithObject)
            }
            R.id.btn_move_for_result -> {
                val intentForResult = Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivityForResult(intentForResult, REQUEST_CODE) // sudah deprecated, diganti: registerForActivityResult
            }
        }
    }
}
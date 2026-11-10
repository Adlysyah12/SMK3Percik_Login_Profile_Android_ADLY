package com.example.luaspersegipanjang_adly

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // menghubungkan ke UI
        val etPanjang = findViewById<EditText>(R.id.etPanjang)
        val etLebar = findViewById<EditText>(R.id.etLebar)
        // findViewById untuk memanggil dari id UI
        // <EditText untuk input
        // R.id... untuk mamnggil id dari ui
        val btnHitung = findViewById<Button>(R.id.btnHasil)
        val tvHasil = findViewById<TextView>(R.id.LuasHasil)

        // memverikan aksi btn
        btnHitung.setOnClickListener {
            val panjangStr = etPanjang.text.toString()
            val lebarStr = etLebar.text.toString()

            //validasi ; input tidak ksosng
            if (panjangStr.isNotEmpty() && lebarStr.isNotEmpty()) {
                try {
                    //konversi huruf ke angka (double)
                    val panjang = panjangStr.toDouble()
                    val lebar = lebarStr.toDouble()

                    //rumus
                    val luas = panjang * lebar

                    //menampilkan hasil
                    tvHasil.text = getString(R.string.label_hasil,luas.toString())
                } catch (e :NumberFormatException) {
                    tvHasil.text = getString(R.string.error_invalid_input)
                }
            }else {
                tvHasil.text = getString(R.string.error_empty_fields)
            }
        }

    }
}
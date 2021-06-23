package com.plate.editor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.license.plate.editor.VehicleKeyboardHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VehicleKeyboardHelper.bind(et_plate)
    }
}
package com.plate.editor

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.license.plate.editor.VehicleKeyboardHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 页面中使用
        VehicleKeyboardHelper.bind(et_plate)
        // Dialog 中使用
        btn_dialog.setOnClickListener {
            showEditDialog()
        }
    }
    
    /**
     * 显示编辑弹框
     */
    private fun showEditDialog() {
        val contentView = LayoutInflater.from(this).inflate(R.layout.edit_dialog_layout, null)
        VehicleKeyboardHelper.bind(contentView.findViewById(R.id.et_dialog))
        val dialog = AlertDialog.Builder(this)
            .setTitle("编辑车牌号")
            .setView(contentView)
            .setNegativeButton(
                "取消"
            ) { dialog, which -> dialog?.dismiss() }
            .setPositiveButton("确定") { dialog, which ->
                Toast.makeText(this@MainActivity, "完成编辑！", Toast.LENGTH_SHORT).show()
                dialog?.dismiss()
            }
            .create()
        dialog.show()
    }
}
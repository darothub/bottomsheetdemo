package com.decagon.bottomsheettut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_persistence_sheet.*


class MainActivity : AppCompatActivity() {

    lateinit var behavior: BottomSheetBehavior<LinearLayout>
    private val bottomSheetSomething: LinearLayout by lazy {
        findViewById<LinearLayout>(R.id.bs)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        behavior = BottomSheetBehavior.from(bs as LinearLayout)

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                btnClick.text = when(newState){
                    BottomSheetBehavior.STATE_EXPANDED -> "Close the bottom sheet"
                    BottomSheetBehavior.STATE_COLLAPSED -> "Expand the bottom sheet"
                    else -> "State changing"
                }
            }

        })
//
        btnClick.setOnClickListener {
//            Toast.makeText(this, "Click", Toast.LENGTH_LONG).show()
            behavior.state = if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) BottomSheetBehavior.STATE_COLLAPSED
            else BottomSheetBehavior.STATE_EXPANDED
        }
    }
}
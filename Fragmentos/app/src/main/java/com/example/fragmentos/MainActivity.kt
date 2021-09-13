package com.example.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {


    private val KEY = "STATE_KEY"
    private var addImageInFragment: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addImageInFragment = savedInstanceState?.getBoolean(KEY, true) ?: true
        if (addImageInFragment)
            supportFragmentManager.beginTransaction().add(R.id.container, ImageIn())
                .commit()
    }



    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putBoolean(KEY, false)
        }

        super.onSaveInstanceState(outState)
    }

     fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            replace(R.id.container, fragment)
            addToBackStack(fragment.tag)
            commit()
        }
    }

}
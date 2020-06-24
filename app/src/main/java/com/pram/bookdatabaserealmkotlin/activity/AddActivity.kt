package com.pram.bookdatabaserealmkotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pram.bookdatabaserealmkotlin.R
import com.pram.bookdatabaserealmkotlin.fragment.AddFragment

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initInstances()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, AddFragment.newInstance())
                .commit()
        }
    }

    private fun initInstances() {}
}
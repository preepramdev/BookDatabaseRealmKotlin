package com.pram.bookdatabaserealmkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pram.bookdatabaserealmkotlin.R
import com.pram.bookdatabaserealmkotlin.fragment.DetailFragment

class DetailActivity : AppCompatActivity() {

    private var bookId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initInstances()

        if (intent != null) {
            bookId = intent.getIntExtra("bookId", 0)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, DetailFragment.newInstance(bookId))
                .commit()
        }
    }

    private fun initInstances() {}
}
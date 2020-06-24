package com.pram.bookdatabaserealmkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pram.bookdatabaserealmkotlin.R
import com.pram.bookdatabaserealmkotlin.fragment.UpdateFragment
import com.pram.bookdatabaserealmkotlin.model.Book

class UpdateActivity : AppCompatActivity() {
    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        initInstances()

        if (intent != null) {
            book = intent.getParcelableExtra("book")
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, UpdateFragment.newInstance(book))
                .commit()
        }
    }

    private fun initInstances() {}
}
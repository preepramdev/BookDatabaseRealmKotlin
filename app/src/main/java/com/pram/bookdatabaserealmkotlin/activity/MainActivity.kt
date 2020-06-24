package com.pram.bookdatabaserealmkotlin.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pram.bookdatabaserealmkotlin.fragment.MainFragment
import com.pram.bookdatabaserealmkotlin.R
import com.pram.bookdatabaserealmkotlin.db.BookDatabaseManager
import com.pram.bookdatabaserealmkotlin.model.Book
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInstances()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, MainFragment.newInstance())
                .commit()
        }

        presetBook()
    }

    private fun initInstances() {

    }

    private fun presetBook() {
        val books: List<Book> = BookDatabaseManager.instance!!.getAllBooks()!!

        if (books.isEmpty()) {
            val presetBooks: MutableList<Book> = ArrayList()

            presetBooks.add(Book(".NET Multithreading", "Alan Dennis", "360"))
            presetBooks.add(Book("Unix Basic", "W. John Snow", "126"))
            presetBooks.add(Book("Hello! Python", "Anthony Briggs", "352"))
            presetBooks.add(Book("Software Requirements", "Benjamin L. Kovitz", "448"))

            presetBooks.forEach { presetBook ->
                BookDatabaseManager.instance!!.createBook(presetBook)
            }

            Log.e(TAG, "presetBook: $presetBooks")
        } else {
            Log.e(TAG, "books: $books")
        }
    }
}
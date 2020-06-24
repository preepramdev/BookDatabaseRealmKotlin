package com.pram.bookdatabaserealmkotlin.db

import android.content.Context
import android.util.Log
import com.pram.bookdatabaserealmkotlin.manager.Contextor
import com.pram.bookdatabaserealmkotlin.model.Book

class BookDatabaseController {
    private val TAG = "BookDatabaseController"
    private var mContext: Context?
    private val databaseManager: BookDatabaseManager?
    private val emptyResult = Any()

    init {
        mContext = Contextor.instance!!.context
        databaseManager = BookDatabaseManager.instance
    }

    fun getAllBooks(callBack: BookDatabaseCallBack) {
        val books: List<Book>? = databaseManager!!.getAllBooks()
        books!!.forEach { book ->
            Log.e(TAG, "-->")
            Log.e(TAG, "fetchDatabase bookId: " + book.id)
            Log.e(TAG, "fetchDatabase bookTitle: " + book.title)
            Log.e(TAG, "fetchDatabase bookAuthor: " + book.author)
            Log.e(TAG, "fetchDatabase bookPages: " + book.pages)
            Log.e(TAG, "<--")
        }
        callBack.onCallBack(books)
    }

    fun getBook(bookId: Int, callBack: BookDatabaseCallBack) {
        val book = databaseManager!!.getBook(bookId)
        callBack.onCallBack(book)
    }

    fun createBook(book: Book?, callBack: BookDatabaseCallBack) {
        databaseManager!!.createBook(book!!)
        callBack.onCallBack(emptyResult) // void
    }

    fun updateBook(book: Book?, callBack: BookDatabaseCallBack) {
        databaseManager!!.updateBook(book!!)
        callBack.onCallBack(emptyResult) // void
    }

    fun removeBook(bookId: Int, callBack: BookDatabaseCallBack) {
        databaseManager!!.removeBook(bookId)
        callBack.onCallBack(emptyResult) // void
    }
}
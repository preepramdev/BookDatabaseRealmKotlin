package com.pram.bookdatabaserealmkotlin

import android.app.Application
import com.pram.bookdatabaserealmkotlin.db.BookDatabaseController
import com.pram.bookdatabaserealmkotlin.manager.Contextor.Companion.instance
import io.realm.Realm

val databaseController: BookDatabaseController by lazy {
    MainApplication.databaseController!!
}

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance!!.init(applicationContext)
        Realm.init(applicationContext) // todo 4. add this line
        databaseController = BookDatabaseController()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    companion object {
        var databaseController: BookDatabaseController? = null
    }
}
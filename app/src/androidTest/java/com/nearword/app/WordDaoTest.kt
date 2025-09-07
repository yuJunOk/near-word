package com.nearword.app

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nearword.app.data.db.AppDatabase
import com.nearword.app.data.db.WordDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WordDaoTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: WordDao

    @Before
    fun createDb() = runBlocking {
        val context = ApplicationProvider.getApplicationContext<Context>()
        // 1. 临时文件（测试完自动删）
        val dbFile = context.getDatabasePath("test_englishwords.db")
        // 2. 普通磁盘库 + 从 assets 拷贝
        db = Room.databaseBuilder(context, AppDatabase::class.java, dbFile.absolutePath)
            .createFromAsset("databases/englishwords.db")
            .allowMainThreadQueries()
            .build()
        dao = db.wordDao()
    }

    @After
    fun closeDb() {
        if (::db.isInitialized) db.close()
        // 可选：删掉临时文件
        ApplicationProvider.getApplicationContext<Context>()
            .getDatabasePath("test_englishwords.db")
            .delete()
    }

    @Test
    fun checkTableExists() = runBlocking {
        val c = db.openHelper.readableDatabase
        c.query("SELECT name FROM sqlite_master WHERE type='table'").use { cur ->
            while (cur.moveToNext()) {
                println("Table: ${cur.getString(0)}")
            }
        }
    }

    @Test
    fun printWordLine() = runBlocking {
        val entity = dao.query("a").first()
        println(entity)
    }

}
package com.nearword.app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nearword.app.data.db.entity.WordEntity

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()  {
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "englishwords.db"          // 内部存储最终文件名
                )
                    .createFromAsset("databases/englishwords.db") // ← 关键：只第一次拷贝
                    .fallbackToDestructiveMigration()             // 版本冲突时重建（可改迁移）
                    .build()
                    .also { INSTANCE = it }
            }
    }
}
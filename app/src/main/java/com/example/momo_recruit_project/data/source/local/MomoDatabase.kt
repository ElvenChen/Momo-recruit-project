package com.example.momo_recruit_project.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.momo_recruit_project.data.Animal

@Database(entities = [Animal::class], version = 1, exportSchema = false)
abstract class MomoDatabase : RoomDatabase() {

    abstract val momoDatabaseDao : MomoDatabaseDao

    companion object{

        @Volatile
        private var INSTANCE : MomoDatabase? = null

        fun getInstance(context: Context): MomoDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MomoDatabase::class.java,
                        "momo_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
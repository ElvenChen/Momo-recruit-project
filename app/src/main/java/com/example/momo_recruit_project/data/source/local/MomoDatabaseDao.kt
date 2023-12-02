package com.example.momo_recruit_project.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.momo_recruit_project.data.Animal


@Dao
interface MomoDatabaseDao {

    @Insert
    fun insert(animal: Animal)

    @Query("SELECT * FROM animal_table ORDER BY id ASC")
    fun getAllAnimalDetailList(): List<Animal>?


    @Query("SELECT * FROM animal_table WHERE location LIKE '%' || :keyword || '%' ORDER BY id ASC")
    fun getAnimalDetailListByLocation(keyword: String): List<Animal>
}
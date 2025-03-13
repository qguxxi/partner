package com.synth.partner.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.stevdzasan.onetap.GoogleUser
import com.synth.partner.data.model.GoogleUserEntity

@Dao
interface GoogleUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoogleUser(googleUser: GoogleUserEntity)

    @Update
    suspend fun updateGoogleUser(googleUser: GoogleUserEntity)

    @Query("SELECT * FROM google_user WHERE sub = :sub")
    suspend fun getGoogleUser(sub: String): GoogleUserEntity

    @Query("DELETE FROM google_user WHERE sub = :sub")
    suspend fun deleteGoogleUser(sub: String)

}
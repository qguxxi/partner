package com.synth.partner.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.synth.partner.data.model.GoogleUserEntity

private const val databaseVersion = 1
const val databaseName = "partner_database"

@Database(entities = [GoogleUserEntity::class], version = databaseVersion, exportSchema = false)
abstract class PartnerDatabase : RoomDatabase() {


    abstract fun googleUserDao(): GoogleUserDao



}
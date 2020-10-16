package apportunity.slovarik.model.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import apportunity.slovarik.model.dbmodel.DictionaryThemeModel
import apportunity.slovarik.model.dbmodel.DictionaryWithWords
import apportunity.slovarik.model.dbmodel.DictionaryWordModel

@Database(entities = [DictionaryThemeModel::class, DictionaryWordModel::class], version = 1, exportSchema = false)
abstract class DictionaryDatabase: RoomDatabase() {

    abstract fun dictionaryDAO(): DictionaryDAO

    companion object{
        @Volatile
        private var INSTANCE: DictionaryDatabase? = null

        fun getDatabase(context: Context): DictionaryDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DictionaryDatabase::class.java,
                    "dictionary_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
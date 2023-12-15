package cz.utb.fai.subjectinfo.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectInfoDao {

    @Query("select * from subject_info WHERE zkratka = :zkratka")
    fun getSubjectByZkratka(zkratka: String): Flow<SubjectInfoDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( subject: SubjectInfoDTO)
}

@Database(entities = [SubjectInfoDTO::class], version = 1)
abstract class MyRoomDatabase: RoomDatabase() {
    abstract val subjectInfoDao: SubjectInfoDao
}

private lateinit var INSTANCE: MyRoomDatabase

fun getDatabase(context: Context): MyRoomDatabase {
    synchronized(MyRoomDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                MyRoomDatabase::class.java,
                "my_room_database").build()
        }
    }
    return INSTANCE
}
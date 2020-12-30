package cl.desafiolatam.desafiodos.orm

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatam.desafiodos.task.TaskDAO
import cl.desafiolatam.desafiodos.task.TaskUIDataHolder

@Database(entities= [TaskUIDataHolder::class],version=1)
abstract class RoomTasks: RoomDatabase(){
    abstract fun getTaskDao():TaskDAO

}

class RoomApplication: Application() {

    companion object {
        var database:RoomTasks? = null

    }
    override fun onCreate(){
        super .onCreate()
        database = Room
                .databaseBuilder( this ,
                        RoomTasks:: class . java ,
                        "tasks-master-db").
                allowMainThreadQueries().
                build()
    }
}
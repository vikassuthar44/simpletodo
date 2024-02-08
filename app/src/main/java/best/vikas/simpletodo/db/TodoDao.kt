package best.vikas.simpletodo.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table")
    fun getAllTodo(): Flow<List<ToDoEntity>>

    @Insert
    fun insert(toDoEntity: ToDoEntity)

    @Delete
    fun delete(toDoEntity: ToDoEntity)

    @Update
    fun update(toDoEntity: ToDoEntity)
}
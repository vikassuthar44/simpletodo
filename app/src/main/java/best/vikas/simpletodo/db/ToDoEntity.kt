package best.vikas.simpletodo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "done")
    val done: Boolean = false,
    @ColumnInfo(name = "dateTime")
    val dateTime: Double = System.currentTimeMillis().toDouble(),
)
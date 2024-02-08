package best.vikas.simpletodo.db

import kotlinx.coroutines.flow.Flow

interface TodoRepo {

    suspend fun getAllTodo(): Flow<List<ToDoEntity>>

    suspend fun insert(toDoEntity: ToDoEntity)

    suspend fun delete(toDoEntity: ToDoEntity)

    suspend fun update(toDoEntity: ToDoEntity)
}
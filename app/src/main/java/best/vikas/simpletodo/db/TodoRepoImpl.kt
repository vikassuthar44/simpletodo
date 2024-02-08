package best.vikas.simpletodo.db

import best.vikas.simpletodo.db.ToDoEntity
import best.vikas.simpletodo.db.TodoDao
import best.vikas.simpletodo.db.TodoRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepoImpl @Inject constructor(
    private val todoDao: TodoDao,
) : TodoRepo {
    override suspend fun getAllTodo(): Flow<List<ToDoEntity>> = todoDao.getAllTodo()

    override suspend fun insert(toDoEntity: ToDoEntity) = todoDao.insert(toDoEntity)

    override suspend fun delete(toDoEntity: ToDoEntity) = todoDao.delete(toDoEntity)

    override suspend fun update(toDoEntity: ToDoEntity) = todoDao.update(toDoEntity)
}
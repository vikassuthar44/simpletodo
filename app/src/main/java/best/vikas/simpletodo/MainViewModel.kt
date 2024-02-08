package best.vikas.simpletodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import best.vikas.simpletodo.db.ToDoEntity
import best.vikas.simpletodo.db.TodoRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val todoRepoImpl: TodoRepoImpl,
) : ViewModel() {

    private val _todos = MutableStateFlow<List<ToDoEntity>>(emptyList())
    val todos = _todos.asStateFlow()

    init {
        getTodos()
    }


    private fun getTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepoImpl.getAllTodo().collect { data ->
                _todos.update { data }
            }
        }
    }

    fun delete(toDoEntity: ToDoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepoImpl.delete(toDoEntity)
        }
    }

    fun insert(toDoEntity: ToDoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepoImpl.insert(toDoEntity)
        }
    }


    fun update(toDoEntity: ToDoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepoImpl.update(toDoEntity)
        }
    }

}
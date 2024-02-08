package best.vikas.simpletodo.di

import android.content.Context
import androidx.room.Room
import best.vikas.simpletodo.db.ToDoDatabase
import best.vikas.simpletodo.db.TodoDao
import best.vikas.simpletodo.db.TodoRepo
import best.vikas.simpletodo.db.TodoRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDB(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(context = context, ToDoDatabase::class.java, "todo_db").build()

    @Provides
    @Singleton
    fun provideDatabaseDao(toDoDatabase: ToDoDatabase) = toDoDatabase.todoDao()

    @Provides
    @Singleton
    fun provideTodoRepoImpl(todoDao: TodoDao): TodoRepo = TodoRepoImpl(todoDao = todoDao)
}
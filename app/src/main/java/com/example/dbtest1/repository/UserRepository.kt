package com.example.dbtest1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.dbtest1.database.UserDatabase
import com.example.dbtest1.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {

    companion object{

        private var userDatabase:UserDatabase? = null
        private fun initializeDB(context: Context):UserDatabase?{
            return UserDatabase.getInstance(context)

        }
        fun insert(context: Context,user: User){
            userDatabase = initializeDB(context)

            CoroutineScope(IO).launch{
                userDatabase?.getDao()?.insert(user)
            }
        }

        fun getAllUserData(context: Context):LiveData<List<User>>?
        {
            userDatabase = initializeDB(context)
            return userDatabase?.getDao()?.getAllUserData()
        }
    }

}
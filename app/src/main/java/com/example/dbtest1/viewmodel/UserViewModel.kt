package com.example.dbtest1.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dbtest1.model.User
import com.example.dbtest1.repository.UserRepository

class UserViewModel:ViewModel() {
    fun insert(context: Context,user: User){
        UserRepository.insert(context,user)
    }

    fun getAllUser(context: Context):LiveData<List<User>>?{
        return UserRepository.getAllUserData(context)
    }
}
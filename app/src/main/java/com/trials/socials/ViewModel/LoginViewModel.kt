package com.trials.socials.ViewModel

import android.util.Log
import retrofit2.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trials.socials.Model.User.UserRequest
import com.trials.socials.Model.User.UserResponse
import com.trials.socials.Retrofit.UserService
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val userService: UserService) : ViewModel() {

    private val _loginResult  = MutableLiveData<Result<Boolean>>();
    init {
        val loginResult : LiveData<Result<Boolean>> = _loginResult ;
    }


    fun login(username: String, password: String){
        val user = UserRequest(username,password);
        userService.login(user).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    _loginResult.value = Result.success(true)
                } else {
                    _loginResult.value = Result.failure(Throwable("Login failed"))
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                _loginResult.value = Result.failure(t)
            }
        })
    }

    companion object {
        fun createFactory(userService: UserService): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                        return LoginViewModel(userService) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    }


}
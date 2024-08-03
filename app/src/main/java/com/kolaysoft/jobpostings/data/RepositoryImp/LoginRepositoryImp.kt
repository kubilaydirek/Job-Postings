package com.kolaysoft.jobpostings.data.RepositoryImp

import android.util.Log
import com.google.gson.Gson
import com.kolaysoft.jobpostings.data.model.register.ApiErrorResponse
import com.kolaysoft.jobpostings.data.model.register.RegisterRequestData
import com.kolaysoft.jobpostings.data.model.register.RegisterResponseData
import com.kolaysoft.jobpostings.data.repository.LoginRepository
import com.kolaysoft.jobpostings.data.service.ApiService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(private val service: ApiService) : LoginRepository {

    override suspend fun register(registerData: RegisterRequestData): Response<RegisterResponseData> {
        return try {
            val result = service.register(registerData)
            if (result.code() == 200) {
                result
            } else {
                val errorBody = result.errorBody()?.string()
                Response.error(result.code(), ResponseBody.create(null, errorBody ?: "Hata içeriği yok"))
            }
        } catch (e: Exception) {
            Log.e("LoginRepositoryImp", "error $e")
            Response.error(500, ResponseBody.create(null, "Beklenmedik bir hata oluştu"))
        }
    }

}
package com.kaboomsanto.mpesaintegration.repository

import com.kaboomsanto.mpesaintegration.api.DarajaApi
import com.kaboomsanto.mpesaintegration.api.RetrofitClient
import com.kaboomsanto.mpesaintegration.model.STKPushRequest
import retrofit2.create

class MpesaRepository {

    private val api = RetrofitClient.instance.create(DarajaApi::class.java)

    suspend fun getAccessToken(auth : String) = api.getAccessToken(auth)

    suspend fun sendSTKPush(auth: String, stkPushRequest: STKPushRequest) = api.sendSTKPush(auth, stkPushRequest)
}
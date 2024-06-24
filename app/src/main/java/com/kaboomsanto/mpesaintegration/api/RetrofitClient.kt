package com.kaboomsanto.mpesaintegration.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Purpose of OkHttpClient
//OkHttpClient is a tool used to make network requests (like accessing web pages or APIs) from an application. In the context of your code, it is used to communicate with the M-Pesa API to perform various actions (like transactions) over the internet.
//
//How OkHttpClient is Useful
//Making HTTP Requests: When your application needs to interact with a web service (like the M-Pesa API), OkHttpClient sends HTTP requests to the service and receives responses.
//Logging: The code includes a logging feature that records the details of these requests and responses. This helps developers see exactly what data is being sent to and received from the API, which is very helpful for debugging.

object RetrofitClient {

    private const val BASE_URL = "https://sandbox.safaricom.co.ke/"


//    This part sets up logging so that every time your app makes a network request, it logs the full details of the request and the response (including headers and body).
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    val instance : Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
            client).build()
    }
}
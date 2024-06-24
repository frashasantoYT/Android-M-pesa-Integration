package com.kaboomsanto.mpesaintegration.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaboomsanto.mpesaintegration.repository.MpesaRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PaymentViewModel: ViewModel() {

    private val repository = MpesaRepository()

    private val _paymentStatus = MutableLiveData<String>()

    val paymentStatus: LiveData<String> get() = _paymentStatus

    private val consumerKey = ""
    private val consumerSecret = ""
    private val businessShortCode = "174379"
    private val passkey = ""
    private val callbackUrl = "https://yourdomain.com/callback"


    private suspend fun getAccessToken(): String? {
        val credentials = "Basic " + android.util.Base64.encodeToString(
            "$consumerKey:$consumerSecret".toByteArray(), android.util.Base64.NO_WRAP
        )

        val response = repository.getAccessToken(credentials)
        return if(response.isSuccessful){
            response.body()?.access_token
    }
        else{
           null
        }

}


    fun initiatePayment(amount: String, phoneNumber: String){
        viewModelScope.launch {
            val accessToken = getAccessToken()

            if(accessToken != null){
                val timestamp = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())
                val password = android.util.Base64.encodeToString("$businessShortCode$passkey$timestamp".toByteArray(), android.util.Base64.NO_WRAP)


                val stkPushRequest = com.kaboomsanto.mpesaintegration.model.STKPushRequest(
                    BusinessShortCode = businessShortCode,
                    Password = password,
                    Timestamp = timestamp,
                    TransactionType = "CustomerPayBillOnline",
                    Amount = amount,
                    PartyA = phoneNumber,
                    PartyB = businessShortCode,
                    PhoneNumber = phoneNumber,
                    CallBackURL = callbackUrl,
                    AccountReference = "AccountReference",
                    TransactionDesc = "Payment Description"

                )

                val response = repository.sendSTKPush("Bearer $accessToken", stkPushRequest)
                if(response.isSuccessful){
                    _paymentStatus.postValue("Payment initiated: ${response.body()?.CustomerMessage}")

                }
                else{
                    _paymentStatus.postValue("Payment initiation failed: ${response.errorBody()?.string()}")
                }
            }
            else{
                _paymentStatus.postValue("Failed to get access token")
            }
        }
    }



}
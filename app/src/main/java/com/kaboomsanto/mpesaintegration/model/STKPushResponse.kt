package com.kaboomsanto.mpesaintegration.model

class STKPushResponse(

val MerchantRequestID: String,
val CheckoutRequestID: String,
val ResponseCode: String,
val ResponseDescription: String,
val CustomerMessage: String
)
package com.kaboomsanto.mpesaintegration

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.kaboomsanto.mpesaintegration.viewmodel.PaymentViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: PaymentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val amountEditText = findViewById<EditText>(R.id.amountEditText)
        val phoneNumberEditText = findViewById<EditText>(R.id.phoneNumberEditText)
        val payButton = findViewById<Button>(R.id.payButton)

        viewModel.paymentStatus.observe(this, Observer { status ->
            Toast.makeText(this, status, Toast.LENGTH_LONG).show()
        })

        payButton.setOnClickListener {
            var amount = amountEditText.text.toString()
            var phoneNumber = phoneNumberEditText.text.toString().trim()

            if (phoneNumber.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please enter your Phone Number",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (amount.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            phoneNumber = formatPhoneNumber(phoneNumber)

            viewModel.initiatePayment(amount, phoneNumber)
        }




    }

    fun formatPhoneNumber(phoneNumber: String): String {
        var formattedNumber = phoneNumber.trim()

        // Remove any leading "+" or "0"
        if (formattedNumber.startsWith("+")) {
            formattedNumber = formattedNumber.substring(1)
        } else if (formattedNumber.startsWith("0")) {
            formattedNumber = formattedNumber.substring(1)
        }


        if (!formattedNumber.startsWith("254")) {
            formattedNumber = "254$formattedNumber"
        }

        return formattedNumber
    }


}
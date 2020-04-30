package com.anoop.multigenesystask.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anoop.multigenesystask.R
import com.anoop.multigenesystask.retrofit.NetworkClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        getHomeData()
    }

    private fun getHomeData() {

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.Main) {

                try {

                    val service = NetworkClient.create()

                    val homeResponse = service.getHomeData()

                    val branchResponse = service.getBranches()

                    if (homeResponse.isSuccessful && branchResponse.isSuccessful) {
                        val homeData = homeResponse.body()!!.data

                        val branchData = branchResponse.body()!!

                        val intent = Intent(this@SplashActivity, DashboardActivity::class.java)
                        intent.putExtra("homeData", homeData)
                        intent.putExtra("branchData", branchData)

                        startActivity(intent)
                        finish()

                    }


                } catch (e: Exception) {

                    Toast.makeText(
                        this@SplashActivity,
                        "Something went wrong...",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }
        }
    }
}

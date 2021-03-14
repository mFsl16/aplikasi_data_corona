package com.faisal.coronaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.viewpager2.widget.ViewPager2
import com.faisal.coronaapp.api.RetrofitInstance
import com.faisal.coronaapp.repo.CountryDetail
import com.faisal.coronaapp.repo.CountryList
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.hide()

        RetrofitInstance.instance.getCountryList().enqueue(object : Callback<CountryList> {
            override fun onResponse(call: Call<CountryList>, response: Response<CountryList>) {
                Log.d("TAG", "onResponse: ${response.body()?.countries?.get(0)?.name}")
            }

            override fun onFailure(call: Call<CountryList>, t: Throwable) {
                Log.e("TAG", "onFailure: failed: ${t.message}" )
            }

        })

        if(savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeFragment>(R.id.view_pager)
            }
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.stats -> {
                    supportFragmentManager.commit {
                        replace<StatsFragment>(R.id.view_pager)
                    }
                    true
                }
                else -> {
                    supportFragmentManager.commit {
                        replace<HomeFragment>(R.id.view_pager)
                    }
                    true
                }
            }
        }
    }
}
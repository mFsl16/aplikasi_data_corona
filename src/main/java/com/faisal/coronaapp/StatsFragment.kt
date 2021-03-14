package com.faisal.coronaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.faisal.coronaapp.api.RetrofitInstance
import com.faisal.coronaapp.repo.CountryDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stats, container, false)
        var country = "indonesia"
        setContent(view, country)

        val searchBtn = view.findViewById<ImageButton>(R.id.search_btn)
        searchBtn.setOnClickListener {
            val te = view.findViewById<EditText>(R.id.teCountry)
            country = te.text.toString()
            setContent(view, country)
        }


        return view
    }

    private fun setContent(view: View, country: String) {
        val name = view.findViewById<AppCompatButton>(R.id.btn_country)
        val kasPosi = view.findViewById<TextView>(R.id.kasus_positif)
        val kasSemb = view.findViewById<TextView>(R.id.kasus_sembuh)
        val kasMeni = view.findViewById<TextView>(R.id.kasus_meni)
        val kasAktif = view.findViewById<TextView>(R.id.kasus_aktif)

        RetrofitInstance.instance.getCounrtyDetail(country).enqueue(object: Callback<ArrayList<CountryDetail>>{
            override fun onResponse(call: Call<ArrayList<CountryDetail>>, response: Response<ArrayList<CountryDetail>>) {
                if (response.body()!!.size > 0) {
                    name.text = response.body()?.get(0)?.countryRegion
                    kasPosi.text = response.body()?.get(0)?.confirmed.toString()
                    kasSemb.text = response.body()?.get(0)?.recovered.toString()
                    kasMeni.text = response.body()?.get(0)?.deaths.toString()
                    kasAktif.text = response.body()?.get(0)?.active.toString()
                } else {
                    Toast.makeText(activity, "Country not found", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<CountryDetail>>, t: Throwable) {
                Toast.makeText(activity, "Failed: ${t.message}", Toast.LENGTH_LONG).show()
            }

        })

    }
}
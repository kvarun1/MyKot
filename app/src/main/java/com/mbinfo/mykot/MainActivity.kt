package com.mbinfo.mykot


import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hadi.retrofitmvvm.util.Resource
import com.mancj.materialsearchbar.MaterialSearchBar
import com.mbinfo.adapter.ImageAdapter
import com.mbinfo.repository.AppRepository
import com.mbinfo.util.errorSnack
import com.mbinfo.viewmodel.PicsViewModel
import com.mbinfo.viewmodel.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PicsViewModel

    // lateinit var picsAdapter: PicsAdapter
    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPermissions()
        init()
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            RECORD_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                }
            }
        }
    }

    private fun init() {
      /*  val searchBar = findViewById(R.id.searchBar) as MaterialSearchBar
        searchBar.setHint("Search..")
        searchBar.setSpeechMode(true)
        //SEARCHBAR TEXT CHANGE LISTENER
        searchBar.addTextChangeListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {

            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
                //SEARCH FILTER


            }

            override fun afterTextChanged(editable: Editable) {

            }
        })

*/

        rvPics.setHasFixedSize(true)
        /*   rvPics.layoutManager = LinearLayoutManager(this)*/
        val gridLayoutManager =
            GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        rvPics.setLayoutManager(gridLayoutManager) //

        // picsAdapter = PicsAdapter()
        setupViewModel()
    }

    private fun setupViewModel() {
        val repository = AppRepository()
        val factory = ViewModelProviderFactory(application, repository)
        viewModel = ViewModelProvider(this, factory).get(PicsViewModel::class.java)
        getPictures()
    }

    private fun getPictures() {
        viewModel.picsData.observe(this, Observer { response ->
            val unit = when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    val fruits = response.data?.icons
                    for (i in 0 until fruits!!.size) {
                        print("${fruits[i]} ")
                        val img = fruits[i].rasterSizes
                        val adapter = img.let { ImageAdapter(it) }
                        rvPics.adapter = adapter
                    }


                }

                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        rootLayout.errorSnack(message, Snackbar.LENGTH_LONG)
                    }

                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        progress.visibility = View.GONE
    }

    private fun showProgressBar() {
        progress.visibility = View.VISIBLE

    }

    fun onProgressClick(view: View) {}
}












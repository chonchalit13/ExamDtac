package th.co.toei.examdtac.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import th.co.toei.examdtac.R
import th.co.toei.examdtac.databinding.ActivityMainBinding
import th.co.toei.examdtac.view.main.adapter.MainAdapter
import th.co.toei.examdtac.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeData()
        initAdapter()
        init()
    }

    private fun observeData() {
        mainViewModel.contactsLiveData.observe(this, Observer {
            mainAdapter.setListData(it)
        })

        mainViewModel.errorLiveData.observe(this, Observer {
            Log.e(TAG, it)
        })
    }

    private fun init() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(inputText: String?): Boolean {
                inputText?.let {
                    mainViewModel.getContactsData(it.toIntOrNull() ?: 1)
                }
                return true
            }

            override fun onQueryTextChange(inputText: String?): Boolean {
                return true
            }
        })
    }

    private fun initAdapter() {
        mainAdapter = MainAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mainAdapter
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
package com.challenger.jokes_challenger_api_clean_archichecture.ui.home

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.challenger.jokes_challenger_api_clean_archichecture.R
import com.challenger.jokes_challenger_api_clean_archichecture.utils.EXPLICIT_KEYWORD
import com.challenger.jokes_challenger_api_clean_archichecture.utils.JOKES_DEFAULT_NUMBER
import com.challenger.jokes_challenger_api_clean_archichecture.utils.Resource
import com.challenger.jokes_challenger_api_clean_archichecture.viewmodels.JokesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import rx.Subscription


private const val TAG = "HomeActivity"

class HomeActivity : AppCompatActivity() {
    private val jokesViewModel: JokesViewModel by viewModel()
    private lateinit var jokesAdapter: JokeItemAdapter
    private var subscriptionSearh: Subscription? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
        initObservers()
        initAdapter()
        iniRecyclerView()
        bringJokesDefault()
    }


    private fun bringJokesDefault() {
        jokesViewModel.getJokes(JOKES_DEFAULT_NUMBER, "")
    }


    private fun initAdapter() {
        jokesAdapter = JokeItemAdapter()
    }

    private fun iniRecyclerView() {
        jokes_list_recyclerview.apply {
            adapter = jokesAdapter
        }
    }

    private fun initObservers() {
        jokesViewModel.get_jokes_random.observe(this, Observer { result ->
            Log.i(TAG, result.javaClass.name)
            when (result) {
                is Resource.Success -> {
                    jokesAdapter.submitList(result.result)
                    hideProgressBar()
                }

                is Resource.Error -> {

                    hideProgressBar()
                }

                is Resource.Loading -> {

                    showProgressBar()
                }

            }

        })
    }


    private fun openDraweLayout() {
        drawer_layout.openDrawer(Gravity.RIGHT)

    }


    private fun closeDraweLayout() {
        drawer_layout.closeDrawers()

    }

    private fun initListeners() {
        menu_imageview.setOnClickListener {
            openDraweLayout()
        }

        filter_button.setOnClickListener {
            val numJokes = num_jokes_id_edittext.text.toString()
            val filterExplicit = if (explicit_swicth.isChecked) EXPLICIT_KEYWORD else ""
            closeDraweLayout()
            if (numJokes != "") {
                jokesViewModel.getJokes(numJokes.toInt(), filterExplicit)
            } else {
                jokesViewModel.getJokes(JOKES_DEFAULT_NUMBER, filterExplicit)
            }

        }
    }


    private fun showProgressBar() {
        progressbar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressbar.visibility = View.GONE

    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptionSearh?.unsubscribe()
    }
}
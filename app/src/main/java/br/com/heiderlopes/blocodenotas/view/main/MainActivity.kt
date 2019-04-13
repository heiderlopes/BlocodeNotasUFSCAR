package br.com.heiderlopes.blocodenotas.view.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import br.com.heiderlopes.blocodenotas.R
import br.com.heiderlopes.blocodenotas.model.Nota

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.loading.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        mainViewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        registerObservers()

        mainViewModel.buscarTodos()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun registerObservers() {
        mainViewModel.isLoading.observe(this, isLoadingObserver)
        mainViewModel.mensagemErro.observe(this, mensagemErroObserver)
        mainViewModel.notas.observe(this, notasObserver)
    }

    private var notasObserver = Observer<List<Nota>> {

    }

    private var mensagemErroObserver = Observer<String> {
        if(it!!.isNotEmpty()) {
            Toast.makeText(this,
                it, Toast.LENGTH_LONG).show()
        }
    }

    private var isLoadingObserver = Observer<Boolean> {
        if(it == true) {
            containerLoading.visibility = View.VISIBLE
        } else {
            containerLoading.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

package com.example.bangladictionarydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bangladictionarydemo.Database_Maintain.DictionaryViewModel
import com.example.bangladictionarydemo.Fragments.FavoriteFragment
import com.example.bangladictionarydemo.Fragments.HistoryFragment
import com.example.bangladictionarydemo.Fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var wordAdapter: WordAdapter
    private lateinit var navController: NavController
    private lateinit var dictionaryViewModel: DictionaryViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarId)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.findNavController()
       /* appBarConfiguration = AppBarConfiguration(navController.graph, null)
        setupActionBarWithNavController(navController, appBarConfiguration)*/

        setupActionBarWithNavController(navController)


        /* dictionaryViewModel = ViewModelProvider(this).get(DictionaryViewModel::class.java)
         recyclerview.layoutManager = LinearLayoutManager(this)
         wordAdapter = WordAdapter()
         recyclerview.adapter = wordAdapter
         dictionaryViewModel.readAllData.observe(this , Observer{word ->
             Log.e("MyTag", "onCreate: $word", )
             wordAdapter.setData(word)
         })
         WordSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
             override fun onQueryTextSubmit(query: String?): Boolean {
                 return true
             }

             override fun onQueryTextChange(query: String?): Boolean {
                 if (query != null) {
                     searchWord(query)
                 }
                 return true
             }

         })*/

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == navController.currentDestination?.id) return true

        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favoriteFragment -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, FavoriteFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setReorderingAllowed(true).commit()
            }
            R.id.homeFragment -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, HomeFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setReorderingAllowed(true).commit()
            }
            R.id.historyFragment -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, HistoryFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setReorderingAllowed(true).commit()
            }
        }
        return true
    }*/

    /* private fun searchWord(query: String) {
         val searchQuery = "%$query%"
         dictionaryViewModel.searchWord(searchQuery).observe(this, { list ->
             list.let {
                 wordAdapter.setData(it)
             }
         })
     }*/
}
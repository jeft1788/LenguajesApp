package com.example.mireckycler2

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mireckycler2.adapter.RecyclerViewAdapter
import com.example.mireckycler2.data.DataSource
import com.example.mireckycler2.model.RecyclerData


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var dataSource : DataSource
    private lateinit var dataset: ArrayList<RecyclerData>
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataset = ArrayList<RecyclerData>()
        val myDataset = DataSource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.idCourseRV)
        //LinearLayout sin columnas
        //val layoutManager = LinearLayoutManager(this)
        //Gridlaoyout con 2 columnas
        val layoutManager = GridLayoutManager(this, 2)
        //LinearLayout Manager para hacer el recycler Hortizontal
        //val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = RecyclerViewAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        // set the top title val title = actionBar.getTitle().toString() // get the title actionBar.hide() // or even hide the actionbar
        /*val buscar = findViewById<SearchView>(R.id.search)
        buscar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // collapse the view ?
                //menu.findItem(R.id.menu_search).collapseActionView();
                Log.e("queryText", query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // search goes here !!
                //recyclerView.adapter.getFilter().filter(newText);
                //dataset.filter { recyclerData -> recyclerData.equals(newText) }

                Log.e("queryText", newText)
                return false
            }
        })        /*0buscar.setOnQueryTextFocusChangeListener { view, b ->
            Log.i("aris",b.toString())
        }*/*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        var item: MenuItem = menu!!.findItem(R.id.search)
        if (item != null){
            var searchView = item.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filter(newText)
                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    fun filter(text: String?){
        val filteredlist: ArrayList<RecyclerData> = ArrayList<RecyclerData>()
        for (item in dataset) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.stringResourceId.toString().lowercase().contains(attr.text.toString().lowercase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist)
        }

    }


   

}
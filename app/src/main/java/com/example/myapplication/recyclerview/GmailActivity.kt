package com.example.myapplication.recyclerview

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.recyclerview.adapters.ContactsAdapter
import com.example.myapplication.recyclerview.adapters.GmailAdapter
import com.example.myapplication.databinding.ActivityGmailBinding
import com.example.myapplication.recyclerview.fragment.ContactBottomSheet
import com.example.myapplication.recyclerview.models.DataSource
import com.example.myapplication.recyclerview.util.DebounceSearchHandler
import com.example.myapplication.recyclerview.util.SwipeToDeleteGmailCallback

class GmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGmailBinding
    private lateinit var adapterMail: GmailAdapter
    private lateinit var adapterContacts: ContactsAdapter
    private val debounceSearchHandler = DebounceSearchHandler(1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialSetup()
    }

    private fun initialSetup() {
        setupMailRecyclerView()
        setupContactsRecyclerView()
        setupMailItemDecoration()
        swipeToDeleteItem()
        setupSearching()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuContacts -> {
                setupBottomSheet()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBottomSheet() {
        val bottomSheet = ContactBottomSheet()
        bottomSheet.show(supportFragmentManager, "BottomSheetDialog")
    }

    private fun setupSearching() {
        binding.searchViewGmail.setOnQueryTextListener(object : OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("TAG", "onQueryTextSubmit: $query")
                query?.let { adapterMail.filterData(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    debounceSearchHandler.debounceSearch(newText) {
                        Log.d("TAG", "onQueryTextChange: $it")
                        adapterMail.filterData(it)
                    }
                }
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_view, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.menuSearch)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setIconifiedByDefault(true)
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d("TAG", "onQueryTextSubmit: ")
                    adapterContacts.filter(query)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.d("TAG", "onQueryTextChange: ")
                    adapterContacts.filter(newText)
                    return false
                }
            })
        }
        return true
    }

    private fun setupMailAdapter() {
        val listData = DataSource().getExpandableMails()
        adapterMail = GmailAdapter(listData)
    }

    private fun setupContactsAdapter() {
        val contacts = DataSource().getMailContacts()
        adapterContacts = ContactsAdapter(contacts)
    }

    private fun setupMailRecyclerView() {
        setupMailAdapter()
        binding.recyclerViewGmail.apply {
            adapter = this@GmailActivity.adapterMail
        }
    }

    private fun setupMailItemDecoration() {
        val decorationDrawable = ResourcesCompat.getDrawable(resources, R.drawable.divider, null)
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        dividerItemDecoration.setDrawable(decorationDrawable ?: return)
        binding.recyclerViewGmail.addItemDecoration(dividerItemDecoration)
    }

    private fun setupContactsRecyclerView() {
        setupContactsAdapter()
        binding.recyclerViewContacts.apply {
            adapter = adapterContacts
        }
    }

    private fun swipeToDeleteItem() {
        if (::adapterMail.isInitialized) {
            val touchHelper = ItemTouchHelper(
                SwipeToDeleteGmailCallback(
                    adapterMail,
                    binding.recyclerViewGmail,
                    this
                )
            )
            touchHelper.attachToRecyclerView(binding.recyclerViewGmail)
        }
    }
}
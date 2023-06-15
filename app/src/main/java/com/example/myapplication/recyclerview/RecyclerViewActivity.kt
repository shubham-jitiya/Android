package com.example.myapplication.recyclerview

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.recyclerview.adapters.FoldersAdapter
import com.example.myapplication.databinding.ActivityRecyclerViewBinding
import com.example.myapplication.recyclerview.models.DataSource
import com.example.myapplication.recyclerview.util.FolderLookup

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private var tracker: SelectionTracker<Long>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val folderDetails = DataSource().getFolderDetails()
        val recyclerViewFolders = binding.recyclerViewFolders
        val adapter = FoldersAdapter(folderDetails)

        recyclerViewFolders.layoutManager = LinearLayoutManager(this)
        recyclerViewFolders.adapter = adapter

        tracker = SelectionTracker.Builder<Long>(
            "selection-1",
            recyclerViewFolders,
            StableIdKeyProvider(recyclerViewFolders),
            FolderLookup(recyclerViewFolders),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        tracker?.addObserver(object : SelectionTracker.SelectionObserver<Long>() {
            override fun onSelectionChanged() {
                val selectedItems = tracker?.selection?.size()
                if (selectedItems != null && selectedItems > 0) {
                    title = "$selectedItems items selected"
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#ef6c00")))
                } else {
                    title = resources.getString(R.string.app_name)
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_500)))
                }
            }
        })

        if (savedInstanceState != null) {
            tracker?.onRestoreInstanceState(savedInstanceState)
        }

        adapter.setTracker(tracker)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.folder_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuDeselect -> {
                val isCleared = tracker?.clearSelection() ?: false
                Log.d("TAG", "onOptionsItemSelected: $isCleared")
                return false
            }
            R.id.menuGrid -> {
                binding.recyclerViewFolders.layoutManager = GridLayoutManager(this, 2)
                return false
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        tracker?.onSaveInstanceState(outState)
    }
}
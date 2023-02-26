package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),IAdapyer {
    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler=findViewById<RecyclerView>(R.id.recycle)
        recycler.layoutManager =LinearLayoutManager(this)
        val adapter =Newadaper(this,this)
        recycler.adapter=adapter
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(ViewModel::class.java)
        viewModel.allData.observe(this, Observer {list->
            list?.let {
                adapter.update(it)
            }

        })

    }

    override fun onItemListner(word: Word) {

          viewModel.delete(word)
    }

    fun submit(view: View) {
        val text =findViewById<EditText>(R.id.editText)
        val noteText =text.text.toString()
        if (noteText.isNotEmpty()){
            viewModel.insert(Word(noteText))
        }
    }
}
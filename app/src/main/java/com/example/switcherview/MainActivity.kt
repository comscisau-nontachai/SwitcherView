package com.example.switcherview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import pl.aprilapps.switcher.Switcher

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    lateinit var switcher: Switcher
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         switcher = Switcher.Builder(this)
            .addContentView(findViewById(R.id.content))
            .addProgressView(findViewById(R.id.loading_view))
            .addErrorView(findViewById(R.id.error_view))
            .addEmptyView(findViewById(R.id.empty_view))
            .build()

        btnContent.setOnClickListener(this)
        btnEmpty.setOnClickListener(this)
        btnProgress.setOnClickListener(this)
        btnError.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnContent ->{
               switcher.showContentView()
            }
            R.id.btnProgress ->{
                switcher.showProgressView()
            }
            R.id.btnError -> {
                switcher.showErrorView()
            }
            R.id.btnEmpty -> {
                switcher.showEmptyView()
            }
        }
    }
}

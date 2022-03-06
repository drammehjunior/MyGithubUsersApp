package com.example.mygithubview

import android.app.ActivityOptions
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGithub: RecyclerView
    private val list = ArrayList<Github>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGithub = findViewById(R.id.rv_githubUsers)
        rvGithub.setHasFixedSize(true)

        list.addAll(listGithub)
        showRecyclerList()
    }

    private val listGithub: ArrayList<Github>
        get(){
            with(resources){
                val dataName = getStringArray(R.array.name)
                val dataUsername = getStringArray(R.array.username)
                val dataPhoto = obtainTypedArray(R.array.avatar)
                val dataLocation = getStringArray(R.array.location)
                val dataRepository = getStringArray(R.array.repository)
                val dataCompany = getStringArray(R.array.company)
                val dataFollowers = getStringArray(R.array.followers)
                val dataFollowing = getStringArray(R.array.following)

            val githubList = ArrayList<Github>()
            for(i in dataName.indices){
                val github = Github(dataName[i],dataUsername[i],dataPhoto.getResourceId(i, -1),dataLocation[i],dataRepository[i],dataCompany[i],dataFollowers[i],dataFollowing[i])
                githubList.add(github)
            }
            return githubList
        }}

    private fun showRecyclerList(){

        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            rvGithub.layoutManager = GridLayoutManager(this, 2)
        }else{
            rvGithub.layoutManager = LinearLayoutManager(this)
        }
        val listGithubAdapter = ListGithubAdapter(list)
        rvGithub.adapter = listGithubAdapter

        listGithubAdapter.setOnItemClickCallback(object : ListGithubAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Github) {
                val intentToDetail = Intent(this@MainActivity, UserDetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity)
                startActivity(intentToDetail, options.toBundle())
            }
        })
    }
}
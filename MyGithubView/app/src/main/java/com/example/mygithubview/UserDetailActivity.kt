package com.example.mygithubview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mygithubview.databinding.ActivityMainBinding
import com.example.mygithubview.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Github>("DATA")
        Log.d("Detail Data", data?.name.toString())
        data?.avatar?.let { binding.imgItemPhoto.setImageResource(it) }

        with(binding){
            userName.text= data?.name
            userUsername.text = data?.username
            userLocation.text = data?.location
            userCompany.text = data?.company
            userFollower.text = data?.followers
            userFollowing.text = data?.following
            userRepository.text = data?.repository
        }
    }
}
package com.example.user.garbarinotest.home.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.user.garbarinotest.R
import com.example.user.garbarinotest.adapters.AdapterPosts
import com.example.user.garbarinotest.models.PostItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this,2)

        var itemsShop = (0..20).map {
            PostItem(
                "ljkasdjklña$it",
                "Smart TV LG 43Smart TV LG 43Smart TV LG 43Smart TV LG 43",
                "d3lfzbr90tctqz.cloudfront.net/epi/resource/r/smart-tv-lg-43-4k-ultra-hd-43uj6560/ea1ad44603acda220729bbbb8afc70c2feb381f32044ccc0a02383242c34142f",
                5000,
                10000,
                it
            )
        }

        val adapter = AdapterPosts(itemsShop)

        recyclerView.adapter = adapter

    }
}

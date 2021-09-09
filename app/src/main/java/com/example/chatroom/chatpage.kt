package com.example.chatroom


import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.chatroom.SearchFragment
import com.example.chatroom.chatFragment
import com.example.chatroom.SettingsFragment
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pagechat.*

class chatpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagechat)

        setSupportActionBar(toolbar_main)

        val toolbar:Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        var tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addfragment(chatFragment(), "Chats")
        viewPagerAdapter.addfragment(SearchFragment(), "Search")
        viewPagerAdapter.addfragment(SettingsFragment(), "Settings")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }




    internal class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
        private val fragments: ArrayList<Fragment> = ArrayList<Fragment>()
        private val titles: ArrayList<String> = ArrayList<String>()

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        fun addfragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

    }

}
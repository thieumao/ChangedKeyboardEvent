package com.thieumao.changedkeyboardevent

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            setFragment(MainFragment.newInstance())
        }
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = this.getFragmentManager().beginTransaction()
        transaction.add(R.id.content_main, fragment, fragment.hashCode().toString())
        transaction.commit()
    }
}

package com.ksv.navgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.ksv.navgraph.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mainMenu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbar)

//        supportFragmentManager.commit {
//            replace<BaseFragment>(binding.fragmentContainer.id)
//        }

        supportFragmentManager.addOnBackStackChangedListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        mainMenu = menu
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return super.onOptionsItemSelected(item)
        return when(item.itemId){
            R.id.alpha_menu_button -> {
                supportFragmentManager.commit{
                    replace<AlphaFragment>(binding.fragmentContainer.id, ALPHA_FRAGMENT_TAG)
                    addToBackStack(AlphaFragment::class.java.name)

                }
                true
            }
            R.id.vtb_menu_button -> {
                supportFragmentManager.commit{
                    replace<VtbFragment>(binding.fragmentContainer.id, VTB_FRAGMENT_TAG)
                    addToBackStack(VtbFragment::class.java.name)
                }
                true
            }
            R.id.sber_menu_button -> {
                supportFragmentManager.commit{
                    replace<SberFragment>(binding.fragmentContainer.id, SBER_FRAGMENT_TAG)
                    addToBackStack(SberFragment::class.java.name)
                }
                true
            }
            R.id.tbank_menu_button -> {
                supportFragmentManager.commit{
                    replace<TBankFragment>(binding.fragmentContainer.id, TBANK_FRAGMENT_TAG)
                    addToBackStack(TBankFragment::class.java.name)
                }
                true
            }
            else -> false
        }
    }

    companion object{
        private const val SBER_FRAGMENT_TAG = "SBER_FRAGMENT"
        private const val VTB_FRAGMENT_TAG = "VTB_FRAGMENT"
        private const val TBANK_FRAGMENT_TAG = "TBANK_FRAGMENT"
        private const val ALPHA_FRAGMENT_TAG = "ALPHA_FRAGMENT"
    }
}
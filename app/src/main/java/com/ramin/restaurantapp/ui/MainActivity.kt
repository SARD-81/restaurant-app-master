package com.ramin.restaurantapp.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageButton
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.ramin.restaurantapp.R
import com.ramin.restaurantapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val preferences by lazy {
        getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val isDarkMode = preferences.getBoolean(KEY_DARK_MODE, true)
        AppCompatDelegate.setDefaultNightMode(
            if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val themeItem = menu.findItem(R.id.action_theme)
        val themeSwitch = themeItem.actionView?.findViewById<SwitchMaterial>(R.id.themeSwitch)
            ?: return true
        val isDarkMode = preferences.getBoolean(KEY_DARK_MODE, true)
        themeSwitch.setOnCheckedChangeListener(null)
        themeSwitch.isChecked = isDarkMode
        updateThemeSwitchText(themeSwitch, isDarkMode)
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            updateThemeSwitchText(themeSwitch, isChecked)
            preferences.edit().putBoolean(KEY_DARK_MODE, isChecked).apply()
            AppCompatDelegate.setDefaultNightMode(
                if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_liked -> {
                navController.navigate(R.id.likedFoodsFragment)
                true
            }
            R.id.action_saved -> {
                navController.navigate(R.id.savedFoodsFragment)
                true
            }
            R.id.action_about -> {
                navController.navigate(R.id.aboutFragment)
                true
            }
            R.id.action_map -> {
                navController.navigate(R.id.mapFragment)
                true
            }
            R.id.action_call -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:02191009100"))
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateThemeToggle(button: AppCompatImageButton, isDarkMode: Boolean) {
        val labelRes = if (isDarkMode) {
            R.string.theme_toggle_light
        } else {
            R.string.theme_toggle_dark
        }
        val iconRes = if (isDarkMode) {
            R.drawable.ic_theme_light
        } else {
            R.drawable.ic_theme_dark
        }
        button.setImageResource(iconRes)
        button.contentDescription = getString(labelRes)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object {
        private const val PREFS_NAME = "restaurant_preferences"
        private const val KEY_DARK_MODE = "dark_mode_enabled"
    }
}

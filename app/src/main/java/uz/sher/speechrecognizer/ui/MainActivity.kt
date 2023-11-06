package uz.sher.speechrecognizer.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.databinding.ActivityMainBinding
import uz.sher.speechrecognizer.ui.analysis.AnalysisMenuFragment
import uz.sher.speechrecognizer.ui.menu.IntroMenuFragment
import uz.sher.speechrecognizer.ui.menu.MenuFragment
import uz.sher.speechrecognizer.ui.splash.SplashFragment
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.ANALYSIS_MENU
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.ANALYSIS_SPEECH
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.HEAR
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.INTRO_MENU
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.MENU
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.PRONUNCIATION


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SplashFragment())
            .commit()

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val tagFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)?.tag
        if (!tagFragment.isNullOrEmpty())
            setFragmentClickBackPressed(tagFragment)
        else super.onBackPressed()

    }

    private fun setFragmentClickBackPressed(tag: String) {
        when (tag) {
            ANALYSIS_SPEECH -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, AnalysisMenuFragment(), ANALYSIS_MENU).commit()
            }
            ANALYSIS_MENU, HEAR, PRONUNCIATION -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, MenuFragment(), MENU).commit()
            }

            MENU -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, IntroMenuFragment(), INTRO_MENU).commit()
            }
            INTRO_MENU -> {
                finish()
            }
            else -> {
                finish()
            }
        }
    }


}
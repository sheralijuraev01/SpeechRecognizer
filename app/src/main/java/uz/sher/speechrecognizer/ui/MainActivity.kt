package uz.sher.speechrecognizer.ui


import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallState
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManagerFactory
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
    private var appUpdateManager: AppUpdateManager? = null

    private val REQUEST_CODE = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appUpdateManager = AppUpdateManagerFactory.create(applicationContext)

        checkForUpdates()
        showFeedbackDialog()
        appUpdateManager!!.registerListener(
            installStateUpdatedListener
        )


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


    private var installStateUpdatedListener =
        InstallStateUpdatedListener { installState: InstallState ->
            if (installState.installStatus() == InstallStatus.DOWNLOADED) {
                Toast.makeText(
                    this,
                    "Downloaded, Restart the app in 5 seconds",
                    Toast.LENGTH_SHORT
                ).show()
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({ appUpdateManager!!.completeUpdate() }, 5000)
//            showCompletedUpdate();
            }
        }

    private fun showFeedbackDialog() {
        val reviewManager = ReviewManagerFactory.create(this)
        reviewManager.requestReviewFlow().addOnCompleteListener { it: Task<ReviewInfo?> ->
            if (it.isSuccessful) {
                reviewManager.launchReviewFlow(this, it.result!!)
            }
        }
    }

    private fun checkForUpdates() {
        appUpdateManager!!.appUpdateInfo.addOnSuccessListener { info: AppUpdateInfo ->
            val isUpdateAvailable =
                info.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
            val isUpdateAllowed = info.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)
            if (isUpdateAvailable && isUpdateAllowed) {
                try {
                    appUpdateManager!!.startUpdateFlowForResult(
                        info,
                        AppUpdateType.FLEXIBLE,
                        this,
                        REQUEST_CODE
                    )
                } catch (e: IntentSender.SendIntentException) {
                    throw RuntimeException(e)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                Toast.makeText(this, "Nimadir xato ketdi", Toast.LENGTH_SHORT).show()
                Log.e("Error", "Nimadir xato ketdi")
            }
        }
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

    override fun onDestroy() {
        super.onDestroy()
        appUpdateManager!!.unregisterListener(installStateUpdatedListener)
    }


}
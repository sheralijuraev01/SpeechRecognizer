package uz.sher.speechrecognizer.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.databinding.FragmentSplashBinding
import uz.sher.speechrecognizer.ui.menu.IntroMenuFragment
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.INTRO_MENU


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return _binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countDownTimer = object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                parentFragmentManager.beginTransaction().replace(
                    R.id.fragmentContainer,
                    IntroMenuFragment(),
                    INTRO_MENU
                ).commit()
            }


        }.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
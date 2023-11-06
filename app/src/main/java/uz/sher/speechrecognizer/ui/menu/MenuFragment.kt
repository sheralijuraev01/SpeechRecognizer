package uz.sher.speechrecognizer.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.databinding.FragmentMenuBinding
import uz.sher.speechrecognizer.ui.analysis.AnalysisMenuFragment
import uz.sher.speechrecognizer.ui.hear.HearFragment
import uz.sher.speechrecognizer.ui.pronunciation.PronunciationFragment
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.ANALYSIS_MENU
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.HEAR
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.INTRO_MENU
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.PRONUNCIATION


class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.neuroContainer.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AnalysisMenuFragment(), ANALYSIS_MENU).commit()
        }
        binding.hearContainer.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HearFragment(), HEAR).commit()
        }

        binding.pronunciationContainer.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, PronunciationFragment(), PRONUNCIATION).commit()
        }

        binding.menuBackArrowIcon.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, IntroMenuFragment(), INTRO_MENU).commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
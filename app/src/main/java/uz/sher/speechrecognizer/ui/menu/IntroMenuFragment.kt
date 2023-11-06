package uz.sher.speechrecognizer.ui.menu

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.databinding.FragmentIntroMenuBinding
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.MENU


class IntroMenuFragment : Fragment() {
    private var _binding: FragmentIntroMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIntroMenuBinding.inflate(inflater, container, false)

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAnimation()
        binding.startBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MenuFragment(), MENU).commit()
        }

        binding.aboutApp.setOnClickListener{
            aboutApp()
        }


        binding.exitBtn.setOnClickListener {
            activity?.finish()
        }
    }

    private fun aboutApp() {
        val dialog = AlertDialog.Builder(binding.root.context).create()
        val view = layoutInflater.inflate(R.layout.about_app, null)
        dialog.setView(view)
        dialog.show()

        val cancel = view.findViewById<TextView>(R.id.btn_cancel_dialog)
        cancel.setOnClickListener {
            dialog.dismiss()
        }
    }


    private fun loadAnimation(){
        val animation1 = AnimationUtils.loadAnimation(binding.root.context, R.anim.lefttorightextra)
        val animation2 = AnimationUtils.loadAnimation(binding.root.context, R.anim.righttoleftextra)
        binding.startBtn.startAnimation(animation1)
//        binding.informationBtn.startAnimation(animation2)
        binding.aboutApp.startAnimation(animation2)
        binding.exitBtn.startAnimation(animation1)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
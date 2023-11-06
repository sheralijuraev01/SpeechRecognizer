package uz.sher.speechrecognizer.ui.analysis

import android.annotation.SuppressLint
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.adapters.MenuExpandableAdapter
import uz.sher.speechrecognizer.data.analysis_data.MenuAnalysis
import uz.sher.speechrecognizer.databinding.FragmentMenuAnalysisBinding
import uz.sher.speechrecognizer.model.analysis_speech.ChildExpandable
import uz.sher.speechrecognizer.model.analysis_speech.ParentExpandable
import uz.sher.speechrecognizer.ui.menu.MenuFragment
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.ANALYSIS_SPEECH
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.MENU


class AnalysisMenuFragment : Fragment(), MenuExpandableAdapter.OnUserClickListener {
    private var _binding: FragmentMenuAnalysisBinding? = null
    private val binding get() = _binding!!
    private lateinit var menuExpandableAdapter: MenuExpandableAdapter
    private var titleList: MutableList<ParentExpandable> = ArrayList()
    private lateinit var dataList: MenuAnalysis
    private var childList: MutableList<MutableList<ChildExpandable>> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuAnalysisBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        menuExpandableAdapter = MenuExpandableAdapter(requireContext(), titleList, childList)

        solutionIOIcon()
        binding.expandableView.setAdapter(menuExpandableAdapter)
        menuExpandableAdapter.setonUserClickListener(this)

        binding.menuAnalysisBack.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(
                R.id.fragmentContainer, MenuFragment(),
                MENU
            ).commit()
        }

    }

    fun initList() {

        dataList = MenuAnalysis()
        titleList = dataList.getParentData()
        childList = dataList.getChildData()

    }

    @SuppressLint("ObsoleteSdkInt")
    fun solutionIOIcon() {
        val display = requireActivity().windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x
        val r = resources
        val px =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50f, r.displayMetrics).toInt()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            binding.expandableView.setIndicatorBounds(width - px, width)
        } else {
            binding.expandableView.setIndicatorBoundsRelative(width - px, width)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onUserClickListener(parentPosition: Int, childPosition: Int) {
        //        Toast.makeText(this@MenuActivity,childList[parentPosition][childPosition].childText,Toast.LENGTH_SHORT).show()
        val name = childList[parentPosition][childPosition].childText
        parentFragmentManager.beginTransaction().replace(
            R.id.fragmentContainer,
            AnalysisSpeechFragment.newInstance(name),
            ANALYSIS_SPEECH
        ).commit()
    }
}
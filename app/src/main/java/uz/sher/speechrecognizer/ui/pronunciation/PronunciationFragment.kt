package uz.sher.speechrecognizer.ui.pronunciation

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.adapters.PronounciationAdapter
import uz.sher.speechrecognizer.data.PronunciationData
import uz.sher.speechrecognizer.databinding.FragmentPronunciatonBinding
import uz.sher.speechrecognizer.model.Pronunciation
import uz.sher.speechrecognizer.ui.menu.MenuFragment
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.MENU


class PronunciationFragment : Fragment(), PronounciationAdapter.OnClickAdapterItemListener {
    private var _binding: FragmentPronunciatonBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PronounciationAdapter
    private lateinit var list: MutableList<Pronunciation>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPronunciatonBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = PronunciationData.getPronunciationData()
        adapter = PronounciationAdapter(list)
        binding.pronunciationRcView.adapter = adapter

        adapter.setOnclikcListener(this)

        binding.backArrow.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MenuFragment(), MENU).commit()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClickItem(position: Int) {
        openDialog(position)
    }

    @SuppressLint("MissingInflatedId")
    private fun openDialog(position: Int) {
        val pronItem = list[position]
        val dialog = AlertDialog.Builder(binding.root.context).create()
        val view = layoutInflater.inflate(R.layout.pronunciation_dialog, null)

        dialog.setView(view)
        dialog.show()

        val cancel = view.findViewById<TextView>(R.id.dialog_cancel)
        val title = view.findViewById<TextView>(R.id.dialog_title)
        val body = view.findViewById<TextView>(R.id.dialogBody)
        val icon = view.findViewById<ImageView>(R.id.dialogImage)

        title.text = pronItem.title
        body.text = pronItem.body
        icon.setImageResource(pronItem.image)


        cancel.setOnClickListener {
            dialog.dismiss()
        }


    }


}
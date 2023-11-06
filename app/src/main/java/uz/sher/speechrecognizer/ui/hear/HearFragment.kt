package uz.sher.speechrecognizer.ui.hear

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.data.hear_data.HearData
import uz.sher.speechrecognizer.databinding.FragmentHearBinding
import uz.sher.speechrecognizer.model.hear_model.Hear
import uz.sher.speechrecognizer.ui.menu.MenuFragment
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.MENU


class HearFragment : Fragment(), OnClickListener {
    private var _binding: FragmentHearBinding? = null
    private val binding get() = _binding!!
    private var listsHear: MutableList<Hear> = ArrayList()
    private var currentIndex = 0;
    private lateinit var answerTag: String
    private   var sound= MediaPlayer()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHearBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListHear()
        setQuestions(currentIndex)
        setDefaultAnswerBackground()
        binding.soundBtn.setOnClickListener{
            if (currentIndex != listsHear.size){
                startMedia(currentIndex)
            }
        }


        binding.nextSoundBtn.setOnClickListener {
            if(currentIndex+2==listsHear.size){
                Toast.makeText(binding.root.context,"Mashqlar tugadi!!!",Toast.LENGTH_SHORT).show()
              binding.nextSoundBtn.text="Menuga qaytish"

                setDefaultAnswerBackground()
                binding.hearDoneIcon.visibility = View.INVISIBLE
                setQuestions(++currentIndex)

            }
            else if (currentIndex + 1 != listsHear.size) {
                setDefaultAnswerBackground()
                binding.hearDoneIcon.visibility = View.INVISIBLE
                setQuestions(++currentIndex)

            }else{
                parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,MenuFragment()).commit()
            }
        }

        binding.hearBackArrow.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,MenuFragment(),MENU).commit()
        }


        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)


    }

    private fun startMedia(index: Int) {
        if(!sound.isPlaying){
            sound=MediaPlayer.create(binding.root.context,listsHear[index].voice)
            sound.start()

            binding.hearDoneIcon.visibility=View.INVISIBLE
        }

    }


    private fun setQuestions(index: Int) {
        binding.option1.setBackgroundResource(listsHear[index].option1)
        binding.option2.setBackgroundResource(listsHear[index].option2)
        binding.option3.setBackgroundResource(listsHear[index].option3)
        binding.option4.setBackgroundResource(listsHear[index].option4)
        answerTag = listsHear[index].answerTag
    }

    private fun initListHear() {
        listsHear.addAll(HearData.getHearData())
        listsHear.shuffle()

    }

    override fun onDestroy() {
        super.onDestroy()
        sound.release()
        _binding = null
    }

    override fun onClick(v: View?) {
        val tag = v?.tag.toString()
        binding.hearDoneIcon.visibility = View.VISIBLE
        if (tag == answerTag){
            binding.hearDoneIcon.setBackgroundResource(R.drawable.done)
            setCorrectAnswerBackground(tag.toInt())
        }else{
             binding.hearDoneIcon.setBackgroundResource(R.drawable.error)
            setErrorAnswerBackground(tag.toInt())
        }
    }

    private fun setCorrectAnswerBackground(state:Int){
        when(state){
            1->{
                binding.option1Container.setBackgroundResource(R.drawable.corrext_bg)
                binding.option2Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option3Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option4Container.setBackgroundResource(R.drawable.deafult_bg)
            }
            2->{
                binding.option1Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option2Container.setBackgroundResource(R.drawable.corrext_bg)
                binding.option3Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option4Container.setBackgroundResource(R.drawable.deafult_bg)
            }
            3->{
                binding.option1Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option2Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option3Container.setBackgroundResource(R.drawable.corrext_bg)
                binding.option4Container.setBackgroundResource(R.drawable.deafult_bg)
            }
            4->{
                binding.option1Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option2Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option3Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option4Container.setBackgroundResource(R.drawable.corrext_bg)
            }
        }

    }
    private fun setErrorAnswerBackground(state:Int){
        when(state){
            1->{
                binding.option1Container.setBackgroundResource(R.drawable.error_bg)
                binding.option2Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option3Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option4Container.setBackgroundResource(R.drawable.deafult_bg)
            }
            2->{
                binding.option1Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option2Container.setBackgroundResource(R.drawable.error_bg)
                binding.option3Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option4Container.setBackgroundResource(R.drawable.deafult_bg)
            }
            3->{
                binding.option1Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option2Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option3Container.setBackgroundResource(R.drawable.error_bg)
                binding.option4Container.setBackgroundResource(R.drawable.deafult_bg)
            }
            4->{
                binding.option1Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option2Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option3Container.setBackgroundResource(R.drawable.deafult_bg)
                binding.option4Container.setBackgroundResource(R.drawable.error_bg)
            }
        }

    }

    private fun setDefaultAnswerBackground(){
        binding.option1Container.setBackgroundResource(R.drawable.deafult_bg)
        binding.option2Container.setBackgroundResource(R.drawable.deafult_bg)
        binding.option3Container.setBackgroundResource(R.drawable.deafult_bg)
        binding.option4Container.setBackgroundResource(R.drawable.deafult_bg)
    }

}
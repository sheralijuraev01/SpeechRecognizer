package uz.sher.speechrecognizer.ui.analysis

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.data.analysis_data.Images
import uz.sher.speechrecognizer.data.analysis_data.Images.Companion.getImage
import uz.sher.speechrecognizer.data.analysis_data.MenuAnalysis
import uz.sher.speechrecognizer.databinding.FragmentAnalysisSpeechBinding
import uz.sher.speechrecognizer.util.CheckInteger
import uz.sher.speechrecognizer.util.NumberToText
import uz.sher.speechrecognizer.util.constants.FragmentTag.Companion.ANALYSIS_MENU

private const val ARG_PARAM1 = "param1"

class AnalysisSpeechFragment : Fragment(), RecognitionListener {
    private var _binding: FragmentAnalysisSpeechBinding? = null

    private val binding get() = _binding!!
    private val permission = 100


    private lateinit var speech: SpeechRecognizer
    private lateinit var recognizerIntent: Intent


    private var param1 = "Salom"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1).toString()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnalysisSpeechBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initItems()
        val colorRed = R.color.main_color

        binding.progressBar.visibility = View.VISIBLE
        speech = SpeechRecognizer.createSpeechRecognizer(binding.root.context)


        speech.setRecognitionListener(this)

        binding.speechBackArrowIcon.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,AnalysisMenuFragment(),ANALYSIS_MENU).commit()
        }




        recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

        recognizerIntent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, true);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "uz-UZ");
        recognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )


        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            binding.toggleButtonContainer.visibility = View.INVISIBLE
            binding.textError.visibility = View.INVISIBLE
            binding.animationView.visibility = View.VISIBLE
            if (isChecked) {
                binding.progressBar.visibility = View.VISIBLE
                binding.progressBar.isIndeterminate = true
                binding.progressBar.progressTintList =
                    resources.getColorStateList(R.color.secondary_color)

                binding.correctIcon.visibility = View.INVISIBLE

                requestPermissions(
                    arrayOf(android.Manifest.permission.RECORD_AUDIO),
                    permission
                )
            } else {

                binding.progressBar.isIndeterminate = false
                binding.progressBar.visibility = View.VISIBLE
                speech.stopListening()
            }
        }
    }

    private fun initItems() {
        binding.animationView.visibility = View.INVISIBLE
        binding.textView.text = param1

        binding.imageView.setImageResource(getImage(param1))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            permission -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                speech.startListening(recognizerIntent)
            } else {
                Toast.makeText(
                    binding.root.context, "Permission Denied!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    override fun onReadyForSpeech(params: Bundle?) {

    }

    override fun onBeginningOfSpeech() {
        binding.progressBar.isIndeterminate = false
        binding.progressBar.max = 10
    }

    override fun onRmsChanged(rmsdB: Float) {
        binding.progressBar.progress = rmsdB.toInt()
    }

    override fun onBufferReceived(buffer: ByteArray?) {}

    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onEndOfSpeech() {
        binding.progressBar.isIndeterminate = true
        binding.progressBar.progressTintList = resources.getColorStateList(R.color.secondary_color)
        binding.toggleButton.isChecked = false

        binding.toggleButtonContainer.visibility = View.VISIBLE
        binding.animationView.visibility = View.INVISIBLE
    }

    override fun onError(error: Int) {
        val errorMessage: String = getErrorText(error)
        binding.textError.visibility = View.VISIBLE
        binding.textError.text = errorMessage
        binding.toggleButton.isChecked = false

        binding.toggleButtonContainer.visibility = View.VISIBLE
        binding.animationView.visibility = View.INVISIBLE

        binding.correctIcon.visibility = View.INVISIBLE
    }

    private fun getErrorText(error: Int): String {
        var message = ""
        message = when (error) {
            SpeechRecognizer.ERROR_AUDIO -> "Ovoz tanishda xatolik"
            SpeechRecognizer.ERROR_CLIENT -> "Iltimos internetingizni tekshiring"
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Audio yozishga ruxsatni tekshiring"
            SpeechRecognizer.ERROR_NETWORK -> "Iltimos internetingizni tekshiring"
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Internetingiz tezligi past "
            SpeechRecognizer.ERROR_NO_MATCH -> "Yaxshi eshitilmadi. Qaytadan gapiring"
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "Serverda xatolik"
            SpeechRecognizer.ERROR_SERVER -> "Serverda xatolik"
            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "Serverda xatolik"
            else -> "Yaxshi eshitilmadi. Qaytadan gapiring"
        }
        return message
    }

    override fun onResults(results: Bundle?) {

        val matches = results!!.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        var text = ""

        if (matches != null) {
            text = matches[0]
        }
        if (CheckInteger.checkInt(text)) {
            text = NumberToText.numberToText(text.toInt())
        }
        binding.textError.visibility = View.INVISIBLE
//        binding.textResult.text = text
        if (text == param1.lowercase()) {
            binding.correctIcon.visibility = View.VISIBLE
            binding.correctIcon.setBackgroundResource(R.drawable.done)
//            binding.textView.text = "To'g'ri"
        } else {
            binding.correctIcon.visibility = View.VISIBLE
            binding.correctIcon.setBackgroundResource(R.drawable.error)
//            binding.textView.text = "Xato"
        }

    }

    override fun onPartialResults(partialResults: Bundle?) {}

    override fun onEvent(eventType: Int, params: Bundle?) {}

    override fun onStop() {
        super.onStop()
        speech.destroy()

    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            AnalysisSpeechFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}
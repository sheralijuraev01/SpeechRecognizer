package uz.sher.speechrecognizer.model.hear_model

import android.speech.tts.Voice

data class Hear(
    val voice: Int,
    val option1: Int,
    val option2: Int,
    val option3: Int,
    val option4: Int,
    val answerTag: String
)


package uz.sher.speechrecognizer.util

class CheckInteger {
    companion object {
        fun checkInt(string: String): Boolean {
            val intValue = string.toIntOrNull()
            return intValue != null

        }
    }


}
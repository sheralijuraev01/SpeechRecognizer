package uz.sher.speechrecognizer.util

class NumberToText {
    companion object{
        fun numberToText(num: Int): String {
            if (num == 100) return "yuz"
            else if (num == 1000) return "ming"

            var number = num
            val units =
                arrayOf("", "bir", "ikki", "uch", "to'rt", "besh", "olti", "yetti", "sakkiz", "to'qqiz")
            val teens = arrayOf(
                "o'n",
                "o'n bir",
                "o'n ikki",
                "o'n uch",
                "o'n to'rt",
                "o'n besh",
                "o'n olti",
                "o'n yetti",
                "o'n sakkiz",
                "o'n to'qqiz"
            )
            val tens = arrayOf(
                "",
                "",
                "yigirma",
                "o'ttiz",
                "qirq",
                "ellik",
                "oltmish",
                "yetmish",
                "sakson",
                "to'qson"
            )
            val hundred = "yuz"
            val thousand = "ming"
            val million = "million"

            if (number == 0) {
                return "nol"
            }

            val parts = mutableListOf<String>()

            if (number < 0) {
                parts.add("minus")
                number = -number
            }

            if (number >= 1000000) {
                parts.add(numberToText(number / 1000000))
                parts.add(million)
                number %= 1000000
            }

            if (number >= 1000) {
                parts.add(numberToText(number / 1000))
                parts.add(thousand)
                number %= 1000
            }

            if (number >= 100) {
                parts.add(units[number / 100])
                parts.add(hundred)
                number %= 100
            }

            if (number in 10..19) {
                parts.add(teens[number - 10])
                number = 0
            }

            if (number >= 20) {
                parts.add(tens[number / 10])
                number %= 10
            }

            if (number > 0) {
                parts.add(units[number])
            }
            return parts.joinToString(" ")
        }
    }

}
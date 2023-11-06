package uz.sher.speechrecognizer.data

import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.model.Pronunciation

class PronunciationData {
    companion object {
        var list: MutableList<Pronunciation> = ArrayList()

        fun getPronunciationData(): MutableList<Pronunciation> {
            list.clear()
            list.add(
                Pronunciation(
                    "1.",
                    "Tilning kirib-chiqishi",
                    "Tilni iloji boricha tashqariga chiqarib, 2 soniya ushlab turing, so'ng uni orqaga torting. 2 soniya ushlab turing va takrorlang. Bu tilni muvofiqlashtirilgan naqshlarda harakat qilishni o'rgatishda yordam beradi, bu esa nutqni yaxshilashga yordam beradi.",
                    R.drawable.one_
                )
            )
            list.add(
                Pronunciation(
                    "2.",
                    "Tilning yonma-yon harakatlari",
                    "Ushbu nutq terapiyasi mashqlari uchun og'zingizni oching va tilni og'zingizning o'ng burchagiga tegizish uchun harakatlantiring. 2 soniya ushlab turing, so'ngra og'izning chap burchagiga teging. 2 soniya ushlab turing va takrorlang.",
                    R.drawable.two_
                )
            )
            list.add(
                Pronunciation(
                    "3.",
                    "Tilning yuqoriga va pastga harakatlari",
                    "Og'izni oching va tilni chiqaring. Keyin tilni burunga qadar cho'zing. 2 soniya ushlab turing, so'ngra tilni iyak tomon pastga tushiring. 2 soniya ushlab turing va takrorlang.",
                    R.drawable.three_
                )
            )
            list.add(
                Pronunciation(
                    "4.",
                    " Tabassum",
                    "Tabassum qilish ko'plab yuz mushaklarini o'z ichiga oladi. Shunday qilib, tabassum - og'zaki vosita ko'nikmalarini yaxshilaydigan oddiy nutq terapiyasi mashqidir. Oyna oldida tabassum qilishni mashq qiling. 2 soniya tabassum qiling, keyin dam oling va takrorlang." +
                            "" +
                            "Qon tomirlari kabi nevrologik jarohatlardan so'ng, ko'p odamlar yuzining bir tomonini harakatga keltirishda muammolarga duch kelishlari mumkin. Oynada tabassum qilishni mashq qilayotganda, tabassumni iloji boricha nosimmetrik qilishga harakat qiling.",
                    R.drawable.smile
                )
            )

            list.add(
                Pronunciation(
                    "5.",
                    " Labning burishishi",
                    "Og'iz bo'shashgan holda boshlang. Keyin, xuddi o'payotgandek lablarni bir-biriga bog'lab, bu holatda 2 soniya ushlab turing. 2 soniya dam oling va takrorlang. Dvigatelning aniqligi va nazorati bo'yicha qo'shimcha qiyinchilik uchun, iloji boricha sekin burishishni mashq qiling" +
                            "" +
                            "\n" +
                            "Harakat ko'nikmalariga qaratilgan oldingi nutq terapiyasi mashqlarini mashq qilgandan so'ng, odamlar so'zlashuvni o'z ichiga olgan quyidagi mashqlarni bajarishga tayyor bo'lishi mumkin. Agar umuman gapira olmasa, odamlar miyaning moslashuvi va qayta o'rnatilishini rivojlantirish uchun og'zaki mashqlarni bajarayotganlarini tasavvur qilishlari mumkin.\n",
                    R.drawable.five_
                )
            )

            list.add(
                Pronunciation(
                    "6.",
                    " Undosh va unlilarni juftlash takrori",
                    "Qaysi undoshlarni gapirish qiyinligini yozishdan boshlang. Keyin, birma-bir, bu undoshlarning har birini 5 ta unli (a, e, i, o, u) bilan juftlang. Masalan, “r” tovushi bilan qiynalayotganlar “ra, re, ri, ro, ru” deb takror-takror aytishni mashq qilishlari mumkin. Qo'shimcha qiyinchilik uchun buni barcha undoshlar bilan sinab ko'ring.",
                    R.drawable.six_
                )
            )

            list.add(
                Pronunciation(
                    "7.",
                    " Gap tuzish",
                    "Nutqning apraksiyasi kabi nevrologik asosda muvofiqlashtirish buzilishi bo'lgan shaxslar til ishlab chiqarishning kognitiv tarkibiy qismlari bilan hech qanday muammoga duch kelmaydi. Biroq, ularning lablari va tilini harakatlantirish qobiliyati buziladi.\n" +
                            "\n" +
                            "Shuning uchun, ovoz chiqarib o'qish nutq apraksiyasi bo'lganlarga nutqni mashq qilish imkoniyatini beradi. Garchi bu afazi bilan og'rigan odamlar uchun ajoyib mashq bo'lsa-da, tiklanishning dastlabki bosqichlarida bu juda asabiylashishi mumkin.\n" +
                            "\n" +
                            "Qisqa vaqt ichida faqat bir yoki ikkita jumla mashq qilib, kichikdan boshlang. Keyin, jumlalar sonini yoki keyingi qiyinchilik uchun mashq qilish uchun sarflangan vaqtni oshiring.\n",
                    R.drawable.seven_
                )
            )

            list.add(
                Pronunciation(
                    "8.",
                    " Fonologik ishlov berish",
                    "Fonologiya nutq tovush shakllarini o'rganadi. Fonologiyaga qaratilgan nutq terapiyasi mashqlari, shuningdek, odamlarga nutq ishlab chiqarish ko'nikmalarini yaxshilashga yordam berish uchun foydali bo'lishi mumkin.\n" +
                            "\n" +
                            "Ushbu mashq uchun oila a'zosidan yoki tarbiyachidan turli so'zlarni aytishini so'rang. Keyin ular aytgan har bir so'zda nechta bo'g'in borligini taxmin qiling. Oila a'zolari yoki tarbiyachi har doim javob to'g'ri yoki noto'g'ri ekanligi haqida fikr bildirishi kerak. Fikr-mulohaza ushbu mashqni terapevtik qilishning muhim qismidir.\n",
                    R.drawable.eight_
                )
            )

            list.add(
                Pronunciation(
                    "9.",
                    " So'z o'yinlari",
                    "So'z o'yinlarini o'ynash amaliy nutq terapiyasi mashqlarini qiziqarli va qiziqarli mashg'ulotga birlashtirishning ajoyib usuli bo'lishi mumkin. Garchi barcha so'z o'yinlari so'zlarni og'zakilashtirishni talab qilmasa ham, odamlar shunchaki tilning kognitiv komponentlari ustida ishlashni tanlashi yoki o'yinni nutqni o'z ichiga olishi uchun moslashtirishi mumkin.\n" +
                            "\n" +
                            "Masalan, Boggle, Scrabble yoki Bananagrams kabi o'yinlar so'z topish va xotira kabi kognitiv til qobiliyatlarini o'z ichiga oladi. Ushbu o'yinlar davomida oddiygina so'zlarni yaratish o'rniga, odamlar nutq ishlab chiqarish ko'nikmalarini mashq qilish uchun qilingan har bir so'zni aytishni ham tanlashlari mumkin.\n" +
                            "\n", R.drawable.nine_
                )
            )

            return list
        }
    }
}
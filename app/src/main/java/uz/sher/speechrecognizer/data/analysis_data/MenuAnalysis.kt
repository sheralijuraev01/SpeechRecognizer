package uz.sher.speechrecognizer.data.analysis_data

import uz.sher.speechrecognizer.model.analysis_speech.ChildExpandable
import uz.sher.speechrecognizer.model.analysis_speech.ParentExpandable

class MenuAnalysis {
    private val dataItemList: MutableList<ParentExpandable> = ArrayList()


    private val listA: MutableList<ChildExpandable> = ArrayList()
    private val listB: MutableList<ChildExpandable> = ArrayList()
    private val listD: MutableList<ChildExpandable> = ArrayList()
    private val listE: MutableList<ChildExpandable> = ArrayList()
    private val listF: MutableList<ChildExpandable> = ArrayList()
    private val listG: MutableList<ChildExpandable> = ArrayList()
    private val listH: MutableList<ChildExpandable> = ArrayList()
    private val listI: MutableList<ChildExpandable> = ArrayList()
    private val listJ: MutableList<ChildExpandable> = ArrayList()
    private val listK: MutableList<ChildExpandable> = ArrayList()
    private val listL: MutableList<ChildExpandable> = ArrayList()
    private val listM: MutableList<ChildExpandable> = ArrayList()
    private val listN: MutableList<ChildExpandable> = ArrayList()
    private val listO: MutableList<ChildExpandable> = ArrayList()
    private val listP: MutableList<ChildExpandable> = ArrayList()
    private val listQ: MutableList<ChildExpandable> = ArrayList()
    private val listR: MutableList<ChildExpandable> = ArrayList()
    private val listS: MutableList<ChildExpandable> = ArrayList()
    private val listT: MutableList<ChildExpandable> = ArrayList()
    private val listU: MutableList<ChildExpandable> = ArrayList()
    private val listV: MutableList<ChildExpandable> = ArrayList()
    private val listX: MutableList<ChildExpandable> = ArrayList()
    private val listY: MutableList<ChildExpandable> = ArrayList()
    private val listZ: MutableList<ChildExpandable> = ArrayList()

    private val dataChildItemList = ArrayList<MutableList<ChildExpandable>>()


    fun getParentData(): MutableList<ParentExpandable> {

        dataItemList.clear()
        dataItemList.add(ParentExpandable("A"))
        dataItemList.add(ParentExpandable("B"))
        dataItemList.add(ParentExpandable("D"))
        dataItemList.add(ParentExpandable("E"))
        dataItemList.add(ParentExpandable("F"))
        dataItemList.add(ParentExpandable("G"))
        dataItemList.add(ParentExpandable("H"))
        dataItemList.add(ParentExpandable("I"))
        dataItemList.add(ParentExpandable("J"))
        dataItemList.add(ParentExpandable("K"))
        dataItemList.add(ParentExpandable("L"))
        dataItemList.add(ParentExpandable("M"))
        dataItemList.add(ParentExpandable("N"))
        dataItemList.add(ParentExpandable("O"))
        dataItemList.add(ParentExpandable("P"))
        dataItemList.add(ParentExpandable("Q"))
        dataItemList.add(ParentExpandable("R"))
        dataItemList.add(ParentExpandable("S"))
        dataItemList.add(ParentExpandable("T"))
        dataItemList.add(ParentExpandable("U"))
        dataItemList.add(ParentExpandable("V"))
        dataItemList.add(ParentExpandable("X"))
        dataItemList.add(ParentExpandable("Y"))
        dataItemList.add(ParentExpandable("Z"))


        return dataItemList
    }

    fun getChildData(): MutableList<MutableList<ChildExpandable>> {
        dataChildItemList.clear()

        //A harfi
        listA.clear()
        listA.add(ChildExpandable("Aytmoq"))
        listA.add(ChildExpandable("Almashtirib bermoq"))
        listA.add(ChildExpandable("Archa"))
        listA.add(ChildExpandable("Avtobus"))
        listA.add(ChildExpandable("Angladim"))
        listA.add(ChildExpandable("Asal"))
        dataChildItemList.add(listA)

        //B harfi
        listB.clear()
        listB.add(ChildExpandable("Bermoq"))
        listB.add(ChildExpandable("Baqlajon"))
        listB.add(ChildExpandable("Boshlamoq"))
        listB.add(ChildExpandable("Bayroq"))
        listB.add(ChildExpandable("Beshik"))
        listB.add(ChildExpandable("Bola"))
        dataChildItemList.add(listB)

        // D harfi
        listD.clear()
        listD.add(ChildExpandable("Davlat"))
        listD.add(ChildExpandable("Dangasa"))
        listD.add(ChildExpandable("Dasturxon"))
        listD.add(ChildExpandable("Dazmol"))
        listD.add(ChildExpandable("Dengiz"))
        listD.add(ChildExpandable("Dunyo"))
        dataChildItemList.add(listD)

        // E harfi
        listE.clear()
        listE.add(ChildExpandable("Elektr"))
        listE.add(ChildExpandable("Ekologiya"))
        listE.add(ChildExpandable("Eshik"))
        listE.add(ChildExpandable("Ertak"))
        listE.add(ChildExpandable("Eshitmoq"))
        listE.add(ChildExpandable("Eslamoq"))
        dataChildItemList.add(listE)

        // F harfi
        listF.clear()
        listF.add(ChildExpandable("Faqat"))
        listF.add(ChildExpandable("Farishta"))
        listF.add(ChildExpandable("Foydalanmoq"))
        listF.add(ChildExpandable("Forum"))
        listF.add(ChildExpandable("Foyda"))
        listF.add(ChildExpandable("Fursat"))
        dataChildItemList.add(listF)

        // G harfi
        listG.clear()
        listG.add(ChildExpandable("Gap"))
        listG.add(ChildExpandable("Garaj"))
        listG.add(ChildExpandable("Gavhar"))
        listG.add(ChildExpandable("Gilam"))
        listG.add(ChildExpandable("Gul"))
        listG.add(ChildExpandable("Guruch"))
        dataChildItemList.add(listG)

        // H harfi
        listH.clear()
        listH.add(ChildExpandable("Halol"))
        listH.add(ChildExpandable("Harakat"))
        listH.add(ChildExpandable("Hayot"))
        listH.add(ChildExpandable("Hujjat"))
        listH.add(ChildExpandable("Hikoya aytib bermoq"))
        listH.add(ChildExpandable("Hakam"))
        dataChildItemList.add(listH)

        // I harfi
        listI.clear()
        listI.add(ChildExpandable("Ikki"))
        listI.add(ChildExpandable("Ilhom"))
        listI.add(ChildExpandable("Ilon"))
        listI.add(ChildExpandable("Ildiz"))
        listI.add(ChildExpandable("Ikkiyuzlamachi"))
        listI.add(ChildExpandable("Istiqbol"))
        dataChildItemList.add(listI)

        // J harfi
        listJ.clear()
        listJ.add(ChildExpandable("Jamila"))
        listJ.add(ChildExpandable("Jasur"))
        listJ.add(ChildExpandable("Javohir"))
        listJ.add(ChildExpandable("Juda"))
        listJ.add(ChildExpandable("Juft"))
        listJ.add(ChildExpandable("Jumla"))
        dataChildItemList.add(listJ)

        // K harfi
        listK.clear()
        listK.add(ChildExpandable("Kompyuter"))
        listK.add(ChildExpandable("Kampir"))
        listK.add(ChildExpandable("Kasal"))
        listK.add(ChildExpandable("Kalkulyator"))
        listK.add(ChildExpandable("Kulmoq"))
        listK.add(ChildExpandable("Kinoteatr"))
        dataChildItemList.add(listK)

        // L harfi
        listL.clear()
        listL.add(ChildExpandable("Lahza"))
        listL.add(ChildExpandable("Laylak"))
        listL.add(ChildExpandable("Lekin"))
        listL.add(ChildExpandable("Latifa"))
        listL.add(ChildExpandable("Lola"))
        listL.add(ChildExpandable("Likopcha"))
        dataChildItemList.add(listL)

        // M harfi
        listM.clear()
        listM.add(ChildExpandable("Masala"))
        listM.add(ChildExpandable("Mashina"))
        listM.add(ChildExpandable("Maymun"))
        listM.add(ChildExpandable("Muhokama"))
        listM.add(ChildExpandable("Mashinada bormoq"))
        listM.add(ChildExpandable("Mushuk"))
        dataChildItemList.add(listM)

        // N harfi
        listN.clear()
        listN.add(ChildExpandable("Nam"))
        listN.add(ChildExpandable("Navbat"))
        listN.add(ChildExpandable("Nima"))
        listN.add(ChildExpandable("Nisbatan"))
        listN.add(ChildExpandable("Non"))
        listN.add(ChildExpandable("Nur"))
        dataChildItemList.add(listN)

        // O harfi
        listO.clear()
        listO.add(ChildExpandable("Ohak"))
        listO.add(ChildExpandable("Olib kelmoq"))
        listO.add(ChildExpandable("Ovqatlanmoqda"))
        listO.add(ChildExpandable("Ota"))
        listO.add(ChildExpandable("Oymomo"))
        listO.add(ChildExpandable("Oyoq"))
        dataChildItemList.add(listO)

        // P harfi
        listP.clear()
        listP.add(ChildExpandable("Paxta"))
        listP.add(ChildExpandable("Paynet"))
        listP.add(ChildExpandable("Paypoq"))
        listP.add(ChildExpandable("Palto"))
        listP.add(ChildExpandable("Parcha"))
        listP.add(ChildExpandable("Partiya"))
        dataChildItemList.add(listP)


        // Q harfi
        listQ.clear()
        listQ.add(ChildExpandable("Qachon"))
        listQ.add(ChildExpandable("Qaysar"))
        listQ.add(ChildExpandable("Qorni ochmoq"))
        listQ.add(ChildExpandable("Qaytim"))
        listQ.add(ChildExpandable("Quloq"))
        listQ.add(ChildExpandable("Quyosh"))
        dataChildItemList.add(listQ)

        // R harfi
        listR.clear()
        listR.add(ChildExpandable("Radio"))
        listR.add(ChildExpandable("Rahmat"))
        listR.add(ChildExpandable("Randa"))
        listR.add(ChildExpandable("Rayhon"))
        listR.add(ChildExpandable("Rassom"))
        listR.add(ChildExpandable("Raketa"))
        dataChildItemList.add(listR)

        // S harfi
        listS.clear()
        listS.add(ChildExpandable("Suhbat"))
        listS.add(ChildExpandable("Sevgi"))
        listS.add(ChildExpandable("Sinf"))
        listS.add(ChildExpandable("Sotib olmoq"))
        listS.add(ChildExpandable("Suv bermoq"))

        dataChildItemList.add(listS)


        // T harfi
        listT.clear()
        listT.add(ChildExpandable("Tinglamoq"))
        listT.add(ChildExpandable("Turmoq"))
        listT.add(ChildExpandable("Takrorlamoqda"))
        listT.add(ChildExpandable("Tomosha qilmoq"))
        listT.add(ChildExpandable("Timsoh"))

        dataChildItemList.add(listT)


        // U harfi
        listU.clear()
        listU.add(ChildExpandable("Uzatmoq"))
        listU.add(ChildExpandable("Uxlamoq"))
        listU.add(ChildExpandable("Uchmoq"))
        listU.add(ChildExpandable("Ustoz"))
        listU.add(ChildExpandable("Uskuna"))
        dataChildItemList.add(listU)


        // V harfi
        listV.clear()
        listV.add(ChildExpandable("Vijdon"))
        listV.add(ChildExpandable("Vino"))
        listV.add(ChildExpandable("Vahima"))
        listV.add(ChildExpandable("Vulqon"))
        listV.add(ChildExpandable("Velosiped"))
        dataChildItemList.add(listV)


        // X harfi
        listX.clear()
        listX.add(ChildExpandable("Xursand"))
        listX.add(ChildExpandable("Xurmo"))
        listX.add(ChildExpandable("Xirmon"))
        listX.add(ChildExpandable("Xonadon"))
        listX.add(ChildExpandable("Xodim"))
        dataChildItemList.add(listX)


        // Y harfi
        listY.clear()
        listY.add(ChildExpandable("Yozib bermoq"))
        listY.add(ChildExpandable("Yordam bermoq"))
        listY.add(ChildExpandable("Yotmoq"))
        listY.add(ChildExpandable("Yulduz"))
        listY.add(ChildExpandable("Yigirma besh"))
        dataChildItemList.add(listY)


        // Z harfi
        listZ.clear()
        listZ.add(ChildExpandable("Zoologiya"))
        listZ.add(ChildExpandable("Zanjir"))
        listZ.add(ChildExpandable("Zinapoya"))
        listZ.add(ChildExpandable("Zargar"))
        listZ.add(ChildExpandable("Zahar"))
        dataChildItemList.add(listZ)

        return dataChildItemList

    }
}
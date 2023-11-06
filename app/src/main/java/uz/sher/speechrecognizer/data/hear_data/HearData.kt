package uz.sher.speechrecognizer.data.hear_data

import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.model.hear_model.Hear

class HearData {
    companion object{
        var list:MutableList<Hear> =ArrayList()
        fun getHearData():MutableList<Hear>{
            list.clear()
            list.add(Hear(R.raw.eshik, R.drawable.everest,R.drawable.ertak,R.drawable.eshik,R.drawable.ekologiya,"3"))
            list.add(Hear(R.raw.kampir, R.drawable.kampir,R.drawable.kasal,R.drawable.kino,R.drawable.kalkulyator,"1"))
            list.add(Hear(R.raw.asal, R.drawable.kasal,R.drawable.asal,R.drawable.masala,R.drawable.ichmoq,"2"))
            list.add(Hear(R.raw.guruch, R.drawable.gul,R.drawable.gap,R.drawable.guruch,R.drawable.gilam,"3"))
            list.add(Hear(R.raw.randa, R.drawable.raketa,R.drawable.radio,R.drawable.rayhon,R.drawable.randa,"4"))
            list.add(Hear(R.raw.rayhon, R.drawable.rayhon,R.drawable.raketa,R.drawable.rahmat,R.drawable.rassom,"1"))
            list.add(Hear(R.raw.raketa, R.drawable.rahmat,R.drawable.raketa,R.drawable.muhokama,R.drawable.davlat,"2"))
            list.add(Hear(R.raw.rassom, R.drawable.oymoma,R.drawable.navbat,R.drawable.rassom,R.drawable.suhbat,"3"))
            list.add(Hear(R.raw.archa, R.drawable.avtobus,R.drawable.asal,R.drawable.paypoq,R.drawable.archa,"4"))
            list.add(Hear(R.raw.ildiz, R.drawable.ildiz,R.drawable.qaytim,R.drawable.pirog,R.drawable.palto,"1"))
            list.add(Hear(R.raw.zinopoya, R.drawable.suhbat,R.drawable.zinapoya,R.drawable.qaysar,R.drawable.non,"2"))
            list.add(Hear(R.raw.darvoza, R.drawable.oymoma,R.drawable.paxta,R.drawable.darvoza,R.drawable.davlat,"3"))
            list.add(Hear(R.raw.kozoynak, R.drawable.ohak,R.drawable.ovqatlanmoq,R.drawable.qachon,R.drawable.kozoynak,"4"))
            list.add(Hear(R.raw.karkidon, R.drawable.karkidon,R.drawable.suv_bermoq,R.drawable.jasur,R.drawable.hujjat,"1"))
            list.add(Hear(R.raw.xarita, R.drawable.ilon,R.drawable.davlat,R.drawable.xarita,R.drawable.eshitmoq,"3"))
            list.add(Hear(R.raw.qulupnay, R.drawable.tomosha_qilmoq,R.drawable.boshlamoq,R.drawable.quyosh,R.drawable.qulupnay,"4"))
            list.add(Hear(R.raw.qurbaqa, R.drawable.qurbaqa,R.drawable.uxlamoq,R.drawable.qachon,R.drawable.quloq,"1"))
            list.add(Hear(R.raw.qaychi, R.drawable.qurbaqa,R.drawable.qaychi,R.drawable.foyda,R.drawable.guruch,"2"))
            list.add(Hear(R.raw.pichoq, R.drawable.lola,R.drawable.ohak,R.drawable.pichoq,R.drawable.karkidon,"3"))
            list.add(Hear(R.raw.shamol, R.drawable.yotmoq,R.drawable.farishta,R.drawable.tomosha_qilmoq,R.drawable.shamol,"4"))
            list.add(Hear(R.raw.quloq, R.drawable.quloq,R.drawable.kompyuter,R.drawable.karkidon,R.drawable.kalkulyator,"1"))
            list.add(Hear(R.raw.lolaqizgaldoq, R.drawable.juft,R.drawable.lolaqizgaldoq,R.drawable.halol,R.drawable.javohir,"2"))
            list.add(Hear(R.raw.suv, R.drawable.bayroq,R.drawable.baqlajon,R.drawable.suv_bermoq,R.drawable.dunyo,"3"))
            list.add(Hear(R.raw.timsoh, R.drawable.anglamoq,R.drawable.halol,R.drawable.qorni_ochmoq,R.drawable.timsoh,"4"))
            list.add(Hear(R.raw.soyabon, R.drawable.soyabon,R.drawable.archa,R.drawable.randa,R.drawable.rassom,"1"))
            list.add(Hear(R.raw.kasal, R.drawable.masala,R.drawable.kasal,R.drawable.uzatmoq,R.drawable.dangasa,"2"))
            list.add(Hear(R.raw.sandiq, R.drawable.qulupnay,R.drawable.timsoh,R.drawable.sandiq,R.drawable.shamol,"3"))
            list.add(Hear(R.raw.chavandoz, R.drawable.juda,R.drawable.fursat,R.drawable.jumla,R.drawable.chavondoz,"4"))
            list.add(Hear(R.raw.qozon, R.drawable.qozon,R.drawable.archa,R.drawable.barmoq,R.drawable.dazmol,"1"))
            list.add(Hear(R.raw.nayza, R.drawable.nam,R.drawable.nayza,R.drawable.navbat,R.drawable.non,"2"))
            list.add(Hear(R.raw.askar, R.drawable.asal,R.drawable.avtobus,R.drawable.askar,R.drawable.anglamoq,"3"))
            list.add(Hear(R.raw.xanjar, R.drawable.harakat,R.drawable.hikoya_aytib,R.drawable.ikkiyuzlamachi,R.drawable.xanjar,"4"))
            list.add(Hear(R.raw.barg, R.drawable.barg,R.drawable.gilam,R.drawable.bayroq,R.drawable.gul,"1"))
            list.add(Hear(R.raw.hamshira, R.drawable.gul,R.drawable.hamshira,R.drawable.hujjat,R.drawable.qozon,"2"))
            list.add(Hear(R.raw.tandir, R.drawable.uxlamoq,R.drawable.uzatmoq,R.drawable.tandir,R.drawable.takrorlamoq,"3"))
            list.add(Hear(R.raw.choy, R.drawable.shamol,R.drawable.suhbat,R.drawable.soyabon,R.drawable.choy,"4"))
            list.add(Hear(R.raw.shirinlik, R.drawable.shirinlik,R.drawable.hamshira,R.drawable.eshik,R.drawable.beshik,"1"))
            list.add(Hear(R.raw.zanjir, R.drawable.kompyuter,R.drawable.zanjir,R.drawable.ikki,R.drawable.bola,"2"))
            list.add(Hear(R.raw.durbin, R.drawable.dangasa,R.drawable.darvoza,R.drawable.durbin,R.drawable.dazmol,"3"))
            list.add(Hear(R.raw.qoplon, R.drawable.quloq,R.drawable.qachon,R.drawable.qulupnay,R.drawable.qoplon,"4"))
            list.add(Hear(R.raw.anor, R.drawable.anor,R.drawable.asal,R.drawable.avtobus,R.drawable.navbat,"1"))
            return list
        }

    }
}
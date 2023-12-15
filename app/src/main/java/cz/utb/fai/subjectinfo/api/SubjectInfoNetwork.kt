package cz.utb.fai.subjectinfo.api

import cz.utb.fai.subjectinfo.database.SubjectInfoDTO
import cz.utb.fai.subjectinfo.domain.SubjectInfoDomain

data class SubjectInfoNetwork(
    val katedra: String,
    val zkratka: String,
    val rok: String,
    val nazev: String,
    val nazevDlouhy: String,
    val vyukaZS: String,
    val vyukaLS: String,
    val kreditu: Int,
    val viceZapis: String,
    val minObsazeni: Int?,  // Change the type accordingly if it's not an Int
    val garanti: String,
    val garantiSPodily: String,
    val garantiUcitIdno: String,
    val prednasejici: String,
    val prednasejiciSPodily: String,
    val prednasejiciUcitIdno: String,
    val cvicici: String,
    val cviciciSPodily: String,
    val cviciciUcitIdno: String,
    val seminarici: String,
    val seminariciSPodily: String,
    val seminariciUcitIdno: String,
    val schvalujiciUznani: String,
    val schvalujiciUznaniUcitIdno: String,
    val examinatori: String,
    val examinatoriUcitIdno: String,
    val podminujiciPredmety: String,
    val vylucujiciPredmety: String,
    val podminujePredmety: String,
    val literatura: String,
    val nahrazPredmety: String,
    val metodyVyucovaci: String,
    val metodyHodnotici: String,
    val akreditovan: String,
    val jednotekPrednasek: Int,
    val jednotkaPrednasky: String,
    val jednotekCviceni: Int,
    val jednotkaCviceni: String,
    val jednotekSeminare: Int,
    val jednotkaSeminare: String,
    val anotace: String,
    val typZkousky: String,
    val maZapocetPredZk: String,
    val formaZkousky: String,
    val pozadavky: String,
    val prehledLatky: String,
    val predpoklady: String,
    val ziskaneZpusobilosti: String,
    val casovaNarocnost: String,
    val predmetUrl: String?,  // Change the type accordingly if it's not a String
    val vyucovaciJazyky: String,
    val poznamka: String,
    val ectsZobrazit: String,
    val ectsAkreditace: String,
    val ectsNabizetUPrijezdu: String,
    val poznamkaVerejna: String?,  // Change the type accordingly if it's not a String
    val skupinaAkreditace: String?,  // Change the type accordingly if it's not a String
    val skupinaAkreditaceKey: String?,  // Change the type accordingly if it's not a String
    val zarazenDoPrezencnihoStudia: String,
    val zarazenDoKombinovanehoStudia: String,
    val studijniOpory: String?,  // Change the type accordingly if it's not a String
    val praxePocetDnu: String,
    val urovenNastavena: String,
    val urovenVypoctena: String,
    val automatickyUznavatZppZk: String,
    val hodZaSemKombForma: String
)

fun SubjectInfoNetwork.mapToDatabase(): SubjectInfoDTO {
    return SubjectInfoDTO(
        nazev = this.nazev,
        zkratka = this.zkratka,
        kreditu = this.kreditu,
        typZkousky = this.typZkousky,
        vyucovaciJazyky = this.vyucovaciJazyky
    )
}
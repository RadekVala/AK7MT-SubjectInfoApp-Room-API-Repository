package cz.utb.fai.subjectinfo.domain

data class SubjectInfoDomain (
    val nazev: String,
    val zkratka: String,
    val kreditu: Int,
    val typZkousky: String,
    val vyucovaciJazyky: List<String>
)
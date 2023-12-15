package cz.utb.fai.subjectinfo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import cz.utb.fai.subjectinfo.domain.SubjectInfoDomain

@Entity(tableName = "subject_info")
data class SubjectInfoDTO (
    //@PrimaryKey(autoGenerate = true) val id: Int = 0,
    @PrimaryKey
    val nazev: String,
    val zkratka: String,
    val kreditu: Int,
    val typZkousky: String,
    val vyucovaciJazyky: String,
)

fun SubjectInfoDTO.mapToDomain(): SubjectInfoDomain {
    return SubjectInfoDomain(
        nazev = this.nazev,
        zkratka = this.zkratka,
        kreditu = this.kreditu,
        typZkousky = this.typZkousky,
        vyucovaciJazyky = this.vyucovaciJazyky.split(", ")
    )
}
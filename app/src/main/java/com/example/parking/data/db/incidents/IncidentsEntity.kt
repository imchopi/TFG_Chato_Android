package com.example.parking.data.db.incidents

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incidents")
data class IncidentsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val uuid: String,
    val categoryName: String = "Network",
    val title: String,
    val description: String,
    val image: String? = "",
    val date: String,
    val checked: Boolean = false,
    val resolved: Boolean = false,
    val userId: String,

    )

fun List<IncidentsEntity>.asIncident():List<Incident> {
    return this.map {
        Incident(
            it.id,
            it.uuid,
            it.categoryName,
            it.title,
            it.description,
            it.image,
            it.date,
            it.checked,
            it.resolved,
            it.userId,
        )
    }
}
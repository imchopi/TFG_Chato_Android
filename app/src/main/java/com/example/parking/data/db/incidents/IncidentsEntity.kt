package com.example.parking.data.db.incidents

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incidents")
data class IncidentsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = 0,
    val uuid: String,
    val categoryName: String = "Network",
    val title: String,
    val description: String,
    var image: String? = "",
    val date: String,
    val checked: Boolean = false,
    val resolved: Boolean = false,
    val userId: String,
    )

/**
 * Converts a list of `IncidentsEntity` objects to a list of `Incident` objects.
 *
 * This function maps each `IncidentsEntity` to an `Incident`, preserving all the relevant properties.
 *
 * @receiver The list of `IncidentsEntity` objects to be converted.
 * @return A list of `Incident` objects.
 */
fun List<IncidentsEntity>.asIncident(): List<Incident> {
    return this.map {
        Incident(
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

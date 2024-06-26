package com.example.parking.data.repository

import android.util.Log
import com.example.parking.data.db.incidents.Incident
import com.example.parking.data.db.incidents.IncidentsDBRepository
import com.example.parking.data.db.incidents.IncidentsEntity
import com.example.parking.data.db.incidents.asIncident
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val incidentsDBRepository: IncidentsDBRepository,
) {

    /**
     * Exposes a Flow of incidents to observe changes.
     *
     * This property maps the Flow of `IncidentsEntity` from the database repository
     * to a Flow of `Incident` objects using the extension function `asIncident()`.
     *
     * @return A Flow of `List<Incident>`.
     */
    val incident: Flow<List<Incident>>
        get() {
            // Maps the Flow of IncidentsEntity to a Flow of Incident using the extension function asIncident()
            val list = incidentsDBRepository.incidents.map {
                it.asIncident()
            }
            return list
        }

    /**
     * Adds an incident to the database.
     *
     * @param incident The `IncidentsEntity` to be added to the database.
     */
    suspend fun addIncident(incident: IncidentsEntity) {
        incidentsDBRepository.insert(incident)
    }

    /**
     * Inserts a list of incidents into the database.
     *
     * @param listIncidentEntity The list of `IncidentsEntity` objects to be inserted into the database.
     */
    suspend fun insertAll(listIncidentEntity: List<IncidentsEntity>) {
        incidentsDBRepository.insertAll(listIncidentEntity)
    }
}


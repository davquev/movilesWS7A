package com.example.appfutbolperu.database

import androidx.room.*
import com.example.appfutbolperu.models.Team

@Dao
interface TeamDAO {
    @Insert
    fun insertTeam(vararg team: Team)

    @Query("SELECT * FROM teams ")
    fun getAllTeams(): List<Team>

    @Delete
    fun deleteTeams(vararg team: Team)

    @Update
    fun updateTeams(vararg team: Team)
}
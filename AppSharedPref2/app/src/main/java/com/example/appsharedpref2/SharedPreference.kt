package com.example.appsharedpref2

import android.content.Context

class SharedPreference(val context: Context) {
    //nombre para mi SharedP
    private val PREFS_NAME = "sharedPreferences"

    //creo el SharedP
    private val sharedPreference = context.getSharedPreferences(
        PREFS_NAME, Context.MODE_PRIVATE
    )

    //grabar
    fun save(keyName: String, value: String){
        val editor = sharedPreference.edit()
        editor.putString(keyName, value).commit()
        //editor.commit()
    }

    //get
    fun getValue(keyName: String): String?{
        return sharedPreference.getString(keyName, null)
    }

    //limpiar el SharedP
    fun clear(){
        val editor = sharedPreference.edit()
        editor.clear().commit()
        //editor.commit()
    }
}
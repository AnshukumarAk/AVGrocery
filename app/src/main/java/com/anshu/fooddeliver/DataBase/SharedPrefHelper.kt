package com.anshu.fooddeliver.DataBase

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper {
    companion object {
        private val PREF_FILE = "food_deliver.db"
    }
    private var settings: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private val instances: MutableMap<Context, SharedPrefHelper> = HashMap()

    constructor(context: Context) {
        settings = context.getSharedPreferences(SharedPrefHelper.PREF_FILE, Context.MODE_PRIVATE)
        editor = settings?.edit()
    }

    fun getString(key: String?, defValue: String?): String? {
        return settings!!.getString(key, defValue)
    }

    fun setString(key: String?, value: String?): SharedPrefHelper? {
        editor!!.putString(key, value)
        editor!!.commit()
        print(this)
        return this
    }
    fun getBoolean(key: String?, defValue: Boolean?): Boolean? {
        return settings!!.getBoolean(key, defValue!!)
    }
    fun setBoolean(key: String?, value: Boolean?): SharedPrefHelper? {
        editor!!.putBoolean(key, value!!)
        editor!!.commit()
        print(this)
        return this
    }
}
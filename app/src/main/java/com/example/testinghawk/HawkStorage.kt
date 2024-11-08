package com.example.testinghawk

import com.orhanobut.hawk.Hawk

class HawkStorage {

    @Synchronized
     fun <T> put(key: String, value: T): Boolean = Hawk.put(key, value)

    @Synchronized
     fun <T> get(key: String) = Hawk.get<T>(key)


    @Synchronized
     fun clear(): Boolean = Hawk.deleteAll()

    @Synchronized
     fun delete(key: String): Boolean = Hawk.delete(key)

}
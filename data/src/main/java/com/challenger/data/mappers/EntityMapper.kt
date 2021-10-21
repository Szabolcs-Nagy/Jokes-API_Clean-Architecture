package com.challenger.data.mappers

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <M> the remote model input type
 * @param <E> the entity model output type
 */
abstract class EntityMapper<in M, out E> {

  abstract  fun mapFromRemote(type: M): E

    fun  mapFromRemote(type: List<M>):  List<E> {
        val list = ArrayList<E>()
        type.forEach{item->
            list.add(mapFromRemote(item))
        }
        return list

    }

}
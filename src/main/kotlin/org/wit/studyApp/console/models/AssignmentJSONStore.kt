package org.wit.studyApp.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.wit.studyApp.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "assignments.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<StudyAppModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class AssignmentJSONStore : StudyAppStore {

    var assignments = mutableListOf<StudyAppModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    //returns everything in assignment list
    override fun findAll(): MutableList<StudyAppModel> {
        return assignments
    }

    //returns one specfic item from assignment list
    override fun findOne(id: Long) : StudyAppModel? {
        var foundAssignment: StudyAppModel? = assignments.find { p -> p.id == id }
        return foundAssignment
    }

    //Creates new item in assignment list
    override fun create(assignemnt: StudyAppModel) {
        assignemnt.id = generateRandomId()
        assignments.add(assignemnt)
        serialize()
    }

    //Attempted delete function to clear JSON file
     fun delete() {
        assignments.clear()
         serialize()
    }

    //Updates item in assignment list
    override fun update(assignemnt: StudyAppModel) {
        var foundAssignment = findOne(assignemnt.id!!)
        if (foundAssignment != null) {
            foundAssignment.title = assignemnt.title
            foundAssignment.Date = assignemnt.Date
        }
        serialize()
    }

    //Logs all items in assignment list
    internal fun logAll() {
        assignments.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(assignments, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        assignments = Gson().fromJson(jsonString, listType)
    }
}

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

    override fun findAll(): MutableList<StudyAppModel> {
        return assignments
    }

    override fun findOne(id: Long) : StudyAppModel? {
        var foundAssignment: StudyAppModel? = assignments.find { p -> p.id == id }
        return foundAssignment
    }

    override fun create(assignemnt: StudyAppModel) {
        assignemnt.id = generateRandomId()
        assignments.add(assignemnt)
        serialize()
    }

    override fun update(assignemnt: StudyAppModel) {
        var foundAssignment = findOne(assignemnt.id!!)
        if (foundAssignment != null) {
            foundAssignment.title = assignemnt.title
            foundAssignment.Date = assignemnt.Date
        }
        serialize()
    }

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

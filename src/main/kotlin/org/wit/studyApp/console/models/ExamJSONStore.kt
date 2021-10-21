package org.wit.studyApp.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.wit.studyApp.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE2 = "exams.json"
val gsonBuilder2 = GsonBuilder().setPrettyPrinting().create()
val listType2 = object : TypeToken<java.util.ArrayList<StudyAppModel>>() {}.type

fun generateRandomIdExam(): Long? {
    return Random().nextLong()
}

class ExamJSONStore : StudyAppStore {

    var exams = mutableListOf<StudyAppModel>()

    init {
        if (exists(JSON_FILE2)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<StudyAppModel> {
        return exams
    }

    override fun findOne(id: Long) : StudyAppModel? {
        var foundAssignment: StudyAppModel? = exams.find { p -> p.id == id }
        return foundAssignment
    }

    override fun create(assignemnt: StudyAppModel) {
        assignemnt.id = generateRandomId()
        exams.add(assignemnt)
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
        exams.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder2.toJson(exams, listType2)
        write(JSON_FILE2, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE2)
        exams = Gson().fromJson(jsonString, listType2)
    }
}
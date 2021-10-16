package org.wit.studyApp.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class StudyAppMemStore : StudyAppStore {

    val assignments = ArrayList<StudyAppModel>()

    override fun findAll(): List<StudyAppModel> {
        return assignments
    }

    override fun findOne(id: Long) : StudyAppModel? {
        var foundAssignment: StudyAppModel? = assignments.find { p -> p.id == id }
        return foundAssignment
    }

    override fun create(assignment: StudyAppModel) {
        assignment.id = getId()
        assignments.add(assignment)
        logAll()
    }

    override fun update(assignment: StudyAppModel) {
        var foundAssignment = findOne(assignment.id!!)
        if (foundAssignment != null) {
            foundAssignment.title = assignment.title
            foundAssignment.Date = assignment.Date
        }
    }

    internal fun logAll() {
        assignments.forEach { logger.info("${it}") }
    }
}
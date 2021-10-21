package org.wit.studyApp.console.controllers

import mu.KotlinLogging
import org.wit.studyApp.console.models.AssignmentJSONStore
import org.wit.studyApp.console.models.StudyAppModel
import org.wit.studyApp.console.views.StudyAppView

class StudyAppController {

    val assignments = AssignmentJSONStore()

    val assignmentView = StudyAppView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Study Planner Console App" }
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Study App Console App" }
    }

    fun menu() :Int { return assignmentView.menu() }

    fun add(){
        var aPlacemark = StudyAppModel()

        if (assignmentView.addAssignmentPlacemarkData(aPlacemark))
            assignments.create(aPlacemark)
        else
            logger.info("Assignment Not Added")
    }

    fun list() {
        assignmentView.listAssignmentPlacemark(assignments)
    }

    fun update() {

        assignmentView.listAssignmentPlacemark(assignments)
        var searchId = assignmentView.getId()
        val aPlacemark = search(searchId)

        if(aPlacemark != null) {
            if(assignmentView.updateAssignmentPlacemarkData(aPlacemark)) {
                assignments.update(aPlacemark)
                assignmentView.showAssignmentPlacemark(aPlacemark)
                logger.info("Assignment Updated : [ $aPlacemark ]")
            }
            else
                logger.info("Assignment Not Updated")
        }
        else
            println("Assignment Not Updated...")
    }

    fun search() {
        val aPlacemark = search(assignmentView.getId())!!
        assignmentView.showAssignmentPlacemark(aPlacemark)
    }


    fun search(id: Long) : StudyAppModel? {
        var foundPlacemark = assignments.findOne(id)
        return foundPlacemark
    }
}
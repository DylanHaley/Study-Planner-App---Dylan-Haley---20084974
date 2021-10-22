package org.wit.studyApp.console.controllers

import javafx.application.Platform.runLater
import mu.KotlinLogging
import org.wit.studyApp.console.models.ExamJSONStore
import org.wit.studyApp.console.models.AssignmentJSONStore
import org.wit.studyApp.console.models.StudyAppModel
import org.wit.studyApp.console.views.*
import tornadofx.*

class StudyAppUIController : Controller() {

    val assignments = AssignmentJSONStore()
    val exams = ExamJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Study Planner TornadoFX UI App" }
    }


    //Assignment Functions
    // Add new assignment to the JSON file
    fun addAssignment(_title : String, _date : String){

        var aPlacemark = StudyAppModel(title = _title, Date = _date)
        assignments.create(aPlacemark)
        logger.info("Added")
    }

    //Load the assignments JSON file
    fun loadListAssignmentScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        assignments.logAll()
    }

    //Load the add assignment screen
    fun loadAddAssignmentScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    //Load delete assignment screen
    fun loadDeleteAssignmentScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(DeleteAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    //close the add assignment screen
    fun closeAddAssignment() {
        runLater {
            find(AddAssignmentScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    //close the list assignment screen
    fun closeListAssignment() {
        runLater {
            find(ListAssignmentScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    //Attempted delete function which calls delete from AssignmentJSONStore to clear JSON file however very buggy
    fun deleteAssignment(){
        assignments.delete()
        logger.info("Deleted")
    }

    //Attempted search function does not work as it errors out while trying to load search screen
    fun searchAssignments(id: Long) {
        assignments.findOne(id)
    }

    fun loadSearchAssignmentScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(SearchAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeDeleteAssignment() {
        runLater {
            find(DeleteAssignmentScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }


    //Exam Functions
    //adds Exam to new JSON file
    fun addExam(_title : String, _date : String){

        var aPlacemark = StudyAppModel(title = _title, Date = _date)
        exams.create(aPlacemark)
        logger.info("Added")
    }

    //Loads add exam screen
    fun loadAddExamScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddExamScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    //Closes add exam screen
    fun closeExamAdd() {
        runLater {
            find(AddExamScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    //Loads list exam screen
    fun loadListExamScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListExamScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        exams.logAll()
    }

    //Closes list exam screen
    fun closeListExam() {
        runLater {
            find(ListExamScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

}
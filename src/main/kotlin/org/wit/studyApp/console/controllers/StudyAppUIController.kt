package org.wit.studyApp.console.controllers

import javafx.application.Platform.runLater
import mu.KotlinLogging
import org.wit.studyApp.console.models.ExamJSONStore
import org.wit.studyApp.console.models.AssignmentJSONStore
import org.wit.studyApp.console.models.JSON_FILE
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
    fun addAssignment(_title : String, _date : String){

        var aPlacemark = StudyAppModel(title = _title, Date = _date)
        assignments.create(aPlacemark)
        logger.info("Added")
    }

    fun loadListAssignmentScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        assignments.logAll()
    }

    fun loadAddAssignmentScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadDeleteAssignmentScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(DeleteAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAddAssignment() {
        runLater {
            find(AddAssignmentScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeListAssignment() {
        runLater {
            find(ListAssignmentScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun deleteAssignment(){
//        assignments.delete()
        logger.info("Deleted")
    }

    fun searchAssignments(id: Long) {
//        assignments.findOne(id)
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


    //Exam functions
    fun addExam(_title : String, _date : String){

        var aPlacemark = StudyAppModel(title = _title, Date = _date)
        exams.create(aPlacemark)
        logger.info("Added")
    }

    fun loadAddExamScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddExamScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeExamAdd() {
        runLater {
            find(AddExamScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadListExamScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListExamScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        exams.logAll()
    }

    fun closeListExam() {
        runLater {
            find(ListExamScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

}
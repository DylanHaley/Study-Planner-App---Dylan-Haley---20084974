package org.wit.studyApp.console.controllers

import javafx.application.Platform.runLater
import mu.KotlinLogging
import org.wit.studyApp.console.models.StudyAppJSONStore
import org.wit.studyApp.console.models.StudyAppModel
import org.wit.studyApp.console.views.AddStudyAppScreen
import org.wit.studyApp.console.views.ListAssignmentScreen
import org.wit.studyApp.console.views.MenuScreen
import tornadofx.*

class StudyAppUIController : Controller() {

    val placemarks = StudyAppJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Study Planner TornadoFX UI App" }
    }
    fun add(_title : String, _date : String){

        var aPlacemark = StudyAppModel(title = _title, Date = _date)
        placemarks.create(aPlacemark)
        logger.info("Assignment Added")
    }

    fun loadListScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListAssignmentScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        placemarks.logAll()
    }

    fun loadAddScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddStudyAppScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadDeleteScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddStudyAppScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAdd() {
        runLater {
            find(AddStudyAppScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }
    fun closeList() {
        runLater {
            find(ListAssignmentScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

}
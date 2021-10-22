package org.wit.studyApp.console.views

import org.wit.studyApp.console.controllers.StudyAppUIController
import org.wit.studyApp.console.models.StudyAppModel
import tornadofx.*

class ListExamScreen : View("List Assignments") {

    val assignmentUIController: StudyAppUIController by inject()
    val tableContent = assignmentUIController.exams.findAll()
    val data = tableContent.observable()


    //Lists all current exam due dates that are in the list
    override val root = vbox {
        setPrefSize(1200.0, 400.0)
        tableview(data) {
            readonlyColumn("ID", StudyAppModel::id)
            readonlyColumn("TITLE", StudyAppModel::title)
            readonlyColumn("DATE", StudyAppModel::Date)
        }
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    assignmentUIController.closeListExam()
                }
            }
        }
    }

}
package org.wit.studyApp.console.views

import org.wit.studyApp.console.controllers.StudyAppUIController
import org.wit.studyApp.console.models.StudyAppModel
import tornadofx.*

class DeleteAssignmentScreen : View("Delete Assignments") {

    val assignmentUIController: StudyAppUIController by inject()
    val tableContent = assignmentUIController.exams.findAll()
    val data = tableContent.observable()


    override val root = vbox {
        setPrefSize(600.0, 200.0)
        tableview(data) {
            readonlyColumn("ID", StudyAppModel::id)
            readonlyColumn("TITLE", StudyAppModel::title)
            readonlyColumn("DATE", StudyAppModel::Date)
        }
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    assignmentUIController.closeListAssignment()
                }
            }
        }
    }

}
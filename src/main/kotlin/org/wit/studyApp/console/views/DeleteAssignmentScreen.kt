package org.wit.studyApp.console.views

import org.wit.studyApp.console.controllers.StudyAppUIController
import org.wit.studyApp.console.main.assignments
import tornadofx.*

class DeleteAssignmentScreen : View("Delete Assignments") {

    val assignmentUIController: StudyAppUIController by inject()


    override val root = vbox {
        setPrefSize(600.0, 200.0)
        button("Delete Assignment JSON") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    assignmentUIController.deleteAssignment()
                }
            }
        }
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    assignmentUIController.closeDeleteAssignment()
                }
            }
        }
    }

}
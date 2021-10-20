package org.wit.studyApp.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.studyApp.console.controllers.StudyAppUIController
import tornadofx.*

class MenuScreen : View("Study Planner App") {

    val assignmentUIController: StudyAppUIController by inject()

    override val root = form {
        setPrefSize(600.0, 400.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Assignment Due Date") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadAddAssignmentScreen()
                    }
                }
            }
            text("")
            button("Add Exam Due Date") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadAddExamScreen()
                    }
                }
            }
            text("")
            button("List Assignments") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadListAssignmentScreen()
                    }
                }
            }
            text("")
            button("List Exams") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadListExamScreen()
                    }
                }
            }
            text("")
            button("Delete Assignment Due Date") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadDeleteAssignmentScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }

        }

    }


}
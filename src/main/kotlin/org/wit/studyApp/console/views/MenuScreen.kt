package org.wit.studyApp.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.studyApp.console.controllers.StudyAppUIController
import tornadofx.*

class MenuScreen : View("Study Planner App") {

    val assignmentUIController: StudyAppUIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Assignment Due Date") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadAddScreen()
                    }
                }
            }
            text("")
            button("List Assignments") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Delete Assignment Due Date") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.loadListScreen()
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
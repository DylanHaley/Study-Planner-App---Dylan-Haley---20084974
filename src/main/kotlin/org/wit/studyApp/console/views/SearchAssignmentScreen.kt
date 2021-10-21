package org.wit.studyApp.console.views

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.studyApp.console.controllers.StudyAppUIController
import tornadofx.*

class SearchAssignmentScreen : View("Search Assignments") {

    val model = ViewModel()
    val assignmentUIController: StudyAppUIController by inject()
    val id =  model.bind { SimpleStringProperty() }


    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Exam ID") {
                textfield(id).required()
            }
            button("Search") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentUIController.searchAssignments(id.toLong())
                    }
                }
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
}
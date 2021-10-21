package org.wit.studyApp.console.views

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.studyApp.console.controllers.StudyAppUIController
import tornadofx.*

 class AddAssignmentScreen : tornadofx.View("Add Assignments") {
    val model = ViewModel()
    val _title = model.bind { SimpleStringProperty() }
    val _date= model.bind { SimpleStringProperty() }
    val assignmentkUIController: StudyAppUIController by inject()

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Assignment Name") {
                textfield(_title).required()
            }
            field("Date") {
                textfield(_date).required()
            }
                button("Add") {
                    enableWhen(model.valid)
                    isDefaultButton = true
                    useMaxWidth = true
                    action {
                        runAsyncWithProgress {
                            assignmentkUIController.addAssignment(_title.toString(), _date.toString())

                        }
                    }
                }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentkUIController.closeAddAssignment()
                    }
                }
            }
        }
    }

    override fun onDock() {
        _title.value = ""
        _date.value = ""
        model.clearDecorators()
    }
}
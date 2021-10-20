package org.wit.studyApp.console.views

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.studyApp.console.controllers.StudyAppUIController
import tornadofx.*

class AddExamScreen : tornadofx.View("Add Exams") {
    val model = ViewModel()
    val _title = model.bind { SimpleStringProperty() }
    val _date= model.bind { SimpleStringProperty() }
    val assignmentkUIController: StudyAppUIController by inject()

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Exam Name") {
                textfield(_title).required()
            }
            field("Date") {
                textarea(_date).required()
            }
            button("Add") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentkUIController.addExam(_title.toString(),_date.toString())

                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        assignmentkUIController.closeExamAdd()
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
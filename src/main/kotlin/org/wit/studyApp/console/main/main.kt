package org.wit.studyApp.console.main

import org.wit.studyApp.console.controllers.StudyAppController
import org.wit.studyApp.console.models.AssignmentJSONStore

val assignments = AssignmentJSONStore()

fun main(args: Array<String>) {
    StudyAppController().start()
}



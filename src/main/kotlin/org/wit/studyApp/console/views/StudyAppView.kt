package org.wit.studyApp.console.views

import org.wit.studyApp.console.main.view
import org.wit.studyApp.console.main.assignments
import org.wit.studyApp.console.models.StudyAppJSONStore
import org.wit.studyApp.console.models.StudyAppMemStore
import org.wit.studyApp.console.models.StudyAppModel

class StudyAppView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("Manage Your Study")
        println("---Assignment Tracker---")
        println(" 1. Add an Assignment Due Date ")
        println(" 2. Update Assignment Due Date")
        println(" 3. List Assignment Due Dates")
        println(" 4. Search Assignment Due Dates")
        println("---Exam Tracker---")
        println(" 5. Add an Exam Date")
        println(" 6. Update Exam Date")
        println(" 7. List Exam Date")
        println(" 8. Search Exam Date")
        println("----------------")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listAssignmentPlacemark(assignments: StudyAppJSONStore) {
        println("Listing Assignments")
        println()
        assignments.logAll()
        println()
    }

    fun showAssignmentPlacemark(assignment : StudyAppModel) {
        if(assignment != null)
            println("Assignment Details [ $assignment ]")
        else
            println("Assignment Not Found...")
    }

    fun addAssignmentPlacemarkData(assignment : StudyAppModel) : Boolean {

        println()
        print("Enter Assignment Name : ")
        assignment.title = readLine()!!
        print("Enter Assignment Due Date : ")
        assignment.Date = readLine()!!

        return assignment.title.isNotEmpty() && assignment.Date.isNotEmpty()
    }

    fun updateAssignmentPlacemarkData(assignment : StudyAppModel) : Boolean {

        var tempTitle: String?
        var tempDescription: String?

        if (assignment != null) {
            print("Enter a new Assignment Name for [ " + assignment.title + " ] : ")
            tempTitle = readLine()!!
            print("Enter a new Due Date [ " + assignment.Date + " ] : ")
            tempDescription = readLine()!!

            if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
                assignment.title = tempTitle
                assignment.Date = tempDescription
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}
//package org.wit.studyApp.console.main
//
//import mu.KotlinLogging
//import org.wit.studyApp.console.models.StudyAppJSONStore
//import org.wit.studyApp.console.models.StudyAppModel
//import org.wit.studyApp.console.views.StudyAppView
//
//private val logger = KotlinLogging.logger {}
//
//val assignments = StudyAppJSONStore()
//val view = StudyAppView()
//
//fun main(args: Array<String>) {
//    logger.info { "Launching Study Planner App" }
//    println("Study Planner App")
//    println("Log your study routine to help you reach your goals")
//    println("-------------------------------------")
//    println("Dylan Haley")
//    println("-------------------------------------")
//    var input: Int
//
//    do {
//        input view.menu()
//        when(input) {
//            1 -> addAssignmentPlacemark()
//            2 -> updateAssignment()
//            3 -> view.listAssignmentPlacemark(assignments)
//            4 -> searchAssignments()
//            -1 -> println("Exiting Study App....... Goodbye")
//            else -> println("Invalid Option, Please Try Again")
//        }
//        println()
//    } while (input != -1)
//    logger.info { "Shutting Down Study Planner App" }
//}
//
//fun addAssignmentPlacemark(){
//    var aPlacemark = StudyAppModel()
//
//    if (view.addAssignmentPlacemarkData(aPlacemark))
//        assignments.create(aPlacemark)
//    else
//        logger.info("Assignment Not Added")
//}
//
//fun updateAssignment() {
//
//    view.listAssignmentPlacemark(assignments)
//    var searchId = view.getId()
//    val aPlacemark = search(searchId)
//
//    if(aPlacemark != null) {
//        if(view.updateAssignmentPlacemarkData(aPlacemark)) {
//            assignments.update(aPlacemark)
//            view.showAssignmentPlacemark(aPlacemark)
//            logger.info("Assignment Updated : [ $aPlacemark ]")
//        }
//        else
//            logger.info("Assignment Not Updated")
//    }
//    else
//        println("Assignment Not Updated...")
//}
//
//fun searchAssignments() {
//    val aPlacemark = search(view.getId())!!
//    view.showAssignmentPlacemark(aPlacemark)
//}
//
//
//fun search(id: Long) : StudyAppModel? {
//    var foundAssignment = assignments.findOne(id)
//    return foundAssignment
//}
//
////fun dummyData() {
////    assignments.create(StudyAppModel(title = "New York New York", Date = "So Good They Named It Twice"))
////    assignments.create(StudyAppModel(title= "Ring of Kerry", Date = "Some place in the Kingdom"))
////    assignments.create(StudyAppModel(title = "Waterford City", Date = "You get great Blaas Here!!"))
////}
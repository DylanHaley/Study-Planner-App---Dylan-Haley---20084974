//package org.wit.studyApp.console.controllers
//
//import mu.KotlinLogging
//import org.wit.studyApp.console.models.StudyAppJSONStore
//import org.wit.studyApp.console.models.StudyAppModel
//import org.wit.studyApp.console.views.StudyAppView
//
//class StudyAppController {
//
//    val assignments = StudyAppJSONStore()
//
//    val assignmentView = StudyAppView()
//    val logger = KotlinLogging.logger {}
//
//    init {
//        logger.info { "Launching Study Planner Console App" }
//    }
//
//    fun start() {
//        var input: Int
//
//        do {
//            input = menu()
//            when (input) {
//                1 -> add()
//                2 -> update()
//                3 -> list()
//                4 -> search()
//                -99 -> dummyData()
//                -1 -> println("Exiting App")
//                else -> println("Invalid Option")
//            }
//            println()
//        } while (input != -1)
//        logger.info { "Shutting Down Placemark Console App" }
//    }
//
//    fun menu() :Int { return assignmentView.menu() }
//
//    fun add(){
//        var aPlacemark = StudyAppModel()
//
//        if (assignmentView.addAssignmentPlacemarkData(aPlacemark))
//            assignments.create(aPlacemark)
//        else
//            logger.info("Placemark Not Added")
//    }
//
//    fun list() {
//        assignmentView.listAssignmentPlacemark(assignments)
//    }
//
//    fun update() {
//
//        assignmentView.listAssignmentPlacemark(assignments)
//        var searchId = assignmentView.getId()
//        val aPlacemark = search(searchId)
//
//        if(aPlacemark != null) {
//            if(assignmentView.updateAssignmentPlacemarkData(aPlacemark)) {
//                assignments.update(aPlacemark)
//                assignmentView.showAssignmentPlacemark(aPlacemark)
//                logger.info("Placemark Updated : [ $aPlacemark ]")
//            }
//            else
//                logger.info("Placemark Not Updated")
//        }
//        else
//            println("Placemark Not Updated...")
//    }
//
//    fun search() {
//        val aPlacemark = search(assignmentView.getId())!!
//        assignmentView.showAssignmentPlacemark(aPlacemark)
//    }
//
//
//    fun search(id: Long) : StudyAppModel? {
//        var foundPlacemark = assignments.findOne(id)
//        return foundPlacemark
//    }
//
//    fun dummyData() {
//        assignments.create(StudyAppModel(title = "New York New York", Date = "So Good They Named It Twice"))
//        assignments.create(StudyAppModel(title= "Ring of Kerry", Date = "Some place in the Kingdom"))
//        assignments.create(StudyAppModel(title = "Waterford City", Date = "You get great Blaas Here!!"))
//    }
//}
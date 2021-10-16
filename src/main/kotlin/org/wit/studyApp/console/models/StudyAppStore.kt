package org.wit.studyApp.console.models

interface StudyAppStore {
    fun findAll(): List<StudyAppModel>
    fun findOne(id: Long): StudyAppModel?
    fun create(assignment: StudyAppModel)
    fun update(assignment: StudyAppModel)
}

/**
 * Domain Logic
 *
 * @startuml
 * package startapp {
 * class Project<<(E,orchid)>>
 * class Issue<<(E,orchid)>>
 * Project "1" o-> "*" Issue
 * class ProjectRepository "use" -.> Project
 * class IssueRepository "use" -.> Issue
 * }
 * hide members
 * @enduml
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 */
package org.maxur.tutor.startapp.domain;
Domain Logic

@startuml
package startapp {
class Project<<(E,orchid)>>
class Issue<<(E,orchid)>>
Project "1" o-> "*" Issue
class ProjectRepository "use" -.> Project
class IssueRepository "use" -.> Issue
}
hide members
@enduml

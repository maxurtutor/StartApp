CREATE TABLE issues
(
  issue_id VARCHAR(36) PRIMARY KEY NOT NULL,
  name VARCHAR(100) UNIQUE NOT NULL,
  description TEXT,
  project_id VARCHAR(36) NOT NULL,
  CONSTRAINT "project_id_fk" FOREIGN KEY (project_id) REFERENCES projects(project_id)
)
/**
 * This class is generated by jOOQ
 */
package org.maxur.tutor.startapp.db.schema;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;
import org.maxur.tutor.startapp.db.schema.tables.Issues;
import org.maxur.tutor.startapp.db.schema.tables.Projects;
import org.maxur.tutor.startapp.db.schema.tables.SchemaVersion;
import org.maxur.tutor.startapp.db.schema.tables.records.IssuesRecord;
import org.maxur.tutor.startapp.db.schema.tables.records.ProjectsRecord;
import org.maxur.tutor.startapp.db.schema.tables.records.SchemaVersionRecord;


/**
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<SchemaVersionRecord> SCHEMA_VERSION_PK = UniqueKeys0.SCHEMA_VERSION_PK;
    public static final UniqueKey<ProjectsRecord> CONSTRAINT_F = UniqueKeys0.CONSTRAINT_F;
    public static final UniqueKey<ProjectsRecord> CONSTRAINT_F3 = UniqueKeys0.CONSTRAINT_F3;
    public static final UniqueKey<IssuesRecord> CONSTRAINT_8 = UniqueKeys0.CONSTRAINT_8;
    public static final UniqueKey<IssuesRecord> CONSTRAINT_81 = UniqueKeys0.CONSTRAINT_81;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<IssuesRecord, ProjectsRecord> PROJECT_ID_FK = ForeignKeys0.PROJECT_ID_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<SchemaVersionRecord> SCHEMA_VERSION_PK = createUniqueKey(SchemaVersion.SCHEMA_VERSION, "schema_version_pk", SchemaVersion.SCHEMA_VERSION.VERSION);
        public static final UniqueKey<ProjectsRecord> CONSTRAINT_F = createUniqueKey(Projects.PROJECTS, "CONSTRAINT_F", Projects.PROJECTS.PROJECT_ID);
        public static final UniqueKey<ProjectsRecord> CONSTRAINT_F3 = createUniqueKey(Projects.PROJECTS, "CONSTRAINT_F3", Projects.PROJECTS.NAME);
        public static final UniqueKey<IssuesRecord> CONSTRAINT_8 = createUniqueKey(Issues.ISSUES, "CONSTRAINT_8", Issues.ISSUES.ISSUE_ID);
        public static final UniqueKey<IssuesRecord> CONSTRAINT_81 = createUniqueKey(Issues.ISSUES, "CONSTRAINT_81", Issues.ISSUES.NAME);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<IssuesRecord, ProjectsRecord> PROJECT_ID_FK = createForeignKey(org.maxur.tutor.startapp.db.schema.Keys.CONSTRAINT_F, Issues.ISSUES, "project_id_fk", Issues.ISSUES.PROJECT_ID);
    }
}

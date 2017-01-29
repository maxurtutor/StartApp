/**
 * This class is generated by jOOQ
 */
package org.maxur.tutor.startapp.db.schema.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import org.maxur.tutor.startapp.db.schema.tables.Issues;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IssuesRecord extends UpdatableRecordImpl<IssuesRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 1248619918;

    /**
     * Setter for <code>PUBLIC.ISSUES.ISSUE_ID</code>.
     */
    public IssuesRecord setIssueId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.ISSUES.ISSUE_ID</code>.
     */
    public String getIssueId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>PUBLIC.ISSUES.NAME</code>.
     */
    public IssuesRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.ISSUES.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.ISSUES.DESCRIPTION</code>.
     */
    public IssuesRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.ISSUES.DESCRIPTION</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.ISSUES.PROJECT_ID</code>.
     */
    public IssuesRecord setProjectId(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.ISSUES.PROJECT_ID</code>.
     */
    public String getProjectId() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Issues.ISSUES.ISSUE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Issues.ISSUES.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Issues.ISSUES.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Issues.ISSUES.PROJECT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getIssueId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getProjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IssuesRecord value1(String value) {
        setIssueId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IssuesRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IssuesRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IssuesRecord value4(String value) {
        setProjectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IssuesRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IssuesRecord
     */
    public IssuesRecord() {
        super(Issues.ISSUES);
    }

    /**
     * Create a detached, initialised IssuesRecord
     */
    public IssuesRecord(String issueId, String name, String description, String projectId) {
        super(Issues.ISSUES);

        set(0, issueId);
        set(1, name);
        set(2, description);
        set(3, projectId);
    }
}

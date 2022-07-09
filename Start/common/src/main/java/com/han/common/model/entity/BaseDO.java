package com.han.common.model.entity;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassNAME BaseDO
 * @Description
 * @Author wuj
 * @Date 2022/7/9 15:08
 */
@NoArgsConstructor
public abstract class BaseDO implements Serializable {


    private static final long serialVersionUID = 2174741380632669212L;

    /**
     * primary key.
     */
    private String id;

    /**
     * created time.
     */
    private Timestamp dateCreated;

    /**
     * updated time.
     */
    private Timestamp dateUpdated;

    protected BaseDO(final String id, final Timestamp dateCreated, final Timestamp dateUpdated) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    /**
     * Gets the value of id.
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the value of dateCreated.
     *
     * @return the value of dateCreated
     */
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the dateCreated.
     *
     * @param dateCreated dateCreated
     */
    public void setDateCreated(final Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets the value of dateUpdated.
     *
     * @return the value of dateUpdated
     */
    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    /**
     * Sets the dateUpdated.
     *
     * @param dateUpdated dateUpdated
     */
    public void setDateUpdated(final Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseDO)) {
            return false;
        }
        BaseDO baseDO = (BaseDO) o;
        return Objects.equals(id, baseDO.id) && Objects.equals(dateCreated, baseDO.dateCreated) && Objects.equals(dateUpdated, baseDO.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreated, dateUpdated);
    }

}

/*
 * Copyright (C) 2018 Clivern <http://clivern.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.ponut.model;

import io.ebean.Model;
import javax.persistence.Id;
import io.ebean.annotation.NotNull;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Bots Model
 *
 * @since 1.0.0
 */
@Entity
@Table(name="bots")
public class BotModel extends BaseModel {

    @NotNull
    @Column(name="`name`")
    String name;

    @NotNull
    @Column(name="`slug`")
    String slug;

    @NotNull
    @Column(name="`status`")
    String status;

    @NotNull
    @Column(name="`type`")
    String type;

    @NotNull
    @Column(name="`isDefault`")
    String isDefault;

    @NotNull
    @Column(name="`created`")
    String created;

    @NotNull
    @Column(name="`updated`")
    String updated;

    /**
     * Class Constructor
     *
     * @param  name
     * @param  slug
     * @param  status
     * @param  created
     * @param  updated
     */
    public BotModel(String name, String slug, String status, String type, String isDefault, String created, String updated)
    {
        this.name = name;
        this.slug = slug;
        this.status = status;
        this.type = type;
        this.isDefault = isDefault;
        this.created = created;
        this.updated = updated;
    }

    /**
     * Set Name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Set Slug
     *
     * @param slug
     */
    public void setSlug(String slug)
    {
        this.slug = slug;
    }

    /**
     * Set Status
     *
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * Set Type
     *
     * @param type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Set Is Default
     *
     * @param isDefault
     */
    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
    }

    /**
     * Set Created
     *
     * @param created
     */
    public void setCreated(String created)
    {
        this.created = created;
    }

    /**
     * Set Updated
     *
     * @param updated
     */
    public void setUpdated(String updated)
    {
        this.updated = updated;
    }

    /**
     * Get Name
     *
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Get Slug
     *
     * @return String
     */
    public String getSlug()
    {
        return this.slug;
    }

    /**
     * Get Status
     *
     * @return String
     */
    public String getStatus()
    {
        return this.status;
    }

    /**
     * Get Type
     *
     * @return String
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Get Is Default
     *
     * @return String
     */
    public String getIsDefault()
    {
        return this.isDefault;
    }

    /**
     * Get Created
     *
     * @return String
     */
    public String getCreated()
    {
        return this.created;
    }

    /**
     * Get Updated
     *
     * @return String
     */
    public String getUpdated()
    {
        return this.updated;
    }
}
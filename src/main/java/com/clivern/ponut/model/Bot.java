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

/**
 * Bots Model
 *
 * @since 1.0.0
 */
@Entity
@Table(name="bots")
public class Bot extends Model {

    @Id
    Integer id;

    @NotNull
    String name;

    @NotNull
    String slug;

    @NotNull
    String status;

    @NotNull
    String created;

    @NotNull
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
    public Migration(String name, String slug, String status, String created, String updated)
    {
        this.name = name;
        this.slug = slug;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * Set ID
     *
     * @param id
     */
    public void setId(Long id)
    {
      this.id = id;
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
     * Get ID
     *
     * @return Integer
     */
    public Long getId()
    {
      return this.id;
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
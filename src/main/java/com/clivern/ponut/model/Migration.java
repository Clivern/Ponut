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
 * Migrations Model
 *
 * @since 1.0.0
 */
@Entity
@Table(name="migrations")
public class Migration extends Model {

    @Id
    Long id;

    @NotNull
    String key;

    @NotNull
    String value;

    @NotNull
    String status;


    public Migration(String key, String value, String status)
    {
        this.key = key;
        this.value = value;
        this.status = status;
    }

    public void setId(Long id)
    {
      this.id = id;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Long getId()
    {
      return this.id;
    }

    public String getKey()
    {
        return this.key;
    }

    public String getValue()
    {
        return this.value;
    }

    public String getStatus()
    {
        return this.status;
    }
}
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

import io.ebean.annotation.NotNull;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="options")
public class Option extends BaseOption {

  	@NotNull
  	String opkey;

  	@NotNull
  	String opvalue;

  	@NotNull
  	String autoload;

  	public Option(String opkey, String opvalue, String autoload)
  	{
  		this.opkey = opkey;
  		this.opvalue = opvalue;
  		this.autoload = autoload;
  	}

  	public void setKey(String opkey)
  	{
  		this.opkey = opkey;
  	}

  	public void setValue(String opvalue)
  	{
  		this.opvalue = opvalue;
  	}

  	public void setAutoload(String autoload)
  	{
  		this.autoload = autoload;
  	}

  	public String getKey()
  	{
  		return this.opkey;
  	}

  	public String getValue()
  	{
  		return this.opvalue;
  	}

  	public String getAutoload()
  	{
  		return this.autoload;
  	}
}
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
package com.clivern.ponut.controller.console;

/**
 * Create Command
 *
 * @since 1.0.0
 */
public class Create {

	private boolean info = false;
	private String type;
	private String name;


	public Create setName(String name)
	{
		this.name = name;

		return this;
	}

	public Create setType(String type)
	{
		this.type = type;

		return this;
	}

	public Create setInfo(Boolean info)
	{
		this.info = info;

		return this;
	}

	public String getName()
	{
		return this.name;
	}

	public String getType()
	{
		return this.type;
	}

	public boolean getInfo()
	{
		return this.info;
	}

    public void run() {
    	System.out.printf("Create a New Bot \n > JAR create %s -t %s \n > JAR create %s --type %s \n > JAR create %s -t %s %s \n > JAR -c %s -t %s \n", this.name, this.type, this.name, this.type, this.name, this.type, (this.info) ? " -i" : "", this.name, this.type);
    }

    public static void help()
    {
    	System.out.println(" Create a New Bot \n > JAR create fred -t slack \n > JAR create fred --type messenger \n > JAR create fred -t slack -i \n > JAR -c fred -t slack");
    }
}
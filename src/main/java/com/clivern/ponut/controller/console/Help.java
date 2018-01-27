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
 * Help Command
 *
 * @since 1.0.0
 */
public class Help {

	private String command;

	public Help setCommand(String command)
	{
		this.command = command;

		return this;
	}

	public String getCommand()
	{
		return this.command;
	}

    public void run()
    {
    	if( this.command.equals("-c") || this.command.equals("create") || this.command.equals("create=<bot>") ){
    		Create.help();
    	}
    }
}
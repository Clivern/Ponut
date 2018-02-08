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

    /**
     * Class Constructor
     *
     * @param  command
     */
    public Help(String command)
    {
        this.command = command;
    }

    /**
     * Run Command
     */
    public void run()
    {
        if( this.command.equals("-c") || this.command.equals("create") || this.command.equals("create=<bot>") ){
            Create.help();
        }

        if( this.command.equals("-D") || this.command.equals("delete") || this.command.equals("delete=<bot>") ){
            Delete.help();
        }

        if( this.command.equals("-l") || this.command.equals("--list") ){
            List.help();
        }

        if( this.command.equals("-m") || this.command.equals("migrate=<all||file>") || this.command.equals("migrate") ){
            Migrate.help();
        }

        if( this.command.equals("seed") || this.command.equals("--seed") ){
            Seed.help();
        }

        if( this.command.equals("-s") || this.command.equals("status") ){
            Status.help();
        }

        if( this.command.equals("-v") || this.command.equals("--version") ){
            Version.help();
        }
    }
}
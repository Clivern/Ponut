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

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.lang.String;

/**
 * Map commands printed in the command line to the appropriate console controller
 *
 * @since 1.0.0
 */
public class Mapper implements Runnable {

	/**
     * Create a New Bot
     * $> JAR create fred -t slack
     * $> JAR create fred --type messenger
     * $> JAR create fred -t slack -i
     * $> JAR -c fred -t slack
     *
     * Get Version Info
     * $> JAR -v
     * $> JAR --version
     *
     * List all Bots
     * $> JAR -l
     * $> JAR --list
     * $> JAR -l -t slack
     * $> JAR -l -n fred
     *
     * Get Bots Status
     * $> JAR -s
     * $> JAR status
     * $> JAR status -n fred
     * $> JAR status --name fred
     * $> JAR status -t slack
     *
     * Delete a Bot
     * $> JAR -D fred
     * $> JAR delete fred
	 */
    @Option(names = { "-c", "create" }, paramLabel="<bot>", description = "Create a new bot")
    private String create;

    @Option(names = { "-D", "delete" }, paramLabel="<bot>", description = "Delete an existing bot")
    private String delete;

    @Option(names = { "-m", "migrate" }, paramLabel="<all||file>", description = "Run all or specific migration")
    private String migrate;

    @Option(names = { "-s", "status" }, description = "Get bot(s) status")
    private Boolean status = false;

    @Option(names = { "-t", "--type" }, paramLabel="<type>", description = "Set the bot type for any command")
    private String type;

    @Option(names = { "-n", "--name" }, paramLabel="<bot>", description = "Set the bot name for any command")
    private String name;

    @Option(names = {"-l", "--list"}, description = "Get a list of all bots")
    private Boolean list = false;

    @Option(names = {"seed", "--seed"}, description = "Run database seeders")
    private Boolean seed = false;

    @Option(names = {"-i", "--info"}, description = "Get more log output")
    private Boolean verbose = false;

    @Option(names = { "-v", "--version" }, description = "Print version information and quit")
    private Boolean version = false;

    @Option(names = { "-e", "exec" }, paramLabel="<CMD>" ,description = "Execute a custom command")
    private String execute;

    @Option(names = { "-h", "help" }, paramLabel="<command>", description = "Get a helpful info about command")
    private String help;


    public void run() {

        if( this.version ){
            new Version().run();
        }

        if( this.create != null ){
            new Create().setName((this.create != null) ? this.create : "").setType((this.type != null) ? this.type : "").setInfo(this.verbose).run();
        }

        if( this.help != null ){
            new Help().setCommand(this.help).run();
        }
    }

	public static void call(String[] args)
	{
		CommandLine.run(new Mapper(), System.out, args);
	}
}
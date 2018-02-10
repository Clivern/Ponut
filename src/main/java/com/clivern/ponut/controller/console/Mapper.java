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

import org.pmw.tinylog.Logger;
import picocli.CommandLine.Command;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * Map commands printed in the command line to the appropriate console controller
 *
 * @since 1.0.0
 */
@Command(
    name = "Ponut",
    sortOptions = false,
    header = {
        "@|green  _____   ____  _   _ _    _ _______|@",
        "@|green |  __ \\ / __ \\| \\ | | |  | |__   __||@",
        "@|green | |__) | |  | |  \\| | |  | |  | ||@",
        "@|green |  ___/| |  | | . ` | |  | |  | ||@",
        "@|green | |    | |__| | |\\  | |__| |  | ||@",
        "@|green |_|     \\____/|_| \\_|\\____/   |_||@",
        ""
    },
    description = {
        "",
        "Demonstrates ponut commands and usage help."
    },
    optionListHeading = "@|bold %nCommands|@:%n",
    footer = {
        "",
        "@|cyan If you would like to contribute or report an issue|@",
        "@|cyan go to github: https://github.com/clivern/ponut|@",
        "",
        "@|cyan If you like the project star it on github and follow me on twitter (@clivernco)!|@",
        "@|cyan This project is created and maintained by Clivern (http://clivern.com)|@",
        ""
    }
)
public class Mapper implements Runnable {

    @Option(names = { "-c", "create" }, paramLabel="<bot>", description = "Create a new bot")
    private String create;

    @Option(names = { "-D", "delete" }, paramLabel="<bot>", description = "Delete an existing bot")
    private String delete;

    @Option(names = { "-m", "migrate" }, paramLabel="<up|down||file>", description = "Run all or specific migration")
    private String migrate;

    @Option(names = {"seed", "--seed"}, paramLabel="<up|down||file>", description = "Run database seeders")
    private String seed;

    @Option(names = { "-s", "status" }, description = "Get bot(s) status")
    private Boolean status = false;

    @Option(names = { "-t", "--type" }, paramLabel="<type>", description = "Set the bot type for any command")
    private String type;

    @Option(names = { "-n", "--name" }, paramLabel="<bot>", description = "Set the bot name for any command")
    private String name;

    @Option(names = {"-l", "--list"}, description = "Get a list of all bots")
    private Boolean list = false;

    @Option(names = {"-i", "--info"}, description = "Get more log output")
    private Boolean verbose = false;

    @Option(names = { "-v", "--version" }, description = "Print version information and quit")
    private Boolean version = false;

    @Option(names = { "-e", "exec" }, paramLabel="<CMD>" ,description = "Execute a custom command")
    private String execute;

    @Option(names = { "-h", "help" }, paramLabel="<command>", description = "Get a helpful info about command")
    private String help;


    /**
     * Run Commands
     */
    public void run()
    {
        //Migrate Command
        if( this.migrate != null ){
            Logger.info("Calling Command [ $.. migrate " + this.migrate + " ]");
            new Migrate(this.migrate).run();
        }

        //Seed Command
        if( this.seed != null ){
            Logger.info("Calling Command [ $.. seed " + this.seed + " ]");
            new Seed(this.seed).run();
        }

        //Version Command
        if( this.version ){
            Logger.info("Calling Command [ $.. --version ]");
            new Version().run();
        }

        //Help Command
        if( this.help != null ){
            Logger.info("Calling Command [ $.. help " + this.help + " ]");
            new Help(this.help).run();
        }
    }

    /**
     * Call Command
     *
     * @param args
     */
    public static void call(String[] args)
    {
        CommandLine.run(new Mapper(), System.out, args);
    }
}
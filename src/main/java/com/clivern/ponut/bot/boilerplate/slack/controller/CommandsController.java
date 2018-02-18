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
package com.clivern.ponut.bot.boilerplate.slack.controller;

import spark.Request;
import spark.Response;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.util.*;
import com.clivern.fred.sender.BaseSender;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.clivern.fred.receiver.BaseReceiver;
import com.clivern.fred.receiver.command.Command;
import com.clivern.ponut.bot.boilerplate.slack.service.SettingsService;
import com.clivern.fred.exception.CommandNotFound;
import java.io.IOException;

/**
 * Commands Controller
 *
 * @since 1.0.0
 */
public class CommandsController {

	/**
	 * Respond To Commands
	 *
	 * @param  request
	 * @param  response
	 * @return String
	 * @throws UnirestException
	 * @throws CommandNotFound
	 * @throws IOException
	 */
    public static String renderCommands(Request request, Response response) throws UnirestException, CommandNotFound, IOException
    {
        Config config = new Config();
		Map<String, String> options = SettingsService.instance().getOptions();
		for (Map.Entry<String, String> option : options.entrySet()) {
		    config.set(option.getKey(), option.getValue());
		}
        config.configLogger();
        BaseReceiver baseReceiver = new BaseReceiver(config);

        // Build Our First Command (/fred Command)
        Command fredCommand = new Command("/fred", false, (ct) -> "You Typed -> " + ct.getText() + " To /fred");

        // Build Another Command (/frog Command)
        Command frogCommand = new Command("/frog", false, (ct) -> "You Typed -> " + ct.getText() + " To /frog");

        // Pass Commands To The Receiver
        baseReceiver.setCommand("/fred", fredCommand);
        baseReceiver.setCommand("/frog", frogCommand);

        // Check If Incoming Data Related to Any Configured Command (/fred or /frog)
        if( baseReceiver.commandExists(request.queryParams("command")) ){
            Map<String, String> incomingData = new HashMap<String, String>();
            incomingData.put("channel_name", request.queryParams("channel_name"));
            incomingData.put("user_id", request.queryParams("user_id"));
            incomingData.put("user_name", request.queryParams("user_name"));
            incomingData.put("trigger_id", request.queryParams("trigger_id"));
            incomingData.put("team_domain", request.queryParams("team_domain"));
            incomingData.put("team_id", request.queryParams("team_id"));
            incomingData.put("text", request.queryParams("text"));
            incomingData.put("channel_id", request.queryParams("channel_id"));
            incomingData.put("command", request.queryParams("command"));
            incomingData.put("token", request.queryParams("token"));
            incomingData.put("response_url", request.queryParams("response_url"));

            return baseReceiver.callCurrentCommand(request.queryParams("command"), incomingData);
        }
        return "Command Not Configured In App!";
    }
}
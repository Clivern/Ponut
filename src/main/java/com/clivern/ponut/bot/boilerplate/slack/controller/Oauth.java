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

import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import com.clivern.fred.util.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.clivern.ponut.bot.boilerplate.slack.service.SettingsService;
import com.clivern.fred.exception.CommandNotFound;
import java.io.IOException;

public class Oauth {

    public static String renderRedirectURL(Request request, Response response) throws UnirestException, CommandNotFound, IOException
    {
        Config config = new Config();
		Map<String, String> options = SettingsService.instance().getOptions();
		for (Map.Entry<String, String> option : options.entrySet()) {
		    config.set(option.getKey(), option.getValue());
	    }
        Log log = new Log(config);
        Oauth oauth = new Oauth(config, log);
        return "<a href='" + oauth.getRedirectURL() + "'>Auth</a>";
    }

    public static String renderOauth(Request request, Response response) throws UnirestException, CommandNotFound, IOException
    {
        Config config = new Config();
        Map<String, String> options = SettingsService.instance().getOptions();
		for (Map.Entry<String, String> option : options.entrySet()) {
		    config.set(option.getKey(), option.getValue());
		}
        Log log = new Log(config);
        Oauth oauth = new Oauth(config, log);

        Boolean status = oauth.issueToken(
            ( request.queryParams("code") != null ) ? request.queryParams("code") : "",
            ( request.queryParams("state") != null ) ? request.queryParams("state") : "",
            ( request.queryParams("error") != null ) ? request.queryParams("error") : ""
        );

        Boolean fetch = oauth.fetchAccessToken();

        if( status && fetch ){

            return  "State: " +  oauth.getState() + "<br/>" +
                    "Client ID: " +  oauth.getClientId() + "<br/>" +
                    "Client Secret: " +  oauth.getClientSecret() + "<br/>" +
                    "Scope: " +  oauth.getScope() + "<br/>" +
                    "Redirect Uri: " +  oauth.getRedirectUri() + "<br/>" +
                    "State Type: " +  oauth.getStateType() + "<br/>" +
                    "Team: " +  oauth.getTeam() + "<br/>" +
                    "Incoming Code: " +  oauth.getIncomingCode() + "<br/>" +
                    "Incoming State: " +  oauth.getIncomingState() + "<br/>" +
                    "Incoming Error: " +  oauth.getIncomingError() + "<br/>" +
                    "Incoming Access Token: " +  oauth.getIncomingAccessToken() + "<br/>" +
                    "Incoming Scope: " +  oauth.getIncomingScope() + "<br/>" +
                    "Incoming User ID: " +  oauth.getIncomingUserId() + "<br/>" +
                    "Incoming Team Name: " +  oauth.getIncomingTeamName() + "<br/>" +
                    "Incoming Team ID: " +  oauth.getIncomingTeamId() + "<br/>" +
                    "Incoming Webhook URL: " +  oauth.getIncomingWebhookUrl() + "<br/>" +
                    "Incoming Webhook Channel: " +  oauth.getIncomingWebhookChannel() + "<br/>" +
                    "Incoming Webhook Config URL: " +  oauth.getIncomingWebhookConfigUrl() + "<br/>" +
                    "Incoming Bot User ID: " +  oauth.getIncomingBotUserId() + "<br/>" +
                    "Incoming Bot Access Token: " +  oauth.getIncomingBotAccessToken() + "<br/>";

        }else{
            return "Error";
        }
    }

}
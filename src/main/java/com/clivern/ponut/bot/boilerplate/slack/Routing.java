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
package com.clivern.ponut.bot.boilerplate.slack;

import static spark.Spark.*;
import com.clivern.ponut.bot.boilerplate.slack.controller.*;

/**
 * Routing Class
 *
 * @since 1.0.0
 */
public class Routing {

	/**
	 * Define Bot Routes
	 */
    public void call()
    {
        get("/slack", (request, response) -> OauthController.renderRedirectURL(request, response));
        post("/slack/oauth", (request, response) -> OauthController.renderOauth(request, response));
        post("/slack/commands", (request, response) -> CommandsController.renderCommands(request, response));
    }
}
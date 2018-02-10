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
package com.clivern.ponut.bot.boilerplate.messenger.controller;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import spark.Request;
import spark.Response;
import org.pmw.tinylog.Logger;
import com.clivern.racter.BotPlatform;
import com.clivern.ponut.bot.boilerplate.messenger.service.SettingsService;

/**
 * Verify Messenger Bot
 *
 * @since 1.0.0
 */
public class Verify {

    /**
     * Render Method
     *
     * @param  request
     * @param  response
     * @return String
     */
    public static String render(Request request, Response response) throws IOException
    {
        BotPlatform platform = new BotPlatform(SettingsService.instance().getOptions());
        platform.getVerifyWebhook().setHubMode(( request.queryParams("hub.mode") != null ) ? request.queryParams("hub.mode") : "");
        platform.getVerifyWebhook().setHubVerifyToken(( request.queryParams("hub.verify_token") != null ) ? request.queryParams("hub.verify_token") : "");
        platform.getVerifyWebhook().setHubChallenge(( request.queryParams("hub.challenge") != null ) ? request.queryParams("hub.challenge") : "");

        if( platform.getVerifyWebhook().challenge() ){
            platform.finish();
            response.status(200);
            return ( request.queryParams("hub.challenge") != null ) ? request.queryParams("hub.challenge") : "";
        }

        platform.finish();
        response.status(403);
        return "Verification token mismatch";
    }
}
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
import com.clivern.racter.BotPlatform;
import com.clivern.racter.receivers.webhook.*;
import com.clivern.racter.senders.*;
import com.clivern.racter.senders.templates.*;
import com.clivern.ponut.bot.boilerplate.messenger.service.SettingsService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.pmw.tinylog.Logger;

/**
 * Proccess and Respond To Messenger Requests
 *
 * @since 1.0.0
 */
public class RequestsController {

    /**
     * Render Method
     *
     * @param  request
     * @param  response
     * @return String
     * @throws IOException
     * @throws UnirestException
     */
    public static String render(Request request, Response response) throws IOException, UnirestException
    {
        String body = request.body();
        BotPlatform platform = new BotPlatform(SettingsService.instance().getOptions());
        platform.getBaseReceiver().set(body).parse();
        HashMap<String, MessageReceivedWebhook> messages = (HashMap<String, MessageReceivedWebhook>) platform.getBaseReceiver().getMessages();
        for (MessageReceivedWebhook message : messages.values()) {

            String user_id = (message.hasUserId()) ? message.getUserId() : "";
            String page_id = (message.hasPageId()) ? message.getPageId() : "";
            String message_id = (message.hasMessageId()) ? message.getMessageId() : "";
            String message_text = (message.hasMessageText()) ? message.getMessageText() : "";
            String quick_reply_payload = (message.hasQuickReplyPayload()) ? message.getQuickReplyPayload() : "";
            Long timestamp = (message.hasTimestamp()) ? message.getTimestamp() : 0;
            HashMap<String, String> attachments = (message.hasAttachment()) ? (HashMap<String, String>) message.getAttachment() : new HashMap<String, String>();

            Logger.info("User ID#:" + user_id);
            Logger.info("Page ID#:" + page_id);
            Logger.info("Message ID#:" + message_id);
            Logger.info("Message Text#:" + message_text);
            Logger.info("Quick Reply Payload#:" + quick_reply_payload);


            for (String attachment : attachments.values()) {
                Logger.info("Attachment#:" + attachment);
            }

            String text = message.getMessageText();
            MessageTemplate message_tpl = platform.getBaseSender().getMessageTemplate();

            if( text.equals("text") ){

                message_tpl.setRecipientId(message.getUserId());
                message_tpl.setMessageText("Hello World");
                message_tpl.setNotificationType("REGULAR");
                platform.getBaseSender().send(message_tpl);

            }else{

                message_tpl.setRecipientId(message.getUserId());
                message_tpl.setMessageText("Noop, I don't understand");
                message_tpl.setNotificationType("REGULAR");
                platform.getBaseSender().send(message_tpl);
            }

            return "Ok";
        }

        return "No Request";
    }
}
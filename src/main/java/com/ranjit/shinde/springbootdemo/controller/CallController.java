package com.ranjit.shinde.springbootdemo.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.type.PhoneNumber;

import java.net.URI;

@RestController
@RequestMapping("/calls")
@Validated
@Slf4j
public class CallController {

    public static final String ACCOUNT_SID = System.getenv("ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("AUTH_TOKEN");

    @GetMapping("/")
    public String handleCall(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        call();
        return "done";
    }

    @GetMapping("/message")
    public String handleMessage(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        sendSMS();
        return "done";
    }

    private void call() {
        Call call = Call.creator(
                new PhoneNumber("+919158585052"),
                new PhoneNumber("+13347814315"),
                URI.create("http://demo.twilio.com/docs/voice.xml"))
                .create();
        System.out.println(call.getSid());
    }

    private void sendSMS() {
        Message message = Message.creator(
                new PhoneNumber("+917276637028"),
                new PhoneNumber("+13347814315"),
                "Hello Welcome to Twilio.")
                .create();
        System.out.println(message.getSid());
    }

}

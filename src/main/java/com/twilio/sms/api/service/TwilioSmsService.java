package com.twilio.sms.api.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;



    public void sendSMS(String toNum, String messageBody) {
        Twilio.init(accountSid, authToken);
        Message.creator(
                new PhoneNumber(toNum),
                new PhoneNumber(phoneNumber),
                messageBody)
                .create();

    }

}

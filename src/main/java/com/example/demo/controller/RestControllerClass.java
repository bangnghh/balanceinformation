package com.example.demo.controller;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin()
@RequestMapping("/balanceAPI")
public class RestControllerClass {
    private byte[] result = new byte[0];
    private InputStream is;
    private GenericPackager packager;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    @GetMapping("/hello")
    public String One() {
        return "Hello world";
    }

    @PostMapping("/balanceinfo")
    public HashMap<String, String> Balance(@RequestParam String accountID) {
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("account_id", accountID);
        resultMap.put("account_name", "Nguyen Van A");
        resultMap.put("account_type", "NCBStaff");
        resultMap.put("account_status", "active");
        resultMap.put("balance", "1246000");
        resultMap.put("from_date",dtf.format(now).toString());
        resultMap.put("working_balance", "950000");
        return resultMap;
    }

    @GetMapping("/iso8583")
    public String Iso() throws ISOException {
        is = getClass().getResourceAsStream("/fields.xml");
        packager = new GenericPackager (is);

        ISOMsg isoMsgRequest = new ISOMsg();
        isoMsgRequest.setPackager(packager);
        isoMsgRequest.setMTI("0200");
        isoMsgRequest.set(2, "9704334532234332");
        isoMsgRequest.set(3, "390000");
        isoMsgRequest.set(4, "000005000000");
        isoMsgRequest.set(7, new SimpleDateFormat("MMddHHmmss").format(new Date()));
        isoMsgRequest.set(11, "000000");
        isoMsgRequest.set (12, new SimpleDateFormat ("hhmmss").format(new Date ()));
        isoMsgRequest.set (13, new SimpleDateFormat ("MMdd").format(new Date ()));
        isoMsgRequest.set (15, new SimpleDateFormat ("MMdd").format(new Date ()));
        isoMsgRequest.set(18,"0000");
        isoMsgRequest.set(32,"00000000000");
        isoMsgRequest.set(33,"00000000000");
        isoMsgRequest.set (37,"000000000000");
        isoMsgRequest.set (41, "00000000");
        isoMsgRequest.set(43,"0000000000000000000000000000000000000000");
        isoMsgRequest.set (48,"0");
        isoMsgRequest.set (49,"000");
        isoMsgRequest.set (62, "020238389");
        isoMsgRequest.set (100,"0314");
        isoMsgRequest.set (102,"0");
        isoMsgRequest.set (103,"0");
        isoMsgRequest.set (125,"0");
        isoMsgRequest.set (127,"111");

        result = isoMsgRequest.pack();

        if (result != null){
            return new String(result);
        } else {
            return "Failed";
        }

    }
}

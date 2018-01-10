package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.shdemo.domain.Client;
import com.example.shdemo.domain.Purchase;
import com.example.shdemo.domain.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class PhoneManagerTest {

    @Autowired
    PhoneManager phoneManager;

    private final static String TYPE_NAME_1 = "Ciete";
    private final static String TYPE_DESCRIPTION_1 = "Kwiaty ciete";
    private final static String TYPE_NAME_2 = "doniczkowe";
    private final static String TYPE_DESCRIPTION_2 = "kwiaty doniczkowe";

    private final static String CLIENT_NAME_1 = "Adam";
    private final static String CLIENT_PIN_1 = "1122";
    private final static String CLIENT_NAME_2 = "Monika";
    private final static String CLIENT_PIN_2 = "3344";

    private final static String NAME_1 = "Fiolek";
    private final static double PRICE_1 = 23.77;
    private final static int VAT_1 = 8;
    private final static String NAME_2 = "Bratek";
    private final static double PRICE_2 = 11;
    private final static int VAT_2 = 5;
    private final static String NAME_3 = "Amarylis";
    private final static double PRICE_3 = 6.99;
    private final static int VAT_3 = 3;
    private final static String NAME_4 = "Eustoma";
    private final static double PRICE_4 = 2.55;
    private final static int VAT_4 = 3;

    @Test
    public void addTypeCheck(){
        Type type = new Type();
        type.setMark(TYPE_NAME_1);
        type.setDescription(TYPE_DESCRIPTION_1);

        Long typeId = phoneManager.addType(type);

        Type typeRetrieved  =phoneManager.findTypeById(typeId);
        assertEquals(TYPE_NAME_1, typeRetrieved.getMark());
        assertEquals(TYPE_DESCRIPTION_1, typeRetrieved.getDescription());

        //phoneManager.deleteType(typeRetrieved);
    }

    //@Test
    public void updateTypeCheck(){
        Type type = new Type();
        type.setMark(TYPE_NAME_1);
        type.setDescription(TYPE_DESCRIPTION_1);

        Long typeId = phoneManager.addType(type);
        phoneManager.updateType(typeId);

        Type typeRetrieved  =phoneManager.findTypeById(typeId);
        assertEquals("Zmiana", typeRetrieved.getMark());
        assertEquals(TYPE_DESCRIPTION_1, typeRetrieved.getDescription());

        //phoneManager.deleteType(typeRetrieved);

    };

    @Test
    public void addClientCheck(){
        Client client = new Client();
        client.setFirstName(CLIENT_NAME_1);
        client.setPin(CLIENT_PIN_1);

        Long clientId = phoneManager.addClient(client);

        Client clientRetrieved  =phoneManager.findClientById(clientId);
        assertEquals(CLIENT_NAME_1, clientRetrieved.getFirstName());
        assertEquals(CLIENT_PIN_1, clientRetrieved.getPin());

        //phoneManager.deleteClient(clientRetrieved);
    }

    //@Test
    public void updateClientCheck(){
        Client client = new Client();
        client.setFirstName(CLIENT_NAME_1);
        client.setPin(CLIENT_PIN_1);

        Long clientId = phoneManager.addClient(client);
        phoneManager.updateClient(clientId);

        Client clientRetrieved  =phoneManager.findClientById(clientId);
        assertEquals("Zmiana", clientRetrieved.getFirstName());
        assertEquals(CLIENT_PIN_1, clientRetrieved.getPin());

        //phoneManager.deleteClient(clientRetrieved);

    };


    @Test
    public void addPhoneCheck() {

        Long id = Long.valueOf(1);
        Type type = phoneManager.findTypeById(id);
        Phone phone = new Phone();
        phone.setMark(NAME_1);
        phone.setPriceNetto(PRICE_1);
        phone.setType(type);
        phone.setVat(VAT_1);
        // ... other properties here

        Long phoneId = phoneManager.addPhone(phone);
        type.getPhones().add(phone);

        Phone retrievedPhone = phoneManager.findPhoneById(phoneId);
        assertEquals(NAME_1, retrievedPhone.getMark());
        assertEquals(PRICE_1, retrievedPhone.getPriceNetto(), 5);
        assertEquals(type, retrievedPhone.getType());
        assertEquals(VAT_1, retrievedPhone.getVat());
        assertEquals(NAME_1, type.getPhones().get(0).getMark());
        // ... check other properties here

        //phoneManager.deletePhone(retrievedPhone);
    }

    //@Test
    public void updatePhoneCheck(){
        Long id = Long.valueOf(1);
        Type type = phoneManager.findTypeById(id);
        Phone phone = new Phone();
        phone.setMark(NAME_1);
        phone.setPriceNetto(PRICE_1);
        phone.setType(type);
        phone.setVat(VAT_1);
        // ... other properties here

        Long phoneId = phoneManager.addPhone(phone);
        type.getPhones().add(phone);
        phoneManager.updatePhone(phoneId);

        Phone retrievedPhone = phoneManager.findPhoneById(phoneId);
        assertEquals("Zmiana", retrievedPhone.getMark());
        assertEquals(PRICE_1, retrievedPhone.getPriceNetto(), 5);
        assertEquals(type, retrievedPhone.getType());
        assertEquals(VAT_1, retrievedPhone.getVat());
        // ... check other properties here

        //phoneManager.deletePhone(retrievedPhone);

    }

    @Test
    public void addPurchaseCheck(){
        Long id = Long.valueOf(1);
        Client clientRetrieved = phoneManager.findClientById(id);
        Phone phoneRetrieved = phoneManager.findPhoneById(id);

        Purchase purchase = new Purchase();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        purchase.setDate(date);
        purchase.setClient(clientRetrieved);
        purchase.setPhone(phoneRetrieved);

        Long purchaseId = phoneManager.addPurchase(purchase);
        clientRetrieved.getPurchases().add(purchase);

        Purchase purchaseRetrieved = phoneManager.findPurchaseById(purchaseId);
        assertEquals(date, purchaseRetrieved.getDate());
        assertEquals(clientRetrieved, purchaseRetrieved.getClient());
        assertEquals(phoneRetrieved, purchaseRetrieved.getPhone());
        assertEquals(3, clientRetrieved.getPurchases().size());
    }
}
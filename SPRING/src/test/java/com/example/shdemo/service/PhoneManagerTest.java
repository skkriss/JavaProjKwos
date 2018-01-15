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

    private final static String TYPE_MARK_1 = "Iphone X";
    private final static String TYPE_DESCRIPTION_1 = "Smartfon";
    private final static String TYPE_MARK_2 = "EDGE 8+";
    private final static String TYPE_DESCRIPTION_2 = "Smartfon";

    private final static String CLIENT_NAME_1 = "Pawel";
    private final static String CLIENT_PIN_1 = "1234";
    private final static String CLIENT_NAME_2 = "Marta";
    private final static String CLIENT_PIN_2 = "5678";

    private final static String MARK_1 = "Apple";
    private final static double PRICE_1 = 5700.00;
    private final static int VAT_1 = 23;
    private final static String MARK_2 = "Samsung";
    private final static double PRICE_2 = 2799.99;
    private final static int VAT_2 = 23;
    private final static String MARK_3 = "XIAOMI";
    private final static double PRICE_3 = 1200.00;
    private final static int VAT_3 = 23;
    private final static String MARK_4 = "Microsoft";
    private final static double PRICE_4 = 2999.99;
    private final static int VAT_4 = 23;

    //@Test
    public void addTypeCheck(){
        Type type = new Type();
        type.setMark(TYPE_MARK_1);
        type.setDescription(TYPE_DESCRIPTION_1);

        Long typeId = phoneManager.addType(type);

        Type typeRetrieved  =phoneManager.findTypeById(typeId);
        assertEquals(TYPE_MARK_1, typeRetrieved.getMark());
        assertEquals(TYPE_DESCRIPTION_1, typeRetrieved.getDescription());

        phoneManager.deleteType(typeRetrieved);
    }

    //@Test
    public void updateTypeCheck(){
        Type type = new Type();
        type.setMark(TYPE_MARK_1);
        type.setDescription(TYPE_DESCRIPTION_1);

        Long typeId = phoneManager.addType(type);
        phoneManager.updateType(typeId);

        Type typeRetrieved  =phoneManager.findTypeById(typeId);
        assertEquals("Zmiana", typeRetrieved.getMark());
        assertEquals(TYPE_DESCRIPTION_1, typeRetrieved.getDescription());

        //phoneManager.deleteType(typeRetrieved);

    };

    //@Test
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
        client.setFirstName(CLIENT_NAME_2);
        client.setPin(CLIENT_PIN_2);

        Long clientId = phoneManager.addClient(client);
        phoneManager.updateClient(clientId);

        Client clientRetrieved  =phoneManager.findClientById(clientId);
        assertEquals("Zmiana", clientRetrieved.getFirstName());
        assertEquals(CLIENT_PIN_2, clientRetrieved.getPin());

        //phoneManager.deleteClient(clientRetrieved);

    };


   //@Test
    public void addPhoneCheck() {

	   Type type = new Type();
       type.setMark(TYPE_MARK_1);
       type.setDescription(TYPE_DESCRIPTION_1);

       Long typeId = phoneManager.addType(type);

       Type typeRetrieved  =phoneManager.findTypeById(typeId);
       
        Long id = Long.valueOf(2);
        //Type type = phoneManager.findTypeById(id);
        Phone phone = new Phone();
        phone.setMark(MARK_1);
        phone.setPriceNetto(PRICE_1);
        phone.setType(typeRetrieved);
        phone.setVat(VAT_1);
        // ... other properties here

        Long phoneId = phoneManager.addPhone(phone);
        type.getPhones().add(phone);

        Phone retrievedPhone = phoneManager.findPhoneById(phoneId);
        assertEquals(MARK_1, retrievedPhone.getMark());
        assertEquals(PRICE_1, retrievedPhone.getPriceNetto(), 5);
        assertEquals(type, retrievedPhone.getType());
        assertEquals(VAT_1, retrievedPhone.getVat());
        assertEquals(MARK_1, type.getPhones().get(0).getMark());
        // ... check other properties here

        //phoneManager.deletePhone(retrievedPhone);
    }

    //@Test
    public void updatePhoneCheck(){
        Long id = Long.valueOf(2);
        Type type = phoneManager.findTypeById(id);
        Phone phone = new Phone();
        phone.setMark(MARK_2);
        phone.setPriceNetto(PRICE_2);
        phone.setType(type);
        phone.setVat(VAT_2);
        // ... other properties here

        Long phoneId = phoneManager.addPhone(phone);
        type.getPhones().add(phone);
        phoneManager.updatePhone(phoneId);

        Phone retrievedPhone = phoneManager.findPhoneById(phoneId);
        assertEquals("Zmiana", retrievedPhone.getMark());
        assertEquals(PRICE_2, retrievedPhone.getPriceNetto(), 5);
        assertEquals(type, retrievedPhone.getType());
        assertEquals(VAT_2, retrievedPhone.getVat());
        // ... check other properties here

        //phoneManager.deletePhone(retrievedPhone);

    }

    //@Test
    public void addPurchaseCheck(){
        Purchase purchase = new Purchase();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        purchase.setDate(date);

        Long purchaseId = phoneManager.addPurchase(purchase);

        Purchase purchaseRetrieved = phoneManager.findPurchaseById(purchaseId);
        assertEquals(date, purchaseRetrieved.getDate());
    }
    
    
}
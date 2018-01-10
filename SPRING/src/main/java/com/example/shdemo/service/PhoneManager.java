package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Client;
import com.example.shdemo.domain.Phone;
import com.example.shdemo.domain.Purchase;
import com.example.shdemo.domain.Type;

public interface PhoneManager {

    Long addPhone(Phone phone);
    void updatePhone(Long id);
    void deletePhone(Phone phone);
    Phone findPhoneById(Long id);
    List<Phone> getAllPhones();

    Long addType(Type model);
    void updateType(Long id);
    void deleteType(Type model);
    Type findTypeById(Long id);
    List<Type> getAllTypes();

    Long addClient(Client client);
    void updateClient(Long id);
    void deleteClient(Client client);
    Client findClientById(Long id);
    Client findClientByPin(String pin);
    List<Client> getAllClients();
    void deleteAllClients();

    Long addPurchase(Purchase client);
    void deletePurchase(Purchase purchase);
    Purchase findPurchaseById(Long id);
    List<Purchase> getAllPurchases();
    void deleteAllPurchases();


}
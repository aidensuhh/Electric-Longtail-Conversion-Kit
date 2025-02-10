#include <Arduino.h>
#include <BLEDevice.h>
#include <BLEUtils.h>
#include <BLEServer.h>
#include <icons.hpp>
#include <data.hpp>
#include <unordered_map>

#define SERVICE_UUID "c8a19548-8efa-4143-87eb-5e85ecefc852"

#define DESTINATION_UUID "a8da0e93-e9f4-42e8-9a7e-c773c0842a84"
#define ETA_UUID "9af73d89-bc02-4c61-ba43-9d65fa7fc86c"
#define DIRECTION_UUID "b2ee98be-98cf-4812-bb29-ea72f544b851"
#define DIRECTION_DISTANCE_UUID "449e64fb-22c6-498e-9b5a-2a478d47255c"
#define ETA_MINUTES_UUID "db8a7031-ad2b-42a1-a805-2b6e2f915ad6"
#define TOTAL_DISTANCE_UUID "2a150cad-8e24-40b3-8a94-e9dba67275b9"
#define PRECISE_DIRECTION_UUID "cdae2436-b01a-4f79-8bb1-cf1e4cbac117"

Data destination, eta, currentDirection, currentDirectionDistance, 
etaMinutes, totalRemainingDistance, preciseDirection;

BLECharacteristic destinationCharacteristic, etaCharacteristic, currentDirectionCharacteristic,
currentDirectionDistanceCharacteristic, etaMinutesCharacteristic, 
totalRemainingDistanceCharacteristic, preciseDirectionCharacteristic;

BLEServer *pServer;
BLEService *pService;

static std::unordered_map<std::string, std::pair<Data*, BLECharacteristic*>> uuidMapping = {
  {DESTINATION_UUID, {&destination, &destinationCharacteristic}},
  {ETA_UUID, {&eta, &etaCharacteristic}},
  {DIRECTION_UUID, {&currentDirection, &currentDirectionCharacteristic}},
  {DIRECTION_DISTANCE_UUID, {&currentDirectionDistance, &currentDirectionDistanceCharacteristic}},
  {ETA_MINUTES_UUID, {&etaMinutes, &etaMinutesCharacteristic}},
  {TOTAL_DISTANCE_UUID, {&totalRemainingDistance, &totalRemainingDistanceCharacteristic}},
  {PRECISE_DIRECTION_UUID, {&preciseDirection, &preciseDirectionCharacteristic}}
};

//Callback class passes information over BLE
class MyCallback : public BLECharacteristicCallbacks {
  //When app writes to ESP
  void onWrite(BLECharacteristic *pCharacteristic) override {
    std::string uuid = pCharacteristic->getUUID().toString();
    std::string payload = pCharacteristic->getValue().c_str();

    //Find the associated object given the UUID
    Data *data = &destination;
    if (uuidMapping.find(uuid) != uuidMapping.end()) {
      data = uuidMapping[uuid].first;
    }

    data->setPayload(payload);
  }

  //Maximum Transmission Unit
  void onMtuChanged(BLEServer *pServer, uint16_t mtu) {
    Serial.printf("MTU changed to %d\n", mtu);
  }
};

void initializeBLECharacteristic();

void setup() {
  // put your setup code here, to run once:
}

void loop() {
  // put your main code here, to run repeatedly:
}

void initializeBLECharacteristic() {
  MyCallback *myCallback = new MyCallback();

  //Iterate through uuid mappings, create new characteristic, link to callback
  for (auto it = uuidMapping.begin(); it != uuidMapping.end(); ++it) {
    std::string uuid = it->first;
    BLECharacteristic *pCharacteristic = it->second.second;

    pCharacteristic = pService->createCharacteristic(
      uuid, BLECharacteristic::PROPERTY_READ | BLECharacteristic::PROPERTY_WRITE
    );

    pCharacteristic->setCallbacks(myCallback);
  }
}
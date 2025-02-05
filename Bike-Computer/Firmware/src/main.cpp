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

std::unordered_map<std::string, Data*> uuidMapping = {
  {DESTINATION_UUID, &destination},
  {ETA_UUID, &eta},
  {DIRECTION_UUID, &currentDirection},
  {DIRECTION_DISTANCE_UUID, &currentDirectionDistance},
  {ETA_MINUTES_UUID, &etaMinutes},
  {TOTAL_DISTANCE_UUID, &totalRemainingDistance},
  {PRECISE_DIRECTION_UUID, &preciseDirection}
};

class MyCallback : public BLECharacteristicCallbacks {
  //When app writes to ESP
  void onWrite(BLECharacteristic *pCharacteristic) override {
    std::string uuid = pCharacteristic->getUUID().toString();
    std::string payload = pCharacteristic->getValue().c_str();

    //Find the associated object given the UUID
    Data *data = &destination;
    if (uuidMapping.find(uuid) != uuidMapping.end()) {
      data = uuidMapping[uuid];
    }

    data->setPayload(pCharacteristic->getValue().c_str());
  }

  //Maximum Transmission Unit
  void onMtuChanged(BLEServer *pServer, uint16_t mtu) {
    Serial.printf("MTU changed to %d\n", mtu);
  }
};

// put function declarations here:
int myFunction(int, int);

void setup() {
  // put your setup code here, to run once:
  int result = myFunction(2, 3);
}

void loop() {
  // put your main code here, to run repeatedly:
}

// put function definitions here:
int myFunction(int x, int y) {
  return x + y;
}
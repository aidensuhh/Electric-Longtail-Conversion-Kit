#ifndef DATA_HPP
#define DATA_HPP
#include <iostream>

class Data {
    public:
        Data() {
            payload = "";
        }
        Data(const std::string &message) {
            payload = message;
        }
        
        std::string getPayload() {
            return payload;
        }
        void setPayload(std::string message) {
            payload = message;
        }

        bool getUpdated() {
            return updated;
        }
        void setUpdated(bool value) {
            updated = value;
        }
    private:
        std::string payload;
        bool updated;
};

#endif
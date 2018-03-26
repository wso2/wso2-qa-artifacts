# Introduction
This artifact consists a python code which can detect sensor data from a raspbery pi and push the sesnsor value to IoT Server using MQTT. In order to configure it with IoT Server you need to follow the below steps.

**Tested product version -** IOT 3.1.0 version.

**Required Hardware**

  -  Raspberry pi
  - HC-SR04 Module
  - Resistors: 330Ω and 470Ω
  - Jumper wires

# Steps
**Configuring the raspberry pi**
 The four pins on the ultrasound module should be configured as below to the Raspberry
- VCC to Pin 2 (VCC)
- GND to Pin 6 (GND)
- TRIG to Pin 12 (GPIO18)
- Connect 330Ω resistor to ECHO. On its end connect it to Pin 18 (GPIO24) and through a 470Ω resistor you connect it also to Pin6 (GND).

Please refer [tutorials-raspberrypi.com](https://tutorials-raspberrypi.com/raspberry-pi-ultrasonic-sensor-hc-sr04/) for more details.

**Starting the IOT Server**
  - Download IoT 3.1.0 server and start the server using the below given scripts sequentially
	  - broker.sh
	  - iot-server.sh
	  - analytics.sh

**Creating a device type**
 - Login to https://localhost:9443/devicemgt and click on DEVICE TYPE MANAGEMENT > CREATE DEVICE TYPE
 - Enter the following details to add a new device type and click Add Device Type.
    **Name -** DistanceDetector
	**Description -** This is a device used to measure distance from a object detected
	**Push Notification Transport -** MQTT
	**Feature name -** msg
	**Feature code -** msg
	**Feature description -** Message from the server to the device.
 - Ones you click next **next** fill the new form with the below details and click on **Add**,
	**Transport -**  MQTT
	**Event Name  -** distance
	**Event data type -** INT

**Enroll newly created device**
- On the Enroll Device page, click on the DistanceDetector device type and select Create Device
- Enter the below details to create the device and click **Create Device**.
**Name -** DistanceFinder
**Device Identifier	-** 123456
**Description	-** Enrolling a device for testing

A file named 123456.json will be prompted to be downloaded. Download and rename this file as config.json

**Configuring the DistanceDetector python code**
- Clone the DistanceDetector python project 
- Replace the config.json with the newly created config.json.
- Copy the DistanceDetector project to the raspberry pi
- Issue the following command from the raspbery pi
```sh    
python PythonClient.py
```

The raspbery pi terminall will show the distance value that is captured. You can verify it by login to IOT server and click on the device -> analytics.



### Tips to troubleshoot

- The agent code consists a class named PythonClient.py. This calls consists a method named publishData() this is where the distance calculation method is implemented.
- If the sensor values are failing to retrive when the raspberry pi is turned on the first time, try restarting the raspbery pi. If it keeps failing check if the GPIO pins that you configured are correct. e.g - GPIO_TRIGGER = 23,GPIO_ECHO = 24 found in PythonClient.py class
- You can read more from https://tutorials-raspberrypi.com/raspberry-pi-ultrasonic-sensor-hc-sr04/ to get an idea about the implementation of the python code.


# AndroidBeacons
Simple demonstration of using Beacons in android with AltBeacon Library. Requires devices that are enabled with BlueTooth Low Energy, i.e. API level 18 and plus

Apple introduced iBeacons from iPhone 4s. So its been a while now. 
With Android, beacons was available from API level 18 and plus. But not well supported. 
From Android 5.0 it is getting better.
We can use AltBeacon library to get Beacons features in android. 
Beacons broadcast in regular intercals (between 100ms and 1sec) They send their ID during this session.
# The ID consists of three parts:
- UUID (Organization or company)
- major (arbitrary, e.g. specific chain store)
- minor (eg. location in store)

#Flow Control
- First Define a Region. Region here is the types of beacons that we want to receive not the geographical region.
- Then define a monitoring and ranging callback to start the monitoring.

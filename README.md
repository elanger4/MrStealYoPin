# MrStealYoPin

A research project to see if we can steal a mobile phone user's lock screen passcode
only from phone and smartwatch accelerometer data.

Platforms we used:

Android app to collect accelerometer data.

Pebble smartwatch to collect additional accelerometer data.

Numpy and sklearn to train a random forest classifier to predict a user's passcode
from the pebble and android accelerometer data.

We obtained 95% accuracy on a single prediction, which is a 71% accuracy across
a user's 4-digit pin data.


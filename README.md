[![official JetBrains project](https://jb.gg/badges/official-plastic.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)

# Getting Started with Kotlin Multiplatform
## With Shared Logic and NativeUIs

This repository contains a sample application, used in the second of four webinars on Kotlin Multiplatform.

The slides for the webinar can be found in the **slides** folder, and provide detailed information on the structure of the project and how it can be run.

Before you can build the application you will need to sign up for a key with the [Weather API](https://openweathermap.org/api), and add this in your **local.properties** file. The steps to do this are as follows:

1. Navigate to [https://home.openweathermap.org/users/sign_up](https://home.openweathermap.org/users/sign_up).
2. Fill in the form with your username, email address (the API key will be sent here), and password. 
3. Check the appropriate checkboxes and click on “Create account”.
4. Fill in the “How and where will you use our API?” dialog. Use “Education/Science” as “Purpose” and click the “Save” button.
5. Go to your email and locate the OpenWeatherMap email that was sent to you.
6. Click on the “Verify your email” button.
7. The next email you will receive is the “API Instruction” in which you will receive
your API key. It may take some time to activate this key.
8. Navigate to the **local.properties** file in the
project, which should have been created by your IDE. Add a line where the value is the same as your received API key. 
9. The format of the line should be as follows: *WEATHER\_API\_KEY={your api key goes here}*.

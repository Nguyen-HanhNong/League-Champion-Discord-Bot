# League-Champion-Discord-Bot

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

## What is this application?

This application is a discord bot that allows for randomization of items, roles and champions for League of Legends.

The application integrates the Orianna API, to get information from the Riot Games Data Dragon database.

## Choice of programming language

This application was written using Java and compiled using Apache Maven for a couple of reasons:

- By developing in Java, we can make use of the Orianna API which makes the importing of data from Riot Games' Data Dragon Database very quick and error-free.
- Java has strong support for concurrency, which is important for a Discord bot that needs to handle multiple tasks and requests simultaneously.
- Apache Maven is a popular build automation tool for Java projects, which can help automate and streamline the build and deployment process for my bot.
- Maven provides support for dependency management, which can make it easier to include and manage third-party libraries and dependencies in my project.

## Video of the application running:
![](https://user-images.githubusercontent.com/81977350/210872626-f0d2a7b4-d91d-4081-a634-c3763601b322.gif)

## Instructions to compile and run the application locally:
1. Make sure you have the following downloaded: [Java](https://www.oracle.com/ca-en/java/technologies/downloads/) and [IntelliJ IDE](https://www.jetbrains.com/idea/download/#section=windows)
2. Download the files and store them in a folder or clone the repository.
3. Open IntelliJ and import the project (the folder containing the files from GitHub)
4. Open the .xml file and make sure the dependencies and plugins are installed correctly.
5. Replace `DISCORD_BOT_TOKEN` and `RIOT_API_KEY` locations with your own discord bot token and Riot Developer API key.
6. Compile and run the application by running the LeagueBot java file.

## Potential Improvements and Advancements
- Adding randomization for runes and summoner spells to the application
- Adding integration with Riot's API to automatically change the runes and summonner spell of the player if they're currently playing League of Legends

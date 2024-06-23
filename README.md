# VK Auto Reply Bot
## Usage
### Configuration
Edit src/main/resources/application.properties to configure this bot.  
* vkApi.accessToken - access token for bot. Empty by default, has to be set.
* vkApi.apiVersion - bot uses API of this version.
* vkApi.confirmationToken - token for confirmation of a server. Empty by default, has to be set.
* vkApi.okResponseBody - server has to response to every request (except confirmation) from Callback API with this 
value. VK API Documentation says that this value has to be "ok".
* vkApi.messageSendMethodUri - URI of *messages.send* method for sending messages to users.
* vkApi.randomId - id to prevent duplicating messages. Set to 0 to disable this. In case of using values other than
zero behavior is undefined.
## Running
Enter this command in the terminal in the root of the project:  

Linux/macOs
```
./gradlew bootRun
```
Windows
```
gradlew.bat bootRun
```

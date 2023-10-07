# Amphibians
****
## About App
- This is one of my android app project. I'm practicing calling Api in jetpack compose.
- I used the UDF( undirectional data flow) design pattern to design the app.
- I created UI layer for exposing  data on the screen and Data layer for managing the data.
- To calling or fetching Api you need these features below:
  + Retrofit for network
  + Gson/Json converter factory for tranfering kotlin data object.
  + kotlin.serialization for parsing JSON file
  + Coil for loading images
- I also created a unit test for ViewModel and Repository.
  
* Undirectional data flow:
  
   ![state-unidirectional-flow](https://github.com/Gianguyen1234/CallingApi/assets/112406680/be41e919-6011-4360-b59c-5420d2cf9c84)
* UI layer:
   ![mad-arch-ui-udf-in-action](https://github.com/Gianguyen1234/CallingApi/assets/112406680/ea6d7f1c-6593-4a48-be36-538bbdc333af)
* Data layer:
   ![f13e3d6207f3ecf1_1440](https://github.com/Gianguyen1234/CallingApi/assets/112406680/4cfe3028-3e5c-4a22-8d9c-98969e4295b6)

- Demo app: https://youtube.com/shorts/NE7sC3vIPtc
- In consclusion: to all api you to set up a UI layer and a Data layer:
  +  The UI layer contains ViewModel and UiState (Composable function). The ViewModel is in charge of exposing the screen UI state, and handling the business logic in the UI layer and calling the business logic from other layers of the hierarchy.
  +  The Data layer is responsile for retrieving the data from the api. The data layer includes: data class, repository for managing the data and data source class to retrieve the data from the network.
  +  You should use Dependency Injection (DI) to keep your app flexible, robust, and ready to scale.

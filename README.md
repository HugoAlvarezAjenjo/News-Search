<h1 align=center>News Compose</h1>
<p align = center>Desktop Compose News App</p>

## About

This desktop application is written in Kotlin, utilizing Compose for the frontend and ktor for API calls.
It interacts with the [News API](https://newsapi.org/) to retrieve information.

The aplication shows the most relevant articles and ofers to the user a search bar in order to search for a specific desired topic

## Use

In order to use it, you must create `api.properties` file inside the resources `src/main/resources`

```properties
API_KEY=your_api_key
```

## Credits

Initially, this project was being done following [YoursSohail's tutorial](https://www.youtube.com/watch?v=7IOfsV6dTeg) in order to learn how to use compose in desktop, but clean architecture has been implemented, which provides greater flexibility and independence regarding the backend and hides the API key.

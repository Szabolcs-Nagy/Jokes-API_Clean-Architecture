Joke-Challenger-API-Clean-Archichecture

# Android Technical Test

## Objective

The goal of this simple exercise is for you to create an Android app which will consume content from the “The Internet Chuck Norris Database” API.

The documentation can be found at: http://www.icndb.com/api/ Display a list of jokes

The app should display a list of random jokes fetched from the API, filtered to remove explicit jokes.
For the purpose of this exercise you can ignore duplicate jokes.
Deliverables

We expect you to create an Android project that can be accessed by us via a version controlled repository (Github, Bitbucket, etc).

There is no stipulation for minimum deployment target, but should you wish to use the very latest platform technologies.

You are free to use whatever package manager and libraries are appropriate to complete the task.

If you are unsure how best to proceed during the course of the exercise you should use your own judgment to create what you think is the best solution. 

Part of this exercise is to see how you approach problem solving in the context of software development.

Evaluation criteria

We will take a look at the provided solution as a whole and consider:
● The quality/maintainability of the code delivered; quality is more important than a
complete solution
● The user experience
● How the details of the exercise were approached
Unit Tests


### Architecture pattern

To solve this challenger I have used clean archichecture implementation.

There are different opinions about how many layers Clean Architecture should have. The architecture doesn’t define exact layers but instead lays out the foundation. The idea is that you adapt the number of layers to your needs.

To keep things simple, you’ll use five layers:

Presentation: A layer that interacts with the UI.
Use cases: Sometimes called interactors. Defines actions the user can trigger.
Domain: Contains the business logic of the app.
Data: Abstract definition of all the data sources.
Remote: In our implementation is the more external layer it send request to the API.


   
  
  

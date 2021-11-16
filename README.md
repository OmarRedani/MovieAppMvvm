# IBM MovieApp Interview 

Simple Android Movie App project using The Movie DB API based on MVVM architecture, It fetches the data from the API in order to see the latest movies, and when the user clicks on an item, it opens basic details of the movie on the second screen.

## Features:

* The first screen is a RecyclerView containing movies 
* The second screen is the selected movie details screen
* Image transition between screens 
* An infinite scroll to browse more movies
* Simple Filter to filter movies

## Technologies Used

Project is created with:

* [100% Kotlin] we use Kotlin over java because it's safer and concise
* [Model View viewModel] we use Mvvm as an architecture pattern of our project
* [LiveData] we use LiveData as our observable data holder class. which is lifecycle aware.
* [Retrofit (with Coroutines)] we use retrofit with coroutines to communicate with the rest API and the paging 3 library take care of launching these coroutines
* [Paging 3] we use the paging 3 library for pagination
* [Gson] we use the Gson library to convert a JSON string to an equivalent Java object.
* [Glide] we use glide to load and display images
* [ViewModel] we use viewModel as a data manager in our application
* [Navigation Component with safe args] we use the navigation component to navigate from the gallery movie fragment to the detail screen.
* [View Binding] we use ViewBinding to access our views in a compile-time safe way
* [Dagger-Hilt] we use dagger-hilt for Dependency Injection.

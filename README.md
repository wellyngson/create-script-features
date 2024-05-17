# Feature Generation Script for Android Projects

This script streamlines the creation of new features for Android projects by integrating Jetpack Compose with MVVM-I and Clean Architecture. It helps maintain a clean separation of layers (UI, Data, Domain), ensuring a consistent and maintainable codebase.

## Architecture
![Captura de Tela 2024-05-17 às 11 57 12](https://github.com/wellyngson/create-script-features/assets/59460244/ead9a02d-c5e8-48eb-a96e-501432fcf771)

## Setup
1. Create Script File:
   - Create a new package and file scripts/createfeature.gradle.kts in your root package.
   - 2. Paste the code from this link into your createfeature.gradle.kts. (https://play.kotlinlang.org/embed?short=KkeGhEhCX&theme=darcula&readOnly=true)
   - Paste the code from this link into your createfeature.gradle.kts.
     
2. Apply Script in Build Configuration:
   - Add the following line to your build.gradle.kts module:  ```apply(from = "scripts/createfeature.gradle.kts")```
  
   <img width="933" alt="Captura de Tela 2024-03-26 às 16 44 26" src="https://github.com/wellyngson/create-script-features/assets/59460244/c33e7f30-57f1-4ec1-8f0f-d549b5191180">
   
   - Sync Your Project.

## Package Structure
<img width="457" alt="Captura de Tela 2024-03-26 às 16 16 59" src="https://github.com/wellyngson/create-script-features/assets/59460244/17142850-e1ee-4184-ae34-a2c78ba481db">

## How to Use
In your terminal, execute the following command:

```./gradlew createfeature -PfeatureName=MyNewFeature -PapplicationId=welias.createscriptsfeatures```

Replace _MyNewFeature_ with your desired feature name, and _welias.createscriptsfeatures_ with your application ID for your module.

## BaseScriptViewModel
Firstly, create a *BaseScriptViewModel* in the current package where you are using the *MVVM-I* (Model, View, ViewModel, Intent) architecture to manage interactions between Composables and ViewModel. If you want to change the BaseScriptViewModel to another name, ensure you update the filename accordingly in the script.

<img width="788" alt="Captura de Tela 2024-03-26 às 16 18 42" src="https://github.com/wellyngson/create-script-features/assets/59460244/bfec5abb-8edb-481b-99ca-bed9976a3cc2">

## Result
In just milliseconds, your files will be generated, following a consistent architecture and automating repetitive tasks.

<img width="1167" alt="Captura de Tela 2024-03-26 às 16 30 57" src="https://github.com/wellyngson/create-script-features/assets/59460244/971fb141-eccd-4953-adc1-6f68249581ed">

## Error Handling
If you attempt to create a new feature package with an existing name, an error will occur. Ensure your feature names are unique.

<img width="1128" alt="Captura de Tela 2024-03-26 às 16 32 46" src="https://github.com/wellyngson/create-script-features/assets/59460244/f3ce10c7-5834-4f0b-ab79-b566c1d49ec1">

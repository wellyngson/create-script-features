 - CREATE FEATURE SCRIPT

This script facilitates the generation of features for Android projects, integrating Jetpack Compose with MVVM-I and Clean Architecture to separate layers (UI, Data, Domain).

HOW TO USE:
In your terminal, execute the following command:

 - ./gradlew createfeature -PfeatureName=MyNewFeature -PapplicationId=welias.createscriptsfeatures

Replace MyNewFeature with your desired feature name, and welias.createscriptsfeatures with your applicationId for your module.

 - PACKAGE STRUCTURE:
Package Structure

<img width="457" alt="Captura de Tela 2024-03-26 às 16 16 59" src="https://github.com/wellyngson/create-script-features/assets/59460244/17142850-e1ee-4184-ae34-a2c78ba481db">

 - SETUP:
1. Create a new package and file scripts/createfeature.gradle.kts in your root package.
2. Paste the code from this link into your createfeature.gradle.kts. (https://play.kotlinlang.org/embed?short=KkeGhEhCX&theme=darcula&readOnly=true)
3. Add apply(from = "scripts/createfeature.gradle.kts") to your build.gradle.kts module.

<img width="933" alt="Captura de Tela 2024-03-26 às 16 44 26" src="https://github.com/wellyngson/create-script-features/assets/59460244/c33e7f30-57f1-4ec1-8f0f-d549b5191180">

5. Sync your project.

<img width="457" alt="Captura de Tela 2024-03-26 às 16 16 59" src="https://github.com/wellyngson/create-script-features/assets/59460244/17142850-e1ee-4184-ae34-a2c78ba481db">

Firstly, we have a BaseScriptViewModel, and you need create it in this currente package, where we using the MVVM-I (Model, View, View Model, Intent) Architecture for realize the interactions between Composables and View Model.
If you want change the BaseScriptViewModel for another name, you need to change the filename and change the filename in script.

<img width="788" alt="Captura de Tela 2024-03-26 às 16 18 42" src="https://github.com/wellyngson/create-script-features/assets/59460244/bfec5abb-8edb-481b-99ca-bed9976a3cc2">

 - RESULT:
In just milliseconds, your files will be generated.

<img width="1167" alt="Captura de Tela 2024-03-26 às 16 30 57" src="https://github.com/wellyngson/create-script-features/assets/59460244/971fb141-eccd-4953-adc1-6f68249581ed">

- Generated Files

USE CASE:
If you attempt to create a new feature package with an existing name, an error will occur.

<img width="1128" alt="Captura de Tela 2024-03-26 às 16 32 46" src="https://github.com/wellyngson/create-script-features/assets/59460244/f3ce10c7-5834-4f0b-ab79-b566c1d49ec1">

Error Message

This script enhances feature creation by automating repetitive tasks and enforcing a consistent architecture across your Android projects.

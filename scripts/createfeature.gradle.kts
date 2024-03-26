import org.gradle.api.tasks.*

tasks.register("createfeature") {
    group = "custom"
    description = "Creates a new feature in the Android project"

    val featureName: String by project

    val applicationId: String? = project.findProperty("applicationId")?.toString()

    if (applicationId != null) {
        val basePackagePath = "app/src/main/java/${
            applicationId.replace(
                ".",
                "/",
            )
        }/features/${featureName.toLowerCase()}"

        doLast {
            val featureDir = file("$basePackagePath")
            if (featureDir.exists()) {
                println("Feature directory already exists. No files will be created.")
                return@doLast
            }

            // Create ui packages
            val featureUiDir = file("$basePackagePath/ui")
            featureUiDir.mkdirs()

            // Create domain packages
            val featureDomainDir = file("$basePackagePath/domain")
            featureDomainDir.mkdirs()

            // Create data packages
            val featureDataDir = file("$basePackagePath/data")
            featureDataDir.mkdirs()

            // Create UI files
            createUiFiles(featureName, applicationId, featureUiDir)
            createDomainFiles(featureName, applicationId, featureDomainDir)
            createDataFiles(featureName, applicationId, featureDataDir)

            println("Feature '$featureName' created successfully.")
        }
    } else {
        println("Unable to retrieve the applicationId property. Please ensure it's properly configured in your build.gradle file.")
    }
}

fun createUiFiles(
    featureName: String,
    applicationId: String,
    featureDir: File,
) {
    val uiPackagePath = "${featureDir.path}"
    val uiDir = file(uiPackagePath)
    uiDir.mkdirs()

    // UI files
    val uiFiles =
        listOf(
            "${featureName}Screen.kt" to generateScreenContent(featureName, applicationId),
            "${featureName}Content.kt" to generateContentContent(featureName, applicationId),
            "${featureName}State.kt" to generateStateContent(featureName, applicationId),
            "${featureName}Action.kt" to generateActionContent(featureName, applicationId),
            "${featureName}Result.kt" to generateResultContent(featureName, applicationId),
            "${featureName}ViewModel.kt" to generateViewModelContent(featureName, applicationId),
        )

    uiFiles.forEach { (fileName, fileContent) ->
        val file = file("$uiDir/$fileName")
        file.writeText(fileContent)
    }
}

fun generateScreenContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}
        
        import androidx.compose.runtime.Composable
        
        @Composable
        internal fun ${featureName}Screen() {
            // Implement your screen content here
        }
        """.trimIndent()
}

fun generateContentContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.ui
        
        import androidx.compose.runtime.Composable
        
        @Composable
        internal fun ${featureName}Content() {
            // Implement your content here
        }
        """.trimIndent()
}

fun generateViewModelContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.ui
        
        import $packageName.commons.BaseScriptViewModel

        internal class ${featureName}ViewModel :
            BaseScriptViewModel<${featureName}Action, ${featureName}Result, ${featureName}State>() {
            override val initialState: ${featureName}State
                get() = ${featureName}State()
        
            override fun sendIntent(action: ${featureName}Action) {
                // Implement your action handling logic here
            }
        }
        """.trimIndent()
}

fun generateStateContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.ui
        
        internal data class ${featureName}State(
            // Define your state properties here
        )
        """.trimIndent()
}

fun generateActionContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.ui
        
        internal interface ${featureName}Action {
            // Define your actions here
        }
        """.trimIndent()
}

fun generateResultContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.ui
        
        internal interface ${featureName}Result {
            // Define your results here
        }
        """.trimIndent()
}

fun createDomainFiles(
    featureName: String,
    applicationId: String,
    featureDir: File,
) {
    // Use case
    val domainUseCasePackagePath = "${featureDir.path}/usecase"
    val domainUserCaseDir = file(domainUseCasePackagePath)
    domainUserCaseDir.mkdirs()

    val domainUseCaseFiles =
        listOf(
            "${featureName}UseCase.kt" to generateUseCaseContent(featureName, applicationId),
        )

    domainUseCaseFiles.forEach { (fileName, fileContent) ->
        val file = file("$domainUseCasePackagePath/$fileName")
        file.writeText(fileContent)
    }

    // Repository
    val domainRepositoryPackagePath = "${featureDir.path}/repository"
    val domainRepositoryDir = file(domainRepositoryPackagePath)
    domainRepositoryDir.mkdirs()

    val domainRepositoryFiles =
        listOf(
            "${featureName}Repository.kt" to generateRepositoryContent(featureName, applicationId),
        )

    domainRepositoryFiles.forEach { (fileName, fileContent) ->
        val file = file("$domainRepositoryPackagePath/$fileName")
        file.writeText(fileContent)
    }
}

fun generateUseCaseContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.domain.usecase
        
        // Define your use case implementation here
        internal class ${featureName}UseCase {
            // Implementation goes here
        }
        """.trimIndent()
}

fun generateRepositoryContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.domain.repository
        
        // Define your repository implementation here
        internal interface ${featureName}Repository {
            // Implementation goes here
        }
        """.trimIndent()
}

fun createDataFiles(
    featureName: String,
    applicationId: String,
    featureDir: File,
) {
    // Repository Impl
    val domainRepositoryImplPackagePath = "${featureDir.path}/repository"
    val domainRepositoryImplDir = file(domainRepositoryImplPackagePath)
    domainRepositoryImplDir.mkdirs()

    val dataRepositoryImplFiles =
        listOf(
            "${featureName}RepositoryImpl.kt" to generateRepositoryImplContent(featureName, applicationId),
        )

    dataRepositoryImplFiles.forEach { (fileName, fileContent) ->
        val file = file("$domainRepositoryImplPackagePath/$fileName")
        file.writeText(fileContent)
    }

    // Data source
    val domainDataSourcePackagePath = "${featureDir.path}/datasource"
    val domainDataSourceDir = file(domainDataSourcePackagePath)
    domainDataSourceDir.mkdirs()

    // Local Data source
    val domainLocalDataSourcePackagePath = "${featureDir.path}/datasource/local"
    val domainLocalDataSourceDir = file(domainLocalDataSourcePackagePath)
    domainLocalDataSourceDir.mkdirs()

    // Remote Data source
    val domainRemoteDataSourcePackagePath = "${featureDir.path}/datasource/remote"
    val domainRemoteDataSourceDir = file(domainRemoteDataSourcePackagePath)
    domainRemoteDataSourceDir.mkdirs()

    // Service
    val domainServicePackagePath = "${featureDir.path}/service"
    val domainServiceDir = file(domainServicePackagePath)
    domainServiceDir.mkdirs()

//    val domainRepositoryFiles =
//        listOf(
//            "${featureName}Repository.kt" to generateRepositoryContent(featureName, applicationId),
//        )
//
//    domainRepositoryFiles.forEach { (fileName, fileContent) ->
//        val file = file("$domainRepositoryPackagePath/$fileName")
//        file.writeText(fileContent)
//    }
}

fun generateRepositoryImplContent(
    featureName: String,
    packageName: String,
): String {
    return """
        package $packageName.features.${featureName.toLowerCase()}.data.repository
        
        import $packageName.features.${featureName.toLowerCase()}.domain.repository.${featureName}Repository
        
        // Define your repository implementation here
        internal class ${featureName}RepositoryImpl : ${featureName}Repository {
            // Implementation goes here
        }
        """.trimIndent()
}

package welias.createscriptsfeatures.features.mynewfeature.ui

import welias.createscriptsfeatures.commons.BaseScriptViewModel

internal class MyNewFeatureViewModel :
    BaseScriptViewModel<MyNewFeatureAction, MyNewFeatureResult, MyNewFeatureState>() {
    override val initialState: MyNewFeatureState
        get() = MyNewFeatureState()

    override fun sendIntent(action: MyNewFeatureAction) {
        // Implement your action handling logic here
    }
}